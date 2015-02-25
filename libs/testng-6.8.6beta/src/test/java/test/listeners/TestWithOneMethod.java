package test.listeners;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestCounter.class)
public class TestWithOneMethod {
  @Test public void test() { assert System.nanoTime() > 0; }
}