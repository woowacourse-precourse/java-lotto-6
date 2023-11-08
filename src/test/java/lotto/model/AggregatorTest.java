package lotto.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class AggregatorTest {

    @DisplayName("6개 당첨 1개와 0개 당첨 1개인 경우")
    @Test
    void matchSixAndZero() {
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(List.of(1,2,3,4,5,6)));
        lottos.add(new Lotto(List.of(11,12,13,14,15,16)));

        List<Integer> winningNumbers = List.of(1,2,3,4,5,6);
        List<Integer> bonusNumber = new ArrayList<>();
        bonusNumber.add(7);

        DrawNumbers drawNumbers = new DrawNumbers(winningNumbers, bonusNumber);
        Aggregator aggregator = new Aggregator(drawNumbers);

        List<Integer> result = aggregator.matchResult(lottos);
        Assertions.assertThat(result).isEqualTo(List.of(6, 0));
    }

    @DisplayName("당첨 번호와 5개가 일치하고 보너스번호가 일치하는 경우")
    @Test
    void matchFiveAndBonus() {
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(List.of(1,40,41,42,43,44)));
        lottos.add(new Lotto(List.of(11,12,13,14,15,16)));

        List<Integer> winningNumbers = List.of(40,41,42,43,44,45);
        List<Integer> bonusNumber = new ArrayList<>();
        bonusNumber.add(1);

        DrawNumbers drawNumbers = new DrawNumbers(winningNumbers, bonusNumber);
        Aggregator aggregator = new Aggregator(drawNumbers);

        List<Integer> result = aggregator.matchResult(lottos);
        Assertions.assertThat(result).isEqualTo(List.of(Rule.SECOND_RANK.value(), 0));
    }

    @DisplayName("구입한 로또 번호들 중에서 일치하는 번호가 하나도 없는 경우")
    @Test
    void NomatchResult() {
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(List.of(1,2,3,4,5,6)));
        lottos.add(new Lotto(List.of(11,12,13,14,15,16)));

        List<Integer> winningNumbers = List.of(40,41,42,43,44,45);
        List<Integer> bonusNumber = new ArrayList<>();
        bonusNumber.add(39);

        DrawNumbers drawNumbers = new DrawNumbers(winningNumbers, bonusNumber);
        Aggregator aggregator = new Aggregator(drawNumbers);

        List<Integer> result = aggregator.matchResult(lottos);
        Assertions.assertThat(result).isEqualTo(List.of(0, 0));
    }
}
