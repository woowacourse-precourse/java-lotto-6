package lotto.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class WinningNumbersTest {
    WinningNumbers numbers = new WinningNumbers();

    @DisplayName("당첨 번호에 잘못된 값을 입력했을 경우 에러 반환 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"3.2.1.5.6.8", "23,41,55,12,3,8", "12,31,42,2,12,4"})
    void makeWinningNumber(String input) {
        assertThatThrownBy(() ->
                numbers.makeWinningNumber(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 볼에 잘못된 값을 입력했을 경우 에러 반환 테스트")
    @ParameterizedTest
    @ValueSource(ints = {-3, 46, 13})
    void makeBonusNumber(int input) {
        numbers.makeWinningNumber("13,22,4,5,31,17");
        assertThatThrownBy(() ->
                numbers.makeBonusNumber(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}