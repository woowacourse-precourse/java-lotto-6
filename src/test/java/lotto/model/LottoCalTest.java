package lotto.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoCalTest {
    Map<Integer, Integer> result;

    @Test
    @DisplayName("당첨 개수 초기화")
    public void prizeCountResetTest() {
        //given
        result = new HashMap<>();
        result.put(3, 0);
        result.put(4, 0);
        result.put(5, 0);
        result.put(0, 0);
        result.put(6, 0);
        //when
        LottoCal lottoCal = new LottoCal();
        //then
        Assertions.assertThat(lottoCal.getPrizeCount()).isEqualTo(result);
    }

    @Test
    @DisplayName("등수 확인 테스트")
    public void prizeCountTest() {
        result = new HashMap<>();
        result.put(3, 0);
        result.put(4, 1);
        result.put(5, 0);
        result.put(0, 0);
        result.put(6, 0);
        //when
        LottoCal lottoCal = new LottoCal();
        List<Integer> testLotto = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        List<Integer> userLotto = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 8, 9));
        int bonusNumber = 8;
        //then
        lottoCal.count(testLotto, userLotto, bonusNumber);
        Assertions.assertThat(lottoCal.getPrizeCount()).isEqualTo(result);
    }
}
