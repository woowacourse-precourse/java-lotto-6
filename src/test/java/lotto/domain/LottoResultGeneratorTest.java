package lotto.domain;

import lotto.service.LottoResultGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class LottoResultGeneratorTest {
    LottoPurchaseAmount purchaseAmount;
    WinningNumbers winningNumbers;
    WinningLotto winningLotto;
    LottoResultGenerator lottoResultGenerator;
    Lottos lottos;

    @BeforeEach
    void setUp() {
        purchaseAmount = LottoPurchaseAmount.from(10000);

        List<Integer> numbers1 = List.of(1, 2, 3, 4, 5, 6);
        List<Integer> numbers2 = List.of(1, 2, 3, 4, 5, 7);
        List<Integer> numbers3 = List.of(1, 2, 3, 5, 7, 8);

        winningNumbers = WinningNumbers.from(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 8;
        winningLotto = WinningLotto.create(winningNumbers, bonusNumber);

        lottoResultGenerator = LottoResultGenerator.of(winningLotto, purchaseAmount);
        List<Lotto> severalLottos = new ArrayList<>(List.of(new Lotto(numbers1), new Lotto(numbers2), new Lotto(numbers3)));
        lottos = Lottos.from(severalLottos);
    }

    @DisplayName("랭킹을 계산한다.")
    @Test
    void generatePrizeResult() {
        //when
        Map<PrizeCondition, Long> prizeResult = lottoResultGenerator.generatePrizeResult(lottos);

        //then
        assertThat(prizeResult.getOrDefault(PrizeCondition.FIRST, 0L)).isEqualTo(1);  //FIRST : 1
        assertThat(prizeResult.getOrDefault(PrizeCondition.SECOND, 0L)).isEqualTo(0);  //SECOND : 0
        assertThat(prizeResult.getOrDefault(PrizeCondition.THIRD, 0L)).isEqualTo(1);  //THIRD : 1
        assertThat(prizeResult.getOrDefault(PrizeCondition.FOURTH, 0L)).isEqualTo(1);  //FOURTH : 1
        assertThat(prizeResult.getOrDefault(PrizeCondition.FIFTH, 0L)).isEqualTo(0);  //FIFTH : 0
    }

    @DisplayName("수익률을 계산한다.")
    @Test
    void generateProfit() {
        //when
        lottoResultGenerator.generatePrizeResult(lottos);
        double profit = lottoResultGenerator.generateProfit();
        //(2000000000 + 30000000 + 50000) / 10000 = 230_000_005.0%

        //then
        assertThat(profit).isGreaterThan(10000);
    }
}