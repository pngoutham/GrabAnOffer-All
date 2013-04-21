package com.gao.core.framework.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import javax.jcr.PropertyType;
import javax.jcr.Repository;
import javax.jcr.RepositoryException;
import javax.jcr.RepositoryFactory;
import javax.jcr.Session;
import javax.jcr.SimpleCredentials;
import javax.jcr.UnsupportedRepositoryOperationException;
import javax.jcr.Workspace;
import javax.jcr.nodetype.ConstraintViolationException;
import javax.jcr.nodetype.NodeType;
import javax.jcr.nodetype.NodeTypeIterator;
import javax.jcr.nodetype.NodeTypeManager;
import javax.jcr.nodetype.NodeTypeTemplate;
import javax.jcr.nodetype.PropertyDefinitionTemplate;
import javax.swing.text.DefaultEditorKit.CutAction;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.jackrabbit.api.JackrabbitRepository;
import org.apache.jackrabbit.core.RepositoryFactoryImpl;
import org.apache.jackrabbit.core.RepositoryImpl;
import org.apache.jackrabbit.core.config.ConfigurationException;
import org.apache.jackrabbit.core.config.RepositoryConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.xml.sax.InputSource;

import com.gao.core.framework.repository.properties.CustomPropertyDefinationTemplate;

/**
 * 
 * @author jdomenech
 */
public class RepositoryFactoryBean implements FactoryBean, ResourceLoaderAware,
		InitializingBean, DisposableBean {

	private static final Logger logger = LoggerFactory
			.getLogger(RepositoryFactoryBean.class);
	protected RepositoryFactory repositoryFactory;
	protected String repositoryHome;
	protected String repositoryConf;
	protected String repositoryProps;
	protected ResourceLoader loader;
	protected Repository repository;
	protected boolean createRepositoryHome = false;
	protected boolean clearRepositoryDir = false;
	protected boolean useRepositoryFactory = false;

	public RepositoryFactoryBean() {
		repositoryFactory = new RepositoryFactoryImpl();
	}

	protected RepositoryConfig getRepositoryConfig(File conf)
			throws ConfigurationException, IOException {

		if (!StringUtils.isEmpty(repositoryProps)) {

			logger.debug("Using properties: {}", repositoryProps);
			Resource res = loader.getResource(repositoryProps);

			InputStream in = res.getInputStream();
			Properties props = new Properties();
			// props.load(in);

			props.setProperty("rep.home",
					"/media/Drive 1/Softwares/idea-1/codebase/git/customsitecreator/csc_repository");
			props.setProperty("wsp.name", "primary");
			// props.setProperty("", "");
			// props.setProperty("", "");

			props.list(System.out);

			InputSource xml = new InputSource(conf.getAbsolutePath());
			System.out.println("hello...before create" + conf.getAbsolutePath()
					+ "sdf");
			return RepositoryConfig.create(xml, props);
		}

		return RepositoryConfig.create(conf.getAbsolutePath(), repositoryHome);
	}

	@Override
	public void afterPropertiesSet() throws Exception {

		// if (true) {
		// logger.debug("NOT CREATING REPOSITORY");
		// return;
		// }
		logger.info("repohome", repositoryHome);
		if (!StringUtils.isEmpty(repositoryHome)) {
			this.repositoryHome = FilenameUtils.normalize(repositoryHome);

			File repositoryHomeDir = new File(repositoryHome);
			logger.info("clearRepositoryDir", clearRepositoryDir);
			if (clearRepositoryDir) {
				try {
					FileUtils.deleteDirectory(repositoryHomeDir);
				} catch (Exception e) {
					// Do nothing
				}
			}
			logger.info("createRepositoryHome", createRepositoryHome);
			if (createRepositoryHome && (!repositoryHomeDir.exists())) {
				repositoryHomeDir.mkdirs();
			}

			if (!repositoryHomeDir.exists() || !repositoryHomeDir.isDirectory()) {
				throw new FileNotFoundException("Repository directory "
						+ repositoryHome + " is not accesible");
			}

			logger.debug("Initializing repository in location: '{}'",
					repositoryHomeDir.getAbsolutePath());
		}
		logger.info("repositoryConf", repositoryConf);
		Resource resource = loader.getResource(repositoryConf);
		File conf = File.createTempFile("conf", "xml");

		FileOutputStream out = null;

		try {
			out = new FileOutputStream(conf);
			IOUtils.copy(resource.getInputStream(), out);
		} finally {
			IOUtils.closeQuietly(out);
		}
		System.out.println("useRepositoryFactory: " + useRepositoryFactory);
		if (useRepositoryFactory) {
			Map parameters = new HashMap();
			parameters.put(RepositoryFactoryImpl.REPOSITORY_CONF,
					conf.getPath());
			parameters.put((RepositoryFactoryImpl.REPOSITORY_HOME),
					repositoryHome);
			repository = repositoryFactory.getRepository(parameters);
		} else {
			RepositoryConfig config = getRepositoryConfig(conf);
			repository = RepositoryImpl.create(config);
		}
		logger.info("createCustomNodeTypes", "createCustomNodeTypes");
		createCustomNodeTypes(repository);
	}

	public void destroy() throws Exception {
		if (repository instanceof JackrabbitRepository) {
			((JackrabbitRepository) repository).shutdown();
		}
	}

	public Object getObject() throws Exception {
		return repository;
	}

	protected void createCustomNodeTypes1(Repository repository)
			throws RepositoryException {

		Session session = null;
		try {
			session = repository.login(new SimpleCredentials("username",
					"password".toCharArray()));
			Workspace workspace = session.getWorkspace();
			NodeTypeManager nodeTypeManager = workspace.getNodeTypeManager();
			boolean existActivityType = false;
			for (NodeTypeIterator it = nodeTypeManager.getAllNodeTypes(); it
					.hasNext();) {
				NodeType nodeType = it.nextNodeType();
				if (nodeType.getName().equals("mix:resourceDocument")) {
					existActivityType = true;
					break;
				}
			}

			if (!existActivityType) {
				NodeTypeTemplate nodeTypeTemplate = nodeTypeManager
						.createNodeTypeTemplate();
				nodeTypeTemplate.setName("mix:resourceDocument");
				nodeTypeTemplate.setMixin(true);

				PropertyDefinitionTemplate descriptionProperty = nodeTypeManager
						.createPropertyDefinitionTemplate();
				descriptionProperty.setName("description");
				descriptionProperty.setRequiredType(PropertyType.STRING);
				descriptionProperty.setMandatory(false);
				nodeTypeTemplate.getPropertyDefinitionTemplates().add(
						descriptionProperty);

				PropertyDefinitionTemplate fileTitleProperty = nodeTypeManager
						.createPropertyDefinitionTemplate();
				fileTitleProperty.setName("fileTitle");
				fileTitleProperty.setRequiredType(PropertyType.STRING);
				fileTitleProperty.setMandatory(false);
				nodeTypeTemplate.getPropertyDefinitionTemplates().add(
						fileTitleProperty);

				PropertyDefinitionTemplate filenameProperty = nodeTypeManager
						.createPropertyDefinitionTemplate();
				filenameProperty.setName("fileName");
				filenameProperty.setRequiredType(PropertyType.STRING);
				filenameProperty.setMandatory(true);
				nodeTypeTemplate.getPropertyDefinitionTemplates().add(
						filenameProperty);

				PropertyDefinitionTemplate rolesProperty = nodeTypeManager
						.createPropertyDefinitionTemplate();
				rolesProperty.setName("roles");
				rolesProperty.setRequiredType(PropertyType.STRING);
				rolesProperty.setMultiple(true);
				nodeTypeTemplate.getPropertyDefinitionTemplates().add(
						rolesProperty);

				PropertyDefinitionTemplate fileActivityIdProperty = nodeTypeManager
						.createPropertyDefinitionTemplate();
				fileActivityIdProperty.setName("fileActivityId");
				fileActivityIdProperty.setRequiredType(PropertyType.LONG);
				fileActivityIdProperty.setMultiple(true);
				fileActivityIdProperty.setMandatory(false);
				nodeTypeTemplate.getPropertyDefinitionTemplates().add(
						fileActivityIdProperty);

				PropertyDefinitionTemplate creatorIdProperty = nodeTypeManager
						.createPropertyDefinitionTemplate();
				creatorIdProperty.setName("creatorId");
				creatorIdProperty.setRequiredType(PropertyType.LONG);
				creatorIdProperty.setMandatory(false);
				nodeTypeTemplate.getPropertyDefinitionTemplates().add(
						creatorIdProperty);

				PropertyDefinitionTemplate modifierIdProperty = nodeTypeManager
						.createPropertyDefinitionTemplate();
				modifierIdProperty.setName("modifierId");
				modifierIdProperty.setRequiredType(PropertyType.LONG);
				modifierIdProperty.setMandatory(false);
				nodeTypeTemplate.getPropertyDefinitionTemplates().add(
						modifierIdProperty);

				PropertyDefinitionTemplate sessionIdProperty = nodeTypeManager
						.createPropertyDefinitionTemplate();
				sessionIdProperty.setName("sessionId");
				sessionIdProperty.setRequiredType(PropertyType.LONG);
				sessionIdProperty.setMandatory(false);
				nodeTypeTemplate.getPropertyDefinitionTemplates().add(
						sessionIdProperty);

				PropertyDefinitionTemplate finalDeliveryProperty = nodeTypeManager
						.createPropertyDefinitionTemplate();
				finalDeliveryProperty.setName("finalDelivery");
				finalDeliveryProperty.setRequiredType(PropertyType.BOOLEAN);
				finalDeliveryProperty.setMandatory(false);
				nodeTypeTemplate.getPropertyDefinitionTemplates().add(
						finalDeliveryProperty);

				// Properties required for Schoolclass library
				PropertyDefinitionTemplate isPublishedProperty = nodeTypeManager
						.createPropertyDefinitionTemplate();
				isPublishedProperty.setName("published");
				isPublishedProperty.setRequiredType(PropertyType.BOOLEAN);
				isPublishedProperty.setMandatory(false);
				nodeTypeTemplate.getPropertyDefinitionTemplates().add(
						isPublishedProperty);

				PropertyDefinitionTemplate creationDateProperty = nodeTypeManager
						.createPropertyDefinitionTemplate();
				creationDateProperty.setName("creationDateInMillis");
				creationDateProperty.setRequiredType(PropertyType.LONG);
				creationDateProperty.setMandatory(false);
				nodeTypeTemplate.getPropertyDefinitionTemplates().add(
						creationDateProperty);

				PropertyDefinitionTemplate modificationDateProperty = nodeTypeManager
						.createPropertyDefinitionTemplate();
				modificationDateProperty.setName("modificationDateInMillis");
				modificationDateProperty.setRequiredType(PropertyType.LONG);
				modificationDateProperty.setMandatory(false);
				nodeTypeTemplate.getPropertyDefinitionTemplates().add(
						modificationDateProperty);

				PropertyDefinitionTemplate creatorRoleProperty = nodeTypeManager
						.createPropertyDefinitionTemplate();
				creatorRoleProperty.setName("creatorRole");
				creatorRoleProperty.setRequiredType(PropertyType.STRING);
				creatorRoleProperty.setMultiple(false);
				nodeTypeTemplate.getPropertyDefinitionTemplates().add(
						creatorRoleProperty);

				// PropertyDefinitionTemplate studentIdProperty =
				// nodeTypeManager.createPropertyDefinitionTemplate();
				// studentIdProperty.setName("studentId");
				// studentIdProperty.setRequiredType(PropertyType.LONG);
				// studentIdProperty.setMandatory(false);
				// nodeTypeTemplate.getPropertyDefinitionTemplates().add(studentIdProperty);

				nodeTypeManager.registerNodeType(nodeTypeTemplate, true);
			}
		} finally {
			if (session != null) {
				session.logout();
			}
		}
	}

	protected void createCustomNodeTypes(Repository repository)
			throws RepositoryException {

		Session session = null;
		try {
			session = repository.login(new SimpleCredentials("username",
					"password".toCharArray()));
			Workspace workspace = session.getWorkspace();
			NodeTypeManager nodeTypeManager = workspace.getNodeTypeManager();
			boolean existActivityType = false;
			for (NodeTypeIterator it = nodeTypeManager.getAllNodeTypes(); it
					.hasNext();) {
				NodeType nodeType = it.nextNodeType();
				if (nodeType.getName().equals("mix:imageDocument")) {
					existActivityType = true;
					break;
				}
			}

			if (!existActivityType) {
				NodeTypeTemplate nodeTypeTemplate = nodeTypeManager
						.createNodeTypeTemplate();
				nodeTypeTemplate.setName("mix:imageDocument");
				nodeTypeTemplate.setMixin(true);

				List<CustomPropertyDefinationTemplate> customPropertyDefinationTemplateList = getCustomProperties();

				for (CustomPropertyDefinationTemplate template : customPropertyDefinationTemplateList) {

					nodeTypeTemplate.getPropertyDefinitionTemplates().add(
							getPropertyDefinitionTemplate(nodeTypeManager,
									template));
				}

				nodeTypeManager.registerNodeType(nodeTypeTemplate, true);
			}
		} finally {
			if (session != null) {
				session.logout();
			}
		}
	}

	private PropertyDefinitionTemplate getPropertyDefinitionTemplate(
			NodeTypeManager nodeTypeManager,
			CustomPropertyDefinationTemplate customPropertyDefinationTemplate)
			throws UnsupportedRepositoryOperationException,
			RepositoryException, ConstraintViolationException {
		PropertyDefinitionTemplate propertyDefination = nodeTypeManager
				.createPropertyDefinitionTemplate();
		propertyDefination.setName(customPropertyDefinationTemplate
				.getProperty_name());
		propertyDefination.setMandatory(customPropertyDefinationTemplate
				.isManadatory());
		if (customPropertyDefinationTemplate.isManadatory()) {
			propertyDefination.setMandatory(customPropertyDefinationTemplate
					.isMixin());
		}
		if (customPropertyDefinationTemplate.isMultiple()) {
			propertyDefination.setMultiple(customPropertyDefinationTemplate
					.isMultiple());
		}
		if (customPropertyDefinationTemplate.getRequired_type() != -1) {
			propertyDefination.setRequiredType(customPropertyDefinationTemplate
					.getRequired_type());
		}
		return propertyDefination;
	}

	private List<CustomPropertyDefinationTemplate> getCustomProperties() {
		List<CustomPropertyDefinationTemplate> list = new ArrayList<CustomPropertyDefinationTemplate>();
		CustomPropertyDefinationTemplate customProperty = new CustomPropertyDefinationTemplate();
		customProperty.setProperty_name("fileName");
		customProperty.setManadatory(false);
		customProperty.setProperty_type(PropertyType.STRING);
		list.add(customProperty);

		CustomPropertyDefinationTemplate customProperty1 = new CustomPropertyDefinationTemplate();
		customProperty1.setProperty_name("visibility");
		customProperty1.setManadatory(false);
		customProperty1.setProperty_type(PropertyType.STRING);
		list.add(customProperty1);

		CustomPropertyDefinationTemplate customProperty2 = new CustomPropertyDefinationTemplate();
		customProperty2.setProperty_name("albumId");
		customProperty2.setManadatory(false);
		customProperty2.setProperty_type(PropertyType.STRING);
		list.add(customProperty2);

		CustomPropertyDefinationTemplate customProperty3 = new CustomPropertyDefinationTemplate();
		customProperty3.setProperty_name("creatorId");
		customProperty3.setManadatory(false);
		customProperty3.setProperty_type(PropertyType.STRING);
		list.add(customProperty3);

		CustomPropertyDefinationTemplate customProperty5 = new CustomPropertyDefinationTemplate();
		customProperty5.setProperty_name("createDate");
		customProperty5.setManadatory(false);
		customProperty5.setProperty_type(PropertyType.DATE);
		list.add(customProperty5);

		CustomPropertyDefinationTemplate customProperty6 = new CustomPropertyDefinationTemplate();
		customProperty6.setProperty_name("modifiedDate");
		customProperty6.setManadatory(false);
		customProperty6.setProperty_type(PropertyType.DATE);
		list.add(customProperty6);

		CustomPropertyDefinationTemplate customProperty7 = new CustomPropertyDefinationTemplate();
		customProperty7.setProperty_name("imageType");
		customProperty7.setManadatory(false);
		customProperty7.setProperty_type(PropertyType.STRING);
		list.add(customProperty7);

		/*
		 * //Properties required for Schoolclass library
		 * PropertyDefinitionTemplate isPublishedProperty =
		 * nodeTypeManager.createPropertyDefinitionTemplate();
		 * isPublishedProperty.setName("published");
		 * isPublishedProperty.setRequiredType(PropertyType.BOOLEAN);
		 * isPublishedProperty.setMandatory(false);
		 * nodeTypeTemplate.getPropertyDefinitionTemplates
		 * ().add(isPublishedProperty);
		 * 
		 * PropertyDefinitionTemplate creationDateProperty =
		 * nodeTypeManager.createPropertyDefinitionTemplate();
		 * creationDateProperty.setName("creationDateInMillis");
		 * creationDateProperty.setRequiredType(PropertyType.LONG);
		 * creationDateProperty.setMandatory(false);
		 * nodeTypeTemplate.getPropertyDefinitionTemplates
		 * ().add(creationDateProperty);
		 * 
		 * PropertyDefinitionTemplate modificationDateProperty =
		 * nodeTypeManager.createPropertyDefinitionTemplate();
		 * modificationDateProperty.setName("modificationDateInMillis");
		 * modificationDateProperty.setRequiredType(PropertyType.LONG);
		 * modificationDateProperty.setMandatory(false); nodeTypeTemplate
		 * .getPropertyDefinitionTemplates().add(modificationDateProperty );
		 * 
		 * PropertyDefinitionTemplate creatorRoleProperty =
		 * nodeTypeManager.createPropertyDefinitionTemplate();
		 * creatorRoleProperty.setName("creatorRole");
		 * creatorRoleProperty.setRequiredType(PropertyType.STRING);
		 * creatorRoleProperty.setMultiple(false);
		 * nodeTypeTemplate.getPropertyDefinitionTemplates
		 * ().add(creatorRoleProperty);
		 * 
		 * // PropertyDefinitionTemplate studentIdProperty = //
		 * nodeTypeManager.createPropertyDefinitionTemplate(); //
		 * studentIdProperty.setName("studentId"); //
		 * studentIdProperty.setRequiredType(PropertyType.LONG); //
		 * studentIdProperty.setMandatory(false); //
		 * nodeTypeTemplate.getPropertyDefinitionTemplates
		 * ().add(studentIdProperty);
		 */
		return list;
	}

	public Class getObjectType() {
		return javax.jcr.Repository.class;
	}

	public boolean isSingleton() {
		return true;
	}

	public String getRepositoryHome() {
		return repositoryHome;
	}

	public void setRepositoryHome(String repositoryHome) {
		this.repositoryHome = repositoryHome;
	}

	public void setResourceLoader(ResourceLoader resourceLoader) {
		this.loader = resourceLoader;
	}

	public String getRepositoryConf() {
		return repositoryConf;
	}

	public void setRepositoryConf(String repositoryConf) {
		this.repositoryConf = repositoryConf;
	}

	/**
	 * @return the createRepositoryHome
	 */
	public boolean isCreateRepositoryHome() {
		return createRepositoryHome;
	}

	/**
	 * @param createRepositoryHome
	 *            the createRepositoryHome to set
	 */
	public void setCreateRepositoryHome(boolean createRepositoryHome) {
		this.createRepositoryHome = createRepositoryHome;
	}

	public boolean isClearRepositoryDir() {
		return clearRepositoryDir;
	}

	public void setClearRepositoryDir(boolean clearRepositoryDir) {
		this.clearRepositoryDir = clearRepositoryDir;
	}

	public void setUseRepositoryFactory(boolean useRepositoryFactory) {
		this.useRepositoryFactory = useRepositoryFactory;
	}

	/**
	 * @return the repositoryProps
	 */
	public String getRepositoryProps() {
		return repositoryProps;
	}

	/**
	 * @param repositoryProps
	 *            the repositoryProps to set
	 */
	public void setRepositoryProps(String repositoryProps) {
		this.repositoryProps = repositoryProps;
	}
}
