package br.com.ocjp7.io.reader.words;

import java.util.HashSet;
import java.util.Set;

public class WordsRegistrer extends WordsAction {

	private Set<String> registrer = new HashSet<>();

	@Override
	public void execute(String word) {
		registrer.add(word);		
	}

	public Set<String> getRegistrer() {
		return registrer;
	}
	
}
