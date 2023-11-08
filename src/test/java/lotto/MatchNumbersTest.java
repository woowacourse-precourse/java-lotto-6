package lotto;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MatchNumbersTest extends ApplicationTest{

    @DisplayName("생성된 로또 오름차 출력 확인")
    @Test
    void sortTest() {
        assertRandomUniqueNumbersInRangeTest(
            () -> {
                run("1000", "1,2,3,41,42,43", "7");
                assertThat(output()).contains(
                    "1개를 구매했습니다.",
                    "[1, 2, 3, 4, 5, 6]",
                    "3개 일치 (5,000원) - 1개",
                    "4개 일치 (50,000원) - 0개",
                    "5개 일치 (1,500,000원) - 0개",
                    "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
                    "6개 일치 (2,000,000,000원) - 0개",
                    "총 수익률은 500.0%입니다."
                );
            },
            List.of(5, 6, 4, 3, 1, 2)
        );
    }

    @DisplayName("불일치 테스트")
    @Test
    void matchZeroTest() {
        assertRandomUniqueNumbersInRangeTest(
            () -> {
                run("3000", "1,4,6,25,28,32", "43");
                assertThat(output()).contains(
                    "3개를 구매했습니다.",
                    "[1, 2, 3, 41, 42, 43]",
                    "[4, 5, 6, 7, 21, 42]",
                    "[2, 3, 5, 36, 44, 45]",
                    "3개 일치 (5,000원) - 0개",
                    "4개 일치 (50,000원) - 0개",
                    "5개 일치 (1,500,000원) - 0개",
                    "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
                    "6개 일치 (2,000,000,000원) - 0개",
                    "총 수익률은 0.0%입니다."
                );
            },
            List.of(43, 42, 41, 3, 1, 2),
            List.of(4, 5, 6, 42, 7, 21),
            List.of(2, 5, 45, 44, 3, 36)
        );
    }

    @DisplayName("3개 일치 테스트")
    @Test
    void matchThreeTest() {
        assertRandomUniqueNumbersInRangeTest(
            () -> {
                run("3000", "1,2,3,4,5,6", "45");
                assertThat(output()).contains(
                    "3개를 구매했습니다.",
                    "[1, 2, 3, 41, 42, 43]",
                    "[4, 5, 6, 7, 21, 42]",
                    "[2, 3, 5, 36, 44, 45]",
                    "3개 일치 (5,000원) - 3개",
                    "4개 일치 (50,000원) - 0개",
                    "5개 일치 (1,500,000원) - 0개",
                    "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
                    "6개 일치 (2,000,000,000원) - 0개",
                    "총 수익률은 500.0%입니다."
                );
            },
            List.of(43, 42, 41, 3, 1, 2),
            List.of(4, 5, 6, 42, 7, 21),
            List.of(2, 5, 45, 44, 3, 36)
        );
    }

    @DisplayName("4개 일치 테스트")
    @Test
    void matchFourTest() {
        assertRandomUniqueNumbersInRangeTest(
            () -> {
                run("3000", "1,2,3,4,5,6", "45");
                assertThat(output()).contains(
                    "3개를 구매했습니다.",
                    "[1, 2, 3, 4, 42, 43]",
                    "[4, 5, 6, 7, 21, 42]",
                    "[2, 3, 5, 36, 44, 45]",
                    "3개 일치 (5,000원) - 2개",
                    "4개 일치 (50,000원) - 1개",
                    "5개 일치 (1,500,000원) - 0개",
                    "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
                    "6개 일치 (2,000,000,000원) - 0개",
                    "총 수익률은 2000.0%입니다."
                );
            },
            List.of(43, 42, 4, 3, 1, 2),
            List.of(4, 5, 6, 42, 7, 21),
            List.of(2, 5, 45, 44, 3, 36)
        );
    }

    @DisplayName("5개 일치 테스트")
    @Test
    void matchFiveTest() {
        assertRandomUniqueNumbersInRangeTest(
            () -> {
                run("3000", "1,2,3,4,5,6", "45");
                assertThat(output()).contains(
                    "3개를 구매했습니다.",
                    "[1, 2, 3, 4, 5, 43]",
                    "[4, 5, 6, 7, 21, 42]",
                    "[2, 3, 5, 36, 44, 45]",
                    "3개 일치 (5,000원) - 2개",
                    "4개 일치 (50,000원) - 0개",
                    "5개 일치 (1,500,000원) - 1개",
                    "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
                    "6개 일치 (2,000,000,000원) - 0개",
                    "총 수익률은 50333.3%입니다."
                );
            },
            List.of(43, 5, 4, 3, 1, 2),
            List.of(4, 5, 6, 42, 7, 21),
            List.of(2, 5, 45, 44, 3, 36)
        );
    }

    @DisplayName("5개일치, 보너스 볼 일치 테스트 ")
    @Test
    void matchBonusTest() {
        assertRandomUniqueNumbersInRangeTest(
            () -> {
                run("1000", "1,2,3,4,5,45", "6");
                assertThat(output()).contains(
                    "1개를 구매했습니다.",
                    "[1, 2, 3, 4, 5, 6]",
                    "3개 일치 (5,000원) - 0개",
                    "4개 일치 (50,000원) - 0개",
                    "5개 일치 (1,500,000원) - 0개",
                    "5개 일치, 보너스 볼 일치 (30,000,000원) - 1개",
                    "6개 일치 (2,000,000,000원) - 0개",
                    "총 수익률은 3000000.0%입니다."
                );
            },
            List.of(5, 6, 4, 3, 1, 2)
        );
    }

    @DisplayName("6개 일치 테스트")
    @Test
    void matchSixTest() {
        assertRandomUniqueNumbersInRangeTest(
            () -> {
                run("3000", "1,2,3,4,5,6", "45");
                assertThat(output()).contains(
                    "3개를 구매했습니다.",
                    "[1, 2, 3, 4, 5, 6]",
                    "[4, 5, 6, 7, 21, 42]",
                    "[2, 3, 5, 36, 44, 45]",
                    "3개 일치 (5,000원) - 2개",
                    "4개 일치 (50,000원) - 0개",
                    "5개 일치 (1,500,000원) - 0개",
                    "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
                    "6개 일치 (2,000,000,000원) - 1개",
                    "총 수익률은 66667000.0%입니다."
                );
            },
            List.of(1, 2, 3, 4, 5, 6),
            List.of(4, 5, 6, 42, 7, 21),
            List.of(2, 5, 45, 44, 3, 36)
        );
    }

}
