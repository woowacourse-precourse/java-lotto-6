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

    @Test
    void 구매금액_입력_예외_테스트() {
        // 1. 빈 값을 입력한 경우
        assertSimpleTest(() -> {
            runException(" ");
            assertThat(output()).contains(ERROR_MESSAGE);
        });

        // 2. 숫자가 아닌 값을 입력한 경우
        assertSimpleTest(() -> {
            runException("100j");
            assertThat(output()).contains(ERROR_MESSAGE);
        });

        // 3. 1,000 보다 작은 값을 입력한 경우
        assertSimpleTest(() -> {
            runException("560");
            assertThat(output()).contains(ERROR_MESSAGE);
        });

        // 4. 1,000으로 나누어지지 않는 값을 입력한 경우
        assertSimpleTest(() -> {
            runException("1200");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 당첨번호_입력_예외_테스트() {
        // 1. 빈 값을 입력한 경우
        assertSimpleTest(() -> {
            runException("1000", " ");
            assertThat(output()).contains(ERROR_MESSAGE);
        });

        // 2. 숫자가 아닌 값을 입력한 경우
        assertSimpleTest(() -> {
            runException("1000", "100j");
            assertThat(output()).contains(ERROR_MESSAGE);
        });

        // 3. 쉼표와 숫자 사이에 공백을 입력한 경우
        assertSimpleTest(() -> {
            runException("1000", "1, 2, 3, 4, 5, 6");
            assertThat(output()).contains(ERROR_MESSAGE);
        });

        // 4. 1~45 범위를 벗어난 숫자를 입력한 경우
        assertSimpleTest(() -> {
            runException("1000", "1,2,3,4,5,46");
            assertThat(output()).contains(ERROR_MESSAGE);
        });

        // 5. 당첨번호를 6개 미만으로 입력한 경우
        assertSimpleTest(() -> {
            runException("1000", "1,2,3,4,5");
            assertThat(output()).contains(ERROR_MESSAGE);
        });

        // 6. 당첨번호를 6개를 초과하여 입력한 경우
        assertSimpleTest(() -> {
            runException("1000", "1,2,3,4,5,6,7");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 보너스_번호_입력_예외_테스트() {
        // 1. 빈 값을 입력한 경우
        assertSimpleTest(() -> {
            runException("1000", "1,2,3,4,5,6", " ");
            assertThat(output()).contains(ERROR_MESSAGE);
        });

        // 2. 숫자가 아닌 값을 입력한 경우
        assertSimpleTest(() -> {
            runException("1000", "1,2,3,4,5,6", "1000j");
            assertThat(output()).contains(ERROR_MESSAGE);
        });

        // 3. 1~45 범위를 벗어난 숫자를 입력한 경우
        assertSimpleTest(() -> {
            runException("1000", "1,2,3,4,5,6", "46");
            assertThat(output()).contains(ERROR_MESSAGE);
        });

        // 4. 당첨 번호와 중복된 숫자를 입력한 경우
        assertSimpleTest(() -> {
            runException("1000", "1,2,3,4,5,6", "6");
            assertThat(output()).contains(ERROR_MESSAGE);
        });

    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
