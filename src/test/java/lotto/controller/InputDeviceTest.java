package lotto.controller;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.Application;
import lotto.view.ErrorMessage;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

public class InputDeviceTest extends NsTest {

    @Test
    void 로또_구입_금액_1() {
        assertSimpleTest(() -> {
            runException("1000j");
            assertThat(output()).contains(ErrorMessage.INVALID_PURCHASE_PAYMENT.getMessage());
        });
    }

    @Test
    void 로또_구입_금액_2() {
        assertSimpleTest(() -> {
            runException("j");
            assertThat(output()).contains(ErrorMessage.INVALID_PURCHASE_PAYMENT.getMessage());
        });
    }

    @Test
    void 로또_구입_금액_3() {
        assertSimpleTest(() -> {
            runException("1000 ");
            assertThat(output()).contains(ErrorMessage.INVALID_PURCHASE_PAYMENT.getMessage());
        });

        assertSimpleTest(() -> {
            runException(" 1000");
            assertThat(output()).contains(ErrorMessage.INVALID_PURCHASE_PAYMENT.getMessage());
        });
    }

    @Test
    void 당첨번호_1() {
        assertSimpleTest(() -> {
            runException("1000", "1,2,3,4,ㅁ");
            assertThat(output()).contains(ErrorMessage.INVALID_WINNING_LOTTO.getMessage());
        });
    }

    @Test
    void 당첨번호_2() {
        assertSimpleTest(() -> {
            runException("1000", "1,2,3,4,5");
            assertThat(output()).contains(ErrorMessage.INVALID_WINNING_LOTTO.getMessage());
        });
    }

    @Test
    void 당첨번호_3() {
        assertSimpleTest(() -> {
            runException("1000", "1,2,3,4,5,46");
            assertThat(output()).contains(ErrorMessage.INVALID_WINNING_LOTTO.getMessage());
        });
    }

    @Test
    void 보너스번호_1(){
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        assertSimpleTest(() -> {
            runException("1000", "1,2,3,4,5,6", "a", "a");
            assertThat(output()).contains(
                    ErrorMessage.INVALID_BONUS_NUMBER.getMessage(),
                    ErrorMessage.INVALID_BONUS_NUMBER.getMessage()
            );
        });
    }

    @Test
    void 보너스번호_2(){
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        assertSimpleTest(() -> {
            runException("1000", "1,2,3,4,5,6", "46", "46");
            assertThat(output()).contains(
                    ErrorMessage.INVALID_BONUS_NUMBER.getMessage(),
                    ErrorMessage.INVALID_BONUS_NUMBER.getMessage()
            );
        });
    }

    @Test
    void 보너스번호_3(){
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        assertSimpleTest(() -> {
            runException("1000", "1,2,3,4,5,6", "6", "6");
            assertThat(output()).contains(
                    ErrorMessage.INVALID_BONUS_NUMBER.getMessage(),
                    ErrorMessage.INVALID_BONUS_NUMBER.getMessage()
            );
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
