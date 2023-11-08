package lotto;


import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import org.junit.jupiter.api.Test;

class LottoControllerTest extends NsTest {

    @Test
    void runWithNoWin() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("3000", "1,2,3,4,5,6", "7");
                    assertThat(output()).contains(
                            "3개를 구매했습니다.",
                            "[8, 21, 23, 41, 42, 43]",
                            "[11, 15, 16, 31, 32, 38]",
                            "[7, 11, 16, 35, 36, 44]",
                            "3개 일치 (5,000원) - 0개",
                            "4개 일치 (50,000원) - 0개",
                            "5개 일치 (1,500,000원) - 0개",
                            "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
                            "6개 일치 (2,000,000,000원) - 0개",
                            "총 수익률은 0.0%입니다."
                    );
                },
                List.of(8, 21, 23, 41, 42, 43),
                List.of(31, 15, 11, 16, 32, 38),
                List.of(7, 11, 16, 35, 36, 44)
        );
    }

    @Test
    void runWithOne2nd() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("3000", "11,15,16,31,32,6", "38");
                    assertThat(output()).contains(
                            "3개를 구매했습니다.",
                            "[8, 21, 23, 41, 42, 43]",
                            "[11, 15, 16, 31, 32, 38]",
                            "[7, 11, 16, 35, 36, 44]",
                            "3개 일치 (5,000원) - 0개",
                            "4개 일치 (50,000원) - 0개",
                            "5개 일치 (1,500,000원) - 0개",
                            "5개 일치, 보너스 볼 일치 (30,000,000원) - 1개",
                            "6개 일치 (2,000,000,000원) - 0개",
                            "총 수익률은 1000000.0%입니다."
                    );
                },
                List.of(8, 21, 23, 41, 42, 43),
                List.of(31, 15, 11, 16, 32, 38),
                List.of(7, 11, 16, 35, 36, 44)
        );
    }

    @Test
    void runWithTwo3rd() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("3000", "11, 15, 16, 31, 32, 38", "40");
                    assertThat(output()).contains(
                            "3개를 구매했습니다.",
                            "[8, 21, 23, 41, 42, 43]",
                            "[11, 15, 16, 31, 32, 37]",
                            "[11, 15, 16, 31, 32, 39]",
                            "3개 일치 (5,000원) - 0개",
                            "4개 일치 (50,000원) - 0개",
                            "5개 일치 (1,500,000원) - 2개",
                            "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
                            "6개 일치 (2,000,000,000원) - 0개",
                            "총 수익률은 100000.0%입니다."
                    );
                },
                List.of(8, 21, 23, 41, 42, 43),
                List.of(11, 15, 16, 31, 32, 37),
                List.of(11, 15, 16, 31, 32, 39)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}