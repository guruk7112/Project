package Ecommerce.mycs.generic.ListenereUtility;
/**
 * @author Gurup
 */
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer{

	@Override
	public boolean retry(ITestResult result) {

		int count =0;
		int UpperLimitcount=2;
		
		if(count<UpperLimitcount) {
			count++;
			return true;
		}
		return false;
	}

}
