package Day3;

public class Book {
	String title;
	boolean issued = false;
	
	public Book(String title) {
		this.title = title;
	}
	
	public void issue() {
		if(!issued) {
			issued = true;
			System.out.println("Book '" + title + "'has been issued.");
		}else {
			System.out.println("Book '" + title + "' is already issued.");
		}
	}

}











