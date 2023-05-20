package com.rohan.bookManager;

import java.util.List;
import java.util.Optional;

public class BookService {
    private BookRepository bookRepository=new BookRepository();

    public String addBook(Book book) {
        bookRepository.add(book);
        return "Book Added with Id:"+book.getId();
    }

    public Book getBook(Integer id) throws BookNotFoundException {
        Optional<Book> bookOptional=bookRepository.getById(id);
        if(bookOptional.isEmpty()){
            throw new BookNotFoundException(id);
        }
        return bookOptional.get();
    }

    public List<Book> getAllBook() {
        return bookRepository.getAll();
    }
    public Book getBook(String name) throws BookNotFoundException{
        List<Book> books=bookRepository.getAll();
        for(Book book:books) {
            if (book.getTitle().equals(name))
                return book;
        }
        throw new BookNotFoundException("Book Not Found");
    }

    public Book updateBookPages(Integer id, Integer page) throws BookNotFoundException{
        Book book=getBook(id);
        book.setPages(page);
        bookRepository.update(book);  // but we use add() funtion because we use same implemention
        return book;
    }

    public void removeBookById(Integer id) {
        bookRepository.delete(id);
    }
}

















