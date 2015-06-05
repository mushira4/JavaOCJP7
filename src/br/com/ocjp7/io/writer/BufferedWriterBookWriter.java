package br.com.ocjp7.io.writer;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URISyntaxException;

import br.com.ocjp7.io.Book;

public class BufferedWriterBookWriter implements BookWriterStrategy {

	@Override
	public void writeBook(Book book) throws URISyntaxException, IOException {
		File file = new File(book.getBookFileLocation().getPath());
		try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file))){
			bufferedWriter.write(book.getContent());
		}
	}

}
