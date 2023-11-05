package lotto.valadator;

import static lotto.view.InputView.inputPurchasePrice;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Arrays;
import lotto.view.validator.PurchasePriceValidator;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class PurchasePriceValidatorTest {
    private static final String ERROR_MESSAGE = "[ERROR]";
    private static final ByteArrayOutputStream output = new ByteArrayOutputStream();


    @DisplayName("로또구입금액 입력값 에러 리턴값 확인")
    @ParameterizedTest
    @ValueSource(strings = {"", "100a", "1001"})
    void purchasePriceValidatorErrorReturnTest(String input) {
        boolean result = PurchasePriceValidator.validatePurchasePrice(input);

        assertThat(result).isEqualTo(false);
    }

    @DisplayName("로또구입금액 입력값 리턴값 확인")
    @ParameterizedTest
    @ValueSource(strings = {"1000", "5000", "531234000"})
    void purchasePriceValidatorReturnTest(String input) {
        boolean result = PurchasePriceValidator.validatePurchasePrice(input);

        assertThat(result).isEqualTo(true);
    }

    @DisplayName("로또구입금액 입력값 에러 메시지 출력 확인")
    @ParameterizedTest
    @ValueSource(strings = {"", "100a", "1001"})
    void purchasePriceValidatorErrorTest(String input) {
        System.setOut(new PrintStream(output));

        PurchasePriceValidator.validatePurchasePrice(input);

        assertThat(output.toString()).contains(ERROR_MESSAGE);

        System.setOut(System.out);
        output.reset();
    }

    @DisplayName("로또구입금액 입력값 에러 시 재입력 결과값 확인")
    @Test
    void purchasePriceValidatorRetryTest() {
        String input;
        input = "test\n\"\"\n123\n1000";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        int result = inputPurchasePrice();

        assertThat(result).isEqualTo(1000);
    }


}
