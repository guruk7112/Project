package Ecommerce.mycs.generic.WebDriverUtility;
/**
 * @author Gurup
 */
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class JavaUtility {

	public void getRandomNumber(int number) {
		Random ran=new Random();
		int random=ran.nextInt(number);
	}
	
	public String getSimpleDateWithFormate(String formate) {
		Date date=new Date();
		SimpleDateFormat sim=new SimpleDateFormat(formate);
	String simdate=	sim.format(date);
	
	return simdate;
		}
}
