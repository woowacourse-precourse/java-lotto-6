package lotto.domain;

import lotto.constant.ExceptionMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Result 테스트")
class ResultTest {

    @DisplayName("생성자 테스트")
    @Nested
    class constructor {

        @DisplayName("winningNumbers가 bonusNumber를 포함하고 있으면 오류를 던진다.")
        @Test
        void givenWinningNumberContainsGivenBonusNumber() {

            WinningNumbers winningNumbers = WinningNumbers.createWinningNumbers(List.of(1, 2, 3, 4, 5, 6));
            BonusNumber bonusNumber = new BonusNumber(1);

            assertThatThrownBy(
                    () -> new Result(winningNumbers, bonusNumber)
            )
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ExceptionMessage.BONUS_NUMBER_OVERLAPPED_MESSAGE);

        }

        @DisplayName("winningNumbers가 bonusNumber를 포함하고 있지 않으면 정상적으로 생성한다.")
        @Test
        void givenWinningNumberNotContainsGivenBonusNumber() {

            WinningNumbers winningNumbers = WinningNumbers.createWinningNumbers(List.of(1, 2, 3, 4, 5, 6));
            BonusNumber bonusNumber = new BonusNumber(7);

            assertDoesNotThrow(() -> new Result(winningNumbers, bonusNumber));

        }

    }

    @DisplayName("winningNumberContain 테스트")
    @Nested
    class winningNumberContain {

        @DisplayName("winningNumbers가 숫자를 포함하고 있지 않으면 거짓을 반환한다.")
        @Test
        void givenNumberIsNotContainedInWinningNumbers() {

            WinningNumbers winningNumbers = WinningNumbers.createWinningNumbers(List.of(1, 2, 3, 4, 5, 6));
            BonusNumber bonusNumber = new BonusNumber(7);
            Result result = new Result(winningNumbers, bonusNumber);

            assertFalse(result.winningNumbersContain(8));

        }

        @DisplayName("winningNumbers가 숫자를 포함하고 있으면 참을 반환한다.")
        @Test
        void givenNumberIsContainedInWinningNumbers() {

            WinningNumbers winningNumbers = WinningNumbers.createWinningNumbers(List.of(1, 2, 3, 4, 5, 6));
            BonusNumber bonusNumber = new BonusNumber(7);
            Result result = new Result(winningNumbers, bonusNumber);

            assertTrue(result.winningNumbersContain(1));

        }

    }

    @DisplayName("bonusNumberIs 테스트")
    @Nested
    class bonusNumberIs {

        @DisplayName("BonusNumber와 일치하지 않으면 거짓을 반환한다.")
        @Test
        void givenNumberIsNotContainedInWinningNumbers() {

            WinningNumbers winningNumbers = WinningNumbers.createWinningNumbers(List.of(1, 2, 3, 4, 5, 6));
            BonusNumber bonusNumber = new BonusNumber(7);
            Result result = new Result(winningNumbers, bonusNumber);

            assertFalse(result.bonusNumberIs(1));

        }

        @DisplayName("BonusNumber와 일치하면 참을 반환한다.")
        @Test
        void givenNumberIsContainedInWinningNumbers() {

            WinningNumbers winningNumbers = WinningNumbers.createWinningNumbers(List.of(1, 2, 3, 4, 5, 6));
            BonusNumber bonusNumber = new BonusNumber(7);
            Result result = new Result(winningNumbers, bonusNumber);

            assertTrue(result.bonusNumberIs(7));

        }

    }

}