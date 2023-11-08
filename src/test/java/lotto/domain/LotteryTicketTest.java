package lotto.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;

class LotteryTicketTest {
    @Test
    void 랜덤값_테스트() {
        // Arrange
        int startNum = 1;
        int finishNum = 45;
        int chooseNum = 6;

        List<Integer> lotteryNumbers = LotteryTicket.RandomLottoNum();

        assertNotNull(lotteryNumbers);
        assertEquals(chooseNum, lotteryNumbers.size());

        for (int number : lotteryNumbers) {
            assertTrue(number >= startNum && number <= finishNum);
        }

        long distinctCount = lotteryNumbers.stream().distinct().count();
        assertEquals(chooseNum, distinctCount);
    }
}