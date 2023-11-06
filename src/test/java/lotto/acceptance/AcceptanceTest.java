package lotto.acceptance;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static lotto.error.ExceptionCode.EXCEED_MAX_TRY;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import lotto.Application;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AcceptanceTest extends NsTest {

    private static final String ERROR_PREFIX = "[ERROR]";

    @DisplayName("정상 시나리오를 확인한다.")
    @Test
    void goodScenario() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("8000", "1,2,3,4,5,6", "7");
                    assertThat(output()).contains(
                            "8개를 구매했습니다.",
                            "[8, 21, 23, 41, 42, 43]",
                            "[3, 5, 11, 16, 32, 38]",
                            "[7, 11, 16, 35, 36, 44]",
                            "[1, 8, 11, 31, 41, 42]",
                            "[13, 14, 16, 38, 42, 45]",
                            "[7, 11, 30, 40, 42, 43]",
                            "[2, 13, 22, 32, 38, 45]",
                            "[1, 3, 5, 14, 22, 45]",
                            "3개 일치 (5,000원) - 1개",
                            "4개 일치 (50,000원) - 0개",
                            "5개 일치 (1,500,000원) - 0개",
                            "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
                            "6개 일치 (2,000,000,000원) - 0개",
                            "총 수익률은 62.5%입니다."
                    );
                },
                List.of(8, 21, 23, 41, 42, 43),
                List.of(3, 5, 11, 16, 32, 38),
                List.of(7, 11, 16, 35, 36, 44),
                List.of(1, 8, 11, 31, 41, 42),
                List.of(13, 14, 16, 38, 42, 45),
                List.of(7, 11, 30, 40, 42, 43),
                List.of(2, 13, 22, 32, 38, 45),
                List.of(1, 3, 5, 14, 22, 45)
        );
    }

    @DisplayName("예외 발생 시 재입력을 받는다.")
    @Test
    void canTryAgain() {
        assertSimpleTest(() -> {
            runException("1000j", "1000", "1,2,3,4,5,6", "7");
            assertThat(output()).contains(ERROR_PREFIX, "1개를 구매했습니다.");
        });
    }

    @DisplayName("재입력은 예외가 발생한 부분부터 다시 받는다.")
    @Test
    void canTryAgainWinnerNumbers() {
        assertSimpleTest(() -> {
            runException("1000", "1,2,3,4,56", "7", "1,2,3,4,5,6", "7");
            assertThat(output()).contains(ERROR_PREFIX, "총 수익률은");
        });
    }

    @DisplayName("5번 이상 예외 발생 시 프로그램을 종료한다.")
    @Test
    void tryAgainOver5Times() {
        assertSimpleTest(() -> {
            runException("1000j", "1000j", "1000j", "1000j", "1000j", "1000j");
            assertThat(output()).contains(ERROR_PREFIX, EXCEED_MAX_TRY.getMessage());
        });
    }

    @DisplayName("구매 금액이 1,000원 단위가 아니면 예외를 던진다.")
    @Test
    void notThousandUnit() {
        assertSimpleTest(() -> {
            runException("1001");
            assertThat(output()).contains(ERROR_PREFIX);
        });
    }

    @DisplayName("구매 금액이 100,000원을 넘으면 예외를 던진다.")
    @Test
    void exceedAmountToBuyLotto() {
        assertSimpleTest(() -> {
            runException("101000");
            assertThat(output()).contains(ERROR_PREFIX);
        });
    }

    @DisplayName("입력한 당첨 번호가 6개가 아니면 예외를 던진다.")
    @Test
    void not6WinnerNumbers() {
        assertSimpleTest(() -> {
            runException("1000", "1,2,3,4,5,6,7", "7");
            assertThat(output()).contains(ERROR_PREFIX);
        });
    }

    @DisplayName("당첨 번호가 1~45가 아니면 예외를 던진다.")
    @Test
    void invalidWinnerNumberRange() {
        assertSimpleTest(() -> {
            runException("1000", "1,2,3,4,5,66", "8");
            assertThat(output()).contains(ERROR_PREFIX);
        });
    }

    @DisplayName("입력의 포맷이 틀린 경우 예외를 던진다")
    @Test
    void invalidFormatWinnerNumbers() {
        assertSimpleTest(() -> {
            runException("1000", "1.2.3.4.5.6j", "7,8");
            assertThat(output()).contains(ERROR_PREFIX);
        });
    }

    @DisplayName("보너스 번호가 여러개면 에외를 던진다.")
    @Test
    void multipleBonusNumber() {
        assertSimpleTest(() -> {
            runException("1000", "1,2,3,4,5,6", "7,8");
            assertThat(output()).contains(ERROR_PREFIX);
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
