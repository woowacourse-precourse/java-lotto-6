package lotto.errorTest;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.Application;
import lotto.view.ExceptionMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

public class ErrorTest extends NsTest {


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

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
