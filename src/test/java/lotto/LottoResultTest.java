package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoResultTest {
    private LottoResult lottoResult;

    @BeforeEach
    void setUP() {
        lottoResult = new LottoResult();
    }

    @DisplayName("주어진 랭크 리스트와 구입 금액으로 수익률을 계산한다.")
    @Test
    void calculateEarningRate() {
        List<Rank> inputRanks = new ArrayList<>(List.of(Rank.THREE_MATCH, Rank.FOUR_MATCH, Rank.FIVE_MATCH));
        int inputPurchaseMoney = 10000;
        double result = lottoResult.calculateEarningRate(inputRanks, inputPurchaseMoney);

        assertThat(result).isEqualTo(15550.0);
    }

    @DisplayName("주어진 랭크 리스트로 해당 등수에 몇번 당첨됬는지 알 수 있다.")
    @Test
    void completeResult() {
        List<Rank> inputRanks = new ArrayList<>(List.of(Rank.THREE_MATCH, Rank.THREE_MATCH, Rank.FOUR_MATCH));
        Map<Rank, Integer> result = lottoResult.completeResult(inputRanks);

        assertThat(result.get(Rank.THREE_MATCH)).isEqualTo(2);
        assertThat(result.get(Rank.FOUR_MATCH)).isEqualTo(1);
    }
}