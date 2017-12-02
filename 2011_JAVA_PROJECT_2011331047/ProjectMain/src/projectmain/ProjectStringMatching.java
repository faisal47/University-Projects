package projectmain;
import javax.swing.JOptionPane; 
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.nio.file.Paths;
import java.io.*;
import java.util.*;
import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.extractor.WordExtractor;

	/**
	* This class will match a given string on a given .doc file
	* @author Faisal Ahmed
	*/

public class ProjectStringMatching{

	/**
	* @return the boolean type value to justify if the file has the pattern string or not
	* @exception IOException On Extraction error
	* @param "filename" will get the directory of a specific .doc file
	* @param "st1" will get the string what will be matched on the .doc file
	*/

	public boolean check(String filename,String st1)throws Exception{
	
		FileInputStream fis=new FileInputStream(new File(filename));
		HWPFDocument doc=new HWPFDocument(fis);
		int i,j,k,l;
		WordExtractor extractor = new WordExtractor(doc);
		//st[] has all the string line by line of the .doc file
		String st[] = extractor.getParagraphText();
		
		//following loops are for matching the pattern on the st[] as it has all the lines of the .doc file
		
			for(i=0;i<st.length;i++)
			for(j=0;j<st[i].length();j++){
			
				String st2="";
				boolean flag=false;
				
			for(k=i;k<st.length;k++){
			
				if(flag==true)
				break;
				if(k==i)
				l=j;
				else
				l=0;
				
				for(;l<st[k].length();l++){
					
					st2=st2+st[k].charAt(l);
					if(st2.length() == st1.length()){
					
					flag=true;
					break;
					
					}
				
				}
			}
			flag=st1.equals(st2);
			if(flag == true)
			return true;
				
			}
			
			return false;
	
	}

}