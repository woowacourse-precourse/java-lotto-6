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
    @DisplayName("정상적으로 기능이 동작한다.")
    void 정상적으로_기능이_동작한다() {
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
    @DisplayName("구매 금액 입력값이 숫자가 아닌 경우 예외를 반환한다.")
    void 구매_금액_입력값이_숫자가_아닌_경우_예외를_반환한다() {
        assertSimpleTest(() -> {
            runException("1000j");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    @DisplayName("구매 금액 입력값이 0보다 같거나 작을 경우 예외를 반환한다.")
    void 구매_금액_입력값이_0보다_같거나_작을_경우_예외를_반환한다() {
        assertSimpleTest(() -> {
            runException("0");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    @DisplayName("구매 금액 입력값이 1000원 단위가 아닌 경우 예외를 반환한다.")
    void 구매_금액_입력값이_1000원_단위가_아닌_경우_예외를_반환한다() {
        assertSimpleTest(() -> {
            runException("1001");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    @DisplayName("당첨 번호 입력값이 숫자가 아닌 경우 예외를 반환한다.")
    void 당첨_번호_입력값이_숫자가_아닌_경우_예외를_반환한다() {
        assertSimpleTest(() -> {
            runException("1000", "1,2,3,4,5,6j", "7");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    @DisplayName("당첨 번호 입력값이 6개 보다 적을 경우 예외를 반환한다.")
    void 당첨_번호_입력값이_6개_보다_적을_경우_예외를_반환한다() {
        assertSimpleTest(() -> {
            runException("1000", "1,2,3,4,5", "7");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    @DisplayName("당첨 번호 입력값이 6개 보다 많을 경우 예외를 반환한다.")
    void 당첨_번호_입력값이_6개_보다_많을_경우_예외를_반환한다() {
        assertSimpleTest(() -> {
            runException("1000", "1,2,3,4,5,6,7", "8");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    @DisplayName("당첨 번호 입력값이 1보다 작을 경우 예외를 반환한다.")
    void 당첨_번호_입력값이_1보다_작을_경우_예외를_반환한다() {
        assertSimpleTest(() -> {
            runException("1000", "0,2,3,4,5,6", "7");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    @DisplayName("당첨 번호 입력값이 45보다 클 경우 예외를 반환한다.")
    void 당첨_번호_입력값이_45보다_클_경우_예외를_반환한다() {
        assertSimpleTest(() -> {
            runException("1000", "1,2,3,4,5,46", "7");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    @DisplayName("보너스 번호 입력값이 숫자가 아닌 경우 예외를 반환한다.")
    void 보너스_번호_입력값이_숫자가_아닌_경우_예외를_반환한다() {
        assertSimpleTest(() -> {
            runException("1000", "1,2,3,4,5,6", "7j");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    @DisplayName("보너스 번호 입력값이 1보다 작을 경우 예외를 반환한다.")
    void 보너스_번호_입력값이_1보다_작을_경우_예외를_반환한다() {
        assertSimpleTest(() -> {
            runException("1000", "1,2,3,4,5,6", "0");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    @DisplayName("보너스 번호 입력값이 45보다 클 경우 예외를 반환한다.")
    void 보너스_번호_입력값이_45보다_클_경우_예외를_반환한다() {
        assertSimpleTest(() -> {
            runException("1000", "1,2,3,4,5,6", "46");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    @DisplayName("보너스 번호 입력값이 당첨 번호에 포함되는 경우 예외를 반환한다.")
    void 보너스_번호_입력값이_당첨_번호에_포함되는_경우_예외를_반환한다() {
        assertSimpleTest(() -> {
            runException("1000", "1,2,3,4,5,6", "1");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
