package lotto.exceptionTest;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.Application;
import lotto.view.ExceptionMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

public class InputExceptionTest extends NsTest {


    @Test
    @DisplayName("구매 금액이 1000으로 나누어 지지 않을시 테스트")
    public void inputPurchaseAmountError(){
        assertSimpleTest(() -> {
            runException("1001");
            assertThat(output()).contains(ExceptionMessage.inputPurchaseAmountError.getErrorMessage());
        });
    }

    @Test
    @DisplayName("구매 금액 입력이 숫자가 아닌 문자가 들어 왔을시")
    public void inputPurchaseAmountNumberFormatError(){
        assertSimpleTest(() -> {
            runException("가");
            assertThat(output()).contains(ExceptionMessage.NumberFormatError.getErrorMessage());
        });
    }

    @Test
    @DisplayName("당첨 금액 입력시 6개가 넘는 혹은 넘지 않는 입력이 들어 왔을때")
    public void inputWinningNumberBigSizeError(){
        assertSimpleTest(() -> {
            runException("3000","1,2,3,4,5,6,7");
            assertThat(output()).contains(ExceptionMessage.inputWinningNumbersSizeError.getErrorMessage());
        });
    }
    @Test
    @DisplayName("당첨 금액 입력시 6개가 넘는 혹은 넘지 않는 입력이 들어 왔을때")
    public void inputWinningNumberSmallSizeError(){
        assertSimpleTest(() -> {
            runException("3000","1,2,3,4,5");
            assertThat(output()).contains(ExceptionMessage.inputWinningNumbersSizeError.getErrorMessage());
        });
    }

    @Test
    @DisplayName("당첨 금액 입력시 숫자가 아닌 문자형이 들어왔을때")
    public void inputWinningNumberFormatError(){
        assertSimpleTest(() -> {
            runException("3000","1,2,3,4,가,6");
            assertThat(output()).contains(ExceptionMessage.NumberFormatError.getErrorMessage());
        });
    }

    @Test
    @DisplayName("당첨 금액 입력시 숫자가 중복일때")
    public void inputWinningNumberDuplicationError(){
        assertSimpleTest(() -> {
            runException("3000","1,2,3,4,1,6");
            assertThat(output()).contains(ExceptionMessage.duplicationError.getErrorMessage());
        });
    }

    @Test
    @DisplayName("당첨 금액 입력 숫자중 45보다 큰 숫자가 있을때")
    public void inputWinningNumberBigRangeError(){
        assertSimpleTest(() -> {
            runException("3000","1,2,3,4,46,6");
            assertThat(output()).contains(ExceptionMessage.NumberRangeError.getErrorMessage());
        });
    }
    @Test
    @DisplayName("당첨 금액 입력 숫자중 0보다 작은 숫자가 있을때")
    public void inputWinningNumberSmallRangeError(){
        assertSimpleTest(() -> {
            runException("3000","1,2,3,4,0,6");
            assertThat(output()).contains(ExceptionMessage.NumberRangeError.getErrorMessage());
        });
    }

    @Test
    @DisplayName("보너스 금액 입력시 숫자가 아닌 문자형이 들어왔을때")
    public void inputBonusNumberFormatError(){
        assertSimpleTest(() -> {
            runException("3000","1,2,3,4,5,6" , "가");
            assertThat(output()).contains(ExceptionMessage.NumberFormatError.getErrorMessage());
        });
    }

    @Test
    @DisplayName("보너스 금액 입력시 당첨 금액 숫자중에 중복 숫자가 있을때")
    public void inputBonusNumberDuplicationError(){
        assertSimpleTest(() -> {
            runException("3000","1,2,3,4,5,6" , "1");
            assertThat(output()).contains(ExceptionMessage.duplicationError.getErrorMessage());
        });
    }
    @Test
    @DisplayName("보너스 금액 입력시 숫자중 45보다 큰 숫자가 있을때")
    public void inputBonusNumberBigRangeError(){
        assertSimpleTest(() -> {
            runException("3000","1,2,3,4,5,6", "46");
            assertThat(output()).contains(ExceptionMessage.NumberRangeError.getErrorMessage());
        });
    }
    @Test
    @DisplayName("보너스 금액 입력시 숫자중 0보다 작은 숫자가 있을때")
    public void inputBonusNumberSmallRangeError(){
        assertSimpleTest(() -> {
            runException("3000","1,2,3,4,5,6", "0");
            assertThat(output()).contains(ExceptionMessage.NumberRangeError.getErrorMessage());
        });
    }




    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
