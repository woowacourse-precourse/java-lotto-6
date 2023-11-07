package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
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

    @Nested
    class invalidWinningNumberTest {

        @DisplayName("공백이 포함된 당첨 금액에 대한 예외 테스트")
        @Test
        void invalidWinningNumbersTest1() {
            assertSimpleTest(() -> {
                runException("2000", "1,2,3 ,4,5,6");
                assertThat(output()).contains(ERROR_MESSAGE);
            });
        }

        @DisplayName("범위를 벗어난 숫자가 포함된 당첨 금액에 대한 예외 테스트")
        @Test
        void invalidWinningNumbersTest2() {
            assertSimpleTest(() -> {
                runException("2000", "1,2,3,4,5,61");
                assertThat(output()).contains(ERROR_MESSAGE);
            });
        }

        @DisplayName("6개의 숫자가 아닌 당첨 금액에 대한 예외 테스트")
        @Test
        void invalidWinningNumbersTest3() {
            assertSimpleTest(() -> {
                runException("2000", "1,2,3,4,5");
                assertThat(output()).contains(ERROR_MESSAGE);
            });
        }

        @DisplayName(",로 구분되지 않은 당첨 금액에 대한 예외 테스트")
        @Test
        void invalidWinningNumbersTest4() {
            assertSimpleTest(() -> {
                runException("2000", "1,2,3,4,5.6");
                assertThat(output()).contains(ERROR_MESSAGE);
            });
        }

        @DisplayName("잘못된 입력에 대한 재입력 테스트")
        @Test
        void invalidWinningNumbersTest5() {
            assertRandomUniqueNumbersInRangeTest(() -> {
                        run("2000", "1,2,3,4,5.6", "1,2,3,4,5,6", "7");
                        assertThat(output()).contains(ERROR_MESSAGE,
                                "6개 일치 (2,000,000,000원) - 1개",
                                "총 수익률은 100000000.0%입니다.");
                    },
                    List.of(1, 2, 3, 4, 5, 6),
                    List.of(3, 5, 11, 16, 32, 38)
            );
        }

        @DisplayName("숫자 아닌 값이 포함된 당첨 금액에 대한 예외 테스트")
        @Test
        void invalidWinningNumbersTest6() {
            assertSimpleTest(() -> {
                runException("2000", "1,a,3,4,5,6");
                assertThat(output()).contains(ERROR_MESSAGE);
            });
        }

        @DisplayName("음수가 포함된 당첨 금액에 대한 예외 테스트")
        @Test
        void invalidWinningNumbersTest7() {
            assertSimpleTest(() -> {
                runException("2000", "-1,2,3,4,5,6");
                assertThat(output()).contains(ERROR_MESSAGE);
            });
        }
    }

    @Nested
    class invalidBonusNumberTest {

        @DisplayName("숫자가 아닌 보너스 숫자에 대한 예외 테스트")
        @Test
        void invalidBonusNumberTest1() {
            assertSimpleTest(() -> {
                runException("2000", "1,2,3,4,5,6", "7a");
                assertThat(output()).contains(ERROR_MESSAGE);
            });
        }

        @DisplayName("범위를 벗어난 보너스 숫자에 대한 예외 테스트")
        @Test
        void invalidBonusNumberTest2() {
            assertSimpleTest(() -> {
                runException("2000", "1,2,3,4,5,6", "56");
                assertThat(output()).contains(ERROR_MESSAGE);
            });
        }

        @DisplayName("당첨 번호와 중복되는 보너스 숫자에 대한 예외 테스트")
        @Test
        void invalidBonusNumberTest3() {
            assertSimpleTest(() -> {
                runException("2000", "1,2,3,4,5,6", "5");
                assertThat(output()).contains(ERROR_MESSAGE);
            });
        }

        @DisplayName("음수 보너스 숫자에 대한 예외 테스트")
        @Test
        void invalidBonusNumberTest4() {
            assertSimpleTest(() -> {
                runException("2000", "1,2,3,4,5,6", "-5");
                assertThat(output()).contains(ERROR_MESSAGE);
            });
        }
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
