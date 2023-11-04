package lotto.ui;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.Test;

public class OutputTest {

    @Test
    public void testPrintPurchaseCount() {
        //given
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        int count = 5;
        String expectedOutput = "\n" + count + "개를 구매했습니다.\n";
        String actualOutput = outputStream.toString();

        // when
        Output.printPurchaseCount(count);

        // then
        assertEquals(expectedOutput, actualOutput);
    }
}
