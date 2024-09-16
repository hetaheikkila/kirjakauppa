package domain;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;


@Entity
public class Book {
    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String author, isbn, title;
    private int year;
	private double price;


	@ManyToOne
	@JsonIgnoreProperties("books")
	@JoinColumn(name = "categoryid")
	private Category category;

	public Book(String string, String string2, int i, String string3, double d, Category category2) {
	}

	public Book(String author, String isbn, String title, int year, double price, Category category) {
		super();
		this.author = author;
		this.isbn = isbn;
		this.title = title;
        this.year = year;
		this.price = price;
		this.category = category;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getauthor() {
		return author;
	}

	public void setauthor(String author) {
		this.author = author;
	}

	public String getisbn() {
		return isbn;
	}

	public void setisbn(String isbn) {
		this.isbn = isbn;
	}

	public String gettitle() {
		return title;
	}

	public void settitle(String title) {
		this.title = title;
	}
    public int getyear() {
		return year;
	}

	public void setyear(int year) {
		this.year = year;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price){
		this.price = price;
	}
	public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }


	@Override
	public String toString() {
		return "Book [id=" + id + ", author=" + author + ", isbn=" + 
		isbn + ", title=" + title + ", year=" + year + ", price="+price + 
		", category= "+ category + "]";
	}
}
