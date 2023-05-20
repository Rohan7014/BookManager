package com.rohan.bookManager;

public class BookNotFoundException extends RuntimeException{
    public BookNotFoundException(Integer id){
        super(("Book Not Present With Id:"+id));
    }
    public BookNotFoundException(String str){
        super(str);
    }

}
