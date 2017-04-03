import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.text.*;
import java.util.*;

public class WorkerThread implements Runnable {

    private String command;

    public WorkerThread(String s){
        this.command=s;
    }

    @Override
    public void run() {

        System.out.println(Thread.currentThread().getName()+" Start. Command = "+command);
        processCommand();
        System.out.println(Thread.currentThread().getName()+" End.");

    }

    private void processCommand() {
      try {

          String value = System.getProperty("testSize");
                  if(value.equals("5M")) {
										long start = System.currentTimeMillis();
										Date date = new Date() ;
										SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd_HHmmss_SSS") ;
										File statText = new File(System.getProperty("benchDir")+"/"+dateFormat.format(date) + ".bin") ;
										FileOutputStream is = new FileOutputStream(statText);
										OutputStreamWriter osw = new OutputStreamWriter(is);
										Writer w = new BufferedWriter(osw);
                    for (int length = 0; length <= 1e+7; length += 75 ){
                      w.write("abcdefghijkl");
                      w.write("\n");
                      w.write("abcdefghijkl");
                      w.write("\n");
                      w.write("abcdefghijkl");
                      w.write("\n");
                    }
                    w.close();
                    long end = System.currentTimeMillis();
                    System.out.println((end - start) / 1000f );
                  }
                  else {
                      System.err.println("Invalid file Size");
                  }

      } catch (IOException e) {
          System.err.println("Problem creating test files");
      }
    }

    @Override
    public String toString(){
        return this.command;
    }
}
