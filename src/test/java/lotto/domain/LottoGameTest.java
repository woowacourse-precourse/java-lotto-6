package lotto.domain;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import lotto.Application;
import org.junit.jupiter.api.Test;

public class LottoGameTest extends NsTest {
    @Test
    void 기능_테스트2() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("4000", "3,6,9,12,15,18", "21");
                    assertThat(output()).contains(
                            "4개를 구매했습니다.",
                            "[11, 22, 33, 44, 55, 66]",
                            "[3, 6, 9, 12, 16, 19]",
                            "[7, 17, 27, 37, 47, 57]",
                            "[8, 9, 12, 15, 21, 29]",
                            "3개 일치 (5,000원) - 1개",
                            "4개 일치 (50,000원) - 1개",
                            "5개 일치 (1,500,000원) - 0개",
                            "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
                            "6개 일치 (2,000,000,000원) - 0개",
                            "총 수익률은 1,375.0%입니다."
                    );
                },
                List.of(11, 22, 33, 44, 55, 66),
                List.of(3, 6, 9, 12, 16, 19),
                List.of(7, 17, 27, 37, 47, 57),
                List.of(8, 9, 12, 15, 21, 29)
        );
    }

    @Test
    void 기능_테스트3() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("3000", "11,18,22,33,44,45", "7");
                    assertThat(output()).contains(
                            "3개를 구매했습니다.",
                            "[11, 18, 22, 33, 44, 45]",
                            "[7, 11, 22, 33, 44, 45]",
                            "[8, 11, 22, 33, 44, 45]",
                            "3개 일치 (5,000원) - 0개",
                            "4개 일치 (50,000원) - 0개",
                            "5개 일치 (1,500,000원) - 1개",
                            "5개 일치, 보너스 볼 일치 (30,000,000원) - 1개",
                            "6개 일치 (2,000,000,000원) - 1개",
                            "총 수익률은 67,716,666.7%입니다."
                    );
                },
                List.of(11, 18, 22, 33, 44, 45),
                List.of(7, 11, 22, 33, 44, 45),
                List.of(8, 11, 22, 33, 44, 45)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
