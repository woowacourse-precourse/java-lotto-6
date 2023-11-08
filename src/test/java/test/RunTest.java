package test;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.Application;
import lotto.config.LottoPrize;
import lotto.model.LottoDraw;
import lotto.model.LottoResult;
import lotto.util.Util;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static org.assertj.core.api.Assertions.*;

class RunTest extends NsTest {
    @Test
    void 기능_테스트1() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("5000", "1,2,3,4,5,6", "7");
                    assertThat(output()).contains(
                            "5개를 구매했습니다.",
                            "[1, 2, 3, 4, 5, 6]",
                            "[2, 3, 4, 5, 6, 7]",
                            "[7, 11, 16, 35, 36, 44]",
                            "[1, 8, 11, 31, 41, 42]",
                            "[13, 14, 16, 38, 42, 45]",
                            "3개 일치 (5,000원) - 0개",
                            "4개 일치 (50,000원) - 0개",
                            "5개 일치 (1,500,000원) - 0개",
                            "5개 일치, 보너스 볼 일치 (30,000,000원) - 1개",
                            "6개 일치 (2,000,000,000원) - 1개",
                            "총 수익률은 40,600,000%입니다."
                    );
                },
                List.of(1, 2, 3, 4, 5, 6),
                List.of(2, 3, 4, 5, 6, 7),
                List.of(7, 11, 16, 35, 36, 44),
                List.of(1, 8, 11, 31, 41, 42),
                List.of(13, 14, 16, 38, 42, 45)
        );
    }

    @Test
    void 기능_테스트2() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("7000", "1,2,3,4,5,6", "7");
                    assertThat(output()).contains(
                            "7개를 구매했습니다.",
                            "[1, 2, 3, 4, 5, 6]",
                            "[2, 3, 4, 5, 6, 7]",
                            "[7, 11, 16, 35, 36, 44]",
                            "[1, 8, 11, 31, 41, 42]",
                            "[2, 3, 4, 5, 7, 13]",
                            "[13, 14, 19, 33, 41, 42]",
                            "[13, 14, 16, 38, 42, 45]",
                            "3개 일치 (5,000원) - 0개",
                            "4개 일치 (50,000원) - 1개",
                            "5개 일치 (1,500,000원) - 0개",
                            "5개 일치, 보너스 볼 일치 (30,000,000원) - 1개",
                            "6개 일치 (2,000,000,000원) - 1개",
                            "총 수익률은 29,000,714.3%입니다."
                    );
                },
                List.of(1, 2, 3, 4, 5, 6),
                List.of(2, 3, 4, 5, 6, 7),
                List.of(7, 11, 16, 35, 36, 44),
                List.of(1, 8, 11, 31, 41, 42),
                List.of(2, 3, 4, 5, 7, 13),
                List.of(13, 14, 19, 33, 41, 42),
                List.of(13, 14, 16, 38, 42, 45)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
