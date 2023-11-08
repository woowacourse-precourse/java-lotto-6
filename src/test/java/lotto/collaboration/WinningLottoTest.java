package lotto.collaboration;

import static lotto.app.collaboration.enums.Prize.FIFTH;
import static lotto.app.collaboration.enums.Prize.FIRST;
import static lotto.app.collaboration.enums.Prize.FOURTH;
import static lotto.app.collaboration.enums.Prize.LOST;
import static lotto.app.collaboration.enums.Prize.SECOND;
import static lotto.app.collaboration.enums.Prize.THIRD;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.app.collaboration.Lotto;
import lotto.app.collaboration.PrizeLottos;
import lotto.app.collaboration.WinningLotto;
import lotto.app.collaboration.dto.PlayerLotto;
import lotto.app.collaboration.enums.Prize;
import org.junit.jupiter.api.Test;

class WinningLottoTest {

    @Test
    void matchNumbers로_구매한로또들의_최종상금을_확인할수있다() {
        Lotto lotto1 = Lotto.make(() -> List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto2 = Lotto.make(() -> List.of(2, 3, 4, 5, 6, 45));
        Lotto lotto3 = Lotto.make(() -> List.of(2, 3, 4, 5, 6, 7));
        Lotto lotto4 = Lotto.make(() -> List.of(3, 4, 5, 6, 7, 8));
        Lotto lotto5 = Lotto.make(() -> List.of(4, 5, 6, 7, 8, 9));
        Lotto lotto6 = Lotto.make(() -> List.of(5, 6, 7, 8, 9, 10));
        PlayerLotto p1 = new PlayerLotto(lotto1);
        PlayerLotto p2 = new PlayerLotto(lotto2);
        PlayerLotto p3 = new PlayerLotto(lotto3);
        PlayerLotto p4 = new PlayerLotto(lotto4);
        PlayerLotto p5 = new PlayerLotto(lotto5);
        PlayerLotto p6 = new PlayerLotto(lotto6);
        List<PlayerLotto> buyLottos = List.of(p1, p2, p3, p4, p5, p6);

        WinningLotto winningLotto = new WinningLotto(List.of(1, 2, 3, 4, 5, 6), 45);
        PrizeLottos actual = winningLotto.matchNumbers(buyLottos);
        Map<Prize, List<PlayerLotto>> expected = new HashMap<>();
        expected.put(FIRST, List.of(p1));
        expected.put(SECOND, List.of(p2));
        expected.put(THIRD, List.of(p3));
        expected.put(FOURTH, List.of(p4));
        expected.put(FIFTH, List.of(p5));
        expected.put(LOST, List.of(p6));
        long expectedTotalPrizeMoney = 0L;
        for (Prize prize : Prize.prizeByRank()) {
            expectedTotalPrizeMoney += prize.money() * expected.getOrDefault(prize, List.of()).size();
        }

        assertThat(actual.calculateTotalPrizeMoney()).isEqualTo(expectedTotalPrizeMoney);
    }

}