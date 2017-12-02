package projectmain;
import javax.swing.JOptionPane; 
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.nio.file.Paths;
import java.util.*;

	/**
	* This class will search a whole directory for the .doc type files
	* @author Faisal Ahmed
	*/
	
public class ProjectFileSearching{

	/**
	* This method returns nothing.
	* @exception IOException On Files error
	* @param "folder" will get the directory
	* @param "patterns" will get the string ".doc" as it will search the .doc files only
	*/

	public void scan (String folder, String patterns) throws Exception{
		
		//"dir" object will get the directory from the string 	
        Path dir = Paths.get(folder);
       
	   if (!Files.exists(dir) || !Files.isDirectory(dir)) {
            JOptionPane.showMessageDialog(null,"There is No such directory!");
            return;
        }
		boolean flag1=false;
        
		JOptionPane.showMessageDialog(null,"Directory found");
		String st = JOptionPane.showInputDialog("Now please give the content String you are wanting to search in the .doc files of that directory");
		
		//ds object will get all the .doc files path of the given directory
		
		DirectoryStream<Path> ds = Files.newDirectoryStream(dir, patterns);
            int count = 0;
            for (Path path : ds) {
				ProjectStringMatching okay = new ProjectStringMatching();
				boolean flag =okay.check(path.toString(),st);
				if(flag == true){
					
					//this "flag==true" means the string has been found on one or several .doc files 
					if(flag1 == false){
						flag1=true;
                        JOptionPane.showMessageDialog(null,"This file/files has/have your string");
					
					}
					
					JOptionPane.showMessageDialog(null,path.getFileName());
					
				}
            }
			
			if(flag1 == false)
			JOptionPane.showMessageDialog(null,"Sorry!! No file contains the given string\n");
			
            System.out.println();
    }

}