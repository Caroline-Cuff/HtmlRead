import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class HtmlRead {
    public int counts;
    public boolean run;
    public int index;


    public static void main(String[] args) {
        HtmlRead html = new HtmlRead();
    }

    //todo: figure out how to have it not matter if capitalized
    /// FIRST todo: multiple links in one line
    /// make new substring and start it at the endindex of the old string
    /// while loop
    ///
    //todo: tidy up


    public HtmlRead() {
        run = true;

        while (run == true) {
        Scanner s = new Scanner(System.in);
        System.out.println("What word do you choose?:");
        String input = s.nextLine();


        //try - if something is wrong, it will tell whats wrong
            try {
               // System.out.println(); // ensure that the code is running
                System.out.print("hello \n");
                URL url = new URL("https://en.wikipedia.org/wiki/Percy_Jackson"); // the website it is pulling from
                //URL url = new URL("https://www.manchestersailing.org/");

                URLConnection urlc = url.openConnection(); // connects to itnernet
                urlc.setRequestProperty("User-Agent", "Mozilla 5.0 (Windows; U; " + "Windows NT 5.1; en-US; rv:1.8.0.11) ");

                BufferedReader reader = new BufferedReader( //reads the internet
                        new InputStreamReader(urlc.getInputStream())
                );
                String line; // new string thats reading each line
                System.out.println(input); // word scanning for
                while ((line = reader.readLine()) != null) { // while there is a line
                    //     System.out.println(line); // - 247 'HTTP'


                    //todo: only print line when link
//                    if (line.contains("href=")) {
                        while (line.contains("href=")) { // trying to loop for many links in one line
                           // System.out.println(line); // reads full line if contains href  //todo: turn this off once finished
                            line.indexOf("href="); // start the substring here
                            String startIndex = line.substring(line.indexOf("href") + 6);// read line by line
                       //     System.out.println();


                            //  System.out.println("\n" +startIndex);  // - nearly quarters number of links

                            //todo: get rid of html after link
                            int endIndex = startIndex.indexOf('"'); // all links end with "
                            //   System.out.println(endIndex); // same  as line above
                            String link = startIndex.substring(0, endIndex); // new substring for each linke
                            line = line.substring(line.indexOf("href") + 1);

                            int x = 0;
                            if (link.contains(input)) { // programmer specified string
                                counts++;
                                   System.out.println(link); //todo: turn on once finished
                            }



//                    System.out.println(line.substring(line.indexOf("http"),line.indexOf('"')));
                            //System.out.println(line.substring(line.indexOf("http"), line.indexOf('>')));

                        }
                    }
  //              }
                    // counting the number of times input appears in a link
                    System.out.println("there are " + counts + " instances of '" + input + "'");
                    System.out.println("Run again?");



                reader.close();
            } catch (Exception ex) {

                // explains to the user the issue
                System.out.println(ex);
            }
            // run the program again without the go button
            String again = s.nextLine();
            if (again.equals("yes")){ //running wo play  button
                run = true;
                counts = 0;
                System.out.println(counts);
            }
            else if (again.equals("no")) {
                run = false;
            } // if statement

            System.out.println("1"+run); // it's true here; need it ot be false
        } // while
        System.out.println(run);

    } // method
} //class
