package lotto.view;

import lotto.domain.Buyer;
import lotto.domain.GenerateRandomNum;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static lotto.utils.ErrorMessages.CHECK_NUMBER_IN_RANGE;
import static lotto.utils.ErrorMessages.INPUT_NUMBER_FORMAT;
import static lotto.view.InputValidator.parseNumber;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class InputViewTest {
    private InputView inputView;
    private ByteArrayOutputStream outputStream;

    @BeforeEach
    public void setUp() {
        inputView = new InputView();
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    @AfterEach
    public void tearDown() {
        System.setOut(System.out);
    }

    @Test
    @DisplayName("printTicketCnt 메서드 테스트 - 금액을 지불 후 몇 개를 구매했는지 출력 문구")
    public void printTicketCnt() {
        Buyer buyer = new Buyer(3000, 3);

        inputView.printTicketCnt(buyer);

        String expectedOutput = "\n3개를 구매했습니다.\n";
        assertEquals(expectedOutput, outputStream.toString());
    }
}