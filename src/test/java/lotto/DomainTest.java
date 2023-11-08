package lotto;

import lotto.domain.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import java.util.List;

import static java.util.Map.entry;
import static lotto.util.LottoGenerator.generateLottos;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DomainTest {

    @DisplayName("돈에 따라 살수 있는 로또 개수 테스트")
    @Test
    void 살_수_있는_로또의_개수_테스트(){
        //given
        int expectedValue = 5;
        int lottoCounts;

        //when
        Money money = new Money(5000);

        //then
        assertEquals(money.getCount(), expectedValue);
    }

    @DisplayName("돈에 따른 알맞은 로또의 개수가 생성됐는지 테스트")
    @Test
    void 금액에_따른_로또_생성_테스트(){
        //given
        Lottos lottos;
        int lottoCounts = 5;

        //when
        lottos = new Lottos(generateLottos(lottoCounts));

        //then
        assertEquals(lottoCounts, lottos.getLottos().size());
    }

    @DisplayName("당첨된 로또의 개수가 예상값과 맞는지 비교한다.")
    @Test
    void 당첨_테스트(){
        //given
        Lottos lottos = new Lottos(
                List.of(
                        new Lotto(List.of(1, 2, 3, 4, 5, 6)),//3등
                        new Lotto(List.of(1, 2, 3, 4, 5, 6)),//3등
                        new Lotto(List.of(1, 2, 3, 4, 5, 7))//2등
                )
        );
        TotalWinningNumbers totalWinningNumbers
                = new TotalWinningNumbers(new Lotto(List.of(1, 2, 3, 4, 5, 10)), 7);

        //when
        LottoResult lottoResult = totalWinningNumbers.checkLottos(lottos);

        //then
        assertThat(lottoResult.getResults())
                .contains(entry(Rank.SECOND, 1), entry(Rank.THIRD, 2), entry(Rank.FIFTH, 0));
    }

    @DisplayName("당첨이 된 후에 계산한 수익률을 테스트한다.")
    @Test
    void 수익률_테스트(){
        //given
        Money money = new Money(3000);
        Lottos lottos = new Lottos(
                List.of(
                        new Lotto(List.of(1, 2, 3, 10, 11, 12)),
                        new Lotto(List.of(1, 2, 3, 10, 11, 12)),
                        new Lotto(List.of(1, 2, 10, 11, 12, 13))
                )
        );
        TotalWinningNumbers totalWinningNumbers
                = new TotalWinningNumbers(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 7);
        double expectedRateOfReturn = 10000d/3000d*100d;

        //when
        LottoResult lottoResult = totalWinningNumbers.checkLottos(lottos);

        //then
        assertEquals(lottoResult.getRateOfReturn(money), expectedRateOfReturn);
    }

    @DisplayName("당첨금이 매우 클 경우")
    @Test
    void 당첨금이_매우_클_경우_테스트() {
        Money money = new Money(2000);
        Lottos lottos = new Lottos(
                List.of(
                        new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                        new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                        new Lotto(List.of(1, 2, 3, 4, 5, 6))
                )
        );
        TotalWinningNumbers totalWinningNumbers
                = new TotalWinningNumbers(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 7);
        double expectedRateOfReturn = 6000000000d/2000d*100d;

        //when
        LottoResult lottoResult = totalWinningNumbers.checkLottos(lottos);

        //then
        assertEquals(lottoResult.getRateOfReturn(money), expectedRateOfReturn);

    }
}
