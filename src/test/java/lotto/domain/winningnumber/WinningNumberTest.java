package lotto.domain.winningnumber;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class WinningNumberTest {
    private static final String SIX_NUMBERS = "1,2,3,4,5,6";
    private static final String BONUS_NUMBER = "7";

    private WinningNumber winningNumber;

    @DisplayName("당첨번호와 보너스번호 인자로 입력 받아 객체 생성")
    @Test
    void createWinningNumber() {
        winningNumber = new WinningNumber(SIX_NUMBERS, BONUS_NUMBER);
        assertThat(winningNumber).isNotEqualTo(null);
    }

    @DisplayName("당첨번호 숫자로 변환")
    @Test
    void convertInputToNumberList() {
        winningNumber = new WinningNumber(SIX_NUMBERS, BONUS_NUMBER);
        assertThat(winningNumber.getWinningNumbers()).isInstanceOf(List.class);
    }

    @DisplayName("당첨번호 입력 시 숫자와 콤마(,) 외 다른 값 입력하면 예외 발생")
    @Test
    void createWithNotNumbers() {
        assertThatThrownBy(() -> new WinningNumber("1,2,3,4,5,char", BONUS_NUMBER))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력한 당첨번호가 6개가 아니면 예외 발생")
    @Test
    void createWithNotSixNumbers() {
        assertThatThrownBy(() -> new WinningNumber("1,2,3,4,5", BONUS_NUMBER))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력한 당첨번호가 1~45 사이의 수가 아니면 예외 발생")
    @Test
    void createWithNumbersNotBetween1And45() {
        assertThatThrownBy(() -> new WinningNumber("0,2,3,4,5,55", BONUS_NUMBER))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력한 당첨번호에 중복되는 수 있으면 예외 발생")
    @Test
    void createWithDuplicateNumbers() {
        assertThatThrownBy(() -> new WinningNumber("1,2,3,4,5,5", BONUS_NUMBER))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스번호 입력 시 숫자 외 다른 값 입력하면 예외 발생")
    @Test
    void createWithNotNumber() {
        assertThatThrownBy(() -> new WinningNumber(SIX_NUMBERS, "bonus"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력한 보너스번호가 1~45 사이의 수가 아니면 예외 발생")
    @Test
    void createWithNumberNotBetween1And45() {
        assertThatThrownBy(() -> new WinningNumber(SIX_NUMBERS, "55"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스번호가 당첨번호와 중복되면 예외 발생")
    @Test
    void hasBonusNumberInWinningNumbers() {
        assertThatThrownBy(() -> new WinningNumber(SIX_NUMBERS, "5"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}