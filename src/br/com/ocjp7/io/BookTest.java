package br.com.ocjp7.io;

import java.io.IOException;
import java.net.URISyntaxException;

import br.com.ocjp7.io.writer.BookWriter;
import br.com.ocjp7.io.writer.FileWriterBookWriter;

public class BookTest {
	public static void main(String[] args) throws URISyntaxException, IOException {
		BookWriter bookWriter = new BookWriter(new FileWriterBookWriter());
		Book book = new Book( "xpto" , "eriky" );
		book.setContent( "Tentativa" );
		bookWriter.writeBook(book );
		
		
	}
}
