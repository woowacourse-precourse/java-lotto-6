package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;


class CalculateTest {
    private Calculate calc;

    @DisplayName("등수를 제대로 계산하는가")
    @Test
    void calculateLottoRankTest() {
        // given
        List<Integer> answerLotto = Arrays.asList(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;
        List<Lotto> lottos = Arrays.asList(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)), new Lotto(Arrays.asList(7, 1, 2, 3, 4, 5)));
        calc = new Calculate(lottos, answerLotto, bonusNumber);

        // when
        calc.countAll();
        Map<WinningDetails, Integer> rank = calc.getRank();

        // then
        assertThat(rank).containsEntry(WinningDetails.FIRST, 1);
        assertThat(rank).containsEntry(WinningDetails.SECOND, 1);
    }

    @DisplayName("수익률을 제대로 계산하는가")
    @Test
    void calculateRate() {
        // given
        List<Lotto> lottos = Arrays.asList(
                new Lotto(Arrays.asList(8, 21, 23, 41, 42, 43)),
                new Lotto(Arrays.asList(3, 5, 11, 16, 32, 38)),
                new Lotto(Arrays.asList(7, 11, 16, 35, 36, 44)),
                new Lotto(Arrays.asList(1, 8, 11, 31, 41, 42)),
                new Lotto(Arrays.asList(13, 14, 16, 38, 42, 45)),
                new Lotto(Arrays.asList(7, 11, 30, 40, 42, 43)),
                new Lotto(Arrays.asList(2, 13, 22, 32, 38, 45)),
                new Lotto(Arrays.asList(1, 3, 5, 14, 22, 45)));
        int bonusNumber = 7;
        List<Integer> answerNumber = Arrays.asList(1, 2, 3, 4, 5, 6);
        int money = 8000;
        calc = new Calculate(lottos, answerNumber, bonusNumber);

        // when
        calc.countAll();
        Map<WinningDetails, Integer> rank = calc.getRank();
        RatingAndPrinting printer = new RatingAndPrinting(lottos);
        double rate = printer.caculateRate(rank, money);

        assertThat(rate).isEqualTo(62.5);
    }
}