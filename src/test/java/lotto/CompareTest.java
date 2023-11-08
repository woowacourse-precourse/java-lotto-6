package lotto;

import static lotto.domain.CompareNumber.CompareNumbers;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.domain.Ranking;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CompareTest {

    @DisplayName("로또 번호와 당첨 번호를 비교하여 1등이여야 한다.")
    @Test
    void compareNumbersFir() {

        Map<Ranking, Integer> result = new HashMap<>();
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(List.of(1,2,3,4,5,6)));
        Lotto winer_lotto = new Lotto(List.of(1,2,3,4,5,6));

        result = CompareNumbers(lottos, winer_lotto, 7);

        assertThat(result.get(Ranking.FIRST)).isEqualTo(1);

    }

    @DisplayName("로또 번호와 당첨 번호를 비교하여 2등이여야 한다.")
    @Test
    void compareNumbersSec() {

        Map<Ranking, Integer> result = new HashMap<>();
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(List.of(1,2,3,4,5,6)));
        Lotto winer_lotto = new Lotto(List.of(1,2,3,4,5,7));

        result = CompareNumbers(lottos, winer_lotto, 6);

        assertThat(result.get(Ranking.SECOND)).isEqualTo(1);

    }

    @DisplayName("로또 번호와 당첨 번호를 비교하여 3등이여야 한다.")
    @Test
    void compareNumbersThi() {

        Map<Ranking, Integer> result = new HashMap<>();
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(List.of(1,2,3,4,5,6)));
        Lotto winer_lotto = new Lotto(List.of(1,2,3,4,5,8));

        result = CompareNumbers(lottos, winer_lotto, 7);

        assertThat(result.get(Ranking.THIRD)).isEqualTo(1);

    }

    @DisplayName("로또 번호와 당첨 번호를 비교하여 4등이여야 한다.")
    @Test
    void compareNumbersFor() {

        Map<Ranking, Integer> result = new HashMap<>();
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(List.of(1,2,3,4,5,6)));
        Lotto winer_lotto = new Lotto(List.of(1,2,3,4,7,8));

        result = CompareNumbers(lottos, winer_lotto, 7);

        assertThat(result.get(Ranking.FOURTH)).isEqualTo(1);

    }

    @DisplayName("로또 번호와 당첨 번호를 비교하여 5등이여야 한다.")
    @Test
    void compareNumbersFif() {

        Map<Ranking, Integer> result = new HashMap<>();
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(List.of(1,2,3,4,5,6)));
        Lotto winer_lotto = new Lotto(List.of(1,2,3,7,8,9));

        result = CompareNumbers(lottos, winer_lotto, 7);

        assertThat(result.get(Ranking.FIFTH)).isEqualTo(1);

    }
}
