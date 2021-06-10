import java.io.File;
import com.adventnet.zoho.client.report.*;

public class MainExport {
	String email = "Your Email";
    String dbname = "Your database name";
    String tbname = "Your table name";
    String clientId = "Your Client ID";
    String clientSecret = "Your Client Secret";
    String refreshToken = "Your generated refresh token";

    private ReportClient rc = new ReportClient(clientId, clientSecret, refreshToken);

    public void exportdata() throws Exception
    {
        String uri = rc.getURI(email,dbname,tbname);
        System.out.println(uri);
        String filePath = "C:\\Your desired file path\\Your table.csv";
        File csvFile = new File(filePath);
        rc.exportData(uri,"CSV",csvFile,null,null);
        System.out.println("Your file is Exported");
    }

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

}
