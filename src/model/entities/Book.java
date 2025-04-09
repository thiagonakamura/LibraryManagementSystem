package model.entities;

/**
 * Represents a book entity in the system.
 * This class holds basic information about a book including title, author, and availability status.
 * It provides methods to lend and return the book, as well as accessors and mutators.
 **/
public class Book {

	private String title;
	private String author;
	private boolean available;
	
	public Book() {
	}
	
	public Book(String title, String author, boolean available) {
		super();
		this.title = title;
		this.author = author;
		this.available = available;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}
	
	// Marks the book as lent
	public void lendBook() {
		available = false;
	}
	
	// Marks the book as returned
	public void returnBook() {
		available = true;
	}
	
	@Override
	public String toString() {
		return "Title: " + title;
	}
}
