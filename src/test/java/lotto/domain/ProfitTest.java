package lotto.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class ProfitTest {

    @Test
    void calProfit() {
        Profit profit = new Profit();
        ArrayList<Integer> result = new ArrayList<>(Arrays.asList(0,0,0,1,1,1,1,1));
        double resultProfit = profit.CalProfit(100000,result);
        double resultCmp = 2031555000.0/100000;
        assertThat(resultProfit).isEqualTo(resultCmp*100);
    }
}