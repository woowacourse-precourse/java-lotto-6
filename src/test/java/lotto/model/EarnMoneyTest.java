package lotto.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.Map;


import java.util.HashMap;

public class EarnMoneyTest {
    @Test
    void testGetEarnMoney() {
        Map<String, Integer> result = new HashMap<>();
        result.put("three", 3);
        result.put("four", 1);
        result.put("five", 2);
        result.put("fiveBonus", 1);
        result.put("six", 0);
        
        Assertions.assertThat(EarnMoney.getEarnMoney(result)).isEqualTo(33065000);
    }
}
