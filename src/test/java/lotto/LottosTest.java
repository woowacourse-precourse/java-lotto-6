package lotto;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LottosTest {

    private static final int START_RANGE = 1;
    private static final int END_RANGE = 45;
    private static final int LOTTO_NUMBER_DIGITS = 6;

    @DisplayName("발급한 로또의 개수를 잘 반환하는지 확인한다.")
    @Test
    void checkSize() {
        int expected = 5;
        List<Lotto> lotto = new ArrayList<>();
        for (int i = 0; i < expected; i++) {
            lotto.add(
                    new Lotto(new ArrayList<>(pickUniqueNumbersInRange(START_RANGE, END_RANGE, LOTTO_NUMBER_DIGITS))));
        }
        Lottos lottos = new Lottos(lotto);
        assertThat(lottos.size()).isEqualTo(expected);
    }

    @DisplayName("입력받은 인덱스의 Lotto 객체를 잘 반환하는지 확인한다.")
    @ParameterizedTest
    @CsvSource({"13", "14", "15", "16", "17", "18"})
    void checkGetIndexLotto(int number) {

        List<Lotto> lotto = new ArrayList<>();
        lotto.add(new Lotto(new ArrayList<>(List.of(1, 2, 3, 4, 5, 6))));
        lotto.add(new Lotto(new ArrayList<>(List.of(7, 8, 9, 10, 11, 12))));
        lotto.add(new Lotto(new ArrayList<>(List.of(13, 14, 15, 16, 17, 18))));

        Lottos lottos = new Lottos(lotto);

        assertThat(lottos.getIndexLotto(0).contains(number)).isFalse();
        assertThat(lottos.getIndexLotto(1).contains(number)).isFalse();
        assertThat(lottos.getIndexLotto(2).contains(number)).isTrue();
    }

    @DisplayName("당첨 등수와 그 개수를 맞게 반환하는지 확인한다.")
    @Test
    void checkCountMatches() {
        Map<Integer, Integer> expected = new HashMap<>();
        expected.put(0, 2);
        expected.put(5, 1);
        expected.put(4, 0);
        expected.put(3, 1);
        expected.put(2, 1);
        expected.put(1, 1);

        Lotto winnings = new Lotto(new ArrayList<>(List.of(1, 2, 3, 4, 5, 6)));
        int bonusNumber = 7;

        List<Lotto> lotto = new ArrayList<>();
        lotto.add(new Lotto(new ArrayList<>(List.of(7, 8, 9, 10, 11, 12))));
        lotto.add(new Lotto(new ArrayList<>(List.of(13, 14, 15, 16, 17, 18))));
        lotto.add(new Lotto(new ArrayList<>(List.of(1, 2, 3, 7, 8, 9))));
        lotto.add(new Lotto(new ArrayList<>(List.of(1, 2, 3, 4, 5, 8))));
        lotto.add(new Lotto(new ArrayList<>(List.of(1, 2, 3, 4, 5, 7))));
        lotto.add(new Lotto(new ArrayList<>(List.of(1, 2, 3, 4, 5, 6))));
        Lottos lottos = new Lottos(lotto);

        assertThat(lottos.countMatches(winnings, bonusNumber)).isEqualTo(expected);
    }

}