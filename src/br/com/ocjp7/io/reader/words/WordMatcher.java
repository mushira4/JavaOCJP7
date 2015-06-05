package br.com.ocjp7.io.reader.words;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.com.ocjp7.io.Book;

public class WordMatcher {

	private List<WordsAction> wordsActions = new ArrayList<>();

	public void executeActions(String content) {
		Scanner scanner = new Scanner(content);
		scanner.useDelimiter("\\W");
		iterateOverWords(scanner);
	}

	public void executeActions(Book book) throws IOException, URISyntaxException {
		Scanner scanner = new Scanner(Paths.get(book.getBookFileLocation().getPath()));
		scanner.useDelimiter("\\W");
		iterateOverWords(scanner);
	}

	public void addAction(WordsAction wordsAction) {
		wordsActions.add(wordsAction);
	}

	private void iterateOverWords(Scanner scanner) {
		while (scanner.hasNext()) {
			String word = scanner.next();
			if (!word.trim().equals("")) {
				for (WordsAction action : wordsActions) {
					action.execute(word);
				}
			}
		}
	}

}
