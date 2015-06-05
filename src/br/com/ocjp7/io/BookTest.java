package br.com.ocjp7.io;

import java.io.IOException;
import java.net.URISyntaxException;

import br.com.ocjp7.io.reader.BookReader;
import br.com.ocjp7.io.reader.InputStreamBookReader;
import br.com.ocjp7.io.reader.words.WordMatcher;
import br.com.ocjp7.io.reader.words.WordsCounter;
import br.com.ocjp7.io.reader.words.WordsRegistrer;
import br.com.ocjp7.io.writer.BookWriter;
import br.com.ocjp7.io.writer.OutputStreamBookWriter;

public class BookTest {
	public static void main(String[] args) throws URISyntaxException, IOException {
		BookWriter bookWriter = new BookWriter(new OutputStreamBookWriter());
		Book book = new Book("xpto", "eriky");
		book.setContent("Content of the book book XXXX");
		bookWriter.writeBook(book);

		BookReader bookReader = new BookReader(new InputStreamBookReader());
		Book readBook = bookReader.readBook(book.getAuthor(), book.getName());
		System.out.println("Reading ========================");
		System.out.println(readBook.getContent());
		System.out.println("======================== Reading");

		WordsCounter wordsCounter = new WordsCounter();
		WordsRegistrer wordsRegistrer = new WordsRegistrer();

		WordMatcher wordMatcher = new WordMatcher();
		wordMatcher.addAction(wordsCounter);
		wordMatcher.addAction(wordsRegistrer);
		wordMatcher.executeActions(readBook);

		System.out.println("Total word: " + wordsCounter.getCounter());
		System.out.println("Words within content: " + wordsRegistrer.getRegistrer());

	}
}
