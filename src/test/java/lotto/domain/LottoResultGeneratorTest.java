package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoResultGeneratorTest {
    WinningNumbers winningNumbers;
    BonusNumber bonusNumber;
    WinningLotto winningLotto;
    LottoPurchaseAmount purchaseAmount = LottoPurchaseAmount.create("10000");

    @DisplayName("당첨번호에 보너스넘버가 중복되지 않으면 정상 처리된다.")
    @Test
    void create() {
        // given
        winningNumbers = WinningNumbers.create("1,2,3,4,5,6");
        bonusNumber = BonusNumber.create("7");
        winningLotto = WinningLotto.create(winningNumbers, bonusNumber);

        // when
        LottoResultGenerator lottoResultGenerator = LottoResultGenerator.create(winningLotto, purchaseAmount);

        // then
        assertThat(lottoResultGenerator).isNotNull();
    }

    @DisplayName("당첨번호와 보너스넘버가 중복되면 예외 발생한다.")
    @Test
    void cannotCreate_duplicate() {
        // given
        winningNumbers = WinningNumbers.create("1,2,3,4,5,6");
        bonusNumber = BonusNumber.create("1");

        // when, then
        assertThatThrownBy(() -> WinningLotto.create(winningNumbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("랭킹을 계산한다.")
    @Test
    void generatePrizeResult() {
        // given
        List<Integer> numbers1 = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> numbers2 = Arrays.asList(1, 2, 3, 4, 5, 7);
        List<Integer> numbers3 = Arrays.asList(1, 2, 3, 5, 7, 8);

        winningNumbers = WinningNumbers.create("1,2,3,4,5,6");
        bonusNumber = BonusNumber.create("7");
        winningLotto = WinningLotto.create(winningNumbers, bonusNumber);
        LottoResultGenerator lottoResultGenerator = LottoResultGenerator.create(winningLotto, purchaseAmount);
        List<Lotto> lottos = new ArrayList<>(List.of(new Lotto(numbers1), new Lotto(numbers2), new Lotto(numbers3)));

        // when, then
        Map<PrizeCondition, Long> prizeResult = lottoResultGenerator.generatePrizeResult(Lottos.create(lottos));
        assertThat(prizeResult.getOrDefault(PrizeCondition.FIRST, 0L)).isEqualTo(1);  //FIRST : 1
        assertThat(prizeResult.getOrDefault(PrizeCondition.SECOND, 0L)).isEqualTo(1);  //SECOND : 1
        assertThat(prizeResult.getOrDefault(PrizeCondition.THIRD, 0L)).isEqualTo(0);  //THIRD : 0
        assertThat(prizeResult.getOrDefault(PrizeCondition.FOURTH, 0L)).isEqualTo(1);  //FOURTH : 1
        assertThat(prizeResult.getOrDefault(PrizeCondition.FIFTH, 0L)).isEqualTo(0);  //FIFTH : 0
    }

    @DisplayName("수익률을 계산한다.")
    @Test
    void generateProfit() {
        // given
        List<Integer> numbers1 = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> numbers2 = Arrays.asList(1, 2, 3, 4, 5, 7);
        List<Integer> numbers3 = Arrays.asList(1, 2, 3, 5, 7, 8);

        List<Lotto> lottos = new ArrayList<>(List.of(new Lotto(numbers1), new Lotto(numbers2), new Lotto(numbers3)));
        winningNumbers = WinningNumbers.create("1,2,3,4,5,6");
        bonusNumber = BonusNumber.create("7");
        winningLotto = WinningLotto.create(winningNumbers, bonusNumber);
        LottoResultGenerator lottoResultGenerator = LottoResultGenerator.create(winningLotto, purchaseAmount);

        // when, then
        lottoResultGenerator.generatePrizeResult(Lottos.create(lottos));
        double profit = lottoResultGenerator.generateProfit();  //(2000000000 + 30000000 + 50000) / 10000 = 230_000_005.0%
        assertThat(profit).isGreaterThan(10000);
    }
}