package lotto.model;

import lotto.constant.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoMakerTest {

    @ParameterizedTest
    @DisplayName("예외) 입력이 없을 때")
    @ValueSource(strings = {""})
    void 공백_입력_예외(String value){
        assertThatThrownBy(() -> new LottoMaker(value))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.NON_EXIST_INPUT.getMessage());
    }

    @ParameterizedTest
    @DisplayName("예외) 숫자가 아닌 값을 입력했을 때")
    @ValueSource(strings = {"ewijfoefj", " ", "1,000"})
    void 숫자가_아닌_문자_예외(String value){
        assertThatThrownBy(() -> new LottoMaker(value))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.NOT_DIGIT.getMessage());
    }

    @ParameterizedTest
    @DisplayName("예외) 0을 입력했을 때")
    @ValueSource(strings = {"0"})
    void 입력_0_예외(String value){
        assertThatThrownBy(() -> new LottoMaker(value))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.EXIST_ZERO.getMessage());
    }

    @ParameterizedTest
    @DisplayName("예외) 1000원 단위가 아닌 값을 입력했을 때")
    @ValueSource(strings = {"1400", "52"})
    void 금액_단위_예외(String value){
        assertThatThrownBy(() -> new LottoMaker(value))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INVALID_MONEY.getMessage());
    }

}