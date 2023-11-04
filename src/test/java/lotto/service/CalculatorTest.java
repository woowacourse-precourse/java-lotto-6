package lotto.service;

import static org.assertj.core.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;
import lotto.model.win.Rank;
import org.junit.jupiter.api.Test;

/**
 *     - 1등: 6개 번호 일치 / 2,000,000,000원
 *     - 2등: 5개 번호 + 보너스 번호 일치 / 30,000,000원
 *     - 3등: 5개 번호 일치 / 1,500,000원
 *     - 4등: 4개 번호 일치 / 50,000원
 *     - 5등: 3개 번호 일치 / 5,000원
 */
public class CalculatorTest {
    Calculator calculator = new Calculator();

    @Test
    void 계산기_테스트() {
        //given
        Map<Rank, Integer> map = new HashMap<>();
        map.put(Rank.FIFTH, 1);
        int pay = 1000;

        double value = calculator.calculateRateOfReturn(map, pay);

        assertThat(value).isEqualTo((5000-pay)*100/pay);
    }
}
