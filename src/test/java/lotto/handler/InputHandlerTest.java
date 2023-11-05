package lotto.handler;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import lotto.message.ErrorMessage;
import lotto.message.SystemMessage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static lotto.message.ErrorMessage.INVALID_COUNT_FORMAT;
import static lotto.message.SystemMessage.INPUT_PURCHASE_PRICE;
import static org.assertj.core.api.Assertions.assertThat;

class InputHandlerTest {
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

    @Test
    @DisplayName("유효하지 않은 입력 시 반복 메시지를 표시하고 유효한 입력을 반환")
    void testSetLottoPurchasePriceWithInvalidInput() {
        // given
        int retryCount = 3;
        String inputMessage = INPUT_PURCHASE_PRICE.getMessage();
        String repeatMessage = INPUT_PURCHASE_PRICE.getMessage() + "\n"
                + INVALID_COUNT_FORMAT.getMessage() + "\n";

        // when
        run("qwe", "asd", "zxc", "123");
        int lottoPurchasePrice = InputHandler.setLottoPurchasePrice();

        // then
        assertThat(output()).isEqualTo(
                repeatMessage.repeat(retryCount) +
                        inputMessage
        );
        assertThat(lottoPurchasePrice).isEqualTo(123);
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