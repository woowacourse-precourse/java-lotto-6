package lotto.application;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.Application;
import lotto.constraints.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

public class LottoControllerTest extends NsTest {

    @DisplayName("구입 금액이 올바르지 않을 경우 예외가 발생한다.")
    @ParameterizedTest
    @MethodSource("exceptionInputLessThen1000")
    void exceptionInputLessThen1000(int input) {
        assertSimpleTest(() -> {
            runException(String.valueOf(input));
            assertThat(output()).contains(ErrorMessage.INVALID_MONEY.getMessage());
        });
    }

    private static int[] exceptionInputLessThen1000() {
        return new int[]{999, 500, 0};
    }

    @DisplayName("구입 금액이 1000원 단위가 아닐 경우 예외가 발생한다.")
    @ParameterizedTest
    @MethodSource("exceptionInputNotMultipleOf1000")
    void exceptionInputNotMultipleOf1000(int input) {
        assertSimpleTest(() -> {
            runException(String.valueOf(input));
            assertThat(output()).contains(ErrorMessage.NOT_MULTIPLE_PER_PRICE.getMessage());
        });
    }

    private static int[] exceptionInputNotMultipleOf1000() {
        return new int[]{1500, 2222, 3800};
    }

    @DisplayName("당첨 번호가 6개가 아닐 경우 예외가 발생한다.")
    @Test
    void exceptionInputNotSixNumbers() {
        assertSimpleTest(() -> {
            runException("1000", "1,2,3,4,5", "6");
            assertThat(output()).contains(ErrorMessage.OVER_LOTTO_SIZE.getMessage());
        });
    }

    @DisplayName("당첨 번호가 1 ~ 45 사이의 숫자가 아닐 경우 예외가 발생한다.")
    @Test
    void exceptionInputNotInRange() {
        assertSimpleTest(() -> {
            runException("1000", "1,2,3,4,5,46", "6");
            assertThat(output()).contains(ErrorMessage.OUT_OF_RANGE.getMessage());
        });
    }

    @DisplayName("당첨 번호에 보너스 번호가 이미 있을 경우 예외가 발생한다.")
    @Test
    void exceptionInputBonusNumberAlreadyExist() {
        assertSimpleTest(() -> {
            runException("1000", "1,2,3,4,5,6", "6");
            assertThat(output()).contains(ErrorMessage.DUPLICATE_NUMBER.getMessage());
        });
    }

    @DisplayName("게임이 정상적으로 수행된다.")
    @Test
    void gameSuccessTest() {
        assertRandomUniqueNumbersInRangeTest(() -> {
                    run("2000", "1,2,3,4,5,6", "7");
                    assertThat(output()).contains(
                            "2개를 구매했습니다.",
                            "[1, 2, 3, 4, 5, 6]",
                            "[3, 5, 11, 16, 32, 38]",
                            "3개 일치 (5,000원) - 0개",
                            "4개 일치 (50,000원) - 0개",
                            "5개 일치 (1,500,000원) - 0개",
                            "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
                            "6개 일치 (2,000,000,000원) - 1개",
                            "총 수익률은 100000000.0%입니다."
                    );
                },
                List.of(1, 2, 3, 4, 5, 6),
                List.of(3, 5, 11, 16, 32, 38)
        );
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
