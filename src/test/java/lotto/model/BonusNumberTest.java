package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BonusNumberTest {

    @Test
    @DisplayName("BonusNumber 객체 생성")
    void bonusNumber() {
        // given
        Integer bonusNumber = 1;
        // when
        BonusNumber bonusNumber1 = new BonusNumber(bonusNumber);
        // then
        assertNotNull(bonusNumber1);
    }
}