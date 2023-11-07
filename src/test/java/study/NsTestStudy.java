package study;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public abstract class NsTestStudy {
    private PrintStream standardOut;
    private OutputStream captor;
    private static Scanner scanner;

    @BeforeEach
    public void init() {
        standardOut = System.out;
        captor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(captor));
    }

    @AfterEach
    protected final void printOutput() {
        System.setOut(standardOut);
        System.out.println(output());
    }

    protected final void run(final String... args) {
        try {
            command(args);
            runMain();
        } finally {
            close();
        }
    }

    private void command(final String... args) {
        final byte[] buf = String.join("\n", args).getBytes();
        System.setIn(new ByteArrayInputStream(buf));
    }

    public abstract void runMain();

    public void close() {
        if (scanner != null) {
            scanner.close();
            scanner = null;
        }
    }

    protected final String output() {
        return captor.toString().trim();
    }
}
