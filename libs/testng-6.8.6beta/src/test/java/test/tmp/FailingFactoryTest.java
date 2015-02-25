package test.tmp;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

@Test
public class FailingFactoryTest {

  private final String _value1;
  private final String _value2;
  private String _setUp;

  @Factory(dataProvider = "input")
  public FailingFactoryTest(String value1, String value2) {
    _value1 = value1;
    _value2 = value2;
  }

  @DataProvider(name = "input")
  static Object[][] data_input() {
//    return new Object[][] {
//        new Object[] { "wor" , "ld" }
//    };
    return new Object[0][0];
  }

  @BeforeClass
  public void setUpClass() {
    _setUp = "Hello " + _value1 + _value2;
  }

  @BeforeMethod
  public void setUp() {
    _setUp = "Hello " + _value1 + _value2;
  }

  public void test() {
    Assert.assertEquals("Hello world", _setUp);
  }

}