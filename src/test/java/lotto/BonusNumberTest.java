package lotto;

import lotto.domain.BonusNumber;
import lotto.domain.ExceptionMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BonusNumberTest {
    @Nested
    @DisplayName("Success")
    class Success {
        @DisplayName("띄어쓰기가 포함된 보너스 번호")
        @Test
        public void testBonusNumbersWithSpace() {
            String inputBonusNumber = " 7 ";
            List inputWinningNumber = List.of(1,2,3,4,5,6);
            BonusNumber bonusNumber = new BonusNumber(inputBonusNumber, inputWinningNumber);
            int expected = 7;

            assertEquals(expected, bonusNumber.getBonusNumber());
        }
    }

    @Nested
    @DisplayName("Failure")
    class Failure {

        @Test
        @DisplayName("빈 값 입력 시, 에러 처리")
        void testValidateEmptyInput() {
            String inputBonusNumber = "  ";
            List inputWinningNumber = List.of(1,2,3,4,5,6);

            assertThatThrownBy(() -> new BonusNumber(inputBonusNumber, inputWinningNumber))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ExceptionMessage.NULL_INPUT.getMessage());
        }

        @Test
        @DisplayName("숫자 형식이 아닌 값 입력 시, 에러 처리")
        void testValidateNumberInput() {
            String inputBonusNumber = "one";
            List inputWinningNumber = List.of(1,2,3,4,5,6);

            assertThatThrownBy(() -> new BonusNumber(inputBonusNumber, inputWinningNumber))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ExceptionMessage.INVALID_NUMBER.getMessage());
        }

        @Test
        @DisplayName("로또 번호가 범위를 벗어날 경우 에러 처리 (1 미만)")
        void validateLottoNumbersInRangeUnder1() {
            String inputBonusNumber = "0";
            List inputWinningNumber = List.of(1,2,3,4,5,6);

            assertThatThrownBy(() -> new BonusNumber(inputBonusNumber, inputWinningNumber))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ExceptionMessage.OUT_OF_RANGE.getMessage());
        }

        @Test
        @DisplayName("로또 번호가 범위를 벗어날 경우 에러 처리 (45 초과)")
        void validateLottoNumbersInRangeOver45() {
            String inputBonusNumber = "87";
            List inputWinningNumber = List.of(1,2,3,4,5,6);

            assertThatThrownBy(() -> new BonusNumber(inputBonusNumber, inputWinningNumber))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ExceptionMessage.OUT_OF_RANGE.getMessage());
        }

        @Test
        @DisplayName("로또 번호와 중복된 경우 에러 처리")
        void validateDuplicateWithLottoNumbers() {
            String inputBonusNumber = "3";
            List inputWinningNumber = List.of(1,2,3,4,5,6);

            assertThatThrownBy(() -> new BonusNumber(inputBonusNumber, inputWinningNumber))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ExceptionMessage.BONUS_NUMBER_DUPLICATES.getMessage());
        }
    }
}
