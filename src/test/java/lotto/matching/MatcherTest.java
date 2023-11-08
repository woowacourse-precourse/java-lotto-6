package lotto.matching;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import lotto.result.Grade;
import lotto.Lotto;
import lotto.result.Result;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MatcherTest {

    private final Matcher matcher = new Matcher();

    @DisplayName("당첨 로또와 구매한 로또를 비교해 결과를 출력할 수 있다.")
    @Test
    void matchWinning() {
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonus = 7;
        Lotto firstLotto = new Lotto(List.of(1, 2, 3, 30, 40, 41));
        Lotto secondLotto = new Lotto(List.of(10, 14, 21, 26, 33, 42));
        Lotto thirdLotto = new Lotto(List.of(1, 2, 3, 4, 5, 7));
        Lotto fourthLotto = new Lotto(List.of(7, 4, 2, 3, 5, 40));
        List<Lotto> lottoList = new ArrayList<>(List.of(firstLotto, secondLotto, thirdLotto, fourthLotto));

        Result result = matcher.matchWinning(winningLotto, lottoList, bonus);
        Map<Grade, Integer> map = result.getMap();

        Assertions.assertThat(map.get(Grade.FIFTH)).isEqualTo(1);
        Assertions.assertThat(map.get(Grade.FOURTH)).isEqualTo(1);
        Assertions.assertThat(map.get(Grade.SECOND)).isEqualTo(1);
    }
}