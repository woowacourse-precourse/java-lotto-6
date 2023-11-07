package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.Reward;
import lotto.dto.GameResultResponse;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottosTest {

    @DisplayName("한 로또가 당첨 번호와 전부 일치할 때 1등이 당첨된다.")
    @Test
    void matchSix(){
        GameResultResponse response = setUpLottos().match(
                Arrays.asList(1, 2, 3, 4, 5, 6), 7, 4000);
        Assertions.assertThat(response.getRewards().get(Reward.FIRST_REWARD)).isEqualTo(1);
        Assertions.assertThat(response.getProfit()).isEqualTo("50000000.0");
    }

    @DisplayName("3개 일치하는 로또가 1개 4개 일치하는 로또가 1개일때 5등과 4등이 당첨된다.")
    @Test
    void matchThreeAndFour(){
        GameResultResponse response = setUpLottos().match(
                Arrays.asList(1, 2, 3, 4, 13, 19), 7, 4000);
        Assertions.assertThat(response.getRewards().get(Reward.FIFTH_REWARD)).isEqualTo(1);
        Assertions.assertThat(response.getRewards().get(Reward.FOURTH_REWARD)).isEqualTo(1);
        Assertions.assertThat(response.getProfit()).isEqualTo("1375.0");
    }

    private static Lottos setUpLottos() {
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(Arrays.asList(1,2,3,4,5,6)));
        lottos.add(new Lotto(Arrays.asList(1,2,13,14,15,16)));
        lottos.add(new Lotto(Arrays.asList(1,2,23,24,25,26)));
        lottos.add(new Lotto(Arrays.asList(1,2,33,34,35,36)));
        return new Lottos(lottos);
    }
}
