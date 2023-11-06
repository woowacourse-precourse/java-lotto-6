package lotto.handler;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static lotto.message.ErrorMessage.INVALID_COUNT_FORMAT;
import static lotto.message.ErrorMessage.INVALID_PURCHASE_AMOUNT;
import static lotto.message.SystemMessage.INPUT_PURCHASE_PRICE;
import static org.assertj.core.api.Assertions.assertThat;

class InputHandlerTest {
    private PrintStream standardOut;
    private OutputStream captor;

    @BeforeEach
    public void init() {
        standardOut = System.out;
        captor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(captor));
    }

    @AfterEach
    public void printOutput() {
        System.setOut(standardOut);
        System.out.println(output());
    }

    @Test
    @DisplayName("유효하지 않은 입력 시 반복적으로 입력 메시지를 표시하고 유효한 입력을 반환")
    void testSetLottoPurchasePriceWithInvalidInput() {
        // given
        int retryCount = 3;
        int answerNum = 2000;
        String answer = "2000";

        // when
        run("qwe", "asd", "zxc", answer);
        int lottoPurchasePrice = InputHandler.setLottoPurchasePrice();

        // then
        String inputMessage = INPUT_PURCHASE_PRICE.getMessage();
        String InvalidCountFormatMessage = INPUT_PURCHASE_PRICE.getMessage() + "\n"
                + INVALID_COUNT_FORMAT.getMessage() + "\n";

        assertThat(output()).isEqualTo(
                InvalidCountFormatMessage.repeat(retryCount) +
                        inputMessage
        );
        assertThat(lottoPurchasePrice).isEqualTo(answerNum);
    }

    @Test
    @DisplayName("유효하지 않은 입력 시 반복적으로 입력 메시지를 표시하고 유효한 입력을 반환2")
    void testSetLottoPurchasePriceWithInvalidInput2() {
        // given
        int answerNum = 2000;
        String answer = "2000";

        // when
        run("qwe", "123", answer);
        int lottoPurchasePrice = InputHandler.setLottoPurchasePrice();

        // then
        String inputMessage = INPUT_PURCHASE_PRICE.getMessage();
        String InvalidCountFormatMessage = INPUT_PURCHASE_PRICE.getMessage() + "\n"
                + INVALID_COUNT_FORMAT.getMessage() + "\n";
        String InvalidPurchaseAmountMessage = INPUT_PURCHASE_PRICE.getMessage() + "\n"
                + INVALID_PURCHASE_AMOUNT.getMessage() + "\n";

        assertThat(output()).isEqualTo(
                InvalidCountFormatMessage +
                        InvalidPurchaseAmountMessage +
                        inputMessage
        );
        assertThat(lottoPurchasePrice).isEqualTo(answerNum);
    }

    private String output() {
        return captor.toString().trim();
    }

    private void run(final String... args) {
        try {
            command(args);
        } finally {
            Console.close();
        }
    }

    private void command(final String... args) {
        final byte[] buf = String.join("\n", args).getBytes();
        System.setIn(new ByteArrayInputStream(buf));
    }

}