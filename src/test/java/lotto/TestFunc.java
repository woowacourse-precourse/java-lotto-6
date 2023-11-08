package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.NoSuchElementException;

public abstract class TestFunc {
    private PrintStream standardOut;
    private OutputStream captor;

    @BeforeEach
    protected final void init() {
        standardOut = System.out;
        captor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(captor));
    }

    @AfterEach
    protected final void printOutput() {
        System.setOut(standardOut);
        System.out.println(output());
    }

    protected final String output() {
        return captor.toString().trim();
    }

    protected final void runPrice(final String... args) {
        try {
            command(args);
            runPrice();
        } finally {
            Console.close();
        }
    }

    protected final void runWinning(final String... args) {
        try {
            command(args);
            runWinning();
        } finally {
            Console.close();
        }
    }
    protected final void runBonus(final String... args) {
        try {
            command(args);
            runBonus();
        } finally {
            Console.close();
        }
    }

    protected final void runPriceException(final String... args) {
        try {
            runPrice(args);
        } catch (final NoSuchElementException ignore) {
        }
    }

    protected final void runWinningException(final String... args) {
        try {
            runWinning(args);
        } catch (final NoSuchElementException ignore) {
        }
    }

    protected final void runBonusException(final String... args) {
        try {
            runBonus(args);
        } catch (final NoSuchElementException ignore) {
        }
    }

    private void command(final String... args) {
        final byte[] buf = String.join("\n", args).getBytes();
        System.setIn(new ByteArrayInputStream(buf));
    }

    protected abstract void runPrice();

    protected abstract void runWinning();
    protected abstract void runBonus();
}
