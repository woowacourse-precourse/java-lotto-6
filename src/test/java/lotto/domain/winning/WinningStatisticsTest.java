package lotto.domain.winning;

import static lotto.domain.winning.Winning.FIFTH_PLACE;
import static lotto.domain.winning.Winning.FIRST_PLACE;
import static lotto.domain.winning.Winning.FOURTH_PLACE;
import static lotto.domain.winning.Winning.NOTHING;
import static lotto.domain.winning.Winning.SECOND_PLACE;
import static lotto.domain.winning.Winning.THIRD_PLACE;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import lotto.domain.number.DrawnNumbers;
import lotto.domain.number.Lotto;
import lotto.domain.number.Lottos;
import lotto.domain.number.Number;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class WinningStatisticsTest {
    Lotto firstPlace;
    Lotto secondPlace;
    Lotto thirdPlace;
    Lotto fourthPlace;
    Lotto fifthPlace;
    Lotto nothing;
    DrawnNumbers drawnNumbers;

    @BeforeEach
    void setUp() {
        firstPlace = createLotto(1, 2, 3, 4, 5, 6);
        secondPlace = createLotto(1, 2, 3, 4, 5, 7);
        thirdPlace = createLotto(1, 2, 3, 4, 5, 45);
        fourthPlace = createLotto(1, 2, 3, 4, 44, 45);
        fifthPlace = createLotto(1, 2, 3, 43, 44, 45);
        nothing = createLotto(1, 2, 42, 43, 44, 45);
        drawnNumbers = new DrawnNumbers(firstPlace, new Number(7));
    }

    private Lotto createLotto(Integer... values) {
        return new Lotto(Stream.of(values)
                .map(Number::new)
                .collect(Collectors.toSet()));
    }

    @Test
    void count() {
        Lottos lottos = new Lottos(List.of(firstPlace, secondPlace, thirdPlace));
        WinningStatistics winningStatistics = WinningStatistics.of(lottos, drawnNumbers);

        int firstPlaceCount = winningStatistics.count(FIRST_PLACE);
        int secondPlaceCount = winningStatistics.count(SECOND_PLACE);
        int thirdPlaceCount = winningStatistics.count(THIRD_PLACE);
        int fourthPlaceCount = winningStatistics.count(FOURTH_PLACE);
        int fifthPlaceCount = winningStatistics.count(FIFTH_PLACE);
        int nothingCount = winningStatistics.count(NOTHING);

        assertThat(firstPlaceCount).isEqualTo(1);
        assertThat(secondPlaceCount).isEqualTo(1);
        assertThat(thirdPlaceCount).isEqualTo(1);
        assertThat(fourthPlaceCount).isEqualTo(0);
        assertThat(fifthPlaceCount).isEqualTo(0);
        assertThat(nothingCount).isEqualTo(0);
    }

    @Test
    void calculateRateOfReturn() {
        Lottos lottos = new Lottos(List.of(fourthPlace, fifthPlace, nothing));
        WinningStatistics winningStatistics = WinningStatistics.of(lottos, drawnNumbers);

        double rateOfReturn = winningStatistics.calculateRateOfReturn();

        double expected = (double) 55_000 / 3_000 * 100;
        assertThat(rateOfReturn).isEqualTo(expected);
    }
}