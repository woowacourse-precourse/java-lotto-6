package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

public class RankTest extends NsTest {

    @DisplayName("모든 등수가 포함된 결과")
    @Test
    void RankAllTest() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("6000", "1,2,3,4,5,6", "7");
                    assertThat(output()).contains(
                            "6개를 구매했습니다.",
                            "[1, 2, 3, 4, 5, 6]",
                            "[1, 2, 3, 4, 5, 7]",
                            "[1, 2, 3, 4, 5, 8]",
                            "[1, 2, 3, 4, 8, 9]",
                            "[1, 2, 3, 8, 9, 10]",
                            "[1, 2, 8, 9, 10, 11]",
                            "3개 일치 (5,000원) - 1개",
                            "4개 일치 (50,000원) - 1개",
                            "5개 일치 (1,500,000원) - 1개",
                            "5개 일치, 보너스 볼 일치 (30,000,000원) - 1개",
                            "6개 일치 (2,000,000,000원) - 1개",
                            "총 수익률은 3.385925E7%입니다."
                    );
                },
                List.of(1, 2, 3, 4, 5, 6),
                List.of(1, 2, 3, 4, 5, 7),
                List.of(1, 2, 3, 4, 5, 8),
                List.of(1, 2, 3, 4, 8, 9),
                List.of(1, 2, 3, 8, 9, 10),
                List.of(1, 2, 8, 9, 10, 11)
        );
    }

    @DisplayName("1등이 포함된 결과")
    @Test
    void RankFirstRankTest() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("2000", "1,2,3,4,5,6", "7");
                    assertThat(output()).contains(
                            "2개를 구매했습니다.",
                            "[1, 2, 3, 4, 5, 6]",
                            "[1, 2, 8, 9, 10, 11]",
                            "3개 일치 (5,000원) - 0개",
                            "4개 일치 (50,000원) - 0개",
                            "5개 일치 (1,500,000원) - 0개",
                            "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
                            "6개 일치 (2,000,000,000원) - 1개",
                            "총 수익률은 1.0E8%입니다."
                    );
                },
                List.of(1, 2, 3, 4, 5, 6),
                List.of(1, 2, 8, 9, 10, 11)
        );
    }

    @DisplayName("2등이 포함된 결과")
    @Test
    void RankSecondRankTest() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("2000", "1,2,3,4,5,6", "7");
                    assertThat(output()).contains(
                            "2개를 구매했습니다.",
                            "[1, 2, 3, 4, 5, 7]",
                            "[1, 2, 8, 9, 10, 11]",
                            "3개 일치 (5,000원) - 0개",
                            "4개 일치 (50,000원) - 0개",
                            "5개 일치 (1,500,000원) - 0개",
                            "5개 일치, 보너스 볼 일치 (30,000,000원) - 1개",
                            "6개 일치 (2,000,000,000원) - 0개",
                            "총 수익률은 1500000.0%입니다."
                    );
                },
                List.of(1, 2, 3, 4, 5, 7),
                List.of(1, 2, 8, 9, 10, 11)
        );
    }

    @DisplayName("3등이 포함된 결과")
    @Test
    void RankThirdRankTest() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("2000", "1,2,3,4,5,6", "7");
                    assertThat(output()).contains(
                            "2개를 구매했습니다.",
                            "[1, 2, 3, 4, 5, 8]",
                            "[1, 2, 8, 9, 10, 11]",
                            "3개 일치 (5,000원) - 0개",
                            "4개 일치 (50,000원) - 0개",
                            "5개 일치 (1,500,000원) - 1개",
                            "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
                            "6개 일치 (2,000,000,000원) - 0개",
                            "총 수익률은 75000.0%입니다."
                    );
                },
                List.of(1, 2, 3, 4, 5, 8),
                List.of(1, 2, 8, 9, 10, 11)
        );
    }

    @DisplayName("4등이 포함된 결과")
    @Test
    void RankFourthRankTest() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("2000", "1,2,3,4,5,6", "7");
                    assertThat(output()).contains(
                            "2개를 구매했습니다.",
                            "[1, 2, 3, 4, 8, 9]",
                            "[1, 2, 8, 9, 10, 11]",
                            "3개 일치 (5,000원) - 0개",
                            "4개 일치 (50,000원) - 1개",
                            "5개 일치 (1,500,000원) - 0개",
                            "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
                            "6개 일치 (2,000,000,000원) - 0개",
                            "총 수익률은 2500.0%입니다."
                    );
                },
                List.of(1, 2, 3, 4, 8, 9),
                List.of(1, 2, 8, 9, 10, 11)
        );
    }

    @DisplayName("4등이 포함된 결과")
    @Test
    void RankFifthRankTest() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("2000", "1,2,3,4,5,6", "7");
                    assertThat(output()).contains(
                            "2개를 구매했습니다.",
                            "[1, 2, 3, 8, 9, 10]",
                            "[1, 2, 8, 9, 10, 11]",
                            "3개 일치 (5,000원) - 1개",
                            "4개 일치 (50,000원) - 0개",
                            "5개 일치 (1,500,000원) - 0개",
                            "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
                            "6개 일치 (2,000,000,000원) - 0개",
                            "총 수익률은 250.0%입니다."
                    );
                },
                List.of(1, 2, 3, 8, 9, 10),
                List.of(1, 2, 8, 9, 10, 11)
        );
    }

    @DisplayName("등수가 아무도 없는 결과")
    @Test
    void RankLoseRankTest() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("2000", "1,2,3,4,5,6", "7");
                    assertThat(output()).contains(
                            "2개를 구매했습니다.",
                            "[7, 8, 9, 10, 11, 12]",
                            "[1, 2, 8, 9, 10, 11]",
                            "3개 일치 (5,000원) - 0개",
                            "4개 일치 (50,000원) - 0개",
                            "5개 일치 (1,500,000원) - 0개",
                            "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
                            "6개 일치 (2,000,000,000원) - 0개",
                            "총 수익률은 0.0%입니다."
                    );
                },
                List.of(7, 8, 9, 10, 11, 12),
                List.of(1, 2, 8, 9, 10, 11)
        );
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
