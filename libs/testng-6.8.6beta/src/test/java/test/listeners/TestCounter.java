package test.listeners;

import java.util.List;

import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.IReporter;
import org.testng.ISuite;
import org.testng.ITestResult;
import org.testng.xml.XmlSuite;

public class TestCounter implements IReporter, IInvokedMethodListener  {
  int count;
  @Override
  public void beforeInvocation(IInvokedMethod m, ITestResult r) { 
     count++; 
  }
  @Override
  public void afterInvocation(IInvokedMethod method, ITestResult testResult) { }
  @Override
  public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) { 
      System.out.println(count);
  }
}

