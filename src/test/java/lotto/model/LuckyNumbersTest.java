package lotto.model;

import lotto.constant.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LuckyNumbersTest {

    @ParameterizedTest
    @DisplayName("예외) 콤마없이 입력했을 때")
    @ValueSource(strings = {"123456", "asdf"})
    void 콤마_없는_예외(String value) {
        assertThatThrownBy(() -> new LuckyNumbers(value))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.NON_EXIST_COMMA.getMessage());
    }

    @ParameterizedTest
    @DisplayName("예외) 콤마 사이에 값이 없을 때")
    @ValueSource(strings = {"1,2,,3", "a,,1,3"})
    void 콤마_사이_값X_예외(String value) {
        assertThatThrownBy(() -> new LuckyNumbers(value))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.NON_EXIST_INPUT.getMessage());
    }

    @ParameterizedTest
    @DisplayName("예외) 숫자가 아닌 요소값이 있을 때")
    @ValueSource(strings = {"eifo,eiojf", "1,2,a,3"})
    void 숫자가_아닌_예외(String value) {
        assertThatThrownBy(() -> new LuckyNumbers(value))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.NOT_DIGIT.getMessage());
    }

    @ParameterizedTest
    @DisplayName("List<String>에서 List<Integer>로 변환 확인")
    @ValueSource(strings = {"1,2,3,4,5,6"})
    void 타입_변환_확인(String value) {
        LuckyNumbers input = new LuckyNumbers(value);
        input.getNumbers();
        assertThat(input.getNumbers().get(0)).isInstanceOf(Integer.class);
    }

}