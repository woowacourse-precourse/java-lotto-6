package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LottoWinningRecordTest {
    @DisplayName("당첨 통계가 잘 작동한다")
    @Test
    void testCalculateAndPrintStatistic() {
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;

        List<List<Integer>> ticketList = new ArrayList<>();
        List<Integer> row1 = List.of(1, 2, 3, 10, 11, 12);
        List<Integer> row2 = List.of(7, 5, 4, 3, 2, 1);
        ticketList.add(row1);
        ticketList.add(row2);

        int purchaseAmount = 2000;
        LottoWinningRecord lottoWinningRecord = new LottoWinningRecord(winningNumbers, bonusNumber);
        int[] prizes = new int[5];
        int totalPrize = 0;

        for (List<Integer> ticket : ticketList) {
            int prize = lottoWinningRecord.calculatePrize(ticket);

            if (prize > 0) {
                totalPrize += prize;
                if (prize == 5000) {
                    prizes[0]++;
                } else if (prize == 50000) {
                    prizes[1]++;
                } else if (prize == 1500000) {
                    prizes[2]++;
                } else if (prize == 30000000) {
                    prizes[3]++;
                } else if (prize == 2000000000) {
                    prizes[4]++;
                }
            }
        }

        assertArrayEquals(new int[]{1, 0, 0, 1, 0}, prizes);

        double expectedProfitRate = (double) totalPrize / purchaseAmount * 100;
        double roundedProfitRate = Math.round(expectedProfitRate * 100.0) / 100.0;

        assertEquals(roundedProfitRate, 1500250);
    }

}
