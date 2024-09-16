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

			Category category1 = new Category("Scifi");
			Category category2 = new Category("Thriller");
			Category category3 = new Category("Novel");
			categoryRepository.save(category1);
			categoryRepository.save(category2);
			categoryRepository.save(category3);

			Book book1 = new Book("The Hidden Secrets", "Jane Doe", 2023, "978-1-234567-89-0", 12.99, category2);
			Book book2 = new Book("Echoes of Destiny", "John Smith", 2021, "978-0-987654-32-1", 15.49, category3);
			bookRepository.save(book1);
			bookRepository.save(book2);

		};

	}

}
