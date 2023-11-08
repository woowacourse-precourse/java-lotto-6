package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

class LottoManagerTest extends NsTest {
    private static final String ERROR_MESSAGE = "[ERROR]";

    @Test
    void 기능_테스트() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("12000", "1,2,3,4,5,6", "7");
                    assertThat(output()).contains(
                            "12개를 구매했습니다.",
                            "[1, 2, 3, 4, 42, 43]",
                            "[3, 5, 11, 16, 32, 38]",
                            "[1, 2, 3, 4, 5, 6]",
                            "[1, 2, 3, 4, 5, 42]",
                            "[13, 14, 16, 38, 42, 45]",
                            "[1, 2, 3, 4, 5, 7]",
                            "[2, 13, 22, 32, 38, 45]",
                            "[1, 3, 5, 14, 22, 45]",
                            "[6, 7, 10, 14, 22, 40]",
                            "[23, 25, 27, 31, 32, 43]",
                            "[15, 18, 23, 26, 36, 45]",
                            "[8, 14, 15, 24, 27, 36]",
                            "3개 일치 (5,000원) - 1개",
                            "4개 일치 (50,000원) - 1개",
                            "5개 일치 (1,500,000원) - 1개",
                            "5개 일치, 보너스 볼 일치 (30,000,000원) - 1개",
                            "6개 일치 (2,000,000,000원) - 1개",
                            "총 수익률은 169296.25%입니다."
                    );
                },
                List.of(1, 2, 3, 4, 42, 43),
                List.of(3, 5, 11, 16, 32, 38),
                List.of(1, 2, 3, 4, 5, 6),
                List.of(1, 2, 3, 4, 5, 42),
                List.of(13, 14, 16, 38, 42, 45),
                List.of(1, 2, 3, 4, 5, 7),
                List.of(2, 13, 22, 32, 38, 45),
                List.of(1, 3, 5, 14, 22, 45),
                List.of(6, 7, 10, 14, 22, 40),
                List.of(23, 25, 27, 31, 32, 43),
                List.of(15, 18, 23, 26, 36, 45),
                List.of(8, 14, 15, 24, 27, 36)
        );
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() -> {
            runException("10hf!j");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
