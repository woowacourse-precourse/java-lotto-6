package lotto.service;

import static org.junit.jupiter.api.Assertions.*;

import lotto.model.Bonus;
import lotto.model.WinningNumber;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BonusNumberServiceTest {

    BonusNumberService bonusNumberService;

    @BeforeEach
    void setUp() {
        bonusNumberService = new BonusNumberService();
    }

    @Test
    void 옳은_값이_들어오지_않으면_null을_반환한다() {
        WinningNumber winningNumber = new WinningNumber("1,2,3,4,5,6");

        Bonus bonus = bonusNumberService.getBonusNumberIfValid(winningNumber, "7");
        assertEquals(bonus.getNumber(), 7);
    }

}