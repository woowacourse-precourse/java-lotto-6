package lotto.util;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.model.Lotto;
import lotto.model.Prize;
import lotto.model.WinningLotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoUtilTest {
    @DisplayName("당첨 번호와 구입한 로또들을 비교하여 각 Prize별 당첨 횟수를 계산해 Map으로 반환한다.")
    @Test
    void calculatePrizeCount() {
        List<Lotto> lottos = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(1, 2, 3, 4, 5, 7)),
                new Lotto(List.of(1, 2, 3, 4, 8, 9))
        );
        WinningLotto winningLotto = new WinningLotto(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 7);
        Map<Prize, Integer> result = LottoUtil.calculatePrizeCounts(lottos, winningLotto);
        Map<Prize, Integer> expected = new HashMap<>();
        expected.put(Prize.of(6, false), 1);
        expected.put(Prize.of(5, true), 1);
        expected.put(Prize.of(5, false), 0);
        expected.put(Prize.of(4, false), 1);
        expected.put(Prize.of(3, false), 0);
        assertThat(result).isEqualTo(expected);
    }
}
