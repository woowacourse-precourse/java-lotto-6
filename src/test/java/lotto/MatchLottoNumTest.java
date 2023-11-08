package lotto;


import static org.assertj.core.api.Assertions.assertThat;

import domain.MatchLottoNum;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;


public class MatchLottoNumTest {

    @Test
    void testCalculateEarnings() {
        MatchLottoNum matchLottoNum = new MatchLottoNum();

        List<List<Integer>> ticketList = Arrays.asList(
                Arrays.asList(1, 2, 3, 4, 5, 6),
                Arrays.asList(1, 2, 3, 4, 5, 7),
                Arrays.asList(1, 2, 3, 4, 7, 8)
        );

        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;

        int[] matchCounts = matchLottoNum.prizeCount(ticketList, winningNumbers, bonusNumber);
        assertThat(matchCounts[0]).isEqualTo(0); // 3개 일치
        assertThat(matchCounts[1]).isEqualTo(1); // 4개 일치
        assertThat(matchCounts[2]).isEqualTo(0); // 5개 일치 (without bonus)
        assertThat(matchCounts[3]).isEqualTo(2); // 5개 일치 + 보너스
        assertThat(matchCounts[4]).isEqualTo(0); // 6개 일치
    }
}
