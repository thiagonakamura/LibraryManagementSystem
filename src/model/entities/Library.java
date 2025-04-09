package model.entities;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a library system that manages a collection of books.
 * Provides methods to add, remove, list available books, and search by title.
 */
public class Library {
	
	// Internal list to store all registered books in the library
	private List<Book> books = new ArrayList<Book>();

	
	// Returns the list of all books in the library.
	public List<Book> getBooks() {
		return books;
	}
	
	
	// Adds a book to the library collection and marks it as available.
	public void addBook(Book book) {
		books.add(book);
		book.setAvailable(true);
	}
	
	
	// Removes a book from the library collection and marks it as unavailable.
	public void removeBook(Book book) {
		books.remove(book);
		book.setAvailable(false);
	}
	
	
	// Displays all books that are currently available in the library.
	public void booksAvailable() {
		for(Book x : books) {
			if(x.isAvailable() == true) {
				System.out.println(x);
			}
		}
	}
	
	
	/**
	 * Searches for a book by title that is currently available.
	 * The search is case-insensitive.
	 */
	public Book findBookByTitle(String title) {
		for(Book x : books) {
			if(x.getTitle().equalsIgnoreCase(title) && x.isAvailable()) {
				return x;
			}
		}
		return null;
	}
}
