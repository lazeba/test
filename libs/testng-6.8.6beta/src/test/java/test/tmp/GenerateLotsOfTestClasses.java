package test.tmp;

import java.io.File;
import java.io.IOException;

import org.testng.reporters.Files;

public class GenerateLotsOfTestClasses {

  public static void main(String[] args) throws IOException {
    String name = args[0];
    int tests = Integer.parseInt(args[1]);
    int classCount = Integer.parseInt(args[2]);
    for (int j = 0; j < classCount; j++) {
      String className = name + j;
      StringBuilder sb = new StringBuilder();
      sb.append("package test.tmp.profile;\n");
      sb.append("import org.testng.annotations.DataProvider;\n");
      sb.append("import org.testng.annotations.Test;\n");
  
      sb.append(String.format("public class %s {\n", className));
  
      sb.append("    @DataProvider(name = \"Lots\")\n");
      sb.append("    public static Object[][] sliceFunctionsDataProvider() {\n");
      sb.append("        Object[][] data = new Object[1 << 4][];\n");
      sb.append("        for (int i = 0; i < data.length; i++) {\n");
      sb.append("            data[i] = new Object[]{i};\n");
      sb.append("        }\n");
      sb.append("        return data;\n");
      sb.append("    }\n");
  
      sb.append("\n");
      for (int i = 0; i < tests; i++) {
        sb.append("    @Test(dataProvider = \"Lots\")\n");
        sb.append(String.format(
            "    public void test%d(Integer i) throws Exception {\n", i));
//        sb.append("        sb.append(i);\n");
        sb.append("        Thread.currentThread().sleep(1);\n");
        sb.append("    }\n");
        sb.append("\n");
      }
  
      sb.append("}");

      File f = new File("/Users/cbeust/java/testng/src/test/java/test/tmp/profile",
          className + ".java");
      Files.writeFile(sb.toString(), f);
      System.out.println("Created " + f);
    }
  }
}