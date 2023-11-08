package lotto;

import lotto.validation.Validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ValidatorTest {
    @DisplayName("1~45 범위의 숫자 배열 검증")
    @Test
    void check_lotto_number_array_range() {
        int[] numbers = new int[]{0,1,2,3,4,5};
        final IllegalArgumentException exception =
                assertThrows(IllegalArgumentException.class, () -> Validator.checkLottoNumberArrayRange(numbers));
        assertThat(exception.getMessage()).isEqualTo("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
    }

    @DisplayName("가격 단위 검증")
    @Test
    void check_input_price_unit_validation() {
        int price = 1500;
        final IllegalArgumentException exception =
                assertThrows(IllegalArgumentException.class, () -> Validator.checkInputPriceUnitValidation(price));
        assertThat(exception.getMessage()).isEqualTo("[ERROR] 1,000원 단위의 금액만 입력 가능합니다.");
    }

    @DisplayName("당첨 번호 중복 검증")
    @Test
    void check_duplicate_winning_number() {
        int[] numbers = new int[]{1,1,2,3,4,5};
        final IllegalArgumentException exception =
                assertThrows(IllegalArgumentException.class, () -> Validator.checkDuplicateWinningNumber(numbers));
        assertThat(exception.getMessage()).isEqualTo("[ERROR] 당첨 번호는 서로 중복되지 않아야 합니다.");
    }

    @DisplayName("당첨 번호 개수 많을 시 예외처리")
    @Test
    void check_winning_number_count_over() {
        int[] numbers = new int[]{1,2,3,4,5,6,7};
        final IllegalArgumentException exception =
                assertThrows(IllegalArgumentException.class, () -> Validator.checkWinningNumberCount(numbers));
        assertThat(exception.getMessage()).isEqualTo("[ERROR] 당첨 번호는 6개의 숫자여야 합니다.");
    }

    @DisplayName("당첨 번호 개수 적을 시 예외처리")
    @Test
    void check_winning_number_count_under() {
        int[] numbers = new int[]{1,2,3,4,5};
        final IllegalArgumentException exception =
                assertThrows(IllegalArgumentException.class, () -> Validator.checkWinningNumberCount(numbers));
        assertThat(exception.getMessage()).isEqualTo("[ERROR] 당첨 번호는 6개의 숫자여야 합니다.");
    }

    @DisplayName("보너스 번호 중복 검증")
    @Test
    void check_bonus_number_duplicate() {
        int[] winningNumber = new int[]{1,2,3,4,5,6};
        int bonusNumber = 5;
        final IllegalArgumentException exception =
                assertThrows(IllegalArgumentException.class, () -> Validator.checkDuplicateBonusNumber(bonusNumber ,winningNumber));
        assertThat(exception.getMessage()).isEqualTo("[ERROR] 이미 당첨번호로 설정한 번호는 보너스 번호가 될 수 없습니다.");
    }
}