package lotto.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class AggregatorTest {
    @Test
    void result_6개_당첨_1개와_0개_당첨_1개_인경우() {
        Aggregator aggregator = new Aggregator();

        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(List.of(1,2,3,4,5,6)));
        lottos.add(new Lotto(List.of(11,12,13,14,15,16)));

        List<Integer> winningNumbers = List.of(1,2,3,4,5,6);

        List<Integer> result = aggregator.result(lottos, winningNumbers);
        Assertions.assertThat(result).isEqualTo(List.of(6, 0));
    }

    @Test
    void result_구입한_로또_번호들_중에서_일치하는_번호가_하나도_없는_경우() {
        Aggregator aggregator = new Aggregator();

        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(List.of(1,2,3,4,5,6)));
        lottos.add(new Lotto(List.of(11,12,13,14,15,16)));

        List<Integer> winningNumbers = List.of(40,41,42,43,44,45);

        List<Integer> result = aggregator.result(lottos, winningNumbers);
        Assertions.assertThat(result).isEqualTo(List.of(0, 0));
    }
}
