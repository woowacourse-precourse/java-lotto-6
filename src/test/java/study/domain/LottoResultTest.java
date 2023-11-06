package study.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.enums.LottoPrize;
import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.LottoWallet;
import lotto.domain.WinningLotto;
import org.junit.jupiter.api.Test;

public class LottoResultTest {

    @Test
    void countPrizes() {
        LottoWallet wallet = new LottoWallet(
                List.of(new Lotto(List.of(1, 2, 3, 4, 5, 6)), new Lotto(List.of(1, 2, 3, 4, 5, 7)),
                        new Lotto(List.of(1, 2, 3, 4, 5, 8)),
                        new Lotto(List.of(1, 2, 3, 4, 5, 9))));
        WinningLotto winningLotto = new WinningLotto(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 7);

        LottoResult lottoResult = new LottoResult();
        lottoResult.countPrizes(wallet, winningLotto);

        assertThat(lottoResult.getCount(LottoPrize.FIRST_PLACE)).isEqualTo(1);
        assertThat(lottoResult.getCount(LottoPrize.SECOND_PLACE)).isEqualTo(1);
        assertThat(lottoResult.getCount(LottoPrize.THIRD_PLACE)).isEqualTo(2);
        assertThat(lottoResult.getCount(LottoPrize.NO_PLACE)).isEqualTo(0);
    }

    @Test
    void getTotalPrizeAmount() {
        LottoWallet wallet = new LottoWallet(
                List.of(new Lotto(List.of(1, 2, 3, 4, 5, 6)), new Lotto(List.of(1, 2, 3, 4, 5, 7)),
                        new Lotto(List.of(1, 2, 3, 4, 5, 8)),
                        new Lotto(List.of(1, 2, 3, 4, 5, 9))));
        WinningLotto winningLotto = new WinningLotto(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 7);

        LottoResult lottoResult = new LottoResult();
        lottoResult.countPrizes(wallet, winningLotto);

        assertThat(lottoResult.getTotalAmount()).isEqualTo(
                LottoPrize.FIRST_PLACE.getAmount() + LottoPrize.SECOND_PLACE.getAmount()
                        + LottoPrize.THIRD_PLACE.getAmount() * 2);
    }
}
