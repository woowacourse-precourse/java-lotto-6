package lotto.domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class LottoMatcherTest {

    private final WinningNumbers winningNumbers = new WinningNumbers(Arrays.asList(1, 2, 3, 4, 5, 6), 7);
    private final LottoMatcher lottoMatcher = new LottoMatcher(winningNumbers);

    @Test
    @DisplayName("매칭된 번호 수를 계산하여 반환")
    public void testCountMatchesForLotto() {
        Lotto lotto1 = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lotto lotto2 = new Lotto(Arrays.asList(1, 2, 3, 7, 8, 9));
        Lotto lotto3 = new Lotto(Arrays.asList(10, 11, 12, 13, 14, 15));

        assertAll(() -> {
            assertThat(lottoMatcher.countMatchesForLotto(lotto1)).isEqualTo(6);
            assertThat(lottoMatcher.countMatchesForLotto(lotto2)).isEqualTo(3);
            assertThat(lottoMatcher.countMatchesForLotto(lotto3)).isEqualTo(0);
        });
    }

    @Test
    @DisplayName("보너스 번호 매칭 확인")
    public void testHasMatchingBonusNumber() {
        Lotto lottoWithBonus = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7));
        Lotto lottoWithoutBonus = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 8));

        assertAll(() -> {
            assertThat(lottoMatcher.hasMatchingBonusNumber(lottoWithBonus)).isTrue();
            assertThat(lottoMatcher.hasMatchingBonusNumber(lottoWithoutBonus)).isFalse();
        });
    }
}
