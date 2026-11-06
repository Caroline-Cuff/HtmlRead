import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

public class HtmlRead {

    public static void main(String[] args) {
        HtmlRead html = new HtmlRead();
    }

    public HtmlRead() {

        //try - if something is wrong, it will tell whats wrong
        try {
            System.out.println(); // ensure that the code is running
            System.out.print("hello \n");
            URL url = new URL("https://en.wikipedia.org/wiki/Percy_Jackson"); // the website it is pulling from

            URLConnection urlc = url.openConnection(); // connects to itnernet
            urlc.setRequestProperty("User-Agent", "Mozilla 5.0 (Windows; U; " + "Windows NT 5.1; en-US; rv:1.8.0.11) ");

            BufferedReader reader = new BufferedReader( //reads the internet
                    new InputStreamReader(urlc.getInputStream())
            );
            String line; // new string thats reading each line
            while ((line = reader.readLine()) != null) { // while there is a line

                //todo: only print line when link
                if (line.contains("http")) {
                    line.indexOf("http"); // start the substring here
                    String startIndex = line.substring(line.indexOf("http"));// read line by line
                     System.out.println("\n" +startIndex);  // - nearly quarters number of link

                    //todo: get rid of html after link
                    int endIndex = startIndex.indexOf('"'); // all links end with "
                    System.out.println(startIndex.indexOf("\" ")); // same  as line above
                    String link = startIndex.substring(0, endIndex); // new substring for each link
                    System.out.print(link);
                }


//                    System.out.println(line.substring(line.indexOf("http"),line.indexOf('"')));
                //System.out.println(line.substring(line.indexOf("http"), line.indexOf('>')));


            }
            reader.close();
        } catch(Exception ex) {
            // explains to the user the issue
            System.out.println(ex);
        }

    }

}
