package com.library.model.services.factory;

import com.library.model.doa.ILibraryDao;
import com.library.model.services.exception.DaoLoadException;
import com.library.model.services.manager.PropertyManager;

/**
 * This factory class retrieves from the properties file the concrete
 * type of DAO implementation - JDBC or Hibernate
 * 
 *     
 * @author Veeral Patel
 *
 */
public class DAOFactory
{
   public static ILibraryDao getDao() throws DaoLoadException
   {

     Class  c;
     Object o = null;
	try
	{
		String daoImplString = PropertyManager.getPropertyValue("ILibraryDao");
                c = Class.forName(daoImplString);
		o = c.newInstance();

	} catch (ClassNotFoundException e) {
		throw new DaoLoadException("Class not found", e);
	} catch (InstantiationException e) {
		throw new DaoLoadException("Instantiation Issue", e);
	} catch (IllegalAccessException e) {
		throw new DaoLoadException("Illegal Access Issue", e);
	}
	return (ILibraryDao)o;
   } //end getService

}//end ServiceFactory