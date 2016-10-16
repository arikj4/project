import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class securityProject {

	public static void main(String args[]) {

        String a = null;

        try {

        	System.out.println("Number of arguments:" + args.length + " arguments.");
        	System.out.println ("Arguments Include:");
        	for(int i=0; i<args.length; ++i) {
        	    System.out.println(args[i]);
        	}

    		int key = args [2].length();
    		String cipher = "-aes-" + Integer.toString(key * 4) + "-" + args [4];
        	
            
    		String opensslcmd = String.format("openssl enc %s -K %s -v -nosalt -in %s -out %s", args[0], args[2], args[6], args[8]);
            
            Process p = Runtime.getRuntime().exec(opensslcmd);
            
            BufferedReader stdInput = new BufferedReader(new 
                 InputStreamReader(p.getInputStream()));

            BufferedReader stdError = new BufferedReader(new 
                 InputStreamReader(p.getErrorStream()));
           
            System.out.println("Here is the standard output of the command:\n");
            while ((a = stdInput.readLine()) != null) {
                System.out.println(a);
            }
            
            System.out.println("Here is the standard error of the command (if any):\n");
            while ((a = stdError.readLine()) != null) {
                System.out.println(a);
            }
            
            System.exit(0);
        }
        catch (IOException e) {
            System.out.println("an error has occured");
            e.printStackTrace();
            System.exit(-1);
        }
    }
	
}
