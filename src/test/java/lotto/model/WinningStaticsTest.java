package lotto.model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class WinningStaticsTest {

    private List<List<Integer>> lottoNumbers;
    private String winningNumber;
    private String bonusNumber;
    private WinningStatistics winningStatistics;

    @Test
    void 당첨_통계_1등_2등_3등_4등_5등() {
        lottoNumbers = new ArrayList<>();
        lottoNumbers.add(Arrays.asList(1,2,3,7,8,9)); // 5등
        lottoNumbers.add(Arrays.asList(1,2,3,4,8,9)); // 4등
        lottoNumbers.add(Arrays.asList(1,2,3,4,5,9)); // 3등
        lottoNumbers.add(Arrays.asList(1,2,3,4,5,7)); // 2등
        lottoNumbers.add(Arrays.asList(1,2,3,4,5,6)); // 1등

        winningNumber = "1,2,3,4,5,6";
        bonusNumber = "7";
        winningStatistics = new WinningStatistics(lottoNumbers,winningNumber, bonusNumber);

        assertThat(winningStatistics.calculate()).containsExactly(1,1,1,1,1);
    }

    @Test
    void 당첨_통계_1등() {
        lottoNumbers = new ArrayList<>();
        lottoNumbers.add(Arrays.asList(1,2,3,4,5,6)); // 1등
        lottoNumbers.add(Arrays.asList(1,2,3,4,5,6)); // 1등
        lottoNumbers.add(Arrays.asList(1,2,3,4,5,6)); // 1등
        lottoNumbers.add(Arrays.asList(1,2,3,4,5,6)); // 1등
        lottoNumbers.add(Arrays.asList(1,2,3,4,5,6)); // 1등

        winningNumber = "1,2,3,4,5,6";
        bonusNumber = "7";
        winningStatistics = new WinningStatistics(lottoNumbers,winningNumber, bonusNumber);

        assertThat(winningStatistics.calculate()).containsExactly(0,0,0,0,5);
    }

    @Test
    void 당첨_통계_2등() {
        lottoNumbers = new ArrayList<>();
        lottoNumbers.add(Arrays.asList(1,2,3,4,5,7)); // 2등
        lottoNumbers.add(Arrays.asList(1,2,3,4,5,7)); // 2등
        lottoNumbers.add(Arrays.asList(1,2,3,4,5,7)); // 2등
        lottoNumbers.add(Arrays.asList(1,2,3,4,5,7)); // 2등
        lottoNumbers.add(Arrays.asList(1,2,3,4,5,7)); // 2등

        winningNumber = "1,2,3,4,5,6";
        bonusNumber = "7";
        winningStatistics = new WinningStatistics(lottoNumbers,winningNumber, bonusNumber);

        assertThat(winningStatistics.calculate()).containsExactly(0,0,0,5,0);
    }

    @Test
    void 당첨_통계_3등_2명_5등_3명() {
        lottoNumbers = new ArrayList<>();
        lottoNumbers.add(Arrays.asList(1,2,3,4,5,7)); // 2등
        lottoNumbers.add(Arrays.asList(1,2,3,4,5,7)); // 2등
        lottoNumbers.add(Arrays.asList(1,2,3,8,9,10)); // 5등
        lottoNumbers.add(Arrays.asList(1,2,3,8,9,10)); // 5등
        lottoNumbers.add(Arrays.asList(1,2,3,8,9,10)); // 5등

        winningNumber = "1,2,3,4,5,6";
        bonusNumber = "7";
        winningStatistics = new WinningStatistics(lottoNumbers,winningNumber, bonusNumber);

        assertThat(winningStatistics.calculate()).containsExactly(3,0,0,2,0);
    }
}
