package lotto;

import lotto.domain.WinningNumber;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


class WinningNumberTest {
    @Test
    void 당첨번호_개수_불일치_테스트(){
        boolean validatedLessThan6 = WinningNumber.validatePrizeNumber("1,2,3,4,5");
        boolean validatedGreaterThan6 = WinningNumber.validatePrizeNumber("1,2,3,4,5,6,7");

        assertThat(validatedLessThan6).isFalse();
        assertThat(validatedGreaterThan6).isFalse();
    }

    @Test
    void 당첨번호_정수_검증_테스트(){
        boolean validated1 = WinningNumber.validatePrizeNumber("1,a,2,3,4,5");
        boolean validated2 = WinningNumber.validatePrizeNumber("1,1.7,2,3,4,5");
        boolean validated3 = WinningNumber.validatePrizeNumber("1,2,3,4,5,-1.78");

        assertThat(validated1).isFalse();
        assertThat(validated2).isFalse();
        assertThat(validated3).isFalse();
    }

    @Test
    void 당첨번호_범위_검증_테스트(){
        boolean validated1 = WinningNumber.validatePrizeNumber("1,1132,2,3,4,5");
        boolean validated2 = WinningNumber.validatePrizeNumber("1,0,2,3,4,5");
        boolean validated3 = WinningNumber.validatePrizeNumber("1,2,3,4,5,46");

        assertThat(validated1).isFalse();
        assertThat(validated2).isFalse();
        assertThat(validated3).isFalse();
    }

    @Test
    void 당첨번호_중복_검증_테스트(){
        boolean validated1 = WinningNumber.validatePrizeNumber("1,5,2,3,4,5");
        boolean validated2 = WinningNumber.validatePrizeNumber("1,2,3,4,5,1");
        boolean validated3 = WinningNumber.validatePrizeNumber("1,2,45,4,5,45");

        assertThat(validated1).isFalse();
        assertThat(validated2).isFalse();
        assertThat(validated3).isFalse();
    }



}