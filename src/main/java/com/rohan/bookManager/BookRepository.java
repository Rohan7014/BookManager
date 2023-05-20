package com.rohan.bookManager;

import java.util.*;

public class BookRepository {
    Map<Integer,Book> bookData =new HashMap<>();

    public void add(Book book) {
        bookData.put(book.getId(), book);
    }

    public Optional<Book> getById(Integer id) {
        if(bookData.containsKey(id)){
            Book bookToReturn=bookData.get(id);
            return Optional.of(bookToReturn);
        }
        return Optional.empty();
    }

    public List<Book> getAll() {
        return new ArrayList<>(bookData.values());
    }
    public void update(Book book) { // instead of this we directly use add() funtion
        bookData.put(book.getId(), book);
    }

    public void delete(Integer id) {
        bookData.remove(id);
    }
}

















