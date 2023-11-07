package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.model.Lotto;
import lotto.model.LottoResult;
import lotto.model.Lottos;
import lotto.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoResultTest {

    private LottoResult lottoResult;

    @BeforeEach
    void createLottoResult() {
        List<Lotto> newLotto = List.of(
                new Lotto(List.of(3, 5, 11, 16, 32, 38)),
                new Lotto(List.of(7, 11, 16, 35, 36, 44)));

        Lottos lottos = new Lottos(newLotto);
        User user = new User(new Lotto(List.of(3, 5, 11, 2, 7, 1)), "4");
        this.lottoResult = new LottoResult(lottos, user);
    }

    @DisplayName("총 수익률을 계산한다.")
    @Test
    void calculateEarningRate() {
        int cost = 2000;
        assertThat(lottoResult.calEarningRate(cost)).isEqualTo(250.0);
    }

}
