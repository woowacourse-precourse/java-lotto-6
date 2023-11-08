package lotto.vo;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BonusNumberTest {

    @DisplayName("유효한 값으로 BonusNumber를 생성할 경우 예외가 발생하지 않는다.")
    @Test
    void valid_bonusNumber_init_test() {
        // when
        Integer validNumber = 10;

        // then
        assertDoesNotThrow(() -> new BonusNumber(validNumber));
    }

    @DisplayName("로또 번호 범위가 아닌 번호로 BonusNumber를 생성할 경우 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {0, 46})
    void invalid_number_not_between_lotto_number_test(Integer invalidNumber) {
        // then
        assertThrows(IllegalArgumentException.class, () -> new BonusNumber(invalidNumber));
    }

    @DisplayName("BonusNumber는 필드 값을 포장해야 한다.")
    @Test
    void number_value_test() {
        // given
        Integer number = 5;

        // when
        BonusNumber bonusNumber = new BonusNumber(number);
        Integer result = bonusNumber.number();

        // then
        assertEquals(result, number);
    }

    @DisplayName("두 BonusNumber의 필드 값이 동일하면 두 레코드는 동일해야 한다.")
    @Test
    void number_equality_test() {
        // when
        BonusNumber bonusNumber1 = new BonusNumber(1);
        BonusNumber bonusNumber2 = new BonusNumber(1);
        BonusNumber bonusNumber3 = new BonusNumber(2);

        // then
        assertEquals(bonusNumber1.hashCode(), bonusNumber2.hashCode());
        assertEquals(bonusNumber1, bonusNumber2);
        assertNotEquals(bonusNumber1.hashCode(), bonusNumber3.hashCode());
        assertNotEquals(bonusNumber1, bonusNumber3);
    }
}
