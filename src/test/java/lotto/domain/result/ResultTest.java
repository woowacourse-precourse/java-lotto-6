package lotto.domain.result;

import static lotto.domain.grade.Grade.FIFTH;
import static lotto.domain.grade.Grade.FIRST;
import static lotto.domain.grade.Grade.FOURTH;
import static lotto.domain.grade.Grade.SECOND;
import static lotto.domain.grade.Grade.THIRD;
import static lotto.utils.LottoConstant.PROFIT_MULTIPLY;
import static lotto.utils.LottoConstant.PURCHASE_AMOUNT_UNIT;
import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import lotto.domain.grade.GradeCount;
import lotto.domain.lotto.Lotto;
import lotto.domain.winning.Winning;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ResultTest {

    final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    void tearDown() {
        System.setOut(System.out);
    }

    @Test
    void 결과를_집계하여_통계를_조회한다() {
        //Arrange
        List<Integer> winNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;
        Winning winning = Winning.of(winNumbers, bonusNumber);

        List<Lotto> lottos = List.of(
                Lotto.of(List.of(1, 2, 3, 4, 5, 6)),
                Lotto.of(List.of(1, 2, 3, 4, 5, 7)),
                Lotto.of(List.of(1, 2, 3, 4, 5, 8)),
                Lotto.of(List.of(1, 2, 3, 4, 8, 9)),
                Lotto.of(List.of(1, 2, 3, 8, 9, 10)),
                Lotto.of(List.of(1, 2, 8, 9, 10, 11))
        );

        Result result = Result.of();

        List<Integer> expected = List.of(1, 1, 1, 1, 1, 1);

        //Act
        result.aggregate(winning, lottos);

        //Assert
        Statistics statistics = result.getStatistics();

        List<Integer> actual = statistics.getGradeCounts()
                .stream()
                .map(GradeCount::getCount)
                .toList();

        assertThat(actual).containsExactlyElementsOf(expected);
    }

    @Test
    void 결과를_집계하여_상금액을_계산한다() {
        //Arrange
        List<Integer> winNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;
        Winning winning = Winning.of(winNumbers, bonusNumber);

        List<Lotto> lottos = List.of(
                Lotto.of(List.of(1, 2, 3, 4, 5, 6)),
                Lotto.of(List.of(1, 2, 3, 4, 5, 7)),
                Lotto.of(List.of(1, 2, 3, 4, 5, 8)),
                Lotto.of(List.of(1, 2, 3, 4, 8, 9)),
                Lotto.of(List.of(1, 2, 3, 8, 9, 10)),
                Lotto.of(List.of(1, 2, 8, 9, 10, 11))
        );

        Result result = Result.of();
        result.aggregate(winning, lottos);

        long expected = FIRST.getWinningMoney() +
                SECOND.getWinningMoney() +
                THIRD.getWinningMoney() +
                FOURTH.getWinningMoney() +
                FIFTH.getWinningMoney();

        //Act
        result.calculate(lottos.size());

        //Assert
        long actual = result.getWinningMoney().longValue();
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void 결과를_집계하여_수익율을_계산한다() {
        //Arrange
        List<Integer> winNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;
        Winning winning = Winning.of(winNumbers, bonusNumber);

        List<Lotto> lottos = List.of(
                Lotto.of(List.of(1, 2, 3, 4, 5, 6)),
                Lotto.of(List.of(1, 2, 3, 4, 5, 7)),
                Lotto.of(List.of(1, 2, 3, 4, 5, 8)),
                Lotto.of(List.of(1, 2, 3, 4, 8, 9)),
                Lotto.of(List.of(1, 2, 3, 8, 9, 10)),
                Lotto.of(List.of(1, 2, 8, 9, 10, 11))
        );

        Result result = Result.of();
        result.aggregate(winning, lottos);

        long winningMoney = FIRST.getWinningMoney() +
                SECOND.getWinningMoney() +
                THIRD.getWinningMoney() +
                FOURTH.getWinningMoney() +
                FIFTH.getWinningMoney();

        double expected = ((double) winningMoney / (lottos.size() * PURCHASE_AMOUNT_UNIT)) * PROFIT_MULTIPLY;

        //Act
        result.calculate(lottos.size());

        //Assert
        double actual = result.getProfit().getPercentage();
        assertThat(actual).isEqualTo(expected);
    }
}