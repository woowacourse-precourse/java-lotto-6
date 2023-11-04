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

    @BeforeAll
    static void setUpStream() {
        System.setOut(new PrintStream(output));
    }

    @AfterAll()
    static void resetUpStream() {
        System.setOut(System.out);
        output.reset();
    }

    @DisplayName("로또구입금액 입력 에러처리 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"", "100a", "1001"})
    void purchasePriceValidatorErrorTest(String input) {
        PurchasePriceValidator.validatePurchasePrice(input);

        assertThat(output.toString()).contains(ERROR_MESSAGE);
    }

    @DisplayName("로또구입금액 입력 에러 재입력 테스트")
    @Test
    void purchasePriceValidatorRetryTest() {
        String input;
        input = "test\n\"\"\n123\n1000";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        int result = inputPurchasePrice();

        assertThat(result).isEqualTo(1000);
    }


}
