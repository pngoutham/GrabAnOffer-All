package com.gao.core.image.service;

import java.io.InputStream;
import java.util.List;

import javax.jcr.RepositoryException;

import com.gao.core.framework.hibernate.exceptions.InstanceNotFoundException;
import com.gao.core.framework.hibernate.properties.DocumentContent;
import com.gao.core.framework.hibernate.properties.ImageDocument;
import com.gao.core.framework.hibernate.properties.Resource;
import com.gao.core.image.dao.ImageDao;

public class ImageServiceImpl implements ImageService {

	private ImageDao repositoryDao;

	public void setRepositoryDao(ImageDao repositoryDao) {
		this.repositoryDao = repositoryDao;
	}

	@Override
	public ImageDocument addDocument(Resource resource, ImageDocument document,
			InputStream content) throws RepositoryException {
		// TODO Auto-generated method stub
		return repositoryDao.addDocument(resource, document, content);
	}

	@Override
	public ImageDocument getImageDocument(String imageId)
			throws RepositoryException, InstanceNotFoundException {
		// TODO Auto-generated method stub
		return repositoryDao.getImageDocument(imageId);
	}

	@Override
	public void delete(ImageDocument document) throws RepositoryException,
			InstanceNotFoundException {
		// TODO Auto-generated method stub
		repositoryDao.delete(document);
	}

	@Override
	public ImageDocument find(ImageDocument document)
			throws RepositoryException, InstanceNotFoundException {
		// TODO Auto-generated method stub
		return repositoryDao.find(document);
	}

	@Override
	public ImageDocument update(ImageDocument document, InputStream data)
			throws RepositoryException, InstanceNotFoundException {
		// TODO Auto-generated method stub
		return repositoryDao.update(document, data);
	}

	@Override
	public List<ImageDocument> getDocuments(Resource resource)
			throws RepositoryException, InstanceNotFoundException {
		// TODO Auto-generated method stub
		return repositoryDao.getDocuments(resource);
	}

	@Override
	public DocumentContent getDocumentContent(ImageDocument document)
			throws RepositoryException, InstanceNotFoundException {
		// TODO Auto-generated method stub
		return repositoryDao.getDocumentContent(document);
	}

	@Override
	public ImageDocument findByName(Resource resource, ImageDocument document)
			throws RepositoryException, InstanceNotFoundException {
		// TODO Auto-generated method stub
		return repositoryDao.findByName(resource, document);
	}

}
