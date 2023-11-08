package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class LottoGameTest {

    @DisplayName("당첨 번호와 보너스 번호가 중복되면 예외가 발생한다.")
    @Test
    void bonusOverlapThrowsException() {
        LottoGame lottoGame = new LottoGame();
        Lotto win = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonus = 5;

        assertThatThrownBy(() -> lottoGame.bonusOverlap(win, bonus))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("당첨 번호와 보너스 번호가 중복됩니다.");
    }

    @DisplayName("숫자가 1보다 작거나 45보다 크면 예외가 발생한다.")
    @Test
    void rangeCheckThrowsException() {
        LottoGame lottoGame = new LottoGame();
        int number = 46;

        assertThatThrownBy(() -> lottoGame.rangeCheck(number))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("1부터 45 사이의 숫자를 입력해주세요.");
    }

    @DisplayName("유효한 정수 문자열을 입력하면 해당 정수를 반환한다.")
    @Test
    void parseIntegerWithValidInput() {
        LottoGame lottoGame = new LottoGame();
        String validInput = "42";

        Integer result = lottoGame.parseInteger(validInput);

        assertThat(result).isEqualTo(42);
    }

    @DisplayName("유효하지 않은 정수 문자열을 입력하면 예외가 발생한다.")
    @Test
    void parseIntegerWithInvalidInput() {
        LottoGame lottoGame = new LottoGame();
        String invalidInput = "abc";

        assertThatThrownBy(() -> lottoGame.parseInteger(invalidInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("정수를 입력해주세요.");
    }

}