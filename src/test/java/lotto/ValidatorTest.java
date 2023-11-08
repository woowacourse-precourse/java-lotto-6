package lotto;

import lotto.util.Validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ValidatorTest {
    @DisplayName("1~45 범위의 숫자 배열 검증")
    @Test
    void check_lotto_number_array_range() {
        int[] numbers = new int[]{0,1,2,3,4,5};
        for(var number : numbers) {
            final IllegalArgumentException exception =
                    assertThrows(IllegalArgumentException.class, () -> Validator.checkRange(number));
            assertThat(exception.getMessage()).isEqualTo("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    @DisplayName("가격 단위 검증")
    @Test
    void check_input_price_unit_validation() {
        int price = 1500;
        final IllegalArgumentException exception =
                assertThrows(IllegalArgumentException.class, () -> Validator.checkDivisibleByMoneyUnit(price));
        assertThat(exception.getMessage()).isEqualTo("[ERROR] 1,000원 단위의 금액만 입력 가능합니다.");
    }

}