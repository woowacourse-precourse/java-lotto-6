package lotto.vo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BonusNumberTest {

    @DisplayName("BonusNumber는 필드 값을 포장해야 한다.")
    @Test
    public void quantity_value_test() {
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
    public void quantity_equality_test() {
        // when
        BonusNumber bonusNumber1 = new BonusNumber(1);
        BonusNumber bonusNumber2 = new BonusNumber(1);
        BonusNumber bonusNumber3 = new BonusNumber(2);

        // then
        assertEquals(bonusNumber1.hashCode(), bonusNumber2.hashCode());
        assertEquals(bonusNumber1, bonusNumber2);
        assertNotEquals(bonusNumber1, bonusNumber3);
    }
}
