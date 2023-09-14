import java.util.List;
import java.util.Scanner;

import controller.BookHelper;
import model.Book;

public class StartProgram {
	
	static Scanner in = new Scanner(System.in);
	
	static BookHelper bh = new BookHelper();
	
	private static void addBook() {
		System.out.print("Enter the author: ");
		String author = in.nextLine();
		System.out.print("Enter the title: ");
		String title = in.nextLine();
		Book toAdd = new Book(author, title);
		bh.insertBook(toAdd);
	}
	
	private static void deleteBook() {
		Book toDelete = new Book();
		viewTheList();
		System.out.println("Enter the ID number of the book to delete");
		toDelete.setId(in.nextInt());
		bh.removeBook(toDelete);
	}
	
	private static void editBook() {
		
		Book toUpdate = new Book();
		viewTheList();
		System.out.println("Enter the ID number of the book to update");
		toUpdate.setId(in.nextInt());
		System.out.println("What is the author's name?");
		in.nextLine();//had to add this line to keep scanner from skipping input
		toUpdate.setAuthor(in.nextLine());
		System.out.println("What is the title?");
		toUpdate.setTitle(in.nextLine());		
		bh.updateBook(toUpdate);
		
		
	}
	
	public static void main(String[] args) {
		StartProgram start = new StartProgram();	
		start.run();
	}
	
	private void run() {
			
		int userIn = 0;
		Scanner in = new Scanner(System.in);
		while (userIn != 5) {
			printMenu();
			userIn = in.nextInt();
		
			if (userIn ==1) {
				addBook();
				} else if (userIn == 2) {
					deleteBook();
				} else if (userIn == 3) {
					editBook();
				} else if (userIn == 4) {
					viewTheList();
			}
		}
		System.out.println("Bye, happy reading!");
		in.close();
	}
	
	private void printMenu() {
		System.out.println("1.Add Book");
		System.out.println("2.Remove Book");
		System.out.println("3.Update Book");
		System.out.println("4.Show all books");
		System.out.println("5.Quit");
		System.out.println("**************");
	}
	
	private static void viewTheList() {
		// TODO Auto-generated method stub
		List<Book> allItems = bh.showAllItems();
		for(Book book : allItems) {
			System.out.println(book.returnBookDetails());
		}

	}
}
