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
	* This class will take a directory and match a string with the .doc type files of that directory (both the directory and the sample string will be given by the user)
	* @author Faisal Ahmed
	*/

public class ProjectMain {

    public static void main(String[] args)throws Exception{
        
		/**
		* This method will take a directory and search a string (given by the user) on the .doc files of that directory
		* @param args Unused.
		* @exception IOException On input error.
		* @see IOException
		*/
		
        ProjectFileSearching a= new ProjectFileSearching();
		String st1;
        JOptionPane.showMessageDialog(null,"JAVA project (.doc file searching containing a specific string)..");
		st1=JOptionPane.showInputDialog("Give the directory plz");
        String st2="*.doc";
        a.scan(st1,st2);
    
    }
    
}
