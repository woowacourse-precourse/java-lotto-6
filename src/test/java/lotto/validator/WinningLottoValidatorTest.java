package lotto.validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.WinningLotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class WinningLottoValidatorTest {
    @Nested
    @DisplayName("validateWinningNumber 메소드 test")
    class validateInputWinningNumber {
        @DisplayName("당첨 번호가 숫자와 '" + WinningLottoValidator.DELIMITER + "'만으로 이루어져 있으면 검증 성공")
        @Test
        void Winning_number_is_matched_winning_numbers_regex() {
            // given
            String input1 = "1,2,3,4,5,6";
            String input2 = "100,200,300,400,500,600";

            // when
            // then
            WinningLottoValidator.inputValidate(input1);
            WinningLottoValidator.inputValidate(input2);
        }

        @DisplayName("당첨 번호가 입력되지 않은 경우 예외 발생")
        @Test
        void Purchase_amount_is_empty() {
            // given
            String input = "";

            // when
            // then
            assertThatThrownBy(() -> WinningLottoValidator.inputValidate(input)).isInstanceOf(
                    IllegalArgumentException.class).hasMessage(InputValidator.ENTER_VALUE_MESSAGE);
        }

        @DisplayName("당첨 번호에 숫자 이외에 문자가 들어있다면 예외 발생")
        @Test
        void Winning_numbers_contain_characters_except_numbers() {
            // given
            String input = "A,1,2,3,4,5";

            // when
            // then
            assertThatThrownBy(() -> WinningLottoValidator.inputValidate(input)).isInstanceOf(
                            IllegalArgumentException.class)
                    .hasMessage(WinningLottoValidator.ENTER_NUMBERS_AND_DELIMITERS_ONLY_MESSAGE);
        }

        @DisplayName("당첨 번호가 구분자가 '" + WinningLottoValidator.DELIMITER + "' 가 아닐 때 예외 발생")
        @Test
        void test() {
            // given
            String input = "1.2.3.4.5.6";

            // when
            // then
            assertThatThrownBy(() -> WinningLottoValidator.inputValidate(input)).isInstanceOf(
                            IllegalArgumentException.class)
                    .hasMessage(WinningLottoValidator.ENTER_NUMBERS_AND_DELIMITERS_ONLY_MESSAGE);
        }
    }

    @Nested
    @DisplayName("validateLottoSize 메소드 test")
    class ValidateLottoSize {
        @DisplayName("숫자 개수가 " + Lotto.SIZE + "와 일치하면 검증 통과")
        @Test
        void Match_lotto_size() {
            // given
            List<Integer> numbers1 = List.of(1, 2, 3, 4, 5, 6);
            List<Integer> numbers2 = List.of(10, 20, 30, 40, 44, 45);

            // when
            // then
            WinningLotto winningLotto1 = new WinningLotto(numbers1);
            WinningLotto winningLotto2 = new WinningLotto(numbers2);
        }

        @DisplayName("숫자 개수가 " + Lotto.SIZE + "와 일치하지 않으면 예외 발생")
        @Test
        void Unmatch_lotto_size() {
            // given
            List<Integer> numbers1 = List.of(1, 2, 3, 4, 5);
            List<Integer> numbers2 = List.of(1, 2, 3, 4, 5, 6, 7);

            // when
            // then
            assertThatThrownBy(() -> new WinningLotto(numbers1)).isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(LottoValidator.INVALID_LOTTO_SIZE_MESSAGE);
            assertThatThrownBy(() -> new WinningLotto(numbers2)).isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(LottoValidator.INVALID_LOTTO_SIZE_MESSAGE);
        }
    }

    @Nested
    @DisplayName("validateNumbersInLottoRange 메소드 test")
    class ValidateNumbersInLottoRange {
        @DisplayName("번호가 " + Lotto.MIN_LOTTO_NUMBER + " ~ " + Lotto.MAX_LOTTO_NUMBER + " 범위에 있으면 검증 통과")
        @Test
        void Numbers_in_range_lotto_range() {

            // given
            List<Integer> numbers = List.of(1, 20, 25, 30, 40, 45);

            // when
            // then
            WinningLotto winningLotto = new WinningLotto(numbers);
        }

        @DisplayName("번호가 " + Lotto.MIN_LOTTO_NUMBER + " ~ " + Lotto.MAX_LOTTO_NUMBER + " 범위를 벗어나면 예외 발생")
        @Test
        void Numbers_out_of_range_lotto_range() {
            // given
            List<Integer> numbers1 = List.of(-1, -2, -3, 1, 2, 3);
            List<Integer> numbers2 = List.of(43, 44, 45, 46, 47, 48);

            // when
            // then
            assertThatThrownBy(() -> new WinningLotto(numbers1)).isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(WinningLottoValidator.INVALID_LOTTO_NUMBER_RANGE_MESSAGE);
            assertThatThrownBy(() -> new WinningLotto(numbers2)).isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(WinningLottoValidator.INVALID_LOTTO_NUMBER_RANGE_MESSAGE);
        }
    }

    @Nested
    @DisplayName("validateDuplicateNumbers 메소드 test")
    class ValidateDuplicateNumbers {
        @DisplayName("숫자가 중복되지 않으면 검증 통과")
        @Test
        void Has_unique_numbers() {
            // given
            List<Integer> numbers1 = List.of(1, 2, 3, 4, 5, 6);
            List<Integer> numbers2 = List.of(45, 44, 43, 42, 41, 40);

            // when
            // then
            WinningLotto winningLotto1 = new WinningLotto(numbers1);
            WinningLotto winningLotto2 = new WinningLotto(numbers2);
        }

        @DisplayName("중복된 숫자가 존재하면 예외 발생")
        @Test
        void Has_duplicate_numbers() {
            // given
            List<Integer> numbers1 = List.of(1, 1, 2, 3, 4, 5);
            List<Integer> numbers2 = List.of(11, 11, 11, 11, 11, 11);

            // when
            // then
            assertThatThrownBy(() -> new WinningLotto(numbers1)).isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(LottoValidator.DUPLICATE_NUMBERS_MESSAGE);
            assertThatThrownBy(() -> new WinningLotto(numbers2)).isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(LottoValidator.DUPLICATE_NUMBERS_MESSAGE);
        }
    }
}