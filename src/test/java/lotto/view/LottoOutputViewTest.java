package lotto.view;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LottoOutputViewTest {
    private ByteArrayOutputStream capture;
    private PrintStream old;
    private LottoOutputView outputView;

    @BeforeEach
    void setUp() {
        capture = new ByteArrayOutputStream();
        old = System.out;
        System.setOut(new PrintStream(capture));
        outputView = new LottoOutputView();
    }

    @AfterEach
    void restore() {
        System.setOut(old);
    }

    @Test
    void printBuyingPriceInputRequest_테스트() {
        outputView.printBuyingPriceInputRequest();
        assertEquals("구입금액을 입력해 주세요.", capture.toString().trim());
    }
}
