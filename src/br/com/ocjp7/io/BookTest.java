package br.com.ocjp7.io;

import java.io.IOException;
import java.net.URISyntaxException;

import br.com.ocjp7.io.reader.BookReader;
import br.com.ocjp7.io.reader.BufferedReaderBookReader;
import br.com.ocjp7.io.writer.BookWriter;
import br.com.ocjp7.io.writer.BufferedWriterBookWriter;

public class BookTest {
	public static void main(String[] args) throws URISyntaxException, IOException {
		BookWriter bookWriter = new BookWriter(new BufferedWriterBookWriter());
		Book book = new Book("xpto", "eriky");
		book.setContent("Content of the book");
		bookWriter.writeBook(book);

		BookReader bookReader = new BookReader(new BufferedReaderBookReader());
		Book readBook = bookReader.readBook(book.getAuthor(), book.getName());
		System.out.println("Reading ========================");
		System.out.println(readBook.getContent());
		System.out.println("======================== Reading");

	}
}
