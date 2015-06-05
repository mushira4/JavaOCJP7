package br.com.ocjp7.io.writer;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URISyntaxException;

import br.com.ocjp7.io.Book;

public class FileBookWriter implements BookWriterStrategy {

	@Override
	public void writeBook(Book book) throws URISyntaxException, IOException {
		File file = new File(book.getBookFileLocation().getPath());
		try (FileWriter fileWritter = new FileWriter(file)) {
			fileWritter.write(book.getContent());
		}
	}
}
