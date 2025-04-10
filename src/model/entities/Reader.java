package model.entities;

import java.util.ArrayList;
import java.util.List;

/**
 * Class representing a Reader in the library system.
 * Each Reader can borrow and return books, and keeps track of their own borrowed books.
 */
public class Reader {
	
	private String name;
	private List<Book> myBooks = new ArrayList<Book>();
	private Library lib;
	
	public Reader(String name, Library lib) {
		super();
		this.name = name;
		this.lib = lib;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Book> getMyBooks() {
		return myBooks;
	}
	
	
	/**
     * Borrows a book from the library.
     * Adds the book to the reader’s list and marks it as unavailable in the library.
     */
	public void borrowBook(Book book) {
		if(book.isAvailable()) {
			myBooks.add(book);
			lib.removeBook(book);
		}
	}
	
	
	/**
     * Returns a book to the library.
     * Removes the book from the reader’s list and makes it available again.
     */
	public void returnBook(Book book) {
		if(myBooks.contains(book)) {
			myBooks.remove(book);
			lib.addBook(book);
		}
	}
	
	
	// Lists all books currently borrowed by the reader.
	public void listReader() {
		for(Book x : myBooks) {
			System.out.println(x);
		}
	}
	
	
	/**
	 * Searches for a book by title that is currently available.
	 * The search is case-insensitive.
	 */
	public Book findBookByTitle(String title) {
		for(Book x : myBooks) {
			if(x.getTitle().equalsIgnoreCase(title)) {
				return x;
			}
		}
		return null;
	}
}
