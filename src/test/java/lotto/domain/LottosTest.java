package lotto.domain;

import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.Lottos;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

public class LottosTest {

    Lottos lottos;
    int lottoCnt = 3;

    @BeforeEach
    void setUp() {
        lottos = new Lottos(lottoCnt, new FakeNumberGenerator());
    }

    @Test
    void Lottos가_입력한_숫자만큼_로또를_생성하는지_확인하는_테스트() {
        List<Lotto> lottoList = this.lottos.getLottos();

        assertThat(lottoList.size())
                .isEqualTo(lottoCnt);
    }

    @Test
    void Lottos가_각각의_로또의_숫자개수를_6개를_생성하는지_확인() {
        assertThatCode(() -> lottos.generateLottos())
                .doesNotThrowAnyException();
    }

    @Test
    void Lottos가_숫자를_잘_생성하는지_테스트() {
        List<Lotto> lottoList = this.lottos.getLottos();

        for (Lotto lotto : lottoList) {
            List<Integer> lottoNumbers = lotto.getNumbers();

            assertThat(lottoNumbers)
                    .containsExactly(1,2,3,4,5,6);
        }
    }
}
