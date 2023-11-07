package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.model.Lotto;
import lotto.model.LottoResult;
import lotto.model.Lottos;
import lotto.model.Rank;
import lotto.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoResultTest {

    private LottoResult lottoResult;

    @BeforeEach
    void createLottoResult() {
        List<Lotto> newLotto = List.of(
                new Lotto(List.of(4, 19, 26, 28, 43, 44)),
                new Lotto(List.of(14, 15, 22, 23, 32, 36)),
                new Lotto(List.of(4, 17, 26, 31, 37, 43)),
                new Lotto(List.of(2, 6, 11, 26, 33, 34)),
                new Lotto(List.of(10, 20, 23, 24, 35, 41)));

        Lottos lottos = new Lottos(newLotto);
        User user = new User(new Lotto("4,19,26,28,43,10"), "44");
        this.lottoResult = new LottoResult(lottos, user);
    }

    @DisplayName("총 수익률을 계산한다.")
    @Test
    void calculateEarningRate() {
        int cost = 5000;
        int earnings = lottoResult.findResult(Rank.FIVE_BONUS) * Rank.FIVE_BONUS.getPrize()
                + lottoResult.findResult(Rank.THREE) * Rank.THREE.getPrize();
        double earningRate = (earnings / (double) cost) * 100;
        assertThat(lottoResult.calEarningRate(cost)).isEqualTo(earningRate);
    }

}
