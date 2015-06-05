package br.com.ocjp7.io.exceptions;

import java.io.FileNotFoundException;

import br.com.ocjp7.io.Book;

public class BookInexistentException extends FileNotFoundException {

	private static final long serialVersionUID = 1L;
	
	private Book book;

	public BookInexistentException(Book book) {
		super( "Not found author: " + book.getAuthor() + "with the book: " + book.getName() );
		this.book = book;
		
	}

	public Book getBook(){
		return book;
	}
	
	
}
