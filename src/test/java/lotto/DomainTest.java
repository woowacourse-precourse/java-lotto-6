package lotto;

import lotto.domain.LottoPrize;
import lotto.domain.RankCalculator;
import lotto.domain.Stats;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class DomainTest {

    @BeforeEach
    void beforeEach() {
        Stats.clear();
    }

    @DisplayName("등수 계산 테스트")
    @Test
    void rankCalculation() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        LottoPrize result = RankCalculator.calculateRank(lotto, List.of(1, 2, 3, 4, 5, 7), 6);
        assertThat(result).isEqualTo(LottoPrize.SECOND_PRIZE);
    }

    @DisplayName("수익률 계산 테스트")
    @Test
    void rateCalculation() {
        Stats.setPurchased(1000);
        Stats.update(LottoPrize.FOURTH_PRIZE);
        Stats.update(LottoPrize.FIRST_PRIZE);
        String result = Stats.calculateRate();
        assertThat(result).isEqualTo("200005.0");
    }
}
