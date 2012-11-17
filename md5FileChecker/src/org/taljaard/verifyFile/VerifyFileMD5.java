package org.taljaard.verifyFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;

public class VerifyFileMD5 {
	
	public static boolean verifyFileMD5(List<File> files) throws NoSuchAlgorithmException, IOException {
		boolean allVerified = false;
		
		String md5StringValue = null;
		String md5GeneratedStringValue = null;

		if (files.size() % 2 == 0) {
			for (File file : files ) {
				
				if (StringUtils.contains(file.getName(), "md5.txt")) {
					md5StringValue = getMD5String(file, true);
					System.out.println(file.getName() + " -> " + md5StringValue);
				} else {
					md5GeneratedStringValue = getMD5String(file, false);
					System.out.println(file.getName() + " -> " + md5GeneratedStringValue);
				}
				
				if (md5StringValue != null && md5GeneratedStringValue != null ) {
					if (StringUtils.equalsIgnoreCase(md5StringValue, md5GeneratedStringValue)) {
						allVerified = true;
					} else {
						System.out.println("The following zip file doesn't match: " + file.getName());
					}
					md5StringValue = null;
					md5GeneratedStringValue = null;
				}
			} 
		} else {
			System.out.println("Missing either an MD5 File or the main file to check against please verify in your directory. Number of files in your directory = " + files.size());
		}
		
		return allVerified;
	}
	
	private static String getMD5String(File file, boolean isMD5TXT)  throws IOException {
		
		InputStream is = null;
		String MD5 = null;
		
		is = new FileInputStream(file);
		
		if (isMD5TXT) {
			List<String> md5StringValueList = IOUtils.readLines(is);
			MD5 = md5StringValueList.get(0);
		} else {
			MD5 = DigestUtils.md5Hex(is);
		}
		
		if (is != null) {
			is.close();
		}
		
		return MD5;
	}

}
