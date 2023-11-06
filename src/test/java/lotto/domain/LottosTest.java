package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.HashMap;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LottosTest {

    @DisplayName("로또를 여러개 생성 한다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 3, 8})
    public void generateLottoMultipleTimes(Integer loop) {
        Lottos lottos = Lottos.from(loop);

        assertThat(lottos.getList())
                .hasSize(loop)
                .doesNotContainNull();
    }

    @Test
    @DisplayName("당첨된 로또의 등수와 갯수 반환한다")
    void returnWinnerLottoRankAndCount() {
        Lotto lotto1 = new Lotto(List.of(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4),
                new LottoNumber(5), new LottoNumber(6)));
        Lotto lotto2 = new Lotto(List.of(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4),
                new LottoNumber(5), new LottoNumber(7)));
        Lottos lottos = new Lottos(List.of(lotto1, lotto2));

        assertThat(lottos.chargeResult(new WinnerLotto(lotto1, new LottoNumber(7)))).hasSize(2)
                .containsKeys(Rank.SIX, Rank.FIVE_BONUS)
                .containsValue(1);
    }
}
