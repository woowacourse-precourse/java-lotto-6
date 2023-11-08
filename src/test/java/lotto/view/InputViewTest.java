package lotto.view;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class InputViewTest {
    private final InputStream standardOut = System.in;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setIn(new ByteArrayInputStream(outputStreamCaptor.toByteArray()));
    }

    @AfterEach
    public void tearDown() {
        System.setIn(standardOut);
    }

    @Test
    public void testInputLottoPurchaseAmount() {
        ByteArrayInputStream in = new ByteArrayInputStream("10000\n".getBytes());
        System.setIn(in);

        assertEquals(10000, InputView.inputLottoPurchaseAmount());
    }

    @Test
    public void testInputWinningNumbers() {
        ByteArrayInputStream in = new ByteArrayInputStream("1,2,3,4,5,6\n".getBytes());
        System.setIn(in);

        List<Integer> expected = Arrays.asList(1, 2, 3, 4, 5, 6);
        assertEquals(expected, InputView.inputWinningNumbers());
    }

    @Test
    public void testInputBonusNumber() {
        ByteArrayInputStream in = new ByteArrayInputStream("7\n".getBytes());
        System.setIn(in);

        assertEquals(7, InputView.inputBonusNumber());
    }
}
