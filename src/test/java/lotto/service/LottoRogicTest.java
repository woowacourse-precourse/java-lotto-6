package lotto.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import lotto.domain.Lotto;
import lotto.domain.WinningLotto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LottoRogicTest {
    private static int prize;

    @BeforeEach
    public void setup() {
        prize = 5000;
    }

    @Test
    void 로또번호_일치_갯수() {
        Lotto winningNumbers = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        WinningLotto winningLotto = new WinningLotto(winningNumbers, 7);

        Lotto lottoToTest = new Lotto(Arrays.asList(1, 2, 3, 7, 9, 11));

        int matchCount = LottoRogic.getMatchCounts(lottoToTest, winningLotto);

        assertThat(matchCount).isEqualTo(3);
    }


    @Test
    void 보너스_일치여부() {
        Lotto winningNumbers = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        WinningLotto winningLotto = new WinningLotto(winningNumbers, 7);

        Lotto lottoToTest = new Lotto(Arrays.asList(1, 2, 3, 7, 9, 11));

        boolean matchBonus = LottoRogic.getMatchBonus(lottoToTest, winningLotto);

        assertThat(matchBonus).isEqualTo(true);
    }

    @Test
    void 수익률_계산() {
        int prize = 5000;
        LottoRogic.getRate(5);
    }
    
}