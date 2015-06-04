package br.com.ocjp7.io;

import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;

public class BookPathFactory {

	public URI getBookPath(String author, String name) throws URISyntaxException {
		String projectPath = System.getProperty("user.dir");
		return URI.create( projectPath + File.separator + "resources" + File.separator + author + File.separator + name);
	}

	public URI getAuthorPath(String author) {
		String projectPath = System.getProperty("user.dir");
		return URI.create( projectPath + File.separator + "resources" + File.separator + author);
	}

}
