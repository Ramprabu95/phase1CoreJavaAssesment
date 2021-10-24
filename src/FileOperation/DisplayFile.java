package FileOperation;

import java.io.File;
import java.util.*;

public class DisplayFile {
	
	public boolean displayFiles(String file_path) 
	{
		String [] files_init;
		//System.out.println(file_path);
		try {
		File f = new File(file_path);
		files_init = f.list();
		List<String> fileList = Arrays.asList(files_init);
		Collections.sort(fileList);
		int len = fileList.size();
		System.out.println("Total number of files and folders in the path = " + len);
		System.out.println("List of files and folders in the path : " + file_path+" is :");
		System.out.println("#######################################################");
		for(String files:fileList)
		{
			System.out.println(files);	
		}
		
		}
		catch(NullPointerException e)
		{
			System.out.print("Path is invalid");
			return false;
		}
		
		
		
		
		return true;
		
	}

}

class NopathException extends Exception{
	
}
