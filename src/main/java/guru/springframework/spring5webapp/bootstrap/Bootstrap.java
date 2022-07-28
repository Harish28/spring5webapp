package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.Model.Address;
import guru.springframework.spring5webapp.Model.Author;
import guru.springframework.spring5webapp.Model.Book;
import guru.springframework.spring5webapp.Model.Publisher;
import guru.springframework.spring5webapp.Repositories.AuthorRepository;
import guru.springframework.spring5webapp.Repositories.BookRepository;
import guru.springframework.spring5webapp.Repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Bootstrap implements CommandLineRunner {
    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public Bootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author a1 = new Author("Gorge","cavin");
        Author a2 = new Author("Brayn","Adams");
        Book b1 = new Book("GOT","112");
        Book b2 = new Book("GOT2","1312");
        /////////////////////publisher/////////////////
        Publisher p1 = new Publisher();
        p1.setName("ABC");
        p1.setAddressLine("MG road");
        p1.setCity("Bangalore");
        p1.setState("Karnataka");
        p1.setZip("56007");
        publisherRepository.save(p1);
        p1.getBooks().add(b1);
        p1.getBooks().add(b2);
        /////////////////////publisher/////////////////
        b1.setPublisher(p1);
        b2.setPublisher(p1);
        a1.getBooks().add(b1);
        a2.getBooks().add(b2);
        b2.getAuthors().add(a2);
        b1.getAuthors().add(a1);
        authorRepository.save(a1);
        authorRepository.save(a2);
        bookRepository.save(b1);
        bookRepository.save(b2);
        publisherRepository.save(p1);
        System.out.println("No of Books: " + bookRepository.count());
        System.out.println("No Of Authors: " + authorRepository.count());
        System.out.println("No Of Publisher: " + publisherRepository.count());

    }
}
