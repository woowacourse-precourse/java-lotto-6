package lotto.validate;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.Duration;
import java.util.NoSuchElementException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.opentest4j.AssertionFailedError;
import org.opentest4j.TestAbortedException;

class InputValidatorTest {

    InputValidator inputValidator = new InputValidator();

    private static ByteArrayOutputStream outputMessage;

    @BeforeEach
    void setUpStreams() {
        outputMessage = new ByteArrayOutputStream(); // OutputStream 생성
        System.setOut(new PrintStream(outputMessage)); // 생성한 OutputStream 으로 설정
    }

    @AfterEach
    void restoresStreams() {
        System.setOut(System.out); // 원상복귀
    }

    @Test
    @DisplayName("구매 금액이 음수가 입력될시")
    void validatePurchaseAmount() {
        String purchase = "-123000";

        assertAll(
                () -> assertThatThrownBy(() -> inputPurchaseFailureCase(purchase))
                        .isInstanceOf(Exception.class),
                () -> assertTrue(outputMessage
                        .toString()
                        .contains("0 이상의 숫자를 입력해주세요.")
                )
        );

    }

    @Test
    @DisplayName("구매 금액이 숫자가 아닌 값이 들어 올 경우")
    void invalidPurchaseInputFormatTest() {
        String purchase = "iAmSuperShy";
        assertAll(
                () -> assertThatThrownBy(() -> inputPurchaseFailureCase(purchase))
                        .isInstanceOf(Exception.class),
                () -> assertTrue(outputMessage
                        .toString()
                        .contains("잘못된 입력입니다. 숫자를 입력해주세요(범위 1,000~1,000,000,000)")
                )
        );

    }

    @Test
    @DisplayName("1000으로 나누어 지지 않는 경우")
    void dividableInputFormatTest() {
        String purchase = "1234";
        assertAll(
                () -> assertThatThrownBy(() -> inputPurchaseFailureCase(purchase))
                        .isInstanceOf(Exception.class),
                () -> assertTrue(outputMessage
                        .toString()
                        .contains("잘못된 입력입니다. 숫자를 입력해주세요(범위 1,000~1,000,000,000)")
                )
        );

    }

    private void inputPurchaseFailureCase(String purchase){
        assertTimeoutPreemptively(Duration.ofMillis(10000), () -> inputValidator.validatePurchaseAmount(purchase));

    }


}