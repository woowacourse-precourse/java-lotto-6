package lotto.domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import lotto.constant.Rank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class LottoMatcherTest {

    private final WinningNumbers winningNumbers = new WinningNumbers(Arrays.asList(1, 2, 3, 4, 5, 6), 7);
    private final LottoMatcher lottoMatcher = new LottoMatcher(winningNumbers);

    @Test
    @DisplayName("매칭된 번호 수를 계산하여 등수를 반환")
    public void testMatchForLotto() {
        Lotto lotto1 = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lotto lotto2 = new Lotto(Arrays.asList(1, 2, 3, 7, 8, 9));
        Lotto lotto3 = new Lotto(Arrays.asList(10, 11, 12, 13, 14, 15));

        assertAll(() -> {
            assertThat(lottoMatcher.match(lotto1)).isEqualTo(Rank.FIRST);
            assertThat(lottoMatcher.match(lotto2)).isEqualTo(Rank.THIRD);
            assertThat(lottoMatcher.match(lotto3)).isEqualTo(Rank.NONE);
        });
    }

    @Test
    @DisplayName("매칭된 번호 수와 보너스 번호를 통해 등수를 반환")
    public void testMatchWithBonusNumber() {
        Lotto lottoWithBonus = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7));
        Lotto lottoWithoutBonus = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 8));

        assertAll(() -> {
            assertThat(lottoMatcher.match(lottoWithBonus)).isEqualTo(Rank.SECOND);
            assertThat(lottoMatcher.match(lottoWithoutBonus)).isEqualTo(Rank.THIRD);
        });
    }
}
