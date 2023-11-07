package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ResultTest {

    @DisplayName("총 수익률을 계산하여 반환한다.")
    @Test
    void getProfitability(){
        //given
        List<Integer> statistics = new ArrayList<>();
        int quantity = 8;
        statistics.addAll(List.of(0,0,0,1,0,0,0,0)); //5등 1개

        Result result = new Result(statistics);

        //when
        double profitability = result.getProfitability(quantity);

        //then
        Assertions.assertThat(profitability).isEqualTo(62.5);
    }

}