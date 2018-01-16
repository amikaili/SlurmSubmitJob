package SlurmSubmitJob; 

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.Platform;

import SlurmSubmitJob.JobMgr.JobDescriptor;

public class SlurmSubmitJob {	

	public SlurmSubmitJob() {
		
	}

	public static void main(String[] args) {
		
        System.out.println("\nHello JobSubmitStub!\n");
        String cmd = "";
        
        if( ! ( args.length > 0 ) ) {
        	cmd = "uname -a";
        	            
            // Testing JNA:
        	
        	
        	// JobDescriptor jd = new JobDescriptor();
        	
        	// JobMgr.INSTANCE.slurm_init_job_desc_msg( jd );
        	
        	
            // LibC.INSTANCE.printf("Hello, World\n");
            // LibC.INSTANCE.printf("Argument %s\n\n", cmd);            
            //RM.INSTANCE.printf("Slurm native call called print\n");

            // JobMgr.INSTANCE.printf("JobMgr called native print\n");                 
            /*
            for (int i=0;i < args.length;i++) {
                LibC.INSTANCE.printf("Argument %d: %s\n", i, args[i]);
            }
            */
            // End JNA        	
        } else {
            for ( String str: args ){
        	    cmd = cmd + " " + str;
            }
            executeTheCLIcommand( cmd );
        }
        
            System.out.println("JobSubmitStub finished.");
	}
	
	public static void executeTheCLIcommand(String cmd) {
        System.out.println( "JobSubmitStub executing command " + cmd + "\n" );        
        try { // Execute command submitted as args                  
                Process p = Runtime.getRuntime().exec( cmd );
                // Could use the ProcessBuilder with more functionality
                
                BufferedReader reader = new BufferedReader(new InputStreamReader( p.getInputStream() ));
                String line = reader.readLine();
                System.out.println( line );
 
                // p.waitFor();
                
                line = reader.readLine();

                while ( line != null ) {    
                    System.out.println( line );
                    line = reader.readLine();
                }
            }
            catch(IOException e1) {
            	System.out.print( e1 );
            }
            finally{
            	// reader.close();
            }
		
	}
	
	public static void initTestJab( ) {

	}
	
}
