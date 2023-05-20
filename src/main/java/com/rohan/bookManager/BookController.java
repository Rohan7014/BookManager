package com.rohan.bookManager;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {
    private BookService bookService=new BookService();
    //Post API's
    @PostMapping("/add-new-book")
    //public String addBook(@RequestBody Book book)
    public ResponseEntity<String> addBook(@RequestBody Book book){
        // bookData.put(bookData.getId(),book);
        String str=bookService.addBook(book);
        //return str;
        return new ResponseEntity<>(str,HttpStatus.CREATED);
    }
    //Get API's
    // 1. way of input
    @GetMapping("/get-book") // google.com/search?q=yes-bank //"localhost:8080/get-book?id=1"
    //public Book getBook(@RequestParam Integer id)
    public ResponseEntity<Book> getBook(@RequestParam Integer id) {//in google "@RequestParam String q"
       // return bookService.getBook(id);
        try{
            Book book=bookService.getBook(id);
            //return book;
            return new ResponseEntity<>(book, HttpStatus.OK);
        }catch (BookNotFoundException ex){
            //return null;
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }
    }
    // 2. way of input
    @GetMapping("/get-all-book")
    public ResponseEntity<List<Book>> getAllBook(){
        return new ResponseEntity<>(bookService.getAllBook(),HttpStatus.OK);
    }
    // 3. way of input
    @GetMapping("/get-book-by-name/{name}")
    public ResponseEntity<Book> getBookByName(@PathVariable String name){
        try{
            return new ResponseEntity<>(bookService.getBook(name),HttpStatus.OK);
        }catch (BookNotFoundException ex){
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }
//        for(Map.Entry<Integer,Book> entry : bookData.entrySet()){
//            if(entry.getValue().getTitle().equals(name))
//                return entry.getValue();
//        }
//        return null;
    }
    // Update API's
    @PutMapping("/update-book-pages")//if funtion have "@RequestParam,@RequestParam"
    // if funtion have "@PathVariable,@RequestParam" --> // Then URL Is ("/update-book-pages/{id}");
    // if funtion have "@PathVariable,@PathVariable" --> // Then URL Is ("/update-book-pages/{id}/{page}");
    public ResponseEntity<Book> updateBookPages(@RequestParam Integer id,@RequestParam Integer page){
        try{
            Book book=bookService.updateBookPages(id,page);
            return new ResponseEntity<>(book,HttpStatus.CREATED);
        }catch (BookNotFoundException ex){
            return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
        }
//        Book book=bookData.get(id);
//        book.setPages(page);
//        bookData.put(id,book);
//        return book;
    }
    //Delete API's
    @DeleteMapping("/delete-book/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable Integer id){
        bookService.removeBookById(id);
        return new ResponseEntity<>("book delete with id:",HttpStatus.OK);
    }
}
