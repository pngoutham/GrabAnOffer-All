/**
 * 
 */
package com.gao.core.image.service;

import java.io.InputStream;
import java.util.List;

import javax.jcr.RepositoryException;

import com.gao.core.framework.hibernate.exceptions.InstanceNotFoundException;
import com.gao.core.framework.hibernate.properties.DocumentContent;
import com.gao.core.framework.hibernate.properties.ImageDocument;
import com.gao.core.framework.hibernate.properties.Resource;

/**
 * @author goutham
 * 
 */
public interface ImageService {
	public ImageDocument addDocument(Resource resource, ImageDocument document,
			InputStream content) throws RepositoryException;

	public ImageDocument getImageDocument(String imageId)
			throws RepositoryException, InstanceNotFoundException;

	public void delete(ImageDocument document) throws RepositoryException,
			InstanceNotFoundException;

	public ImageDocument find(ImageDocument document)
			throws RepositoryException, InstanceNotFoundException;

	public ImageDocument update(ImageDocument document, InputStream data)
			throws RepositoryException, InstanceNotFoundException;

	public List<ImageDocument> getDocuments(Resource resource)
			throws RepositoryException, InstanceNotFoundException;

	public DocumentContent getDocumentContent(ImageDocument document)
			throws RepositoryException, InstanceNotFoundException;

	public ImageDocument findByName(Resource resource, ImageDocument document)
			throws RepositoryException, InstanceNotFoundException;

}
