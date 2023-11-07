package lotto.model;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import java.util.List;
import lotto.constant.ExceptionMessage;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinningNumberTest {

    // 당첨 번호 개수 관련 테스트
    @DisplayName("당첨 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createWinningNumberByOverSize() {
        assertThatThrownBy(() -> new WinningNumber(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.WINNING_NUMBERS_COUNT_EXCEPTION.getMessage());
    }

    @DisplayName("당첨 번호의 개수가 6개가 안되면 예외가 발생한다.")
    @Test
    void createWinningNumberByUnderSize() {
        assertThatThrownBy(() -> new WinningNumber(List.of(1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.WINNING_NUMBERS_COUNT_EXCEPTION.getMessage());

        assertThatThrownBy(() -> new WinningNumber(List.of(1)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.WINNING_NUMBERS_COUNT_EXCEPTION.getMessage());
    }

    @DisplayName("당첨 번호의 개수가 6개이면 당첨 번호가 생성된다.")
    @Test
    void createWinningNumber() {
        WinningNumber winningNumber = new WinningNumber(List.of(1, 2, 3, 4, 5, 6));
        Assertions.assertThat(winningNumber).isNotNull();

        winningNumber = new WinningNumber(List.of(45, 1, 12, 36, 5, 9));
        Assertions.assertThat(winningNumber).isNotNull();
    }

    // 당첨 번호 범위 관련 테스트

    @DisplayName("당첨 번호가 1 ~ 45 사이의 숫자가 아니면 예외가 발생한다.")
    @Test
    void createWinningNumberByOutOfRange() {
        assertThatThrownBy(() -> new WinningNumber(List.of(1, 2, 3, 4, 5, 46)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.OUT_OF_RANGE_NUMBER_EXCEPTION.getMessage());

        assertThatThrownBy(() -> new WinningNumber(List.of(0, 2, 3, 4, 5, 6)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.OUT_OF_RANGE_NUMBER_EXCEPTION.getMessage());
    }

    @DisplayName("당첨 번호가 1 ~ 45 사이의 숫자이면 당첨 번호가 생성된다.")
    @Test
    void createWinningNumberByInRange() {
        WinningNumber winningNumber = new WinningNumber(List.of(1, 2, 3, 4, 5, 6));
        Assertions.assertThat(winningNumber).isNotNull();

        winningNumber = new WinningNumber(List.of(45, 44, 43, 42, 41, 40));
        Assertions.assertThat(winningNumber).isNotNull();
    }

    // 당첨 번호 중복 관련 테스트
    @DisplayName("당첨 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createWinningNumberByDuplicatedNumber() {
        assertThatThrownBy(() -> new WinningNumber(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.DUPLICATE_NUMBER_EXCEPTION.getMessage());

        assertThatThrownBy(() -> new WinningNumber(List.of(45, 2, 3, 4, 5, 45)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.DUPLICATE_NUMBER_EXCEPTION.getMessage());
    }

    @DisplayName("당첨 번호에 중복된 숫자가 없으면 당첨 번호가 생성된다.")
    @Test
    void createWinningNumberByNotDuplicatedNumber() {
        WinningNumber winningNumber = new WinningNumber(List.of(1, 2, 3, 4, 5, 6));
        Assertions.assertThat(winningNumber).isNotNull();
    }
}
