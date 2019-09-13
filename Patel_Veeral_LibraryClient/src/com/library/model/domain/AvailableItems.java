package com.library.model.domain;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import com.library.model.domain.Book;
import com.library.model.domain.Movie;
import com.library.model.domain.CD;

public class AvailableItems implements Serializable{

	/**
	 * @author Veeral Patel
	 */
	
	//Here we need Serializable to be able to write to the output files
	private static final long serialVersionUID = 1L;
	
	//the allAvailableItems is used to add every object in the library that is available
	ArrayList<Object> allAvailableItems = new ArrayList<Object>();
	
	//This output variable is used to write objects to the output files
	ObjectOutputStream output = null;
	

	//This method is used in order to add a new book. A clause in there checks if the item is available or not
	public void addBook(Book newBook) throws FileNotFoundException, IOException, Exception {
		
		if(newBook.getAvailibility() == 0) {
		
			//Here we are writing the book to the output file, as well as adding it to the allAvailableItems array
			output = new ObjectOutputStream (new FileOutputStream("BooksAvailable.out"));
			output.writeObject(newBook);
                        System.out.println("Inside of AvailableItems.addBook!");
			allAvailableItems.add(newBook);
		}
		//If the item is not available for customers to rent, this exception will be thrown (Availibility Exception)
		else {
		throw new Exception("That Item Is Not Availible, It Might Be Checked Out");
		}
	}

	//This method is used in order to add a new CD. A clause in there checks if the item is available or not
	public void addCD(CD newCD) throws FileNotFoundException, IOException, Exception {
		
		if(newCD.getAvailibility() == 0) {
			//Here we are writing the book to the output file, as well as adding it to the allAvailableItems array
			output = new ObjectOutputStream (new FileOutputStream("CDsAvailable.out"));
			output.writeObject(newCD);
			allAvailableItems.add(newCD);
		}
		//If the item is not available for customers to rent, this exception will be thrown (Availibility Exception)
		else {
			throw new Exception("That Item Is Not Availible, It Might Be Checked Out");
		}
	}
	
	//This method is used in order to add a new Movie. A clause in there checks if the item is available or not
	public void addMovie(Movie newMovie) throws FileNotFoundException, IOException, Exception {
		
		if(newMovie.getAvailibility() == 0) {
			//Here we are writing the book to the output file, as well as adding it to the allAvailableItems array
			output = new ObjectOutputStream (new FileOutputStream("MoviesAvailable.out"));
			output.writeObject(newMovie);
			allAvailableItems.add(newMovie);
			//Here we are writing the book to the output file, as well as adding it to the allAvailableItems array
		}
		//If the item is not available for customers to rent, this exception will be thrown (Availibility Exception)
		else {
			throw new Exception("That Item Is Not Availible, It Might Be Checked Out");
		}
	}
	
	//This method just returns the allAvailableItems array, with all available items in the library
	public ArrayList<Object> returnAllAvailibleItems() throws FileNotFoundException, IOException {
		return allAvailableItems;
	}
	
	//This method returns a list of objects that match the search string
	public ArrayList<Object> returnSearchResult (String str){
		
		//Here, we are turning the string to lowercase, which is what all object titles are stored in, via their class consturctors.
		str = str.toLowerCase().trim();
		ArrayList<Object> searchResult = new ArrayList<> ();
                
		for(int i = 0; i< allAvailableItems.size(); i++) {
			
			if(allAvailableItems.get(i) instanceof Book)
				if( ((Book)allAvailableItems.get(i)).getTitle()       .equals(str)) {
					searchResult.add(allAvailableItems.get(i));
				}
                                
			else if(allAvailableItems.get(i) instanceof Movie)
				if(((Movie)allAvailableItems.get(i)).getTitle()       .equals(str)) {
					searchResult.add(allAvailableItems.get(i));
				}
                                
			else if(allAvailableItems.get(i) instanceof CD)
				if(((CD)allAvailableItems.get(i)).getTitle()         .equals(str)) {
					searchResult.add(allAvailableItems.get(i));
				}
			
		}
		return searchResult;
	}

	
	
}
