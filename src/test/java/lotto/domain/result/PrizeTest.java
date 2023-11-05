package lotto.domain.result;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PrizeTest {

    @DisplayName("getFormattedPrizeMoney가 주어진 패턴대로 변형된 문자열을 반환하는지 확인한다.")
    @Test
    public void getFormattedPrizeMoneyTest() {
        // When
        String validPrizeMoney = Prize.FIRST_PRIZE.getFormattedPrizeMoney();
        String invalidPrizeMoney = Prize.SECOND_PRIZE.getFormattedPrizeMoney();

        // Then
        assertEquals("(2,000,000,000원)", validPrizeMoney);
        assertNotEquals("(2,000,000,000원)", invalidPrizeMoney);
    }
}