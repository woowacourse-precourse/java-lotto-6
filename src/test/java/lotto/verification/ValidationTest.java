package lotto.verification;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidationTest {

    @DisplayName("구입 금액이 최소 1000원 이상이 아니거나, 1000원 단위가 아니면 예외가 발생한다.")
    @Test
    void verifyRangeInputMoney() {
        //given
        final long case1 = 100;
        final long case2 = 2300;
        final long case3 = 3000;

        //when & then
        assertThrows(IllegalArgumentException.class, () -> {
            Validation.verifyRangeInputMoney(case1);
        });

        //when & then
        assertThrows(IllegalArgumentException.class, () -> {
            Validation.verifyRangeInputMoney(case2);
        });

        //when & then
        assertDoesNotThrow(() -> {
            Validation.verifyRangeInputMoney(case3);
        });
    }

    @Test
    void verifyIntegerWinningLottoNumber() {
    }

    @Test
    void verifyRangeWinningLottoNumber() {
    }

    @Test
    void verifyStringToInteger() {
    }
}