package br.com.ocjp7.io.reader;

import java.io.IOException;
import java.net.URISyntaxException;

import br.com.ocjp7.io.Book;

public class BookReader {

	private BookReaderStrategy readerStrategy;

	public BookReader(BookReaderStrategy readerStrategy) {
		this.readerStrategy = readerStrategy;
	}

	public Book readBook(String author, String name) throws URISyntaxException, IOException {
		Book readBook = readerStrategy.readBook(author, name);
		return readBook;
	}
}
