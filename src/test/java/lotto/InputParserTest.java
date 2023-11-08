package lotto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;
import java.util.List;
import lotto.view.InputParser;
import org.junit.jupiter.api.Test;

public class InputParserTest {

    @Test
    public void testParseIntValid() {
        InputParser parser = new InputParser();
        int result = parser.parseInt("42");
        assertEquals(42, result);
    }

    @Test
    public void testParseIntInvalid() {
        InputParser parser = new InputParser();
        assertThrows(IllegalArgumentException.class, () -> {
            parser.parseInt("invalid");
        });
    }

    @Test
    public void testParsingNumbersValid() {
        InputParser parser = new InputParser();
        List<Integer> result = parser.parsingNumbers("1, 2, 3, 4, 5, 6");
        List<Integer> expected = Arrays.asList(1, 2, 3, 4, 5, 6);
        assertEquals(expected, result);
    }

    @Test
    public void testInvalidParsingNumbersEndWithComma() {
        InputParser parser = new InputParser();
        assertThrows(IllegalArgumentException.class, () -> {
            parser.parsingNumbers("1, 2, 3, 4, 5, 6,");
        });
    }

    @Test
    public void testParsingNumbersInvalid() {
        InputParser parser = new InputParser();
        assertThrows(IllegalArgumentException.class, () -> {
            parser.parsingNumbers("1, 2, 3, 4, 5, invalid");
        });
    }
}
