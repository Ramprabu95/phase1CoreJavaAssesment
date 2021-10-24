package FileOperation;

import java.io.File;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class searchFile {
	

	public boolean searchForFile(String folder_path, String file_name) 
	{
		String [] files_init;
		//System.out.println(file_path);
		try {
		File f = new File(folder_path);
		files_init = f.list();
		List<String> fileList = Arrays.asList(files_init);
		Collections.sort(fileList);
		int len = fileList.size();
		for(String files:fileList)
		{
			if(files.equalsIgnoreCase(file_name))
				return true;
		}
		
		}
		catch(NullPointerException e)
		{
			System.out.print("Path is invalid");
			return false;
		}
			
		
		return false;
		

	}
}
