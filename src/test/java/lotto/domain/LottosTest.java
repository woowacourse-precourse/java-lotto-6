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
        lottos.generate(count);

        // then
        assertThat(lottos.getOrderedList()).hasSize(count);
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

    @DisplayName("오름차순으로 정렬된 로또 구매 내역을 반환한다.")
    @Test
    void getOrderedListTest() {
        // given
        Lottos lottos = new Lottos(new TestFixedNumbers());
        List<List<Integer>> expected = List.of(
                List.of(1, 2, 3, 4, 5, 6),
                List.of(1, 2, 3, 4, 5, 45),
                List.of(1, 2, 3, 4, 5, 8)
        );

        // when
        lottos.generate(3);
        List<List<Integer>> orderedList = lottos.getOrderedList();

        // then
        assertThat(orderedList)
                .hasSize(expected.size())
                .containsAll(expected);
    }
}

class TestFixedNumbers implements NumberPicker {
    private int count = -1;

    @Override
    public List<Integer> pick() {
        count++;
        if (count % 5 == 0) {
            return List.of(4, 1, count + 6, 5, 2, 3);
        }
        if (count % 5 == 1) {
            return List.of(4, 1, 45, 5, 2, 3);
        }
        if (count % 5 == 2) {
            return List.of(4, 1, count + 6, 5, 2, 3);
        }
        if (count % 5 == 3) {
            return List.of(4, 1, count + 6, count + 5, 2, 3);
        }
        if (count % 5 == 4) {
            return List.of(count + 4, 1, count + 6, count + 5, 2, 3);
        }

        return List.of(40, 41, 42, 43, 44, 45);
    }
}
