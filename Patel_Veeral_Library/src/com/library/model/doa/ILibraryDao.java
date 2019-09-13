/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.library.model.doa;
import com.library.model.domain.RentalItem;
import com.library.model.domain.AvailableItems;

/**
 *
 * @author vpatel48
 */
public interface ILibraryDao {
    
    	public boolean rentItem(String catalogNumber);
	
	public boolean getAllItems();

    
}
