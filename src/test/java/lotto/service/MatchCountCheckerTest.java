package lotto.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import java.util.List;
import lotto.config.LottoConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MatchCountCheckerTest {
    MatchCountChecker matchCountChecker = new MatchCountChecker();

    @DisplayName("상금 액수별 로또 개수 확인")
    @Test
    public void checkLottoByReward() {
        HashMap<Integer, List<Integer>> matchNumberByLotto = new HashMap<>() {{
            put(0, List.of(6, 0));
            put(1, List.of(0, 1));
            put(2, List.of(5, 1));
        }};

        HashMap<String, Integer> result = new HashMap<>(){{
           put(LottoConfig.FIRST_PRIZE_REWARD, 1);
           put(LottoConfig.SECOND_PRIZE_REWARD, 1);
           put(LottoConfig.THIRD_PRIZE_REWARD, 0);
           put(LottoConfig.FOURTH_PRIZE_REWARD, 0);
           put(LottoConfig.FIFTH_PRIZE_REWARD, 0);
        }};

        assertThat(matchCountChecker.countLottoByPrize(matchNumberByLotto)).isEqualTo(result);
    }
}