package lotto.model;

import lotto.enumeration.WinningPrize;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class LottoResultTest {
    @Test
    public void 로또결과_생성_테스트() {
        //given
        Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));
        Lottos lottos = new Lottos(List.of(lotto));
        WinningNumber winningNumber = new WinningNumber(List.of(1,2,3,4,5,9));
        winningNumber.addBonusNumber(String.valueOf(6));
        UserAmount userAmount = new UserAmount("1000");
        LottoResult lottoResult = new LottoResult(lottos, winningNumber, userAmount);

        //when
        int rank = lottoResult.getWinningResult(WinningPrize.SECOND.getRank());
        double earningRate = lottoResult.getEarningRate();

        //then
        Assertions.assertThat(rank).isEqualTo(1);
        Assertions.assertThat(earningRate).isEqualTo(3000000.0);
    }
}
