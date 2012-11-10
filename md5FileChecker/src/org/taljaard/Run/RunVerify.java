package org.taljaard.Run;

import java.io.File;
import java.util.List;

import org.taljaard.readFiles.ReadFiles;
import org.taljaard.verifyFile.VerifyFileMD5;

public class RunVerify {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String path = "directory containing zipped binary and accomacating md5 text file";
		
		try {
			List<File> files = ReadFiles.readDirectory(path);
			VerifyFileMD5.verifyFileMD5(files);
			
		} catch (Exception e ) {
			e.printStackTrace();
		}
		
	}

}
