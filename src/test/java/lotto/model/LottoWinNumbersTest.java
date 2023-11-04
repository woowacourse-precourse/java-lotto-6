package lotto.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoWinNumbersTest {
    @ParameterizedTest
    @ValueSource(strings = {"1!2!3!4!5!6", "1,2,3,4,5@6"})
    @DisplayName("잘못된 구분자 검증")
    public void 잘못된_구분자(String input) {
        String winNumber = input;
        Assertions.assertThatThrownBy(() -> new LottoWinNumbers(winNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("잘못된 구분자");
    }
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,six", "one,two,삼,넷,five,six"})
    @DisplayName("자연수가 아닌 문자 검증")
    public void 자연수가_아닌_문자(String input) {
        String winNumber = input;
        Assertions.assertThatThrownBy(() -> new LottoWinNumbers(winNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자연수가 아닌 문자");
    }
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3456,7,8,9", "0,-1,-1000,10000,3,5"})
    @DisplayName("잘못된 숫자 범위 검증")
    public void 잘못된_숫자_범위(String input) {
        String winNumber = input;
        Assertions.assertThatThrownBy(() -> new LottoWinNumbers(winNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("1이상 45이하");
    }
    @ParameterizedTest
    @ValueSource(strings = {"1,2,2,3,4,5", "6,6,6,6,6,6"})
    @DisplayName("중복된 숫자 포함 검증")
    public void 중복된_숫자(String input) {
        String winNumber = input;
        Assertions.assertThatThrownBy(() -> new LottoWinNumbers(winNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("중복");
    }

}
