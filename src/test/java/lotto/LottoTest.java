package lotto;

import lotto.domain.ExceptionMessage;
import lotto.domain.Lotto;
import lotto.domain.PurchaseAmount;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

class LottoTest {
    @Nested
    @DisplayName("Success")
    class Success {
        @DisplayName("띄어쓰기가 포함된 로또 당첨 번호")
        @Test
        public void testLottoNumbersWithSpace() {
            String input = "1, 2, 3,4,5,6";
            Lotto lotto = new Lotto(input);
            List expected = List.of(1,2,3,4,5,6);

            assertEquals(expected, lotto.getNumbers());
        }
    }

    @Nested
    @DisplayName("Failure")
    class Failure {
        @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
        @Test
        void createLottoByOverSize() {
            assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
        @Test
        void createLottoByDuplicatedNumber() {
            assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        @DisplayName("빈 값 입력 시, 에러 처리")
        void testValidateEmptyInput() {
            String input = "1,2,,4,5,6";

            assertThatThrownBy(() -> new Lotto(input))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ExceptionMessage.NULL_INPUT.getMessage());
        }

        @Test
        @DisplayName("숫자 형식이 아닌 값 입력 시, 에러 처리")
        void testValidateNumericInput() {
            String input = "a,2,3,4,e,6";

            assertThatThrownBy(() -> new PurchaseAmount(input))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ExceptionMessage.INVALID_NUMBER.getMessage());
        }

        @Test
        @DisplayName("로또 번호의 개수가 6개 미만일 경우 에러 처리")
        void validateLottoSizeUnderSix() {
            assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5)))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ExceptionMessage.INVALID_LOTTO_WINNING_SIZE.getMessage());
        }

        @Test
        @DisplayName("로또 번호의 개수가 6개 초과일 경우 에러 처리")
        void validateLottoSizeOverSix() {
            assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ExceptionMessage.INVALID_LOTTO_WINNING_SIZE.getMessage());
        }

        @Test
        @DisplayName("로또 번호가 범위를 벗어날 경우 에러 처리 (1 미만)")
        void validateLottoNumbersInRangeUnder1() {
            assertThatThrownBy(() -> new Lotto(List.of(0, 2, 3, 4, 5, 6)))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ExceptionMessage.OUT_OF_RANGE.getMessage());
        }

        @Test
        @DisplayName("로또 번호가 범위를 벗어날 경우 에러 처리 (45 초과)")
        void validateLottoNumbersInRangeOver45() {
            assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 67)))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ExceptionMessage.OUT_OF_RANGE.getMessage());
        }

        @Test
        @DisplayName("로또 번호가 중복된 경우 에러 처리")
        void validateDuplicateLottoNumbers() {
            assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 3, 4, 5)))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ExceptionMessage.LOTTO_NUMBER_DUPLICATES.getMessage());
        }
    }
}