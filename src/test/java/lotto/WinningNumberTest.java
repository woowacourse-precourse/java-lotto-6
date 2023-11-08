package lotto;

import lotto.domain.WinningNumber;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


class WinningNumberTest {
    final List<Integer> prizeNumber = List.of(2, 3, 4, 5, 6, 7);

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
        boolean validated4 = WinningNumber.validatePrizeNumber("1,2,5,4,45,45");

        assertThat(validated1).isFalse();
        assertThat(validated2).isFalse();
        assertThat(validated3).isFalse();
        assertThat(validated4).isFalse();
    }

    @Test
    void 보너스번호_개수_불일치_테스트(){
        boolean validated1 = WinningNumber.validateBonusNumber(prizeNumber, "1,2");
        boolean validated2 = WinningNumber.validateBonusNumber(prizeNumber, "1,2,3");

        assertThat(validated1).isFalse();
        assertThat(validated2).isFalse();
    }

    @Test
    void 보너스번호_정수_검증_테스트(){
        boolean validated1 = WinningNumber.validateBonusNumber(prizeNumber, "1.1");
        boolean validated2 = WinningNumber.validateBonusNumber(prizeNumber, "-1.1");
        boolean validated3 = WinningNumber.validateBonusNumber(prizeNumber, "보너스번호");

        assertThat(validated1).isFalse();
        assertThat(validated2).isFalse();
        assertThat(validated3).isFalse();
    }

    @Test
    void 보너스번호_범위_테스트(){
        boolean validated1 = WinningNumber.validateBonusNumber(prizeNumber, "0");
        boolean validated2 = WinningNumber.validateBonusNumber(prizeNumber, "1");
        boolean validated3 = WinningNumber.validateBonusNumber(prizeNumber, "45");
        boolean validated4 = WinningNumber.validateBonusNumber(prizeNumber, "46");


        assertThat(validated1).isFalse();
        assertThat(validated2).isTrue();
        assertThat(validated3).isTrue();
        assertThat(validated4).isFalse();
    }

    @Test
    void 보너스번호_중복_테스트(){
        boolean validated1 = WinningNumber.validateBonusNumber(prizeNumber, "2");
        boolean validated2 = WinningNumber.validateBonusNumber(prizeNumber, "3");
        boolean validated3 = WinningNumber.validateBonusNumber(prizeNumber, "4");
        boolean validated4 = WinningNumber.validateBonusNumber(prizeNumber, "5");
        boolean validated5 = WinningNumber.validateBonusNumber(prizeNumber, "6");
        boolean validated6 = WinningNumber.validateBonusNumber(prizeNumber, "7");

        assertThat(validated1).isFalse();
        assertThat(validated2).isFalse();
        assertThat(validated3).isFalse();
        assertThat(validated4).isFalse();
        assertThat(validated5).isFalse();
        assertThat(validated6).isFalse();
    }

}