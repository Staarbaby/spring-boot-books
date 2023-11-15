package com.campus.spring.book.service;

import com.campus.spring.book.entity.BookEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class BookService {
    public BookService() {
        fillStore();
    }

    static List<BookEntity> bookStorage = new ArrayList<>();
    private void fillStore(){
        Random random = new Random();
        for ( int i = 0; i<100; i++){
                BookEntity book = new BookEntity();
                book.setId(i);
                book.setTitle("Book #" + random.nextInt(100,999));
                book.setDescription("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.");
                bookStorage.add(book);
        }
    }

    public List<BookEntity> all(){
        return bookStorage;
    }

    public Optional<BookEntity> byId(Integer id){
        return bookStorage.stream().filter((bookEntity -> bookEntity.getId() == id)).findFirst();
    }
}
