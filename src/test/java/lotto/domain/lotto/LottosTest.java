package lotto.domain.lotto;

import lotto.domain.game.Prize;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;


class LottosTest {
    private Lottos lottos;

    @BeforeEach
    void setUp() {
        final List<Lotto> lottoList = List.of(
                new Lotto(LottoNumbers.from(List.of(1, 2, 3, 4, 5, 6))),
                new Lotto(LottoNumbers.from(List.of(7, 1, 2, 3, 4, 5))),
                new Lotto(LottoNumbers.from(List.of(1, 2, 3, 4, 5, 18))),
                new Lotto(LottoNumbers.from(List.of(1, 2, 3, 4, 23, 26))),
                new Lotto(LottoNumbers.from(List.of(1, 2, 3, 28, 29, 30)))
        );
        lottos = Lottos.from(lottoList);
    }

    @Test
    void 구매_금액_계산() {
        // when
        final int purchasingCost = lottos.getPurchasingCost();

        // then
        assertThat(purchasingCost).isEqualTo(5000);
    }

    @Test
    void 당첨_번호와_매치되는_상금_계산() {
        // given
        final WinningNumber winningNumber = new WinningNumber(new LottoNumbers(Set.of(
                new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                new LottoNumber(4), new LottoNumber(5), new LottoNumber(6)
        )), new LottoNumber(7));

        // when
        final List<Prize> prizes = lottos.calculatePrizes(winningNumber);

        // then
        assertThat(prizes).containsExactly(
                Prize.FIRST,
                Prize.SECOND,
                Prize.THIRD,
                Prize.FOURTH,
                Prize.FIFTH
        );
    }
}
