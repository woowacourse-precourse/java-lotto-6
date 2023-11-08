package lotto.app.collaboration.dto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.app.collaboration.Lotto;
import lotto.app.collaboration.PrizeLottos;
import lotto.app.collaboration.enums.Prize;
import org.junit.jupiter.api.Test;

class PrizeLottosTest {

    @Test
    void getMessageCountOfPrizeLottosBy로_해당등수의_당첨로또안내메시지받을수있다() {
        Map<Prize, List<PlayerLotto>> lottosWithPrize = new HashMap<>();
        lottosWithPrize.put(Prize.SECOND, List.of(new PlayerLotto(Lotto.make(() -> List.of(1, 2, 3, 4, 5, 6)))));
        PrizeLottos prizeLottos = new PrizeLottos(lottosWithPrize);

        String expected1 = "5개 일치, 보너스 볼 일치 (30,000,000원) - 1개";
        String expected2 = "6개 일치 (2,000,000,000원) - 0개";
        String actual1 = prizeLottos.getMessageCountOfPrizeLottosBy(Prize.SECOND);
        String actual2 = prizeLottos.getMessageCountOfPrizeLottosBy(Prize.FIRST);

        assertThat(actual1).isEqualTo(expected1);
        assertThat(actual2).isEqualTo(expected2);
    }

    @Test
    void calculateTotalPrizeMoney로_해당인원의_토탈상금을얻을수있다() {
        Map<Prize, List<PlayerLotto>> lottosWithPrize = new HashMap<>();
        lottosWithPrize.put(Prize.SECOND, List.of(new PlayerLotto(Lotto.make(() -> List.of(1, 2, 3, 4, 5, 6)))));
        PrizeLottos prizeLottos = new PrizeLottos(lottosWithPrize);

        long expected = 30_000_000L;
        long actual = prizeLottos.calculateTotalPrizeMoney();

        assertThat(actual).isEqualTo(expected);
    }

}