package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import study.AssertionsStudy;

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
    void 기능_테스트2() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("10000", "10, 15, 21, 25, 33, 38", "28");
                    assertThat(output()).contains(
                            "10개를 구매했습니다.",
                            "[6, 8, 10, 20, 34, 37]",
                            "[8, 18, 23, 27, 36, 38]",
                            "[2, 14, 28, 30, 39, 45]",
                            "[4, 5, 9, 12, 18, 30]",
                            "[2, 14, 39, 42, 43, 44]",
                            "[12, 18, 21, 27, 38, 42]",
                            "[20, 21, 25, 33, 37, 39]",
                            "[1, 15, 27, 35, 37, 43]",
                            "[11, 30, 34, 37, 40, 45]",
                            "[1, 14, 22, 30, 36, 42]",
                            "3개 일치 (5,000원) - 1개",
                            "4개 일치 (50,000원) - 0개",
                            "5개 일치 (1,500,000원) - 0개",
                            "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
                            "6개 일치 (2,000,000,000원) - 0개",
                            "총 수익률은 50%입니다."
                    );
                },
                List.of(6, 8, 10, 20, 34, 37),
                List.of(8, 18, 23, 27, 36, 38),
                List.of(2, 14, 28, 30, 39, 45),
                List.of(4, 5, 9, 12, 18, 30),
                List.of(2, 14, 39, 42, 43, 44),
                List.of(12, 18, 21, 27, 38, 42),
                List.of(20, 21, 25, 33, 37, 39),
                List.of(1, 15, 27, 35, 37, 43),
                List.of(11, 30, 34, 37, 40, 45),
                List.of(1, 14, 22, 30, 36, 42)
        );
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() -> {
            runException("1000j");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
