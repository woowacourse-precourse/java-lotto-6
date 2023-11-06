package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottosTest {
    @DisplayName("특정 개수 만큼 로또를 발행한다.")
    @ParameterizedTest
    @ValueSource(ints = {2, 4, 6, 8, 222})
    void createTest(int count) {
        // given
        Lottos lottos = new Lottos(new RandomNumbers());

        // when
        List<Lotto> lottoList = lottos.generate(count);

        // then
        assertThat(lottoList).hasSize(count);
    }

    @DisplayName("각각의 등수에 당첨된 수를 계산한다.")
    @Test
    void countTest() {
        // given
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        BonusNumber bonusNumber = new BonusNumber(45);
        Lottos lottos = new Lottos(new TestFixedNumbers());

        Map<Integer, Integer> numberByRank = Map.of(
                1, 1,
                2, 1,
                3, 4,
                4, 2,
                5, 2
        );

        // when
        lottos.generate(10);
        Map<Integer, Integer> result = lottos.countNumberOfWins(winningLotto, bonusNumber);

        // then
        assertThat(result).containsAllEntriesOf(numberByRank);
    }
}

class TestFixedNumbers implements NumberPicker {
    private int count = -1;

    @Override
    public List<Integer> pick() {
        count++;
        if (count % 5 == 0) {
            return List.of(1, 2, 3, 4, 5, count + 6);
        }
        if (count % 5 == 1) {
            return List.of(1, 2, 3, 4, 5, 45);
        }
        if (count % 5 == 2) {
            return List.of(1, 2, 3, 4, 5, count + 6);
        }
        if (count % 5 == 3) {
            return List.of(1, 2, 3, 4, count + 5, count + 6);
        }
        if (count % 5 == 4) {
            return List.of(1, 2, 3, count + 4, count + 5, count + 6);
        }

        return List.of(40, 41, 42, 43, 44, 45);
    }
}
