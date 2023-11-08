package lotto;

import lotto.Input.InputView;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class InputViewTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final InputStream originalIn = System.in;
    @Test
    public void testReadPurchaseAmount() {
        // Simulate console input
        String input = "123";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // Call the method to be tested
        int purchaseAmount = InputView.readPurchaseAmount();

        // Verify the output and the result
        assertEquals(123, purchaseAmount);
    }

    @Test
    public void testReadAnswerNumber() {
        // Simulate console input
        String input = "1,2,3,4,5,6";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // Call the method to be tested
        List<Integer> answerNumber = InputView.readAnswerNumber();
        List<Integer> expected = List.of(1,2,3,4,5,6);
        // Verify the output and the result
        assertEquals(expected,answerNumber);
    }
}
