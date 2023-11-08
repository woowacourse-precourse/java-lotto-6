package lotto.serviceTest;

import lotto.domain.Lotto;
import lotto.service.LottoStatistics;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

public class LottoStatisticsTest {

    @DisplayName("승률예상하기")
    @Test
    void testCalculateWinRate() {
        int userPurchase = 8;
        List<Lotto> userLottos = new ArrayList<>(List.of(new Lotto(List.of(8, 21, 23, 41, 42, 43)),
                new Lotto(List.of(3, 5, 11, 16, 32, 38)),
                new Lotto(List.of(7, 11, 16, 35, 36, 44)),
                new Lotto(List.of(1, 8, 11, 31, 41, 42)),
                new Lotto(List.of(13, 14, 16, 38, 42, 45)),
                new Lotto(List.of(7, 11, 30, 40, 42, 43)),
                new Lotto(List.of(2, 13, 22, 32, 38, 45)),
                new Lotto(List.of(1, 3, 5, 14, 22, 45))));

        Map<Lotto, Integer> winNumber = new HashMap<>();
        winNumber.put(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 7);

        String winnRate = new LottoStatistics(userPurchase, userLottos, winNumber).calculateWinRate();

        assertEquals(winnRate, "62.5");
    }

    @DisplayName("구입금액과 상금으로 승률계산하기")
    @Test
    void testCalculateWinningPercentage() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        LottoStatistics lottoStatistics = new LottoStatistics();
        int userPurchase = 2;
        long totalPrize = 200000000;
        Method method = LottoStatistics.class.getDeclaredMethod("calculateWinningPercentage", int.class, long.class);
        method.setAccessible(true);
        assertThat(method.invoke(lottoStatistics, userPurchase, totalPrize)).isEqualTo("10000000");
    }

    @DisplayName("소수점 밑에 자리가 존재할때 마지막 0을 제외한 숫자 출력")
    @Test
    void testFormatDecimal() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        LottoStatistics  lottoStatistics = new LottoStatistics();
        double winRate = 23.40;
        Method method = LottoStatistics.class.getDeclaredMethod("formatDecimal",double.class);
        method.setAccessible(true);
        assertThat(method.invoke(lottoStatistics, winRate)).isEqualTo("23.4");
    }
}
