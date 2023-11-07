package view;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static config.OutputMessage.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.Application;

public class ViewTest extends NsTest {

    private static final String ERROR_MESSAGE = "[ERROR]";

    @DisplayName("잘못된 금액 입력시 예외 발생후 금액 입력부터 재시작")
    @Test
    void inputWrongPayAndRestart() {
        assertSimpleTest(
                () -> {
                    run("1", "1000", "1,2,3,4,5,6", "7");
                    assertThat(output()).contains(
                            DEPOSIT.getMessage(),
                            ERROR_MESSAGE,
                            DEPOSIT.getMessage()
                    );
                }
        );
    }

    @DisplayName("당첨번호 개수 미달 입력시 예외 발생후 당첨번호 입력부터 재시작")
    @Test
    void inputWrongNumberCountAndRestart() {
        assertSimpleTest(
                () -> {
                    run("1000", "1,2,3,4,5", "1,2,3,4,5,6", "7");
                    assertThat(output()).contains(
                            WIN_NUMBER.getMessage(),
                            ERROR_MESSAGE,
                            WIN_NUMBER.getMessage()
                    );
                }
        );
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
