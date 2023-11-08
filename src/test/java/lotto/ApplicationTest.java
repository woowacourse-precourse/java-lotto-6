package lotto;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;
import static org.mockito.Mockito.mockStatic;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.Arrays;
import java.util.List;
import lotto.common.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

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

    @Test
    void 예외_테스트_잘못된_구입금액_단위() {
        assertSimpleTest(() -> {
                runException("14001");
                assertThat(output()).contains(ERROR_MESSAGE);
            }
        );

        assertSimpleTest(() -> {
                runException("14010");
                assertThat(output()).contains(ERROR_MESSAGE);
            }
        );

        assertSimpleTest(() -> {
                runException("14100");
                assertThat(output()).contains(ERROR_MESSAGE);
            }
        );
    }

    @Test
    void 예외_테스트_숫자가_아닌_구입금액() {
        assertSimpleTest(() -> {
            runException("1000j");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 정상_테스트_구입금액에_맞는_로또_개수() {
        assertSimpleTest(() -> {
            run("10000");
            assertThat(output()).contains("10개를 구매했습니다.");
        });

        assertSimpleTest(() -> {
            run("8000");
            assertThat(output()).contains("8개를 구매했습니다.");
        });
    }

    @DisplayName("당첨 번호 입력: 숫자가 아닌 경우 예외 처리")
    @Test
    void inputWinningNumbersNotNumeric() {
        assertSimpleTest(() -> {
            runException("8000", "1,2,3,4,5,a");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("당첨 번호 입력: 6자리가 아닌 경우 예외 처리")
    @Test
    void inputWinningNumbersOverSize() {
        assertSimpleTest(() -> {
            runException("8000", "1,2,3,4,5");
            assertThat(output()).contains(ERROR_MESSAGE);
        });

        assertSimpleTest(() -> {
            runException("8000", "1,2,3,4,5,6,7");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("당첨 번호 입력: 1~45에서 벗어난 숫자인 경우 예외 처리")
    @Test
    void inputWinningNumbersOutOfRange() {
        assertSimpleTest(() -> {
            runException("8000", "0,2,3,4,5,6");
            assertThat(output()).contains(ERROR_MESSAGE);
        });

        assertSimpleTest(() -> {
            runException("8000", "1,2,3,4,5,46");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("당첨 번호 입력: 중복된 숫자인 경우 예외 처리")
    @Test
    void inputWinningNumbersDuplicated() {
        assertSimpleTest(() -> {
            runException("8000", "1,2,3,4,5,5");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("당첨 번호 입력: 정상")
    @Test
    void inputWinningNumbers() {
        assertSimpleTest(() -> {
            run("8000", "1,2,3,4,5,6");
            assertThat(output()).contains("보너스 번호를 입력해 주세요.");
        });
    }

    @DisplayName("보너스 번호 입력: 숫자가 아닌 경우")
    @Test
    void inputBonusNumberNotNumeric() {
        assertSimpleTest(() -> {
            runException("8000", "1,2,3,4,5,6", "a");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("보너스 번호 입력: 1~45에서 벗어난 숫자인 경우 예외 처리")
    @Test
    void inputBonusNumberOutOfRange() {
        assertSimpleTest(() -> {
            runException("8000", "1,2,3,4,5,6", "0");
            assertThat(output()).contains(ERROR_MESSAGE);
        });

        assertSimpleTest(() -> {
            runException("8000", "1,2,3,4,5,6", "46");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("보너스 번호 입력: 정상")
    @Test
    void inputBonusNumber() {
        assertSimpleTest(() -> {
            run("8000", "1,2,3,4,5,6", "7");
            assertThat(output()).contains("당첨 통계");
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
