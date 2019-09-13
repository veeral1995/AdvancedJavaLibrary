package com.library.controller;

import com.library.model.domain.AvailableItems;


public interface IInterceptingController
{
    public boolean performAction(String commandString, AvailableItems availableItems);
    
} // end class InterceptingController