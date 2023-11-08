package lotto.input;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import lotto.module.view.InputView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class InputTest {

    InputView inputView;

    @BeforeEach
    public void generateInputView() {
        inputView = new InputView();
    }

    @DisplayName("로또 구매 금액 검증")
    @ParameterizedTest
    @ValueSource(strings = {"  "})
    void validatePurchaseAmount(String input) {
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertThatThrownBy(() -> InputView.readPurchaseAmount())
                .isInstanceOf(IllegalArgumentException.class);
    }
}
