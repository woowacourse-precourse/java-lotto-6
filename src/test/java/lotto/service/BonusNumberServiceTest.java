package lotto.service;

import static org.junit.jupiter.api.Assertions.*;

import lotto.model.Bonus;
import lotto.model.WinningNumber;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class BonusNumberServiceTest {

    BonusNumberService bonusNumberService = new BonusNumberService();
    WinningNumber winningNumber = new WinningNumber("1,2,3,4,5,6");

    @Test
    void 옳은_값이_들어오면_Bonus를_생성한다() {
        Bonus bonus = bonusNumberService.getBonusNumberIfValid(winningNumber, "7");
        assertEquals(bonus.getNumber(), 7);
        assertNotEquals(bonus, null);
    }

    @ParameterizedTest
    @CsvSource(value = {
        "5",
        "48",
        "sdf"
    })
    void 옳은_값이_들어오지_않으면_Bonus를_생성하지_않는다(String bonusNumber) {
        Bonus bonus = bonusNumberService.getBonusNumberIfValid(winningNumber, bonusNumber);
        assertNull(bonus);
    }

}