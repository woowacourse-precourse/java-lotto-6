package lotto.model;

import lotto.constant.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BonusNumberTest {

    @ParameterizedTest
    @DisplayName("예외) 입력이 없을 때")
    @ValueSource(strings = {""})
    void 공백_입력_예외(String value) {
        assertThatThrownBy(() -> new BonusNumber(value, new Lotto(List.of(1, 2, 3, 4, 5, 6))))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.NON_EXIST_INPUT.getMessage());
    }

    @ParameterizedTest
    @DisplayName("예외) 숫자가 아닌 값을 입력했을 때")
    @ValueSource(strings = {"ewijfoefj", " ", "1,000"})
    void 숫자가_아닌_문자_예외(String value) {
        assertThatThrownBy(() -> new BonusNumber(value, new Lotto(List.of(1, 2, 3, 4, 5, 6))))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.NOT_DIGIT.getMessage());
    }

    @ParameterizedTest
    @DisplayName("예외) 보너스 번호가 1~45 범위가 아닐 때")
    @ValueSource(strings = {"0", "100"})
    void 번호_범위_확인(String value) {
        assertThatThrownBy(() -> new BonusNumber(value, new Lotto(List.of(1, 2, 3, 4, 5, 6))))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.NOT_IN_RANGE.getMessage());
    }

    @ParameterizedTest
    @DisplayName("예외) 보너스 번호가 이미 입력받은 로또 번호일 때")
    @ValueSource(strings = {"6"})
    void 번호_중복_확인(String value) {
        assertThatThrownBy(() -> new BonusNumber(value, new Lotto(List.of(1, 2, 3, 4, 5, 6))))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.EXIST_BONUS.getMessage());
    }

}