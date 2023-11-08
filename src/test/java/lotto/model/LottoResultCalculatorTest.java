package lotto.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class LottoResultCalculatorTest {

    private Lotto winningLotto;
    private int bonusNumber;
    private LottoResultCalculator calculator;

    @BeforeEach
    void init() {
        winningLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        bonusNumber = 7;
        calculator = new LottoResultCalculator(winningLotto, bonusNumber);
    }

    @Test
    void 로또_결과_계산_테스트() {
        List<Lotto> purchasedLottos = Arrays.asList(
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),  // 1st rank
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7)),  // 2nd rank
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 8)),  // 3rd rank
                new Lotto(Arrays.asList(1, 2, 3, 4, 8, 9)),  // 4th rank
                new Lotto(Arrays.asList(1, 2, 3, 8, 9, 10))  // 5th rank
        );

        List<LottoResult> results = calculator.getLottoResults(purchasedLottos);
        assertThat(results.size()).isEqualTo(5);
        results.forEach(r ->{
            System.out.println(r.getReward());
            System.out.println(LottoRank.FIRST_RANK.getReward());
            System.out.println(r.getSameEa() );
        });
        assertThat(results.stream().anyMatch(result ->
                result.getReward() == LottoRank.FIRST_RANK.getReward() && result.getSameEa() == 1)).isTrue();
        assertThat(results.stream().anyMatch(result ->
                result.getReward() == LottoRank.SECOND_RANK.getReward() && result.getSameEa() == 1)).isTrue();
        assertThat(results.stream().anyMatch(result ->
                result.getReward() == LottoRank.THIRD_RANK.getReward() && result.getSameEa() == 1)).isTrue();
        assertThat(results.stream().anyMatch(result ->
                result.getReward() == LottoRank.FOURTH_RANK.getReward() && result.getSameEa() == 1)).isTrue();
        assertThat(results.stream().anyMatch(result ->
                result.getReward() == LottoRank.FIFTH_RANK.getReward() && result.getSameEa() == 1)).isTrue();
    }

}