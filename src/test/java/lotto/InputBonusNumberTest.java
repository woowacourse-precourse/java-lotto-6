package lotto;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BonusNumberTest {

    @Test
    void 보너스번호는_1부터_45까지만_구성되어야_합니다() {
        String inputNumber = "77";
        assertThrows(IllegalArgumentException.class,
            () -> new BonusNumber(inputNumber));
    }

}