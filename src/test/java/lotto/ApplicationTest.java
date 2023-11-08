package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

class ApplicationTest extends NsTest {
    private static final String ERROR_MESSAGE = "[ERROR]";

    @Test
    void 기능_테스트() {
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


    @DisplayName("로또 구입 금액이 숫자가 아닐 경우 예외 발생")
    @Test
    void 예산입력테스트0() {
        assertSimpleTest(() -> {
            runException("1000j");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("로또 구입 금액이 1000원 미만일 경우 예외 발생")
    @Test
    void 예산입력테스트1() {
        assertSimpleTest(() -> {
            runException("900");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }
    @DisplayName("로또 구입 금액이 음수일 경우 예외 발생")
    @Test
    void 예산입력테스트2() {
        assertSimpleTest(() -> {
            runException("-2");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }
    @DisplayName("로또 구입 금액이 1000 단위가 아닐 경우 예외 발생")
    @Test
    void 예산입력테스트3() {
        assertSimpleTest(() -> {
            runException("1001");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }


    @DisplayName("정답로또가 중복된 숫자를  포함하는 경우")
    @Test
    void 정답로또입력테스트1() {
        assertSimpleTest(() -> {
            runException("1000","1,1,3,4,5,6");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }
    @DisplayName("정답로또가 잘못된 범위를  포함하는 경우")
    @Test
    void 정답로또입력테스트2() {
        assertSimpleTest(() -> {
            runException("1000","1,46,3,4,5,6");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("정답로또가 숫자가 아닌 경우")
    @Test
    void 정답로또입력테스트3() {
        assertSimpleTest(() -> {
            runException("1000","a");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("보너스 번호가 숫자가 아닌 경우")
    @Test
    void 보너스번호입력테스트1() {
        assertSimpleTest(() -> {
            runException("1000","1,2,3,4,5,6","a");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }
    @DisplayName("보너스 번호가 범위에 벗어난 경우")
    @Test
    void 보너스번호입력테스트2() {
        assertSimpleTest(() -> {
            runException("1000","1,2,3,4,5,6","123");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }
    @DisplayName("보너스 번호가 범위에 벗어난 경우2")
    @Test
    void 보너스번호입력테스트2_1() {
        assertSimpleTest(() -> {
            runException("1000","1,2,3,4,5,6","-1");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }
    @DisplayName("보너스 번호가 정답 로또에 포함된 경우")
    @Test
    void 보너스번호입력테스트3() {
        assertSimpleTest(() -> {
            runException("1000","1,2,3,4,5,6","6");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
