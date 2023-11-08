package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.tuple;

import java.util.List;
import lotto.model.dto.AnalyzerWinningStatistics;
import lotto.model.lottonumbersgenerator.LottoNumbersGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoBuyerTest {
    private LottoNumbersGenerator numbersGenerator;
    private LottoBuyer lottoBuyer;

    @BeforeEach
    void setUp() {
        numbersGenerator = () -> List.of(1, 2, 3, 4, 5, 6);
        lottoBuyer = new LottoBuyer();
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 100, 500, 750, 1250, 1500, 1750, -1000})
    void 로또_구매시_구입_금액이_1000원_단위가_아니면_예외가_발생한다(int purchaseAmount) {
        assertThatThrownBy(() -> lottoBuyer.buyLotto(purchaseAmount, numbersGenerator))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 구매한_로또로_당첨_통계를_얻을_수_있다() {
        Lotto mainNumbers = new Lotto(List.of(1, 2, 3, 4, 5, 12));
        int bonusNumber = 6;
        WinningNumbers winningNumbers = new WinningNumbers(mainNumbers, bonusNumber);
        lottoBuyer.buyLotto(2000, numbersGenerator);

        AnalyzerWinningStatistics analyzerWinningStatistics = lottoBuyer.calculateWinningStatistics(winningNumbers);

        assertThat(analyzerWinningStatistics.winningResults()).hasSize(6)
                .extracting("winningRule", "winningCount")
                .containsExactly(
                        tuple(WinningRule.NO_PRIZE, 0),
                        tuple(WinningRule.FIFTH_PRIZE, 0),
                        tuple(WinningRule.FOURTH_PRIZE, 0),
                        tuple(WinningRule.THIRD_PRIZE, 0),
                        tuple(WinningRule.SECOND_PRIZE, 2),
                        tuple(WinningRule.FIRST_PRIZE, 0)
                );
        assertThat(analyzerWinningStatistics.yield()).isEqualTo(60_000_000D / 2000 * 100);
    }
}
