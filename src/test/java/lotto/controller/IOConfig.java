package lotto.controller;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

public class IOConfig {
    private final InputStream systemIn = System.in;
    private final PrintStream systemOut = System.out;
    private ByteArrayInputStream testIn;
    private ByteArrayOutputStream testOut;

    public void setUpOutput() {
        testOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testOut));
    }

    public String getOutput() {
        return testOut.toString();
    }
    public void mockInput(String testData) {
        testIn = new ByteArrayInputStream(testData.getBytes());
        System.setIn(testIn);
    }

    public void restoreInputOutput() {
        System.setIn(systemIn);
        System.setOut(systemOut);
    }
}
