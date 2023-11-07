package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.junit.jupiter.api.Test;

class RefereeTest {
    private static final int BONUS = 10;
    private static final int PURCHASE_AMOUNT = 2000;
    private static final float RATE_OF_RETURN = 1500250.0f;

    private final Referee referee = new Referee();
    private HashMap<Integer, Integer> result;
    private final List<Lotto> lottos = new ArrayList<>();
    private final Lotto winningLotto = new Lotto(List.of(6, 1, 5, 2, 4, 3));

    RefereeTest() {
        lottos.add(new Lotto(List.of(1, 2, 3, 7, 8, 9)));
        lottos.add(new Lotto(List.of(1, 2, 3, 4, 5, 10)));
    }

    @Test
    void 구매한_로또들과_입력한_당첨_번호랑_보너스_번호_비교하기() {
        referee.compare(lottos, winningLotto, BONUS);

        result = makeDefaultResult();
        result.put(2, 1);
        result.put(5, 1);

        assertThat(referee.getResult()).isEqualTo(result);
    }

    @Test
    void 결과_가져오기() {
        result = makeDefaultResult();

        assertThat(referee.getResult()).isEqualTo(result);
    }

    @Test
    void 수익률_가져오기() {
        referee.compare(lottos, winningLotto, BONUS);

        assertThat(referee.getRateOfReturn(PURCHASE_AMOUNT)).isEqualTo(RATE_OF_RETURN);
    }

    private HashMap<Integer, Integer> makeDefaultResult() {
        HashMap<Integer, Integer> result = new HashMap<>();
        for (int i = 1; i < 6; i++) {
            result.put(i, 0);
        }
        return result;
    }
}