package br.com.ocjp7.io.writer;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import br.com.ocjp7.io.Book;

public class FileWriterBookWriter implements BookWriterStrategy {

	@Override
	public void writeBook(Book book) throws URISyntaxException, IOException {
		URI bookPath = book.getBookFileLocation();

		File file = new File(bookPath.toString());
		try (FileWriter fileWritter = new FileWriter(file)) {
			fileWritter.write(book.getContent());
		}
	}
}
