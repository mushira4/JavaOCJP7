package br.com.ocjp7.io.reader;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.nio.CharBuffer;

import br.com.ocjp7.io.Book;

public class InputStreamBookReader implements BookReaderStrategy {

	@Override
	public Book readBook(Book book) throws URISyntaxException, IOException {
		File file = new File(book.getBookFileLocation().getPath());
	
		StringBuilder builder = new StringBuilder();
		try (InputStreamReader reader = new InputStreamReader(new FileInputStream(file))) {
			CharBuffer cbuf = CharBuffer.allocate(128);
			while (reader.ready()) {
				reader.read(cbuf);
				builder.append(cbuf.array());
			}
		}

		book.setContent(builder.toString());
		return book;
	}

}
