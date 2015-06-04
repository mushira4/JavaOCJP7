package br.com.ocjp7.io.reader;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import br.com.ocjp7.io.Book;

public class FileReaderBookReader implements BookReaderStrategy {

	@Override
	public Book readBook(String author, String name) throws URISyntaxException, IOException {
		Book book = new Book(name, author);
		URI bookPath = book.getBookFileLocation();
		
		File bookFile = new File(bookPath);
		try (FileReader fileReader = new FileReader(bookFile)) {
			StringBuilder stringBuilder = new StringBuilder();

			char[] bookCharBuffer = new char[128];
			while (fileReader.read(bookCharBuffer) != -1) {
				stringBuilder.append(bookCharBuffer);
			}

			book.setContent(stringBuilder.toString());
		}

		return book;
	}

}
