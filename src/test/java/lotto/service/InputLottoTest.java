package lotto.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;

import java.util.List;
import lotto.view.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputLottoTest {
    @DisplayName("숫자가 아닌 문자가 섞여있을 때")
    @Test
    void 양수가_아닐때1() {
        String input = "1,2,f";
        assertThatThrownBy(() -> {
            InputLotto.isNumeric(input);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.NOT_NUM_ERROR);
    }

    @DisplayName("음수가 있을 때")
    @Test
    void 양수가_아닐때2() {
        String input = "-1,2,3";
        assertThatThrownBy(() -> {
            InputLotto.isNumeric(input);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.NOT_NUM_ERROR);
    }

    @Test
    void 양수_일때() {
        String input = "15,1,2";
        assertThatCode(() -> {
            InputLotto.isNumeric(input);
        }).doesNotThrowAnyException();
    }

    @Test
    void split_로또번호_구분() {
        List<Integer> result = InputLotto.separateLottoNumber("1,2,3,4,5,6");
        assertThat(result).contains(1, 2, 3, 4, 5, 6);
        assertThat(result).containsExactly(1, 2, 3, 4, 5, 6);
    }
}