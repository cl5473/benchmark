import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.text.*;
import java.util.*;

public class file512K {
    public void writing() {
        try {
            long start = System.currentTimeMillis();
            Date date = new Date() ;
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd_HHmmss_SSS") ;
            File statText = new File(System.getProperty("benchDir")+"/"+dateFormat.format(date) + ".bin") ;
 	    // System.out.println(statText);
            FileOutputStream is = new FileOutputStream(statText);
            OutputStreamWriter osw = new OutputStreamWriter(is);
            Writer w = new BufferedWriter(osw);
            for (int length = 0; length <= 1e+6; length += 74) {
              w.write("abcdefghijkl");
              w.write("\n");
              w.write("abcdefghijkl");
              w.write("\n");
              w.write("abcdefghijkl");
              w.write("\n");
            }
            w.close();
            long end = System.currentTimeMillis();
            System.out.println((end - start) / 1000f + "," + (statText) );
        } catch (IOException e) {
            System.err.println("Problem creating test files");
        }
    }

    public static void main(String[]args) {
        file512K write = new file512K();
        write.writing();
    }

}
