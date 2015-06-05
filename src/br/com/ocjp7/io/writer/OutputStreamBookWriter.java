package br.com.ocjp7.io.writer;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.URISyntaxException;

import br.com.ocjp7.io.Book;

public class OutputStreamBookWriter implements BookWriterStrategy {

	@Override
	public void writeBook(Book book) throws URISyntaxException, IOException {
		File bookFile = new File(book.getBookFileLocation().getPath());
		try (OutputStreamWriter streamWriter = new OutputStreamWriter(new FileOutputStream(bookFile))) {
			streamWriter.write(book.getContent());
		}
	}

}
