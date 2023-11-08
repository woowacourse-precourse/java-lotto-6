package lotto.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import lotto.model.Lotto;
import lotto.model.LottoResult;
import lotto.model.Money;
import lotto.model.UserLotto;
import lotto.model.WinningLotto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LottoGameServiceTest {
    private LottoGameService lottoGameService;

    @BeforeEach
    void setUp() {
        lottoGameService = new LottoGameService();
    }

    @Test
    void 로또_구매_로직_테스트() {
        String lottoCount = lottoGameService.buyLotto("3000");
        assertEquals("3", lottoCount);
    }

    @Test
    void 로또_발행_로직_테스트() {
        lottoGameService.buyLotto("3000");
        assertThat(lottoGameService.makeLotto()).contains(
                "[", ",", "]"
        );
    }

    @Test
    void 결과_계산_로직_테스트() {
        //given
        UserLotto userLotto = new UserLotto(
                List.of(
                        new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                        new Lotto(List.of(1, 2, 3, 4, 5, 7)),
                        new Lotto(List.of(1, 2, 3, 4, 5, 9)),
                        new Lotto(List.of(1, 2, 3, 4, 11, 12)),
                        new Lotto(List.of(1, 2, 3, 14, 15, 16)),
                        new Lotto(List.of(1, 17, 18, 19, 20, 21))
                )
        );
        WinningLotto winningLotto = new WinningLotto(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 7);

        //when
        List<LottoResult> result = userLotto.calculateResult(winningLotto);

        //then
        assertThat(result).isEqualTo(
                List.of(
                        LottoResult.FIRST,
                        LottoResult.SECOND,
                        LottoResult.THIRD,
                        LottoResult.FOURTH,
                        LottoResult.FIFTH,
                        LottoResult.NONE
                )
        );
    }
    @Test
    void 수익률_계산_로직_테스트() {
        Money money = new Money("3000");
        List<LottoResult> lottoResults = List.of(
                LottoResult.THIRD
        );

        double totalProfit = money.calculateYield(lottoResults.stream()
                .mapToDouble(LottoResult::getPrizeMoney)
                .sum());
        double rate = (1_500_000 / 3000) * 100.0;
        double expected = Math.round(rate * 100.0)/ 100.0;

        assertThat(totalProfit).isEqualTo(expected);
    }
}