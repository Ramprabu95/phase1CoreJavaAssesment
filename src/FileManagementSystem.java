import java.io.BufferedReader;
import java.io.InputStream;
import java.io.Reader;
import java.util.Scanner;
import FileOperation.*;
public class FileManagementSystem {
	
	static Scanner scan = new Scanner(System.in);
	static int getOptionFromUSer()
	{
		System.out.println("Options available:");
		System.out.println("1. Add a file to the directory list");
		System.out.println("2. Delete a file from the existing directory list");
		System.out.println("3. Search for a user specified file");
		System.out.println("4. Go to main menu");
		System.out.println("Enter the option you need");
		int option = scan.nextInt();
		return option;
		
	}
	static int getOperationType()
	{
		System.out.println("Enter the option based on your type of operation:");
		System.out.println("1. Retrieve the file names in ascending order");
		System.out.println("2. Business level operations - like add, delete, search file");
		System.out.println("3. Close the application");
		int option = scan.nextInt();
		return option;
	}
	static String enterFolderPath() 
	{
		System.out.println("Enter the path to the folder");
		String folderPath = scan.next();
		return folderPath;
	}
	static String enterFilename()
	{
		System.out.println("Enter the file name");
		String fileName = scan.next();
		return fileName;
	}
	static boolean flowOfProgram()
	{
		searchFile searchobj  = new searchFile();
		AddFile  addobj = new AddFile();
		DeleteFile delfile = new DeleteFile();
		//display of the name of the developer
		System.out.println("############File Management System - LockedME.com#########");
		// Display of the developer
		System.out.println("##Designed and developed by : Ram Prabu G, LookedMe.com");
		//Operation that needs to be performed
		int operationType = getOperationType();
		if(operationType == 1)
		{
			DisplayFile obj = new DisplayFile();
			String filePath = enterFolderPath();
			if(obj.displayFiles(filePath) == true)
			{
				return true;
			}
			else
			{
				System.out.println("Error occured--- restarting program");
				return false;
			}
			
		}
		else if(operationType == 2)
		{
			int choice = getOptionFromUSer();
			if(choice ==1)
			{
				System.out.println("###################################################");
				System.out.println("Adding new file into a folder");
				String folderName = enterFolderPath();
				String fileName = enterFilename();
				
				boolean filePresent = searchobj.searchForFile(folderName, fileName);
				if(filePresent == true)
				{
					System.out.println("The file is already present. Do you want to overrite it?---Type y or n");
					String over_write = scan.next();
					if(over_write.equalsIgnoreCase("y"))
					{
						delfile.delFiles(folderName, fileName);
						if(addobj.addFiles(folderName, fileName) == true)
							return true;
						else
						{
							System.out.println("Error in adding file - Restarting the program to repeat the operation");
							return false;
						}
					}
					else
					{
						System.out.println("Operation stopped - Restating the program to repeat the operation");
						return false;
					}
				}
				else
				{
					addobj.addFiles(folderName, fileName);
					return true;
				}
			}
			else if(choice == 2)
			{
				System.out.println("###################################################");
				System.out.println("Deleting a file in a folder");
				String folderName = enterFolderPath();
				String fileName = enterFilename();
				if(delfile.delFiles(folderName, fileName) == true)
					return true;
				else
				{
					System.out.println("Error in deleting file - Restarting program to repeat the operation");
					return false;
				}
			}
			else if(choice == 3)
			{
				System.out.println("###################################################");
				System.out.println("Searching a file in a folder");
				String folderName = enterFolderPath();
				String fileName = enterFilename();
				boolean filePresent = searchobj.searchForFile(folderName, fileName);
				if(filePresent == true)
				{
					System.out.println("File is present in the folder");
					return true;
				}
				else
				{
					System.out.println("File not found in the folder");
					System.out.println("Do you want to repeat the operation? type y or n---");
					String option_search = scan.next();
					if(option_search.equals("y") == true)
						return false;
					else
						return true;
				}
				
			}
			else
			{
				System.out.println("Inavlid option selected----Restarting the program");
				return false;
			}
		}
		else if (operationType == 3)
		{
			System.out.println("Exiting the program");
			System.exit(0);
		}
		else
		{
			System.out.println("Inavlid option selected----Restarting the program");
			return false;
		}
		return true;

	}
	public static void main(String[] args) 
	{

		for(;;)
		{
			if(flowOfProgram() == true)
				break;
			else
				continue;
		}
		System.out.println("######################################################################");
		System.out.println("Operation completed --- to perform operation again restart the program");
		System.exit(0);
    }
		
	
	

}
