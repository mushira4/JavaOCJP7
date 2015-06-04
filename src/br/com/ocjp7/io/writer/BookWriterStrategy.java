package br.com.ocjp7.io.writer;

import java.io.IOException;
import java.net.URISyntaxException;

import br.com.ocjp7.io.Book;

public interface BookWriterStrategy {

	public void writeBook(Book book) throws URISyntaxException, IOException;
}
