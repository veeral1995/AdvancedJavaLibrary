package com.library.model.services.factory;

import com.library.model.services.manager.PropertyManager;
import com.library.model.services.factory.ServiceFactory;
import com.library.model.business.exception.ServiceLoadException;
import com.library.model.services.IService;
import com.library.model.services.manager.SAXPropertyManager;

/**
 * The service factory is in charge of setting an instance of itself, then getting the services that are called, as well as the implementation of the service itself
 *   
 * @author Veeral Patel
 *
 */
public class ServiceFactory {
	private ServiceFactory() {}
	private static ServiceFactory serviceFactoryInstance;
	public static ServiceFactory getInstance() 
	{
		if (serviceFactoryInstance == null)
			serviceFactoryInstance = new ServiceFactory();		
		return serviceFactoryInstance;
	}

	//Here, we are getting the service name via the passed parameter. We are throwing an error if the service was not found or loaded
	public IService getService(String serviceName) throws ServiceLoadException
	{
		try 
		{
		   Class<?> c = Class.forName(getImplName(serviceName));
		   return (IService)c.newInstance();
		} catch (Exception excp) 
		{
		   serviceName = serviceName + " was not found";
		   throw new ServiceLoadException(serviceName, excp);
		}
	}
	

	//Here we are getting the implementation of the service
	private String getImplName (String serviceName)
	{
		return SAXPropertyManager.getPropertyValue(serviceName);
	}
	
}