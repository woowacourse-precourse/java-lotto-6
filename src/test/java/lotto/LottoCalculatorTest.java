package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import lotto.model.Lottos;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoCalculatorTest {

    private LottoCalculator lottoCalculator;

    @BeforeEach
    void setUp() {
        lottoCalculator = new LottoCalculator();
    }

    @Test
    @DisplayName("구입 로또, 당첨 번호, 보너스 번호를 비교해서 당첨 통계를 구한다.")
    void getMatchStatics() {
        // Given
        Lotto winningLotto = new Lotto(List.of(8, 21, 23, 41, 42, 43));
        BonusNumber bonusNumber = new BonusNumber("11", winningLotto);
        Lottos lottos = new Lottos(
                List.of(
                        new Lotto(List.of(8, 21, 23, 41, 42, 43)),
                        new Lotto(List.of(3, 5, 11, 16, 32, 38)),
                        new Lotto(List.of(7, 11, 16, 35, 36, 44)),
                        new Lotto(List.of(1, 8, 11, 31, 41, 42))));

        // When
        Map<WinningType, Integer> result = lottoCalculator.getMatchStatics(lottos, winningLotto, bonusNumber);

        // Then
        assertThat(result).containsKeys(WinningType.NONE, WinningType.FIRST);
    }

    @Test
    @DisplayName("로또로 얻은 수익을 구한다.")
    void getLottosProfit_Statics() {
        // Given
        Map<WinningType, Integer> statics = new EnumMap<>(WinningType.class);
        statics.put(WinningType.FIRST, 3);
        statics.put(WinningType.SECOND, 2);

        int expected = 3 * WinningType.FIRST.getWinningPrice() + 2 * WinningType.SECOND.getWinningPrice();

        // When
        int result = lottoCalculator.getLottosProfit(statics);

        // Then
        assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("로또로 얻은 수익과 구입 금액을 비교해서 수익률을 구한다.")
    void getProfitRate_ProfitAndPurchasePrice() {
        // Given
        Map<WinningType, Integer> statics = new EnumMap<>(WinningType.class);
        statics.put(WinningType.FIRST, 3);
        statics.put(WinningType.SECOND, 2);
        int price = 5_000;
        int profit = lottoCalculator.getLottosProfit(statics);

        // When
        float profitRate = lottoCalculator.getProfitRate(profit, price);

        // Then
        assertThat(profitRate).isEqualTo(3.5300652E7f);
    }

}