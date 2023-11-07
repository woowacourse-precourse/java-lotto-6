package lotto.model;

import static lotto.util.Constant.LOTTO_PRICE;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.Map;
import java.util.HashMap;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ResultTest {

    @DisplayName("결과에 따른 수익률을 계산한다.")
    @Test
    void calculateProfitRate() {

        int amount = 4;
        HashMap<Rank, Integer> rankMap = new HashMap<>();
        rankMap.put(Rank.FIRST, 1);
        rankMap.put(Rank.SECOND, 1);
        Result result = new Result(rankMap);
        double total = (double) (Rank.FIRST.getPrize() + Rank.SECOND.getPrize()) /(amount * LOTTO_PRICE) * 100;
        double profitRate = result.calculateProfitRate(4);


        assertThat(profitRate).isEqualTo(total);
    }

}
