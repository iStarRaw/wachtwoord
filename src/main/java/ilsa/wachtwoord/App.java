package ilsa.wachtwoord;

import ilsa.wachtwoord.models.WachtwoordGenerator;

/**
 * 
 *
 */
public class App 
{
    public static void main( String[] args ) {
        
    	WachtwoordGenerator wg = new WachtwoordGenerator();
    	
    	wg.generatePassword(8);
    	
    	
    	
    }
}
