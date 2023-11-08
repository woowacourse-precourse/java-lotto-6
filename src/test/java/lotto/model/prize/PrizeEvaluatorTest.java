package lotto.model.prize;

import lotto.model.Lotto;
import lotto.model.winning.WinningNumbers;
import org.junit.jupiter.api.*;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("당첨 평가(계산) 테스트")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class PrizeEvaluatorTest {
    private static final String WINNING_NUMBERS = "1,2,3,4,5,6";
    private static final String BONUS_NUMBER = "7";
    private static final int THREE_MATCH_PRIZE = 5_000;
    private static final int FOUR_MATCH_PRIZE = 50_000;
    private static final int FIVE_MATCH_PRIZE = 1_500_000;
    private static final int FIVE_MATCH_WITH_BONUS_PRIZE = 30_000_000;
    private static final int SIX_MATCH_PRIZE = 2_000_000_000;

    @Test
    @Order(1)
    @DisplayName("번호 3개 일치")
    void evaluateThreeMatch() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 43, 44, 45));

        WinningNumbers winningNumbers = new WinningNumbers(WINNING_NUMBERS);
        winningNumbers.addBonusNumber(BONUS_NUMBER);

        PrizeEvaluator prizeEvaluator = new PrizeEvaluator();
        Prize prize = prizeEvaluator.evaluate(winningNumbers, List.of(lotto));

        assertThat(prize.prizeMoney()).isEqualTo(THREE_MATCH_PRIZE);
        assertThat(prize.threeMatchCount()).isEqualTo(1);
    }

    @Test
    @Order(2)
    @DisplayName("번호 4개 일치")
    void evaluateFourMatch() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 44, 45));

        WinningNumbers winningNumbers = new WinningNumbers(WINNING_NUMBERS);
        winningNumbers.addBonusNumber(BONUS_NUMBER);

        PrizeEvaluator prizeEvaluator = new PrizeEvaluator();
        Prize prize = prizeEvaluator.evaluate(winningNumbers, List.of(lotto));

        assertThat(prize.prizeMoney()).isEqualTo(FOUR_MATCH_PRIZE);
        assertThat(prize.fourMatchCount()).isEqualTo(1);
    }

    @Test
    @Order(3)
    @DisplayName("번호 5개 일치")
    void evaluateFiveMatch() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 45));

        WinningNumbers winningNumbers = new WinningNumbers(WINNING_NUMBERS);
        winningNumbers.addBonusNumber(BONUS_NUMBER);

        PrizeEvaluator prizeEvaluator = new PrizeEvaluator();
        Prize prize = prizeEvaluator.evaluate(winningNumbers, List.of(lotto));

        assertThat(prize.prizeMoney()).isEqualTo(FIVE_MATCH_PRIZE);
        assertThat(prize.fiveMatchCount()).isEqualTo(1);
    }

    @Test
    @Order(4)
    @DisplayName("번호 5개 + 보너스 번호 일치")
    void evaluateFiveMatchWithBonus() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 7));

        WinningNumbers winningNumbers = new WinningNumbers(WINNING_NUMBERS);
        winningNumbers.addBonusNumber(BONUS_NUMBER);

        PrizeEvaluator prizeEvaluator = new PrizeEvaluator();
        Prize prize = prizeEvaluator.evaluate(winningNumbers, List.of(lotto));

        assertThat(prize.prizeMoney()).isEqualTo(FIVE_MATCH_WITH_BONUS_PRIZE);
        assertThat(prize.fiveMatchWithBonusCount()).isEqualTo(1);
    }

    @Test
    @Order(5)
    @DisplayName("번호 6개 일치")
    void evaluateSixMatch() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        WinningNumbers winningNumbers = new WinningNumbers(WINNING_NUMBERS);
        winningNumbers.addBonusNumber(BONUS_NUMBER);

        PrizeEvaluator prizeEvaluator = new PrizeEvaluator();
        Prize prize = prizeEvaluator.evaluate(winningNumbers, List.of(lotto));

        assertThat(prize.prizeMoney()).isEqualTo(SIX_MATCH_PRIZE);
        assertThat(prize.sixMatchCount()).isEqualTo(1);
    }
}