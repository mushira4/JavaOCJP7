package br.com.ocjp7.io.reader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import br.com.ocjp7.io.Book;

public class BufferedReaderBookReader implements BookReaderStrategy {

	@Override
	public Book readBook(Book book) throws URISyntaxException, IOException {
		URI bookPath = book.getBookFileLocation();
		File bookFile = new File(bookPath.getPath());

		try (BufferedReader bufferedReader = new BufferedReader(new FileReader(bookFile))) {
			StringBuilder builder = new StringBuilder();
			while (bufferedReader.ready()) {
				builder.append(bufferedReader.readLine());
			}
			book.setContent(builder.toString());
		}

		return book;
	}

}
