package lotto.model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.LinkedHashMap;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottosTest {

    private static final String BONUS_NUMBER = "7";

    @DisplayName("당첨 점수를 계산하여, 각각의 상금 정보를 담은 객체와 당첨된 복권 수 Map 을 반환한다.")
    @Test
    void calculateAllPrices() {
        Lottos lottos = new Lottos(List.of(
            new Lotto(List.of(1, 2, 3, 4, 5, 6)),
            new Lotto(List.of(2, 3, 4, 5, 6, 7)),
            new Lotto(List.of(2, 3, 4, 5, 6, 8)),
            new Lotto(List.of(3, 4, 5, 6, 7, 8)),
            new Lotto(List.of(4, 5, 6, 7, 8, 9)),
            new Lotto(List.of(5, 6, 7, 8, 9, 10))
        ));
        Lotto anwser = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        assertEquals(lottos.calculateScore(
            anwser,
            new Bonus(BONUS_NUMBER, anwser.getNumbers())),
            new LinkedHashMap<>() {{
                put(Price.FIFTH, 1);
                put(Price.FORTH, 1);
                put(Price.THIRD, 1);
                put(Price.SECOND, 1);
                put(Price.FIRST, 1);
            }});
    }

    @DisplayName("구매 금액 8000 원 대비 5 등 당첨금을 계산하여 수익률 62.5 값을 반환한다.")
    @Test
    void calculateRateOfFifth() {
        Lottos lottos =  new Lottos(List.of(
            new Lotto(List.of(1,2,3,4,5,6))
        ));
        Float profit = lottos.calculateProfit(new LinkedHashMap<>() {{
            put(Price.FIFTH, 1);
            put(Price.FORTH, 0);
            put(Price.THIRD, 0);
            put(Price.SECOND, 0);
            put(Price.FIRST, 0);
        }}, 8000);
        assertEquals(profit, 62.5F);
    }
}