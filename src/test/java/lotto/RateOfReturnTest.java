package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RateOfReturnTest extends NsTest {
    @DisplayName("총 수익률 계산 테스트.")
    @Test
    void RORRunningTest() {
        //given
        final int payment = 1000;
        final int[][] match = {{3,0},{2,1}};
        //when
        final RateOfReturn rateOfReturn = new RateOfReturn(match, payment);
        //then
        assertThat(rateOfReturn.setROR(payment)).isEqualTo(500.0);
    }

    @DisplayName("총상금 계산 테스트.")
    @Test
    void RORsetToTalRewordTest() {
        //given
        final int payment = 1000;
        final int[][] match = {{3,0},{2,1}};
        //when
        final RateOfReturn rateOfReturn = new RateOfReturn(match, payment);
        //then
        assertThat(rateOfReturn.setTotalReword()).isEqualTo(5000);
    }

    @DisplayName("총상금 계산 테스트.")
    @Test
    void RORprintReulstTest() {
        //given
        final int payment = 1000;
        final int[][] match = {{3,0},{2,1}};
        //when
        final RateOfReturn rateOfReturn = new RateOfReturn(match, payment);
        //then
        assertThat(output()).contains(
                "총 수익률은 500.0%입니다."
        );
    }


    @Override
    protected void runMain() {
    }
}
