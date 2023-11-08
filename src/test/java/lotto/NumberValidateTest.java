package lotto;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import domain.NumberValidate;
import org.junit.jupiter.api.Test;


public class NumberValidateTest {

    NumberValidate amountValidate = new NumberValidate();

    @Test
    void 금액_숫자_외_문자_입력_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> amountValidate.validateAmount("3000d"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 숫자_1000_미만_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> amountValidate.validateAmount("400"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 금액_단위_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> amountValidate.validateAmount("1200"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
}
