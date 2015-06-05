package br.com.ocjp7.io.reader;

import java.io.IOException;
import java.net.URISyntaxException;

import br.com.ocjp7.io.Book;
import br.com.ocjp7.io.exceptions.BookInexistentException;

public class BookReader {

	private BookReaderStrategy readerStrategy;

	public BookReader(BookReaderStrategy readerStrategy) {
		this.readerStrategy = readerStrategy;
	}

	public Book readBook(String author, String name) throws URISyntaxException, IOException {
		Book book = new Book(name, author);

		if (book.bookFileExists()) {
			return readerStrategy.readBook(book);
		} else {
			throw new BookInexistentException(book);
		}
	}
}
