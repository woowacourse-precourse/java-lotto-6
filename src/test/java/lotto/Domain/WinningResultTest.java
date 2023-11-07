package lotto.Domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningResultTest {

    @Test
    @DisplayName("각 등수의 로또가 한 개씩 당첨 되었을 때의 수익은 모든 상금의 합과 같다. ")
    void getIncome() {
        //given
        Map<Rank, Integer> result = new HashMap<>();
        double sum = 0d;
        for (Rank rank : Rank.values()) {
            result.put(rank, 1);
            sum += rank.getPrizeMoney();
        }

        //when
        WinningResult winningResult = new WinningResult(result);

        //then
        Assertions.assertThat(winningResult.getIncome()).isEqualTo(sum);

    }
}