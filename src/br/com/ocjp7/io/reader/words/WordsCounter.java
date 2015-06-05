package br.com.ocjp7.io.reader.words;

public class WordsCounter extends WordsAction {

	private int counter;

	@Override
	public void execute(String word) {
		counter++;
	}

	public int getCounter() {
		return counter;
	}

}
