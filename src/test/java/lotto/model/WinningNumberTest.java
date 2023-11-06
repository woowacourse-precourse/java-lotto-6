package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;


class WinningNumberTest {

    @Test
    @DisplayName("당첨 번호가 6개가 아니라면 예외를 발생시킨다.")
    void winningNumber_throwException() {
        /**
         * given : 5개의 당첨 번호가 담긴 문자가 주어진다.
         * when : WinningNumber 객체를 생성한다.
         * then : IllegalArgumentException 예외가 발생한다.
         */
        String winningNumInput = "1,2,3,4,5";

        assertThatThrownBy(() -> new WinningNumber(winningNumInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("당첨 번호는 6개여야 합니다.");
    }

    @Test
    @DisplayName("당첨 번호의 원소가 1부터 45까지의 수가 아니라면 예외를 발생시킨다.")
    void validateWinningNumRange_throwException() {
        /**
         * given : 45이상의 숫자가 포함된 6자리의 당첨 번호가 주어진다.
         * when : WinningNumber 객체를 생성한다.
         * then : IllegalArgumentException 예외가 발생한다.
         */
        String winningNumInput = "1,2,3,4,46,47";

        assertThatThrownBy(() -> new WinningNumber(winningNumInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("당첨 번호는 1부터 45까지의 숫자만 가능합니다.");
    }

    @Test
    @DisplayName("중복된 당첨번호가 주어진다면 예외를 발생시킨다. ")
    void validateIsDuplicated_throwException() {
        /**
         * given : 중복된 당첨번호가 포함된 문자가 주어진다.
         * when : WinningNumber 객체를 생성한다.
         * then : IllegalArgumentException 예외가 발생한다.
         */
        String winningNumInput = "1,2,3,4,5,5";

        assertThatThrownBy(() -> new WinningNumber(winningNumInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("당첨 번호는 중복될 수 없습니다.");
    }

    @Test
    @DisplayName("올바른 당첨번호가 주어진다면 예외를 발생시키지 않는다.")
    void validateWinningNumbers_successful() {
        /**
         * given : 조건에 맞는 당첨 번호가 주어진다.
         * when : WinningNumber 객체를 생성한다.
         * then : 예외가 발생하지 않는다.
         */
        String winningNumInput = "1,2,3,4,5,6";

        assertThatCode(() -> new WinningNumber(winningNumInput))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("당첨 번호 생성 후, 값을 검증한다.")
    void validateWinningNumbers_validateValue() {
        /**
         * given : 조건에 맞는 당첨 번호가 주어진다.
         * when : WinningNumber 객체를 생성한다.
         * then : 당첨 번호의 원소와 크기를 검증한다.
         */
        String winningNumInput = "1,2,3,4,5,6";

        WinningNumber winningNumber = new WinningNumber(winningNumInput);
        assertThat(winningNumber.getWinningNumbers()).containsExactly(1, 2, 3, 4, 5, 6);
        assertThat(winningNumber.getWinningNumbers()).hasSize(6);
    }

    @Test
    @DisplayName("로또 번호가 당첨 번호에 포함되어 있다면 True를 반환한다.")
    void isContainLottoNumber_true() {
        /**
         * given : 당첨 번호 1,2,3,4,5,6과 로또 번호 1이 주어진다.
         * when : WinningNumber 객체를 생성한다.
         * then : 1이 포함되어 있기 때문에 True를 반환한다.
         */
        int number= 1;

        WinningNumber winningNumber = new WinningNumber("1,2,3,4,5,6");

        assertThat(winningNumber.isContainLottoNumber(number)).isTrue();
    }

    @Test
    @DisplayName("로또 번호가 당첨 번호에 포함되어 있지 않다면 False를 반환한다.")
    void isContainLottoNumber_false() {
        /**
         * given : 당첨 번호 1,2,3,4,5,6과 로또 번호 7이 주어진다.
         * when : WinningNumber 객체를 생성한다.
         * then : 7이 포함되어 있지 않기 때문에 False를 반환한다.
         */
        int number= 7;

        WinningNumber winningNumber = new WinningNumber("1,2,3,4,5,6");

        assertThat(winningNumber.isContainLottoNumber(number)).isFalse();
    }
}