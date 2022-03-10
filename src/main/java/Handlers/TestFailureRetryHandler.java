package Handlers;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class TestFailureRetryHandler implements IRetryAnalyzer {
    @Override
    public boolean retry(ITestResult result) {
        int count =0;
        int retry = 2;
        while (count < retry){
            count++;
            return  true;
        }
        return false;
    }
}
