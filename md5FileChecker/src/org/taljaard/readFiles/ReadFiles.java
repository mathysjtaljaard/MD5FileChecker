package org.taljaard.readFiles;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class ReadFiles {
	
	public static List<File> readDirectory(String path) throws IOException {
		List<File> files = null;
		
		File folder = new File(path);
		
		files = (folder!= null && folder.isDirectory() ? Arrays.asList(folder.listFiles()) : null);
		
		return files;
	}
	
	

}
