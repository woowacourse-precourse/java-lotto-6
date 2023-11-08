package lotto.view;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class InputViewTest {
    private final InputStream standardOut = System.in;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        String input = "10000\n1,2,3,4,5,6\n7\n";
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
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

}
