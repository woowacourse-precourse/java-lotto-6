package lotto;

import static java.util.Map.entry;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class WinnersCalculatorTest {


    @Test
    void testCalculateWinners() {
//        given
        List<Lotto> lottos = new ArrayList<>();
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        lottos.add(lotto);
        WinnersCalculator winnersCalculator = new WinnersCalculator(List.of(1, 2, 3, 4, 5, 10), 6);
        //when
        Map<Integer, Integer> winners = winnersCalculator.calculateWinners(lottos);

        //then
        Assertions.assertThat(winners).contains(entry(5 + Constants.BONUS_BALL, 1));
    }
}