package br.com.ocjp7.io.writer;

import java.io.IOException;
import java.net.URISyntaxException;

import br.com.ocjp7.io.Book;
import br.com.ocjp7.io.BookFileCreator;

public class BookWriter {

	private BookWriterStrategy bookWriterStrategy;

	public BookWriter(BookWriterStrategy bookWriterStrategy) {
		this.bookWriterStrategy = bookWriterStrategy;
	}

	public void writeBook(Book book) throws URISyntaxException, IOException {
		if (!book.bookFileExists()) {
			BookFileCreator bookFileCreator = new BookFileCreator();
			bookFileCreator.createFile(book);
		}

		bookWriterStrategy.writeBook(book);
	}

}
