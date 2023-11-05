package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class GameTest {
    private static Game game = new Game("5000");

    @DisplayName("금액은 1000의 배수가 아닌 경우 예외가 발생한다.")
    @Test
    void createGameByNotMultiplesOf1000() {
        assertThatThrownBy(() -> new Game("8700"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("금액에 숫자 외의 값이 들어간 경우 예외가 발생한다.")
    @Test
    void createGameByNoNumberString() {
        assertThatThrownBy(() -> new Game("1000Fdk"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨번호 개수가 6개가 아닐 경우 예외가 발생한다.")
    @Test
    void inputWinningMembersByUnderNumberCount() {
        assertThatThrownBy(() -> game.setWinningNumbers("1,2,3,4,5"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨번호 중 중복 값이 있을 경우 예외가 발생한다.")
    @Test
    void inputWinningMembersByDuplicateNumber() {
        assertThatThrownBy(() -> game.setWinningNumbers("1,2,3,4,5,5"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨번호 중 숫자가 아닌 값이 들어간 경우 예외가 발생한다.")
    @Test
    void inputWinningMembersByNoNumberString() {
        assertThatThrownBy(() -> game.setWinningNumbers("1,2,3,4,5,2s"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력한 당첨 번호가 1~45 사이의 숫자가 아닌 경우 예외가 발생한다.")
    @Test
    void inputWinningMembersByIncorrectNumber() {
        assertThatThrownBy(() -> game.setWinningNumbers("1,2,3,4,5,47"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
