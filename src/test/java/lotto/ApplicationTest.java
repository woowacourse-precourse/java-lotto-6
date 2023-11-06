package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
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
    void 예외_테스트() {
        assertSimpleTest(() -> {
            runException("1000j");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 기능_테스트_2() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("10000", "3, 5, 12, 13, 34, 39", "22");
                    assertThat(output()).contains(
                            "10개를 구매했습니다.",
                            "[3, 5, 12, 13, 34, 39]",
                            "[13, 22, 28, 33, 35, 44]",
                            "[16, 30, 31, 36, 39, 42]",
                            "[3, 14, 21, 24, 39, 42]",
                            "[3, 6, 11, 23, 32, 35]",
                            "[9, 31, 35, 37, 38, 42]",
                            "[19, 21, 31, 35, 38, 40]",
                            "[7, 12, 13, 23, 24, 37]",
                            "[17, 19, 20, 21, 25, 44]",
                            "[2, 4, 5, 25, 27, 30]",
                            "3개 일치 (5,000원) - 0개",
                            "4개 일치 (50,000원) - 0개",
                            "5개 일치 (1,500,000원) - 0개",
                            "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
                            "6개 일치 (2,000,000,000원) - 1개",
                            "총 수익률은 20000000.0%입니다."
                    );
                },
                List.of(3, 5, 12, 13, 34, 39),
                List.of(13, 22, 28, 33, 35, 44),
                List.of(16, 30, 31, 36, 39, 42),
                List.of(3, 14, 21, 24, 39, 42),
                List.of(3, 6, 11, 23, 32, 35),
                List.of(9, 31, 35, 37, 38, 42),
                List.of(19, 21, 31, 35, 38, 40),
                List.of(7, 12, 13, 23, 24, 37),
                List.of(17, 19, 20, 21, 25, 44),
                List.of(2, 4, 5, 25, 27, 30)
        );
    }


    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
