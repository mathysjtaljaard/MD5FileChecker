package org.taljaard.test.readFiles;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.junit.Test;
import org.taljaard.readFiles.ReadFiles;

public class TestReadFiles {

	@Test
	public void test() {
		
		String path = "C:\\";
		
		try {
			List<File> files = ReadFiles.readDirectory(path);
			
			assertTrue(files != null);
			for(File file: files) {
				System.out.println(file.getName());
			}
			
			System.out.println(files.size());
			
		} catch (Exception e) {
			if (e instanceof IOException) {
				e.printStackTrace();
				fail("There was an IO Exception while trying to perform the ReadFile Test");
			} else {
				e.printStackTrace();
				fail("There was an Exception while trying to perform the ReadFile Test");
			}
		}
		
	}

}
