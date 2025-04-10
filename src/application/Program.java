package application;

import java.util.Locale;
import java.util.Scanner;

import model.entities.Book;
import model.entities.Library;
import model.entities.Reader;

public class Program {

	public static void main(String[] args) {
		
		// Set default locale to US (helps with formatting, like decimals)
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		// Create a new library
		Library lib = new Library();
		
		// Add books to the library
		lib.addBook(new Book("Don Quixote", "Miguel de Cervantes", true));
		lib.addBook(new Book("Animal Farm", "George Orwell", true));
		lib.addBook(new Book("The Lord of the Rings", "John Ronald", true));
		
		// Ask the user for their name
		System.out.print("Name: ");
		String nameReader = sc.nextLine();
		Reader reader = new Reader(nameReader, lib); // Create a reader linked to the library
			
		String actionReader = "";
		
		// Main program loop
		while (!actionReader.equals("LEAVE")) {
			System.out.println();
			System.out.print("Borrow a book, return a book or leave? ");
			actionReader = sc.nextLine().toUpperCase(); // Convert to uppercase for easier comparison
			
			// Handle book borrowing
			if (actionReader.equals("BORROW")) {			
				lib.booksAvailable(); // Display available books
				
				System.out.println();
				System.out.print("Title of the book you want to borrow: ");
				String titleBook = sc.nextLine().toUpperCase(); // Read the title and convert to uppercase
				
				// Search for the book in the library
				Book bookToBorrow = lib.findBookByTitle(titleBook);
				
				// If the book exists and is available, borrow it
				if (bookToBorrow != null && bookToBorrow.isAvailable()) {
					reader.borrowBook(bookToBorrow);
					System.out.println("You have borrowed: " + bookToBorrow.getTitle());
					
					// Show the reader's borrowed books
					System.out.println("---------------------");
					System.out.println("Your books:");
					reader.listReader();
				}
				else {
					System.out.println("Book not available!");
				}
			} 
			
			// Handle book return
			else if (actionReader.equals("RETURN")) {
				
				// Check if reader has any books
				if (!reader.getMyBooks().isEmpty()) {
					System.out.println("---------------------");
					System.out.println("Your books:");
					reader.listReader(); // List borrowed books
					System.out.print("\nTitle of the book you want to return: ");
					String titleReturnBook = sc.nextLine().toUpperCase();
					
					// Search for the book in the reader's borrowed list
					Book bookToReturn = reader.findBookByTitle(titleReturnBook);
					
					// If found, return it
					if (bookToReturn != null) {
						reader.returnBook(bookToReturn);
						System.out.println("Book returned!");
					}
					else {
						System.out.println("You don´t have this book!");
					}
					
					// Show updated list of borrowed books
					System.out.println("---------------------");
					System.out.println("Your books:");
					reader.listReader();
				}
				else {
					System.out.println("You don´t have any books!");
				}	
			}
			
			// Handle program exit
			else if (actionReader.equals("LEAVE")) {
				System.out.println("Goodbye!");
			}
			
			
		}
		
		
		
		
		sc.close();

	}

}