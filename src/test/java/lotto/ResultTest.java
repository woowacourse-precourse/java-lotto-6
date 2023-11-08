package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.List;
import lotto.model.Result;
import lotto.policy.WinConditionPolicy;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ResultTest {

    @DisplayName("5등 2번, 1등 1번 당첨에 따른 수익을 반환한다.")
    @Test
    void returnWinningProfits() {
        //given
        List<WinConditionPolicy> winResult = new ArrayList<>();
        winResult.add(WinConditionPolicy.FIFTH_PLACE);
        winResult.add(WinConditionPolicy.FIRST_PLACE);
        winResult.add(WinConditionPolicy.FIFTH_PLACE);
        Result result = Result.of(winResult);

        //when
        long profit = (long) result.getTotalWinProfit();

        //then
        assertThat(profit).isEqualTo(2000010000);
    }
}
