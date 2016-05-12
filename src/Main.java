import com.sun.deploy.net.HttpResponse;
import org.omg.CORBA.NameValuePair;
import sun.net.www.http.HttpClient;
import sun.net.www.protocol.http.HttpURLConnection;
import sun.rmi.runtime.Log;

import java.io.*;
import java.net.Inet4Address;
import java.net.Socket;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import static jdk.nashorn.internal.objects.NativeMath.log;

public class Main {

    public static void main(String[] args) throws IOException {
        System.err.println(ck());
    }
    public static String ck () {
        String resultJson = "";
        try{
            URL url = new URL("http://192.168.0.102:8080/");
            String query = "12345";
            HttpURLConnection urlConnection;
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("POST");
            urlConnection.setRequestProperty("email", "MMMemaiul");
            urlConnection.setRequestProperty("pass", "MMMPas");
            urlConnection.setDoInput(true);
            urlConnection.setDoOutput(true);
            urlConnection.connect();
            try (OutputStream output = urlConnection.getOutputStream()) {
                output.write(query.getBytes("UTF-8"));
            }

            InputStream inputStream = urlConnection.getInputStream();
            StringBuilder buffer = new StringBuilder();

            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

            String line;
            while ((line = reader.readLine()) != null) {
                buffer.append(line);
            }

             resultJson = buffer.toString();
            log("json", resultJson);
        }
        catch (Exception e)
        {

        }

        return resultJson;
    }
        /*System.out.println("Welcome to Client side");

        Socket fromserver = null;

        if (argss.length()==0) {
            System.out.println("use: client hostname");
            System.exit(-1);
        }

        System.out.println("Connecting to... "+argss);

        fromserver = new Socket("192.168.0.102",8090);
        BufferedReader in  = new
                BufferedReader(new
                InputStreamReader(fromserver.getInputStream()));
        PrintWriter out = new
                PrintWriter(fromserver.getOutputStream(),true);
        BufferedReader inu = new
                BufferedReader(new InputStreamReader(System.in));

        String fuser,fserver;
        System.err.println(inu.readLine());
        while ((fuser = inu.readLine())!=null) {
            out.println(fuser);
            fserver = in.readLine();
            System.out.println(fserver);
            if (fuser.equalsIgnoreCase("close")) break;
            if (fuser.equalsIgnoreCase("exit")) break;
        }

        out.close();
        in.close();
        inu.close();
        fromserver.close();
        */
}

