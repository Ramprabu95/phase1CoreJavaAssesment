package FileOperation;

import java.io.File;

public class DeleteFile {
	public boolean delFiles(String file_path, String fileName) 
	{
		//System.out.println(file_path);
		try {
		File f = new File(file_path+fileName);
		boolean p = f.delete();
		if(p == false)
		{
			System.out.println("Failed to delete file");return false;
		}
		else
			return true;
		}
		catch(NullPointerException e)
		{
			System.out.print("Path is invalid");
			return false;
		}
	}


}
