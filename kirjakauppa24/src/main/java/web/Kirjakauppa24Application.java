package web;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import domain.Book;
import domain.BookRepository;
import domain.Category;
import domain.CategoryRepository;

@SpringBootApplication
@ComponentScan(basePackages = {"web", "domain"})
public class Kirjakauppa24Application {

	public static void main(String[] args) {
		SpringApplication.run(Kirjakauppa24Application.class, args);
	}

	@Bean
	public CommandLineRunner demo(BookRepository bookRepository, CategoryRepository categoryRepository) {
		return (args) -> {

			Category category1 = new Category("Romance");
			Category category2 = new Category("Thriller");
			Category category3 = new Category("Novel");
			categoryRepository.save(category1);
			categoryRepository.save(category2);
			categoryRepository.save(category3);

			//String author, String isbn, int year, String title, double price, Category category
			Book book1 = new Book("Hennig Mankell", "mau", "0", "Kasvoton kuolema", 12., category2);
			Book book2 = new Book("Hennig Mankell", "mau", "0", "Riian verikoirat", 13.0, category3);
			bookRepository.save(book1);
			bookRepository.save(book2);

		};
	}
}