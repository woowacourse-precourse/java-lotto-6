package test;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.Application;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static lotto.validation.InputValidation.validateInteger;
import static lotto.validation.InputValidation.validateThousand;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ExceptionTest extends NsTest {
    private static final String ERROR_MESSAGE_THOUSAND = "[ERROR] 1000원 단위로 입력해야 합니다.";
    private static final String ERROR_MESSAGE_NOT_NUMBER = "[ERROR] 구입 금액은 숫자여야 합니다.";

    @DisplayName("구입 금액이 숫자가 아니면 예외 처리 한다.")
    @Test
    void validateCostString(){
        assertThatThrownBy(() -> validateInteger("dfdf"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입 금액이 1000원으로 나누어 떨어지지 않는 다면 예외 처리 한다.")
    @Test
    void validateCostThousand(){
        assertThatThrownBy(() -> validateThousand("4848"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입 금액을 잘못 입력하면 오류메세지가 출력 되고 다시 입력을 받는다.")
    @Test
    void buyLottoByWrongCost(){
        assertSimpleTest(() -> {
            runException("thousand", "4800", "40000");
            assertThat(output()).contains(ERROR_MESSAGE_THOUSAND, ERROR_MESSAGE_NOT_NUMBER);
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
