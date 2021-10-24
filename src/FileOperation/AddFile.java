package FileOperation;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class AddFile {
	
	public boolean addFiles(String file_path, String fileName) 
	{
		String [] files_init;
		//System.out.println(file_path);
		try {
		File f = new File(file_path+fileName);
		f.createNewFile();
		}
		catch(NullPointerException e)
		{
			System.out.print("Path is invalid");
			return false;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}

}
