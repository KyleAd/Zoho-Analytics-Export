# Zoho Analytics Export
Zoho Analytics API tool & Automated CSV exporter

## Description
Receives API tables through Zoho Analytics so that it can be exported through a CSV file with just a click of a button. The automated process comes from a simple task schedule that can be applied on any Windows Machine.

## Tasks
**Complete**

## Usage
Before you use this application, you will need to adhere to the correct authentication protocols. Make sure you follow the Zoho Analytics API doc [here](https://www.zoho.com/analytics/api/?java#oauth) so that your application will work. 

### Prerequisites
The IDE used for this program was Eclipse, which is commonly used for Java applications. Any IDE that supports Java Libraries can work. This application also contains a Zoho DLL file which you can find [here](https://www.zoho.com/analytics/api/?java#java-library). With the correct DLL files used, you can reference the client functions that will authenticate your application which will then allow your data to transfer through for a correctly working API.

### Executable
First you need to assemble the correct imports so you can properly reference these libraries and DLL files in your code. At the moment these two imports are required for your executable class. (Examples used here are from the MainExport.Java in this Project)
```
import java.io.File;
import com.adventnet.zoho.client.report.*;
```
Then initialise your main variables, these variables will be values containing your authentication information and file locations. The authentication values will be truly unique and are essential for the program. The file locations are dependant on your requirement, what data you want to capture from your Analytics, and where you want your file to be stored on your machine. 
```
//File locations
String email = "Your Email";
String dbname = "Your database name";
String tbname = "Your table name";

//Auth
String clientId = "Your Client ID";
String clientSecret = "Your Client Secret";
String refreshToken = "Your generated refresh token";
```
Now you have declared the main values that you will be using and what are needed for the application to function. The application now has an authentication, and it knows what data it's grabbing in Analytics. Now you need to declare where your data will be exported referencing the File library as shown below in a separate method. 
```
public void exportdata() throws Exception
{
  String uri = rc.getURI(email,dbname,tbname)
  String filePath = "C:\\Your desired file path\\Your table.csv";
  File csvFile = new File(filePath);
  rc.exportData(uri,"CSV",csvFile,null,null);
}
```
Now to finally compile your code in the main class (static void) so it will execute your functions properly. 
```
public static void main(String[] args) throws Exception
{
   javax.swing.SwingUtilities.invokeLater(new Runnable() {
          public void run() {
      MainExport obj = new MainExport();
      try {
	obj.exportdata();
} catch (Exception e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
  }
          }
      });
  }
```
The application uses Swing Utilities which are good for runnable applications such as this one. It will allows the project to run at the click of a button, in this case clicking hte application once it's published. To publish the application, make sure you export it to a java runnable once you've tested the code and it works. 
