package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.constants.Prize;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoResultTest {

    private Lottos lottos;
    private WinningLotto winLotto;

    @BeforeEach
    void setUp() {
        SpecificLottoGenerator generator = new SpecificLottoGenerator(List.of(1, 2, 3, 4, 5, 6));
        Quantity totalLottery = Quantity.of(new Money(1000), 1000);
        winLotto = WinningLotto.of(new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new BonusNumber(7, new Lotto(List.of(1, 2, 3, 4, 5, 6))));
        lottos = Lottos.of(totalLottery, generator);
    }

    @DisplayName("1등 당첨여부를 확인한다.")
    @Test
    void should_BeWinner_When_Valid() {
        LottoResult result = LottoResult.of(lottos, winLotto);
        assertThat(result.getResult().getOrDefault(Prize.FIRST, 0L)).isEqualTo(1);
    }

    @DisplayName("수익률을 계산한다.")
    @Test
    void should_CalculateProfit_When_Valid() {
        LottoResult result = LottoResult.of(lottos, winLotto);
        double profit = result.calculateProfit();
        assertThat(profit).isEqualTo(2_0000_0000);
    }
    
}
