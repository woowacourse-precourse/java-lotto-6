package lotto.services;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.EnumMap;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.WinningLotto;
import lotto.enums.LottoPrize;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class NumberComparatorTest {

    private final WinningLotto winningLotto = new WinningLotto(List.of(1, 2, 3, 4, 5, 6), 7);

    private LottoNumberComparator comparator;

    @BeforeEach
    void init() {
        comparator = new LottoNumberComparator(List.of(), winningLotto);
    }

    @DisplayName("로또 번호 일치 개수 계산 테스트")
    @Test
    void testMatchingNumbers() {
        Lotto purchasedLotto = new Lotto(List.of(1, 2, 3, 43, 44, 45));
        int matchCount = comparator.countMatchingNumbers(purchasedLotto);
        assertThat(matchCount).isEqualTo(3);
    }

    @DisplayName("보너스 번호 일치 여부 확인")
    @Test
    void testBonusNumberMatched() {
        Lotto purchasedLotto = new Lotto(List.of(10, 20, 30, 40, 45, 7));
        assertTrue(comparator.isBonusNumberMatched(purchasedLotto, winningLotto.getBonusNumber()));
    }

    @DisplayName("당첨 등수 판별 테스트")
    @Test
    void testDeterminePrize() {
        List<Lotto> purchasedLottos = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(1, 2, 3, 4, 5, 7)),
                new Lotto(List.of(1, 2, 3, 4, 44, 45))
        );

        LottoPrize firstPrize = comparator.determinePrize(6, false);
        LottoPrize secondPrize = comparator.determinePrize(5, true);
        LottoPrize thirdPrize = comparator.determinePrize(5, false);

        assertEquals(LottoPrize.FIRST, firstPrize);
        assertEquals(LottoPrize.SECOND, secondPrize);
        assertEquals(LottoPrize.THIRD, thirdPrize);
    }

    @DisplayName("로또 등수에 따른 당첨 통계 횟수 확인")
    @Test
    void testUpdatePrizeCount() {
        List<Lotto> purchasedLottos = List.of(new Lotto(List.of(1, 2, 3, 4, 7, 8)));
        LottoPrize prize = comparator.determinePrize(5, true);
        comparator.updatePrizeCount(prize);

        EnumMap<LottoPrize, Integer> prizeCount = comparator.getPrizeCount();
        assertEquals(1, prizeCount.get(LottoPrize.SECOND));
    }

    @DisplayName("로또번호 일치 여부 테스트")
    @Test
    void testPrizeCountByMatchedNumbers() {
        List<Lotto> purchasedLottos = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)), // 1등
                new Lotto(List.of(1, 2, 3, 4, 5, 7)), // 2등
                new Lotto(List.of(1, 2, 3, 4, 44, 45))  // 4등
        );

        comparator = new LottoNumberComparator(purchasedLottos, winningLotto);
        comparator.calculatePrizes();

        EnumMap<LottoPrize, Integer> expectedPrizeCount = new EnumMap<>(LottoPrize.class);
        expectedPrizeCount.put(LottoPrize.FIRST, 1);
        expectedPrizeCount.put(LottoPrize.SECOND, 1);
        expectedPrizeCount.put(LottoPrize.THIRD, 0);
        expectedPrizeCount.put(LottoPrize.FOURTH, 1);
        expectedPrizeCount.put(LottoPrize.FIFTH, 0);

        assertThat(comparator.getPrizeCount()).isEqualTo(expectedPrizeCount);
    }
}