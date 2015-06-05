package br.com.ocjp7.io.reader;

import java.io.IOException;
import java.net.URISyntaxException;

import br.com.ocjp7.io.Book;

public interface BookReaderStrategy {

	public Book readBook(Book book) throws URISyntaxException, IOException;

}