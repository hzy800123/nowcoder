package JavaLearning;

import java.io.*;

public class Test {
    public static void main(String[] args) throws IOException {

        /*
        System.out.println("Person.count = " + Person.count);

        Person.setNumber(123);

        Student p1 = new Student();
        Teacher p2 = new Teacher();

        // p1.equals(o);

        StrangeStudent pI1 = new StrangeStudent();

        p1.sit(2);
        p2.sit(3);

        p1.run();

        pI1.getup(5);
        System.out.println("pI1.name: " + pI1.getName());
        */

        // String filePath = "G:/AliJarFiles/TestJar/big/trace1.data";
        String filePath = "G:/AliJarFiles/TestJar/big/trace2.data";

        // String fileOutputPath = "G:/AliJarFiles/TestJar/big/traceOutput1.data";
        String fileOutputPath = "G:/AliJarFiles/TestJar/big/traceOutput2.data";

        System.out.println("filePath: " + filePath);

        // Open the file
        // G:\AliJarFiles\TestJar\small
//        FileInputStream fstream = new FileInputStream("textfile.txt");
        FileInputStream fstream = new FileInputStream(filePath);
        BufferedReader br = new BufferedReader(new InputStreamReader(fstream));

        FileWriter fOutputStream = new FileWriter(fileOutputPath, true);
        BufferedWriter out = new BufferedWriter(fOutputStream);

        String strLine;
        long lineCount = 0;
        // long lineLimitTest = 10;

        //Read File Line By Line
        while ((strLine = br.readLine()) != null)   {
            // Print the content on the console
//            System.out.println (strLine);
//            String[] cols = strLine.split("\\|");

//            if (cols != null && cols.length > 1 ) {
//                if (cols.length > 8) {
//                    String tags = cols[8];
            String newStrLine = null;
//                    System.out.println("tags = " + tags);
            if(strLine.indexOf("http.status_code=200") >= 0) {
                newStrLine = strLine.replace("http.status_code=200", "http.status_code=400");
//                System.out.println("After replace: newTags = " + newStrLine);

                out.write(newStrLine);
                out.newLine();
                lineCount++;
//                if(lineCount >= lineLimitTest) {
//                    break;
//                }
                continue;
            }

            //Process each line and add output to Dest.txt file
            out.write(strLine);
            out.newLine();

            lineCount++;
//            if(lineCount >= lineLimitTest) {
//                break;
//            }
        }


        // close buffer writer
        out.close();

        System.out.println("lineCount = " + lineCount);
        //Close the input stream
        fstream.close();

    }
}
