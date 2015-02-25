package test.tmp;

import org.testng.annotations.Test;

public class MyTest {
  @Test
  public void dependOnTest() {
    assert true;
  }
  
  @Test(dependsOnMethods = { "dependOnTest" }, groups="a")
  public void dependingTest() {
    assert false;
  }
}