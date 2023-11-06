package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WinningTest {
    /*
    @DisplayName("당첨 로또 번호 길이가 6이 아니면 예외가 발생한다.")
    @Test
    void winningNumbersLengthTest() {
        assertThatThrownBy(() -> new Winning(List.of(1, 2, 3, 4, 5, 6, 7), 1))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 로또 번호의 숫자 범위가 1보다 작으면 예외가 발생한다.")
    @Test
    void checkRangeMinTest() {
        assertThatThrownBy(() -> new Winning(List.of(-1, 2, 3, 4, 5, 45), 1))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 로또 번호의 숫자 범위가 45보다 크면 예외가 발생한다.")
    @Test
    void checkRangeMaxTest() {
        assertThatThrownBy(() -> new Winning(List.of(1, 2, 3, 4, 5, 46), 1))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 로또 번호의 숫자가 45이면 예외가 발생하지 않는다.")
    @Test
    void checkRange45Test() {
        Winning winning = new Winning(List.of(7, 2, 3, 4, 5, 45), 1);
    }

    @DisplayName("당첨 로또 번호의 숫자가 1이면 예외가 발생하지 않는다.")
    @Test
    void checkRange1Test() {
        Winning winning = new Winning(List.of(7, 2, 3, 4, 5, 6), 1);
    }

    @DisplayName("보너스 번호 범위가 1보다 작으면 예외가 발생한다.")
    @Test
    void checkBonusRangeMinTest() {
        assertThatThrownBy(() -> new Winning(List.of(1, 2, 3, 4, 5, 45), 0))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호 범위가 45보다 작으면 예외가 발생한다.")
    @Test
    void checkBonusRangeMaxTest() {
        assertThatThrownBy(() -> new Winning(List.of(1, 2, 3, 4, 5, 45), 46))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호와 보너스 번호가 중복되면 예외가 발생한다.")
    @Test
    void checkDuplicationBetweenWinningNumberAndBonus() {
        assertThatThrownBy(() -> new Winning(List.of(1, 2, 3, 4, 5, 45), 1))
                .isInstanceOf(IllegalArgumentException.class);
    }*/
}
