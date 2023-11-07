package lotto.service;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;

import lotto.view.ErrorMessage;
import org.junit.jupiter.api.Test;

class InputWinningLottoTest {
    @Test
    void 양수가_아닐때1() {
        String input = "a2f";
        assertThatThrownBy(() -> {
            InputWinningLotto.isNumeric(input);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.NOT_NUM_ERROR);
    }

    @Test
    void 양수가_아닐때2() {
        String input = "-1";
        assertThatThrownBy(() -> {
            InputWinningLotto.isNumeric(input);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.NOT_NUM_ERROR);
    }

    @Test
    void 양수_일때() {
        String input = "15";
        assertThatCode(() -> {
            InputWinningLotto.isNumeric(input);
        }).doesNotThrowAnyException();
    }

}