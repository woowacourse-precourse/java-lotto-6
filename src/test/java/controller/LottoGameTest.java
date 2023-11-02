package controller;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.Application;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

public class LottoGameTest extends NsTest {
    private static final String ERROR_MESSAGE = "[ERROR]";

    @Test
    @DisplayName("입력값이 숫자가 아니라면 예외가 발생한다.")
    void is_Input_All_Digits(){
        assertSimpleTest(() -> {
            runException("10H0j");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    @DisplayName("입력값이 숫자가 아니라면 예외가 발생한다.")
    void is_Input_Remainder_Zero(){
        assertSimpleTest(() -> {
            runException("12300");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    @DisplayName("구입 금액을 입력받아 1000으로 나눈 결과를 lottoQuantity에 저장한다.")
    void initialize_LottoGame(){
        run("8000");
        assertThat(output()).contains("8");
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
