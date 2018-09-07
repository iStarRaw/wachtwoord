package ilsa.wachtwoord;

import ilsa.wachtwoord.models.WachtwoordGenerator;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
        
    	WachtwoordGenerator wg = new WachtwoordGenerator();
    	
    	wg.generatePassword(8);
    	
    	System.out.println(wg.generatePassword(8));
    	
    	
    	
    	
    }
}
