package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RateOfReturnTest extends NsTest {

    //given
    final int payment = 1000;
    final int[][] match = {{3,0},{2,1}};
    @DisplayName("총 수익률 계산 테스트.")
    @Test
    void RORsetRoRTest() {
        //when
        RateOfReturn rateOfReturn = new RateOfReturn(match, payment);
        //then
        assertThat(rateOfReturn.setROR()).isEqualTo(500.0);
    }

    @Override
    protected void runMain() {
    }
}
