package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static lotto.Calculater.*;

public class CalculaterTest {
    @DisplayName("3 ~ 5등 상금이 제대로 더해지는지 확인")
    @Test
    void calculatePrizeTest1(){
        HashMap<Integer, Integer> winHashTable = new HashMap<>();
        winHashTable.put(5,1);
        winHashTable.put(4,1);
        winHashTable.put(3,0);

        int totalSum = calculatePrize1(winHashTable);
        Assertions.assertThat(totalSum).isEqualTo(55000);
    }
    @DisplayName("1 ~ 2등 상금이 제대로 더해지는지 확인")
    @Test
    void calculatePrizeTest2(){
        HashMap<Integer, Integer> winHashTable = new HashMap<>();
        winHashTable.put(2,1);
        winHashTable.put(1,0);

        int totalSum = calculatePrize2(winHashTable);
        Assertions.assertThat(totalSum).isEqualTo(30000000);
    }

    @DisplayName("총 수익률 확인")
    @Test
    void changeToRateTest(){
        int totalMoney = 5000;
        int purchaseInput = 8000;

        double changeRate = changeToRate(totalMoney, purchaseInput);
        Assertions.assertThat(changeRate).isEqualTo(62.5);
    }
}
