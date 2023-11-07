package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.PurchasePrice;
import lotto.domain.WinResult;
import lotto.domain.WinningLotto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoWinResultServiceTest {
    private static final int PRICE = 5000;
    private LottoWinResultService lottoWinResultService = new LottoWinResultService();
    private WinResult winResult;

    @BeforeEach
    void setUpWinResult() {
        List<Lotto> lottos = List.of(
                new Lotto(List.of(1,2,3,4,5,6)),
                new Lotto(List.of(2,6,12,34,36,41)),
                new Lotto(List.of(1,2,3,12,34,41)),
                new Lotto(List.of(1,2,6,12,34,41)),
                new Lotto(List.of(1,2,11,24,33,41))
        );
        WinningLotto winningLotto = new WinningLotto(new Lotto(List.of(1,2,6,12,34,41)));
        winningLotto.setBonusLottoNum(3);
        winResult = lottoWinResultService.getWinResult(lottos, winningLotto);
    }

    @Test
    void getWinResult() {
        assertThat(winResult.getWinResultValue(3)).isEqualTo(2);
        assertThat(winResult.getWinResultValue(4)).isEqualTo(0);
        assertThat(winResult.getWinResultValue(5)).isEqualTo(1);
        assertThat(winResult.getWinResultValue(7)).isEqualTo(1);
        assertThat(winResult.getWinResultValue(6)).isEqualTo(1);
    }

    @Test
    void calculateProfitRate() {
        PurchasePrice purchasePrice = new PurchasePrice(PRICE);
        String profitRate = lottoWinResultService.calculateProfitRate(purchasePrice);

        assertThat(profitRate).isEqualTo("40630200");
    }
}
