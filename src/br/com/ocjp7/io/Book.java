package br.com.ocjp7.io;

import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Paths;

public class Book {

	private String name;
	
	private String author;

	private String content = "";

	public Book(String name, String author) {
		if ( name == null || author == null ){
			throw new IllegalArgumentException("Missing arguments");
		}
		
		this.name = name;
		this.author = author;
	}

	public String getName() {
		return name;
	}

	public String getContent() {
		return content;
	}

	public String getAuthor() {
		return author;
	}
	
	public void setContent(String content) {
		this.content = content;
	}

	public boolean bookFileExists() throws URISyntaxException {
		return Files.exists(Paths.get(getBookFileLocation().getPath()), LinkOption.NOFOLLOW_LINKS);
	}

	public URI getBookFileLocation() throws URISyntaxException {
		return new BookPathFactory().getBookPath(author, name);
	}

	public URI getAuthorDirectoryLocation() {
		return new BookPathFactory().getAuthorPath(author);
	}

}
