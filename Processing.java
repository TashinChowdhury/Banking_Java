import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;


class User
{
	User[] u = new User[100];
	int sID;
	double sBalance=0;
	String sName,sPass,sAddress,sNID;
}

class Load extends User
{	
	int serial = -1;
	public Load()
	{
		for(int i=0; i<100; i++)
		{
			u[i]= new User();
		}
		try 
		{
			String path = "C://Users//HP//eclipse-workspace//PROTYPE//src//info.txt";
			FileReader fr = new FileReader(path);
			BufferedReader br = new BufferedReader(fr);
			
			boolean isLoginSuccess = false;
			
			String line;
			while((line = br.readLine()) != null) {
				++serial;
				
				u[serial].sName = line.split(" ")[0];
				u[serial].sNID = line.split(" ")[2];
				u[serial].sAddress = line.split(" ")[3];
				u[serial].sBalance = Double.parseDouble(line.split(" ")[4]);
				u[serial].sPass = line.split(" ")[1];
				
			}
			fr.close();
		}
		catch(Exception ep) 
		{
			ep.printStackTrace();
		}
	}
	
	public void Show()
	{
		for(int i=0; i<=serial; i++)
		{
			System.out.println(u[i].sName+" "+u[i].sPass+" "+u[i].sNID+" "+u[i].sAddress+" "+u[i].sBalance);
		}
	}
	
	public void Reload()
	{
		try {
			String path = "C://Users//HP//eclipse-workspace//PROTYPE//src//info.txt";
			FileWriter myWriter = new FileWriter(path);
		
			for(int i=0; i<=serial; i++)
			{
				myWriter.write(u[i].sName+" "+u[i].sPass+" "+u[i].sNID+" "+u[i].sAddress+" "+u[i].sBalance+"\n");
			}
			myWriter.close();
		}
		catch(IOException ep){
			System.out.println("MISSING INFO! 404! ERROR!");
			ep.printStackTrace();
		}
		
	}
	
	public void ReWrite(int id)
	{
		try {
			String path = "C://Users//HP//eclipse-workspace//PROTYPE//src//info.txt";
			FileWriter myWriter = new FileWriter(path);
		
			for(int i=0; i<=serial; i++)
			{
				if(i==id)
				{
					
				}
				else
				{
					myWriter.write(u[i].sName+" "+u[i].sPass+" "+u[i].sNID+" "+u[i].sAddress+" "+u[i].sBalance+"\n");
				}
				
			}
			myWriter.close();
		}
		catch(IOException ep){
			System.out.println("MISSING INFO! 404! ERROR!");
			ep.printStackTrace();
		}
		
	}
}
public class Processing{
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Load l = new Load();
		l.Show();
	}

}
