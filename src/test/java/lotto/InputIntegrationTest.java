package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

public class InputIntegrationTest extends NsTest {

    private static final String ERROR_MESSAGE = "[ERROR]";

    @DisplayName("잘못된 구입 금액을 입력했을 때 예외 메시지를 출력하고, 재 입력한다.")
    @Test
    void inputWrongPurchaseAmount() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("1200", "asd", "300", "1000", "1,2,3,4,5,6", "7");
                    assertThat(output()).contains(
                            ERROR_MESSAGE,
                            ERROR_MESSAGE,
                            ERROR_MESSAGE,
                            "1개를 구매했습니다."
                    );
                },
                List.of(8, 21, 23, 41, 42, 43)
        );
    }

    @DisplayName("잘못된 당첨 번호를 입력했을 때 예외가 발생하고, 재 입력한다.")
    @Test
    void inputWrongWinningNumber() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("1000", "1,2,3,4,4,6", "0,1,2,3,4,6", "asd,2,3,4,5,6", "1,2,3,4,5,6,7","1,2,3,4,5,6", "7");
                    assertThat(output()).contains(
                            "1개를 구매했습니다.",
                            ERROR_MESSAGE,
                            ERROR_MESSAGE,
                            ERROR_MESSAGE,
                            ERROR_MESSAGE
                    );
                },
                List.of(8, 21, 23, 41, 42, 43)
        );
    }

    @DisplayName("잘못된 보너스 번호를 입력했을 때 예외가 발생하고, 재 입력한다.")
    @Test
    void inputWrongBonusNumber() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("1000", "1,2,3,4,5,6", "1", "a", "46", "7");
                    assertThat(output()).contains(
                            "1개를 구매했습니다.",
                            ERROR_MESSAGE,
                            ERROR_MESSAGE,
                            ERROR_MESSAGE,
                            ERROR_MESSAGE
                    );
                },
                List.of(8, 21, 23, 41, 42, 43)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
