package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.type.LottoPrize;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoResultTest {
    private List<Lotto> purchasedLottos;
    private Lotto winningNumbers;
    private int bonusNumber;
    private LottoResult lottoResult;

    @BeforeEach
    void setUp() {
        purchasedLottos = Arrays.asList(
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7)),
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 8)));
        winningNumbers = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        bonusNumber = 7;

        lottoResult = new LottoResult(purchasedLottos, winningNumbers, bonusNumber);
    }

    @DisplayName("로또 일치 수가 올바른지 테스트한다.")
    @Test
    void testCountMatchingNumbers() {
        assertThat(lottoResult.countMatchingNumbers(purchasedLottos.get(0))).isEqualTo(6);
        assertThat(lottoResult.countMatchingNumbers(purchasedLottos.get(1))).isEqualTo(5);
        assertThat(lottoResult.countMatchingNumbers(purchasedLottos.get(2))).isEqualTo(5);
    }

    @DisplayName("보너스 번호 일치 여부가 올바른지 테스트한다.")
    @Test
    void testIsMatchBonusNumber() {
        assertThat(lottoResult.isMatchBonusNumber(purchasedLottos.get(0))).isFalse();
        assertThat(lottoResult.isMatchBonusNumber(purchasedLottos.get(1))).isTrue();
        assertThat(lottoResult.isMatchBonusNumber(purchasedLottos.get(2))).isFalse();
    }

    @DisplayName("로또 결과가 올바른지 테스트한다.")
    @Test
    void testCalculateResult() {
        assertThat(lottoResult.matchLotto(purchasedLottos.get(0))).isEqualTo(LottoPrize.FIRST);
        assertThat(lottoResult.matchLotto(purchasedLottos.get(1))).isEqualTo(LottoPrize.SECOND);
        assertThat(lottoResult.matchLotto(purchasedLottos.get(2))).isEqualTo(LottoPrize.THIRD);
    }

    @DisplayName("수익률이 올바른지 테스트한다.")
    @Test
    void testCalculateReturnRatio() {
        List<LottoPrize> prizes = Arrays.asList(LottoPrize.NONE, LottoPrize.THIRD, LottoPrize.THIRD);
        int purchaseAmount = 3000;

        double returnRatio = lottoResult.calculateReturnRatio(prizes, purchaseAmount);
        assertThat(returnRatio).isEqualTo(100000.0);
    }
}