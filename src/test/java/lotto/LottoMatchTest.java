package lotto;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.constants.IntegerConstants;
import lotto.domain.LottoBonus;
import lotto.domain.LottoMatch;
import lotto.domain.LottoMatchType;
import lotto.domain.LottoPurchase;
import lotto.domain.LottoWinning;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoMatchTest {
    @DisplayName("getMatchCount 가 올바른 값을 반환하는지 확인한다")
    @Test
    void test_getMatchCount() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    var lottoPurchase = new LottoPurchase(8 * IntegerConstants.LOTTO_PRICE);

                    var lottoWinning1 = new LottoWinning(List.of(1, 2, 3, 4, 5, 6));
                    var lottoBonus1 = new LottoBonus(lottoWinning1, 7);
                    var lottoMatch1 = new LottoMatch(lottoPurchase, lottoWinning1, lottoBonus1);
                    assertThat(lottoMatch1.getMatchCount(LottoMatchType.MATCH_SIX)).isEqualTo(8);

                    var lottoWinning2 = new LottoWinning(List.of(1, 2, 3, 4, 5, 8));
                    var lottoBonus2 = new LottoBonus(lottoWinning2, 6);
                    var lottoMatch2 = new LottoMatch(lottoPurchase, lottoWinning2, lottoBonus2);
                    assertThat(lottoMatch2.getMatchCount(LottoMatchType.MATCH_FIVE_BONUS)).isEqualTo(8);

                    var lottoWinning3 = new LottoWinning(List.of(1, 2, 3, 4, 5, 8));
                    var lottoBonus3 = new LottoBonus(lottoWinning3, 9);
                    var lottoMatch3 = new LottoMatch(lottoPurchase, lottoWinning3, lottoBonus3);
                    assertThat(lottoMatch3.getMatchCount(LottoMatchType.MATCH_FIVE)).isEqualTo(8);

                    var lottoWinning4 = new LottoWinning(List.of(1, 2, 3, 4, 7, 8));
                    var lottoBonus4 = new LottoBonus(lottoWinning4, 9);
                    var lottoMatch4 = new LottoMatch(lottoPurchase, lottoWinning4, lottoBonus4);
                    assertThat(lottoMatch4.getMatchCount(LottoMatchType.MATCH_FOUR)).isEqualTo(8);

                    var lottoWinning5 = new LottoWinning(List.of(1, 2, 3, 7, 8, 9));
                    var lottoBonus5 = new LottoBonus(lottoWinning5, 10);
                    var lottoMatch5 = new LottoMatch(lottoPurchase, lottoWinning5, lottoBonus5);
                    assertThat(lottoMatch5.getMatchCount(LottoMatchType.MATCH_THREE)).isEqualTo(8);

                    var lottoWinning6 = new LottoWinning(List.of(1, 2, 10, 7, 8, 9));
                    var lottoBonus6 = new LottoBonus(lottoWinning6, 11);
                    var lottoMatch6 = new LottoMatch(lottoPurchase, lottoWinning6, lottoBonus6);
                    assertThat(lottoMatch6.getMatchCount(LottoMatchType.MATCH_NONE)).isEqualTo(8);
                },
                List.of(1, 2, 3, 4, 5, 6),
                List.of(1, 2, 3, 4, 5, 6),
                List.of(1, 2, 3, 4, 5, 6),
                List.of(1, 2, 3, 4, 5, 6),
                List.of(1, 2, 3, 4, 5, 6),
                List.of(1, 2, 3, 4, 5, 6),
                List.of(1, 2, 3, 4, 5, 6),
                List.of(1, 2, 3, 4, 5, 6)
        );
    }
}
