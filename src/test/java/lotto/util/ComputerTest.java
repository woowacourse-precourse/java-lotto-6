package lotto.util;

import lotto.domain.Rank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ComputerTest {
    @DisplayName("수익률을 계산한다.")
    @Test
    void computeProfit() {
        String purchase = "8000";
        Rank rank = new Rank(1, 0, 3, 0, 0);
        System.out.println("-------------결과---------------");
        System.out.println(rank);
        System.out.println("--------------------------------");
        System.out.println(Computer.computeProfit(purchase, rank));
    }
}
