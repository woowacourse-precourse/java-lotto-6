package lotto;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import org.junit.jupiter.api.Test;

public class ApplicationTest2 extends NsTest {
    @Test
    void exampleTest1() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("2000", "1,2,3,4,5,6", "45");
                    assertThat(output()).contains(
                            "2개를 구매했습니다.",
                            "[1, 2, 3, 4, 5, 43]",
                            "[1, 2, 3, 4, 5, 45]",
                            "3개 일치 (5,000원) - 0개",
                            "4개 일치 (50,000원) - 0개",
                            "5개 일치 (1,500,000원) - 1개",
                            "5개 일치, 보너스 볼 일치 (30,000,000원) - 1개",
                            "6개 일치 (2,000,000,000원) - 0개"
                    );
                },
                List.of(1, 2, 3, 4, 5, 43),
                List.of(1, 2, 3, 4, 5, 45)
        );
    }

    @Test
    void exampleTest2() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("4000", "1,2,3,5,6,9", "24");
                    assertThat(output()).contains(
                            "4개를 구매했습니다.",
                            "[1, 3, 5, 6, 9, 24]",
                            "[2, 4, 6, 8, 10, 12]",
                            "[3, 6, 9, 12, 15, 18]",
                            "[4, 8, 12, 16, 20, 24]",
                            "3개 일치 (5,000원) - 1개",
                            "4개 일치 (50,000원) - 0개",
                            "5개 일치 (1,500,000원) - 0개",
                            "5개 일치, 보너스 볼 일치 (30,000,000원) - 1개",
                            "6개 일치 (2,000,000,000원) - 0개"
                    );
                },
                List.of(1, 3, 5, 6, 9, 24),
                List.of(2, 4, 6, 8, 10, 12),
                List.of(3, 6, 9, 12, 15, 18),
                List.of(4, 8, 12, 16, 20, 24)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
