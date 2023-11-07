package lotto;

import static lotto.model.WinningGrade.FIRST_GRADE;
import static lotto.model.WinningGrade.SECOND_GRADE;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.model.BonusNumber;
import lotto.model.Lotto;
import lotto.model.Lottos;
import lotto.model.WinningGrade;
import lotto.model.WinningLotto;
import lotto.model.WinningStatics;
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
        Lotto winningLottoNumbers = new Lotto(List.of(8, 21, 23, 41, 42, 43));
        BonusNumber bonusNumber = new BonusNumber("11");
        WinningLotto winningLotto = new WinningLotto(winningLottoNumbers, bonusNumber);

        Lottos lottos = new Lottos(
                List.of(
                        new Lotto(List.of(8, 21, 23, 41, 42, 43)),
                        new Lotto(List.of(3, 5, 11, 16, 32, 38)),
                        new Lotto(List.of(7, 11, 16, 35, 36, 44)),
                        new Lotto(List.of(1, 8, 11, 31, 41, 42))));

        // When
        WinningStatics result = lottoCalculator.getWinningStatic(lottos, winningLotto);

        // Then
        assertThat(result.getStatics())
                .containsKeys(WinningGrade.NONE_GRADE, FIRST_GRADE);
    }

    @Test
    @DisplayName("로또로 얻은 수익을 구한다.")
    void getLottosProfit_Statics() {
        // Given
        WinningStatics statics = new WinningStatics();
        statics.addWinningCount(FIRST_GRADE);
        statics.addWinningCount(SECOND_GRADE);
        statics.addWinningCount(SECOND_GRADE);

        int firstGradeProfit = statics.getWinningGradeCount(FIRST_GRADE) * FIRST_GRADE.getWinningPrice();
        int secondGradeProfit = statics.getWinningGradeCount(SECOND_GRADE) * SECOND_GRADE.getWinningPrice();
        int expected = firstGradeProfit + secondGradeProfit;

        // When
        int result = lottoCalculator.getWinningProfit(statics);

        // Then
        assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("로또로 얻은 수익과 구입 금액을 비교해서 수익률을 구한다.")
    void getProfitRate_ProfitAndPurchasePrice() {
        // Given
        WinningStatics statics = new WinningStatics();
        statics.addWinningCount(FIRST_GRADE);
        statics.addWinningCount(SECOND_GRADE);
        statics.addWinningCount(SECOND_GRADE);

        int price = 5_000;
        int profit = lottoCalculator.getWinningProfit(statics);

        // When
        float profitRate = lottoCalculator.getProfitRate(profit, price);

        // Then
        assertThat(profitRate).isEqualTo(4.12E7f);
    }

}