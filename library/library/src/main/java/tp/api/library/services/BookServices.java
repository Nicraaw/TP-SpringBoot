package tp.api.library.services;

import org.springframework.stereotype.Service;
import jakarta.persistence.EntityNotFoundException;
import tp.api.library.dto.BookRequestDto;
import tp.api.library.model.Book;
import tp.api.library.model.Author;
import tp.api.library.repository.BookRepository;
import tp.api.library.repository.AuthorRepository;

import java.util.List;

@Service
public class BookServices {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public BookServices(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    public Book findById(Long id) {
        return bookRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Livre avec l'ID " + id + " non trouvé"));
    }


    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    // Méthode CREATE
    public Book create(BookRequestDto bookDto) {

        Author author = authorRepository.findById(bookDto.getAuthorId())
                .orElseThrow(() -> new EntityNotFoundException("Auteur avec l'ID " + bookDto.getAuthorId() + " non trouvé"));

        Book newBook = new Book();
        newBook.setTitle(bookDto.getTitle());
        newBook.setIsbn(bookDto.getIsbn());
        newBook.setYear(bookDto.getYear());
        newBook.setCategory(bookDto.getCategory());
        newBook.setAuthor(author);

        return bookRepository.save(newBook);
    }

    public Book update(Long id, BookRequestDto bookDto) {

        Book existingBook = findById(id);

        Author newAuthor = authorRepository.findById(bookDto.getAuthorId())
                .orElseThrow(() -> new EntityNotFoundException("Auteur avec l'ID " + bookDto.getAuthorId() + " non trouvé"));

        existingBook.setTitle(bookDto.getTitle());
        existingBook.setIsbn(bookDto.getIsbn());
        existingBook.setYear(bookDto.getYear());
        existingBook.setCategory(bookDto.getCategory());
        existingBook.setAuthor(newAuthor);

        return bookRepository.save(existingBook);
    }

    public void delete(Long id) {
        bookRepository.deleteById(id);
    }
}