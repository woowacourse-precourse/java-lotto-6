package lotto.domain;

import lotto.constant.ExceptionMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("WinningNumbers 테스트")
class WinningNumbersTest {

    @DisplayName("createNumbers 테스트")
    @Nested
    class createWinningNumbers {

        @DisplayName("숫자 리스트 길이가 6이 아니면 오류를 반환한다.")
        @Test
        void givenListLengthIsNotSix() {
            assertThatThrownBy(
                    () -> WinningNumbers.createWinningNumbers(List.of(1, 2, 3, 4, 5, 6, 7))
            )
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ExceptionMessage.LENGTH_ERROR_MESSAGE);
        }

        @DisplayName("범위를 벗어난 숫자가 존재하면 오류를 반환한다.")
        @Test
        void givenListHasOutOfRangeNumber() {
            assertThatThrownBy(
                    () -> WinningNumbers.createWinningNumbers(List.of(1, 2, 3, 4, 5, 46))
            )
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ExceptionMessage.OUT_OF_LOTTO_RANGE_MESSAGE);
        }

        @DisplayName("중복된 숫자가 존재하면 오류를 반환한다.")
        @Test
        void givenListHasDuplicatedNumbers() {
            assertThatThrownBy(
                    () -> WinningNumbers.createWinningNumbers(List.of(1, 1, 2, 3, 4, 5))
            )
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ExceptionMessage.DUPLICATION_MESSAGE);
        }

    }

    @DisplayName("contains 테스트")
    @Nested
    class contains {

        @DisplayName("숫자를 포함하고 있지 않으면 거짓을 반환한다.")
        @Test
        void givenNumberIsNotContained() {
            WinningNumbers winningNumbers = WinningNumbers.createWinningNumbers(List.of(1, 2, 3, 4, 5, 6));
            assertFalse(winningNumbers.contains(7));
        }

        @DisplayName("숫자를 포함하고 있으면 참을 반환한다.")
        @Test
        void givenNumberIsContained() {
            WinningNumbers winningNumbers = WinningNumbers.createWinningNumbers(List.of(1, 2, 3, 4, 5, 6));
            assertTrue(winningNumbers.contains(1));
        }

        @DisplayName("BonusNumber를 포함하고 있지 않으면 거짓을 반환한다.")
        @Test
        void givenBonusNumberIsNotContained() {
            WinningNumbers winningNumbers = WinningNumbers.createWinningNumbers(List.of(1, 2, 3, 4, 5, 6));
            assertFalse(winningNumbers.contains(new BonusNumber(7)));
        }

        @DisplayName("BonusNumber를 포함하고 있으면 참을 반환한다.")
        @Test
        void givenBonusNumberIsContained() {
            WinningNumbers winningNumbers = WinningNumbers.createWinningNumbers(List.of(1, 2, 3, 4, 5, 6));
            assertTrue(winningNumbers.contains(new BonusNumber(1)));
        }

    }


}