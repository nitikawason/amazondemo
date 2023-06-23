package amazonlinksetup;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class configreader 

{
	Properties pro;
	public configreader() throws IOException
	{
	
	File src1=new File("./configuration/Amazon.property");
	FileInputStream fs=new FileInputStream(src1);
	
	pro=new Properties();
	pro.load(fs);
	}
	
	public String browserName()
	{
		
		return pro.getProperty("browser");
	}

}
