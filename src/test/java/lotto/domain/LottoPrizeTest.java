package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class LottoPrizeTest {

    private LottoPrize lottoPrize;

    @BeforeEach
    void setUp() {
        lottoPrize = new LottoPrize();
    }

    @DisplayName("5개의 수가 일치했을 때 Map의 하나의 Key가 두개의 Value를 갖는다.")
    @Test
    void setMultipleValuesForKey() {
        Map<String, Integer> result = lottoPrize.doubleValue();
        Map<String, Integer> answer = new HashMap<>();
        answer.put("5Bonus", 0);
        answer.put("5NoBonus", 0);

        assertThat(result).isEqualTo(answer);
    }

    @DisplayName("당첨 볼 개수와 보너스 유무가 들어오면 Map에 저장한다.")
    @Test
    void putWinCountAndBonusInMap() {
        Map<String, Integer> result = lottoPrize.bonusValue(3, "NoBonus");
        Map<String, Integer> answer = new HashMap<>();
        answer.put("3NoBonus", 0);

        assertThat(result).isEqualTo(answer);
    }

    @DisplayName("로또 당첨 결과를 저장하는 이중 Map을 초기 설정한다.")
    @Test
    void initLottoPrize() {
        Map<Integer, Map<String, Integer>> result = lottoPrize.initLottoPrize();

        Map<Integer, Map<String, Integer>> answer = new HashMap<>();
        Map<String,Integer> innerMap = new HashMap<>();
        innerMap.put("3NoBonus", 0);
        answer.put(3, innerMap);

        innerMap = new HashMap<>();
        innerMap.put("4NoBonus", 0);
        answer.put(4, innerMap);

        innerMap = new HashMap<>();
        innerMap.put("5NoBonus", 0);
        innerMap.put("5Bonus", 0);
        answer.put(5, innerMap);

        innerMap = new HashMap<>();
        innerMap.put("6NoBonus", 0);
        answer.put(6, innerMap);

        assertThat(result).isEqualTo(answer);
    }
}