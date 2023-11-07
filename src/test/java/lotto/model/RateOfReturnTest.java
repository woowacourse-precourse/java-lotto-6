package lotto.model;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RateOfReturnTest {

    @Test
    @DisplayName("수익률이 맞게 계산되는지 확인")
    public void testGetRateOfRetun() {
        //given
        Money money = new Money(6000);
        Lottos lottos = new Lottos(
                List.of(
                        new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                        new Lotto(List.of(1, 2, 3, 4, 5, 7)),
                        new Lotto(List.of(1, 2, 3, 4, 5, 8)),
                        new Lotto(List.of(1, 2, 3, 4, 7, 15)),
                        new Lotto(List.of(1, 2, 3, 14, 15, 18)),
                        new Lotto(List.of(1, 2, 7, 14, 15, 18))
                )
        );
        WinningLotto winningLotto = new WinningLotto(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)), 7);

        WinningResult winningResult = new WinningResult(lottos, winningLotto);

        //when
        double rateOfReturn = new RateOfReturn(money, winningResult).getRateOfReturn();

        //then
        Assertions.assertThat(String.format("%,.1f", rateOfReturn)).contains("33,859,250.0");
    }
}