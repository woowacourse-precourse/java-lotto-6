package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.EnumMap;
import java.util.List;
import lotto.domain.Lotto;
import lotto.enums.LottoPrize;
import lotto.services.LottoNumberComparator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class NumberComparatorTest {

    @DisplayName("로또 번호 일치 개수 확인")
    @Test
    void checkMatchingNumbers() {
        Lotto purchasedLotto = new Lotto(List.of(4, 7, 18, 19, 35, 42));
        Lotto winningLotto = new Lotto(List.of(4, 10, 19, 26, 35, 38));
        int bonusNumber = 1;
        LottoNumberComparator numberComparator = new LottoNumberComparator(List.of(purchasedLotto), winningLotto,
                bonusNumber);
        int matchCount = numberComparator.calculateMatchingNumbers(purchasedLotto);

        assertThat(matchCount).isEqualTo(3);
    }

    @DisplayName("로또 번호 일치한 개수 별로 등수 횟수 확인하는 테스트")
    @Test
    void prizeCountByMatchedNumbers() {
        // 당첨 로또 번호와 구매한 로또 목록 생성
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        List<Lotto> purchasedLottos = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)), // 1등
                new Lotto(List.of(1, 2, 3, 4, 5, 7)), // 2등
                new Lotto(List.of(1, 2, 3, 4, 44, 45))  // 4등
        );
        int bonusNumber = 7;
        LottoNumberComparator comparator = new LottoNumberComparator(purchasedLottos, winningLotto, bonusNumber);

        EnumMap<LottoPrize, Integer> expectedPrizeCount = new EnumMap<>(LottoPrize.class);
        expectedPrizeCount.put(LottoPrize.FIRST, 1);
        expectedPrizeCount.put(LottoPrize.SECOND, 1);
        expectedPrizeCount.put(LottoPrize.THIRD, 0);
        expectedPrizeCount.put(LottoPrize.FOURTH, 1);
        expectedPrizeCount.put(LottoPrize.FIFTH, 0);

        assertThat(comparator.getPrizeCount()).isEqualTo(expectedPrizeCount);
    }
}
