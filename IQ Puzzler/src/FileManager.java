
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Scanner;

public class FileManager  {
	private File f;
	private File f2;
	private File f3;
	public FileManager()
	{
		f = new File("casual.txt");
		f2 = new File("timeBomb.txt");
		f3 = new File("level.txt");


		for(int i = 0; i< 4; i++) {
			writeCasualFile("0");
			writeBombFile("0");
		}
		
		writeLevelFile("1");
		for(int i = 0; i< 19; i++) {
			writeLevelFile("0");
		}
	}

	void writeCasualFile(String arg)
	{
		try {
			if(!f.exists())
				f = new File("casual.txt");
			PrintWriter pw = new PrintWriter(new FileOutputStream(f,true));
			pw.write(arg+"\r\n" );
			pw.close();

		}
		catch(Exception e) {}
	}
	void writeBombFile(String arg)
	{
		try {
			if(!f2.exists())
				f2 = new File("timeBomb.txt");
			PrintWriter pw = new PrintWriter(new FileOutputStream(f2,true));
			pw.write(arg+"\r\n" );
			pw.close();

		}
		catch(Exception e) {}
	}
	void writeLevelFile(String arg)
	{
		try {
			if(!f3.exists())
				f3 = new File("level.txt");
			PrintWriter pw = new PrintWriter(new FileOutputStream(f3,true));
			pw.write(arg+"\r\n" );
			pw.close();

		}
		catch(Exception e) {}
	}
	String readCasualFile(int line)
	{	
		String s ="";
		if(f.exists()) {
			try {
				BufferedReader br = new BufferedReader(new FileReader("casual.txt"));
				s=br.readLine();
				for(int i=0; i < line; i++)
				{
					s=br.readLine();
				}
				br.close();
			}
			catch(Exception e) {}
		}
		return s;//	currentLine;
	}
	String readBombFile(int line)
	{	
		String s ="";
		if(f2.exists()) {
			try {
				BufferedReader br = new BufferedReader(new FileReader("timeBomb.txt"));
				s=br.readLine();
				for(int i=0; i < line; i++)
				{
					s=br.readLine();
				}
				br.close();
			}
			catch(Exception e) {}
		}
		return s;//	currentLine;
	}
	String readLevelFile(int line)
	{	
		String s ="";
		if(f3.exists()) {
			try {
				BufferedReader br = new BufferedReader(new FileReader("level.txt"));
				s=br.readLine();
				for(int i=0; i < line; i++)
				{
					s=br.readLine();
				}
				br.close();
			}
			catch(Exception e) {}
		}
		return s;//	currentLine;
	}
	void deleteCasualAll()
	{
		if(f.exists())
			f.delete();

	}
	void deleteBombAll()
	{
		if(f2.exists())
			f2.delete();

	}
	void deleteLevelAll()
	{
		if(f3.exists())
			f3.delete();

	}
}