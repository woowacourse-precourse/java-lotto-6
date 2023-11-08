package lotto.domain;

import lotto.domain.BonusNumber;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BonusNumberTest {

    @Test
    void testGetBonusNumber() {
        int bonusNumberValue = 7;
        BonusNumber bonusNumber = new BonusNumber(bonusNumberValue);
        assertEquals(bonusNumberValue, bonusNumber.getBonusNumber());
    }
}
