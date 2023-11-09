package lotto.model;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import lotto.Application;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinningResultTest extends NsTest {

    // 당첨 통계 관련 테스트
    @DisplayName("5등 통계 테스트")
    @Test
    void fifthStatisticsTest() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("1000", "1,2,3,4,5,6", "7");
                    assertThat(output()).contains(
                            "3개 일치 (5,000원) - 1개"
                    );
                },
                List.of(1, 2, 3, 45, 44, 43)
        );
    }

    @DisplayName("4등 통계 테스트")
    @Test
    void fourthStatisticsTest() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("1000", "1,2,3,4,5,6", "7");
                    assertThat(output()).contains(
                            "4개 일치 (50,000원) - 1개"
                    );
                },
                List.of(1, 2, 3, 4, 45, 44)
        );
    }

    @DisplayName("3등 통계 테스트")
    @Test
    void thirdStatisticsTest() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("1000", "1,2,3,4,5,6", "7");
                    assertThat(output()).contains(
                            "5개 일치 (1,500,000원) - 1개"
                    );
                },
                List.of(1, 2, 3, 4, 5, 44)
        );
    }

    @DisplayName("2등 통계 테스트")
    @Test
    void secondStatisticsTest() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("1000", "1,2,3,4,5,6", "7");
                    assertThat(output()).contains(
                            "5개 일치, 보너스 볼 일치 (30,000,000원) - 1개"
                    );
                },
                List.of(1, 2, 3, 4, 5, 7)
        );
    }

    @DisplayName("1등 통계 테스트")
    @Test
    void firstStatisticsTest() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("1000", "1,2,3,4,5,6", "7");
                    assertThat(output()).contains(
                            "6개 일치 (2,000,000,000원) - 1개"
                    );
                },
                List.of(1, 2, 3, 4, 5, 6)
        );
    }

    // 수익률 관련 테스트
    @DisplayName("1개 구매, 5등 수익률 테스트")
    @Test
    void fifthProfitTest() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("1000", "1,2,3,4,5,6", "7");
                    assertThat(output()).contains(
                            "총 수익률은 500.0%입니다."

                    );
                },
                List.of(1, 2, 3, 45, 44, 43)
        );
    }

    @DisplayName("1개 구매, 4등 수익률 테스트")
    @Test
    void fourthProfitTest() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("1000", "1,2,3,4,5,6", "7");
                    assertThat(output()).contains(
                            "총 수익률은 5,000.0%입니다."
                    );
                },
                List.of(1, 2, 3, 4, 45, 44)
        );
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
