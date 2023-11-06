package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class WinningTierTest {

    @DisplayName("당첨 내역을 정립할 때 6개를 맞춘 1등이 두 명, 5개와 보너스 번호를 맞춘 2등이 한 명일 때 당첨 내역이 검증한다.")
    @Test
    void 당첨_내역을_정립할_때_맞춘_갯수에_따라_등수가_정립되는지_검증() {
        List<Long> userCorrectWinningsCount = new ArrayList<>();
        List<Boolean> userCorrectBonuses = new ArrayList<>();

        userCorrectWinningsCount.add(6L);
        userCorrectBonuses.add(false);

        userCorrectWinningsCount.add(5L);
        userCorrectBonuses.add(true);

        userCorrectWinningsCount.add(6L);
        userCorrectBonuses.add(false);

        WinningTier.estimate(userCorrectWinningsCount, userCorrectBonuses);
        HashMap<Integer, Integer> winningTier = WinningTier.getWinningTier();

        Assertions.assertThat(winningTier.get(1)).isEqualTo(2);
        Assertions.assertThat(winningTier.get(2)).isEqualTo(1);
    }
}
