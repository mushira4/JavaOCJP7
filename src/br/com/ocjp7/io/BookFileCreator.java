package br.com.ocjp7.io;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.attribute.FileAttribute;
import java.nio.file.attribute.PosixFilePermission;
import java.nio.file.attribute.PosixFilePermissions;
import java.util.Set;

public class BookFileCreator {

	public void createFile(Book book) throws URISyntaxException, IOException {
		URI bookPath = book.getBookFileLocation();
		URI authorPath = book.getAuthorDirectoryLocation();

		Set<PosixFilePermission> permissions = PosixFilePermissions.fromString("rwxr-xr-x");
		FileAttribute<Set<PosixFilePermission>> fileAttributes = PosixFilePermissions.asFileAttribute(permissions);

		Files.createDirectories(Paths.get(authorPath.getPath()), fileAttributes);
		Files.createFile(Paths.get(bookPath.getPath()), fileAttributes);
	}

}
