package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottosTest {

    @DisplayName("Lottos를 생성하고 꺼내면 생성한 로또 번호가 들어있다.")
    @Test
    void getLottosTest() {
        Lottos lottos = new Lottos(List.of(new Lotto(List.of(1, 2, 3, 4, 5, 6))));
        List<Lotto> lottoBundle = lottos.getLottos();
        assertThat(lottoBundle.size()).isEqualTo(1);
        assertThat(lottoBundle.get(0).getNumbers()).isEqualTo(
                List.of(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4),
                        new LottoNumber(5), new LottoNumber(6)));
    }
}
