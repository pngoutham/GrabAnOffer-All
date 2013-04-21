/**
 * 
 */
package com.gao.core.image.dao;

import java.io.InputStream;

import com.gao.core.framework.hibernate.exceptions.InstanceNotFoundException;
import com.gao.core.framework.hibernate.properties.DocumentContent;
import com.gao.core.framework.hibernate.properties.ImageDocument;
import com.gao.core.framework.hibernate.properties.Resource;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.jcr.Binary;
import javax.jcr.ItemNotFoundException;
import javax.jcr.Node;
import javax.jcr.NodeIterator;
import javax.jcr.PathNotFoundException;
import javax.jcr.Property;
import javax.jcr.PropertyIterator;
import javax.jcr.Repository;
import javax.jcr.RepositoryException;
import javax.jcr.Session;
import javax.jcr.SimpleCredentials;
import javax.jcr.Value;
import javax.jcr.ValueFactory;
import javax.jcr.Workspace;
import javax.jcr.query.Query;
import javax.jcr.query.QueryManager;
import javax.jcr.query.QueryResult;
import org.apache.jackrabbit.JcrConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author goutham
 * 
 */
public class ImageDaoImpl implements ImageDao {

	private Repository repository;
	private String FILE_ACTIVITY_ROOT_NODE_PATH = "fileActivity";
	private String IMAGE_DOCUMENT_ROOT_NODE_PATH = "practicalCaseActivity";

	public void setRepository(Repository repository) {
		this.repository = repository;
	}

	public ImageDocument addDocument(Resource resource, ImageDocument document,
			InputStream content) throws RepositoryException {
		Session session = null;
		try {
			session = repository.login(new SimpleCredentials("username",
					"password".toCharArray()));

			// find resource node
			Workspace workspace = session.getWorkspace();
			QueryManager queryManager = workspace.getQueryManager();
			String resourceId = resource.getId().toString();
			String queryString = "SELECT * " + "FROM [" + JcrConstants.NT_BASE
					+ "] " + "WHERE resourceId = " + resourceId;
			Query query = queryManager.createQuery(queryString, Query.JCR_SQL2);
			QueryResult queryResult = query.execute();

			Node resourceNode = null;
			if (queryResult.getNodes().hasNext()) {
				resourceNode = queryResult.getNodes().nextNode();
			} else {
				Node rootNode = session.getRootNode();
				resourceNode = rootNode.addNode(resourceId);

				resourceNode.setProperty("resourceId", resourceId);
			}

			ImageDocument createdDocument = addDocument(session, resourceNode,
					document, content);

			session.save();

			// printRepository(session);

			return createdDocument;
		} finally {
			if (session != null) {
				session.logout();
			}
		}
	}

	private Node createFolder(Session session, String path, Node rootNode)
			throws RepositoryException {
		Node node = null;
		try {
			node = rootNode.addNode(path);
			session.save();
		} catch (RepositoryException r) {
			throw new RepositoryException("Error accessing root node", r);
		}
		return node;
	}

	public void delete(ImageDocument document) throws RepositoryException,
			InstanceNotFoundException {

		Session session = null;
		try {
			session = repository.login(new SimpleCredentials("username",
					"password".toCharArray()));

			Node node = session.getNodeByIdentifier(document.getNodeId());

			node.remove();

			session.save();

		} catch (ItemNotFoundException ex) {
			throw new InstanceNotFoundException(document.getNodeId(),
					Node.class.getName());
		} finally {
			if (session != null) {
				session.logout();
			}
		}
	}

	public ImageDocument find(ImageDocument document)
			throws RepositoryException, InstanceNotFoundException {
		Session session = null;
		try {
			session = repository.login(new SimpleCredentials("username",
					"password".toCharArray()));

			Node node = session.getNodeByIdentifier(document.getNodeId());

			return fileNodeToImageDocument(node);
		} catch (ItemNotFoundException ex) {
			throw new InstanceNotFoundException(document.getNodeId(),
					Node.class.getName());
		} finally {
			if (session != null) {
				session.logout();
			}
		}
	}

	/* to do .. */
	public ImageDocument findNode(ImageDocument document)
			throws RepositoryException, InstanceNotFoundException {
		Session session = null;
		try {
			session = repository.login(new SimpleCredentials("username",
					"password".toCharArray()));

			Node node = session.getNodeByIdentifier(document.getNodeId());

			return fileNodeToImageDocument(node);
		} catch (ItemNotFoundException ex) {
			throw new InstanceNotFoundException(document.getNodeId(),
					Node.class.getName());
		} finally {
			if (session != null) {
				session.logout();
			}
		}
	}

	public ImageDocument update(ImageDocument document, InputStream data)
			throws RepositoryException, InstanceNotFoundException {

		Session session = null;
		try {
			Calendar now = Calendar.getInstance();
			session = repository.login(new SimpleCredentials("username",
					"password".toCharArray()));

			Node node = session.getNodeByIdentifier(document.getNodeId());

			node.setProperty("fileName", document.getFileName());
			node.setProperty("description", document.getDescription());
			node.setProperty("roles", document.getRoles());
			node.setProperty(JcrConstants.JCR_LASTMODIFIED,
					now.getTimeInMillis());

			Node contentNode = node.getNode(JcrConstants.JCR_CONTENT);
			contentNode.setProperty(JcrConstants.JCR_LASTMODIFIED, now);
			contentNode.setProperty(JcrConstants.JCR_MIMETYPE,
					document.getMimeType());
			ValueFactory valueFactory = session.getValueFactory();
			if (data != null) {
				Binary binary = valueFactory.createBinary(data);
				contentNode.setProperty(JcrConstants.JCR_DATA, binary);
				document.setDataSize(binary.getSize());
			}
			document.setModificationDate(now.getTimeInMillis());

			session.save();

			return document;
		} catch (ItemNotFoundException ex) {
			throw new InstanceNotFoundException(document.getNodeId(),
					Node.class.getName());
		} finally {
			if (session != null) {
				session.logout();
			}
		}
	}

	public List<ImageDocument> getDocuments(Resource resource)
			throws RepositoryException, InstanceNotFoundException {

		Session session = null;
		try {
			session = repository.login(new SimpleCredentials("username",
					"password".toCharArray()));

			Workspace workspace = session.getWorkspace();
			QueryManager queryManager = workspace.getQueryManager();
			String resourceId = resource.getId().toString();
			String queryString = "SELECT * " + "FROM [" + JcrConstants.NT_BASE
					+ "] " + "WHERE resourceId = " + resourceId;
			Query query = queryManager.createQuery(queryString, Query.JCR_SQL2);
			QueryResult queryResult = query.execute();

			if (!queryResult.getNodes().hasNext()) {
				return new ArrayList<ImageDocument>();
			}

			Node node = queryResult.getNodes().nextNode();
			String nodeParentPath = node.getPath();

			queryString = "SELECT * " + "FROM [" + JcrConstants.NT_BASE + "] "
					+ "WHERE ISCHILDNODE([" + nodeParentPath + "]) "
					+ "ORDER BY [" + JcrConstants.JCR_LASTMODIFIED + "] DESC";
			query = queryManager.createQuery(queryString, Query.JCR_SQL2);
			queryResult = query.execute();
			List<ImageDocument> documents = new ArrayList<ImageDocument>();
			for (NodeIterator it = queryResult.getNodes(); it.hasNext();) {
				Node resultNode = it.nextNode();
				ImageDocument document = fileNodeToImageDocument(resultNode);
				documents.add(document);
			}

			return documents;
		} finally {
			if (session != null) {
				session.logout();
			}
		}
	}

	public DocumentContent getDocumentContent(ImageDocument document)
			throws RepositoryException, InstanceNotFoundException {
		Session session = null;
		try {
			session = repository.login(new SimpleCredentials("username",
					"password".toCharArray()));

			Node node = session.getNodeByIdentifier(document.getNodeId());

			DocumentContent documentContent = new DocumentContent();
			documentContent.setFileName(node.getProperty("fileName")
					.getString());
			Node contentNode = node.getNode(JcrConstants.JCR_CONTENT);
			Binary binaryContent = contentNode.getProperty(
					JcrConstants.JCR_DATA).getBinary();
			documentContent.setContent(binaryContent.getStream());
			documentContent.setMimeType(contentNode.getProperty(
					JcrConstants.JCR_MIMETYPE).getString());
			documentContent.setDataSize(binaryContent.getSize());

			return documentContent;

		} catch (ItemNotFoundException ex) {
			throw new InstanceNotFoundException(document.getNodeId(),
					Node.class.getName());
		} finally {
			if (session != null) {
				session.logout();
			}
		}
	}

	public ImageDocument findByName(Resource resource, ImageDocument document)
			throws RepositoryException, InstanceNotFoundException {
		Session session = null;
		try {
			session = repository.login(new SimpleCredentials("username",
					"password".toCharArray()));

			Workspace workspace = session.getWorkspace();
			QueryManager queryManager = workspace.getQueryManager();
			String resourceId = resource.getId().toString();
			String queryString = "SELECT * " + "FROM [" + JcrConstants.NT_BASE
					+ "] " + "WHERE resourceId = " + resourceId;
			Query query = queryManager.createQuery(queryString, Query.JCR_SQL2);
			QueryResult queryResult = query.execute();

			if (!queryResult.getNodes().hasNext()) {
				throw new InstanceNotFoundException(resourceId,
						ImageDocument.class.getName());
			}

			Node node = queryResult.getNodes().nextNode();
			String nodeParentPath = node.getPath();

			queryString = "SELECT * " + "FROM [" + JcrConstants.NT_BASE + "] "
					+ "WHERE ISCHILDNODE([" + nodeParentPath + "]) "
					+ "AND LOCALNAME() = '" + document.getFileName() + "'";
			query = queryManager.createQuery(queryString, Query.JCR_SQL2);
			queryResult = query.execute();

			if (!queryResult.getNodes().hasNext()) {
				return null;
			}

			Node documentNode = queryResult.getNodes().nextNode();

			return fileNodeToImageDocument(documentNode);

		} finally {
			if (session != null) {
				session.logout();
			}
		}
	}

	private void printRepository(Session session) throws RepositoryException {
		Workspace workspace = session.getWorkspace();
		QueryManager queryManager = workspace.getQueryManager();
		String queryString = "SELECT * " + "FROM [" + JcrConstants.NT_BASE
				+ "]";
		Query query = queryManager.createQuery(queryString, Query.JCR_SQL2);
		QueryResult queryResult = query.execute();

		for (NodeIterator it = queryResult.getNodes(); it.hasNext();) {
			Node resultNode = it.nextNode();
			if (!resultNode.getPath().startsWith("/jcr:system")) {
				for (PropertyIterator it2 = resultNode.getProperties(); it2
						.hasNext();) {
					Property nodeProperty = it2.nextProperty();
					System.out.print("Property: " + nodeProperty.getName()
							+ " = ");
					if (nodeProperty.getDefinition().isMultiple()) {
						Value[] propertyValues = nodeProperty.getValues();
						for (int i = 0; i < propertyValues.length; i++) {
							System.out.print(propertyValues[i].getString()
									+ ", ");
						}
					} else {
					}
				}
			}
		}
	}

	private ImageDocument addDocument(Session session, Node baseNode,
			ImageDocument document, InputStream data)
			throws RepositoryException {
		Node fileNode = baseNode.addNode(document.getFileName(),
				JcrConstants.NT_FILE);
		fileNode.addMixin("mix:imageDocument");
		fileNode.addMixin("mix:lastModified");
		fileNode.setProperty("fileName", document.getFileName());
		fileNode.setProperty("description", document.getDescription());
		fileNode.setProperty("roles", document.getRoles());

		Node contentNode = fileNode.addNode(JcrConstants.JCR_CONTENT,
				JcrConstants.NT_RESOURCE);
		ValueFactory valueFactory = session.getValueFactory();
		Binary binary = valueFactory.createBinary(data);
		contentNode.setProperty(JcrConstants.JCR_DATA, binary);

		// try {
		// TODO : need to make necessary changes in the reading of mime type of
		// the stream.
		// It has issue when "stream.markSupported() == false", in this case we
		// get the exception saying
		// "javax.jcr.RepositoryException: java.io.IOException: Read error",
		// this happens because of the
		// "after first reading stream become exhausted and second reading fails.".
		// Reference link
		// "http://code.google.com/p/jcrom/issues/detail?id=76#c0"
		// These are temporary changes.

		// Tika tika = new Tika();
		String mimeType = document.getMimeType(); // tika.detect(data);
		contentNode.setProperty(JcrConstants.JCR_MIMETYPE, mimeType);

		ImageDocument createdDocument = new ImageDocument();
		createdDocument.setFileName(document.getFileName());
		createdDocument.setDataSize(binary.getSize());
		createdDocument.setNodeId(fileNode.getIdentifier());
		createdDocument.setMimeType(mimeType);
		Calendar calendar = Calendar.getInstance();
		createdDocument.setCreationDate(calendar.getTimeInMillis());
		createdDocument.setModificationDate(calendar.getTimeInMillis());
		createdDocument.setRoles(document.getRoles());
		createdDocument.setNodePath(fileNode.getPath());
		session.save();

		return createdDocument;
		// } catch (IOException ex) {
		// throw new RepositoryException(ex);
		// }
	}

	private ImageDocument fileNodeToImageDocument(Node node)
			throws RepositoryException {

		try {
			ImageDocument foundDocument = new ImageDocument();
			foundDocument.setNodeId(node.getIdentifier());
			foundDocument.setFileName(node.getProperty("fileName").getString());
			foundDocument.setCreationDate(node
					.getProperty(JcrConstants.JCR_CREATED).getDate()
					.getTimeInMillis());
			foundDocument.setModificationDate(node
					.getProperty(JcrConstants.JCR_LASTMODIFIED).getDate()
					.getTimeInMillis());
			if (node.hasProperty("creatorId")) {
				foundDocument.setCreatorId(node.getProperty("creatorId")
						.getLong());
			}
			if (node.hasProperty("finalDelivery")) {
				foundDocument.setFinalDelivery(node
						.getProperty("finalDelivery").getBoolean());
			}
			if (node.hasProperty("description")) {
				foundDocument.setDescription(node.getProperty("description")
						.getString());
			}
			if (node.hasProperty("roles")) {
				Property rolesProperty = node.getProperty("roles");
				Value[] rolesPropertyValues = rolesProperty.getValues();
				String[] roles = new String[rolesPropertyValues.length];
				for (int i = 0; i < rolesPropertyValues.length; i++) {
					roles[i] = rolesPropertyValues[i].getString();
				}
				foundDocument.setRoles(roles);
			}

			Node contentNode = node.getNode(JcrConstants.JCR_CONTENT);
			foundDocument.setDataSize(contentNode
					.getProperty(JcrConstants.JCR_DATA).getBinary().getSize());
			foundDocument.setMimeType(contentNode.getProperty(
					JcrConstants.JCR_MIMETYPE).getString());

			return foundDocument;
		} catch (RepositoryException e) {
			throw new RepositoryException("Error accessing " + node.getPath(),
					e);
		}
	}

	@Override
	public ImageDocument getImageDocument(String imageId)
			throws RepositoryException, InstanceNotFoundException {
		Session session = null;
		ImageDocument ImageDocument = null;
		try {
			session = repository.login(new SimpleCredentials("username",
					"password".toCharArray()));

			// find resource node
			Workspace workspace = session.getWorkspace();
			QueryManager queryManager = workspace.getQueryManager();
			Node rootNode = session.getRootNode();

			String queryString = "SELECT * " + "FROM [" + JcrConstants.NT_BASE
					+ "] " + "WHERE ISCHILDNODE(["
					+ rootNode.getNode(FILE_ACTIVITY_ROOT_NODE_PATH).getPath()
					+ "]) " + "AND fileActivityId = " + imageId;

			Query query = queryManager.createQuery(queryString, Query.JCR_SQL2);
			QueryResult queryResult = query.execute();

			Node resourceNode = null;
			if (queryResult.getNodes().hasNext()) {
				resourceNode = queryResult.getNodes().nextNode();
				String nodeParentPath = resourceNode.getPath();
				queryString = "SELECT * " + "FROM [" + JcrConstants.NT_BASE
						+ "] " + "WHERE ISCHILDNODE([" + nodeParentPath + "])";

				query = queryManager.createQuery(queryString, Query.JCR_SQL2);
				queryResult = query.execute();
				if (queryResult.getNodes().hasNext()) {
					Node fileNode = queryResult.getNodes().nextNode();
					ImageDocument = fileNodeToImageDocument(fileNode);
				}
			}
		} finally {
			if (session != null) {
				session.logout();
			}
		}
		return ImageDocument;
	}
}
