package lotto.view;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

class InputViewTest {
    InputView inputView;

    @BeforeEach
    public void createInputView(){
        inputView = new InputView();
    }

    @ParameterizedTest
    @ValueSource(strings = {"14000"})
    @DisplayName("구매 금액을 입력 받습니다.")
    void inputPurchaseAmount(String input) {
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        String inputPurchaseAmount = inputView.inputPurchaseAmount();

        assertThat(inputPurchaseAmount).isEqualTo(input);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,6"})
    @DisplayName("당첨 번호를 입력 받습니다.")
    void inputWinningNumber(String input) {
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        String inputWinningNumber = inputView.inputWinningNumber();

        assertThat(inputWinningNumber).isEqualTo(input);
    }

    @ParameterizedTest
    @ValueSource(strings = {"7"})
    @DisplayName("보너스 번호를 입력 받습니다.")
    void inputBonusNumber(String input) {
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        String inputWinningNumber = inputView.inputBonusNumber();

        assertThat(inputWinningNumber).isEqualTo(input);
    }
}