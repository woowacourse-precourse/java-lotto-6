package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import lotto.view.message.Error;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class PurchaseAmountTest {

    private final String ERROR_CODE = "[ERROR}";

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream systemOut = System.out;

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(systemOut);
    }

    @ParameterizedTest
    @DisplayName("input이 숫자가 아닌 경우에 에러 발생")
    @ValueSource(strings = {"dk", "", " ", "안녕"})
    public void 입력값이_숫자가_아닌_경우(String input) {
        //when + then
        assertThatThrownBy(() -> {
            PurchaseAmount.create(input);
        }).isInstanceOf(IllegalArgumentException.class);

        assertThat(outContent.toString()).isEqualTo(Error
                .PURCHASE_AMOUNT_VALIDATION_ERROR
                .getMessage());
    }
}
