package org.taljaard.test.verifyFile;

import static org.junit.Assert.*;

import java.io.File;
import java.util.List;

import org.junit.Test;
import org.taljaard.readFiles.ReadFiles;
import org.taljaard.verifyFile.VerifyFileMD5;

public class TestVerifyFile {

	@Test
	public void test() {
		
		String path = "C:/Users/TaljaardLocal/Downloads/Downloaded Apache Files with MD5";
		
		try {
			List<File> files = ReadFiles.readDirectory(path);
			assertTrue(VerifyFileMD5.verifyFileMD5(files));
			
		} catch(Exception e) {
			e.printStackTrace();
			fail("Not yet implemented");
		}
		
		
		
	}

}
