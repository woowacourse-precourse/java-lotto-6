package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import lotto.utils.message.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class WinningNumberTest {
    @Test
    @DisplayName("당첨 번호 로또 생성 성공")
    void createWinningNumber() {
        // given
        String s = "1,2,3,4,5,6";

        // when
        WinningNumber winningNumber = new WinningNumber(s);

        // then
        assertThat(winningNumber).isNotNull();
    }

    @ParameterizedTest
    @ValueSource(strings = {"1.2.3.4.5.6", "1-2-3-4-5-6"})
    @DisplayName("당첨 번호를 쉼표(,)로 구분하지 않으면 에러가 발생한다.")
    void createWinningNumberByWrongDelimiter(String s) {
        assertThatThrownBy(() -> new WinningNumber(s))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(ErrorMessage.INVALID_SPLIT_DELIMITER);
    }

    @Test
    @DisplayName("당첨 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    void createWinningNumberByOverSize() {
        // given
        String s = "1,2,3,4,5,6,7";

        // when // then
        assertThatThrownBy(() -> new WinningNumber(s))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(ErrorMessage.INVALID_NUMBER_SIZE);
    }

    @Test
    @DisplayName("당첨 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    void createWinningNumberByDuplicatedNumber() {
        // given
        String s = "1,2,3,4,5,5";

        // when // then
        assertThatThrownBy(() -> new WinningNumber(s))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(ErrorMessage.DUPLICATED_NUMBER);
    }

    @Test
    @DisplayName("당첨 번호가 1~45 사이의 숫자가 아니라면 예외가 발생한다.")
    void createWinningNumberByWrongRangeNumber() {
        // given
        String s = "0,46,3,4,5,6";

        // when // then
        assertThatThrownBy(() -> new WinningNumber(s))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(ErrorMessage.INVALID_NUMBER_RANGE);
    }
}