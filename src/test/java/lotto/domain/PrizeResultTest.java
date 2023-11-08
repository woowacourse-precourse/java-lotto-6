package lotto.domain;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.PrizeResult;
import lotto.domain.Ranking;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PrizeResultTest {

    @Test
    @DisplayName("상금합 구하기")
    public void calculate() {
        List<Ranking> lottoNumbersList = new ArrayList<>();
        lottoNumbersList.add(Ranking.FIFTH);
        lottoNumbersList.add(Ranking.FIFTH);
        lottoNumbersList.add(Ranking.FOURTH);

        PrizeResult winningResult = new PrizeResult(lottoNumbersList);
        assertThat(winningResult.calculatePrizeSum()).isEqualTo(60000);
    }
}
