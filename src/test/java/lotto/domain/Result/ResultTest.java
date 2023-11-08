package lotto.domain.Result;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.Application;
import lotto.domain.Lotto.Lotto;
import lotto.domain.WinningNumber.WinningNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

public class ResultTest extends NsTest {

    @DisplayName("등수 계산 확인")
    @Test
    void rankTest() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("5000", "1,2,3,4,5,6", "7");
                    assertThat(output()).contains(
                            "5개를 구매했습니다.",
                            "[1, 2, 3, 4, 5, 6]",
                            "[2, 3, 4, 5, 6, 7]",
                            "[3, 4, 5, 6, 7, 8]",
                            "[4, 5, 6, 7, 8, 9]",
                            "[5, 6, 7, 8, 9, 10]",
                            "3개 일치 (5,000원) - 1개",
                            "4개 일치 (50,000원) - 1개",
                            "5개 일치 (1,500,000원) - 0개",
                            "5개 일치, 보너스 볼 일치 (30,000,000원) - 1개",
                            "6개 일치 (2,000,000,000원) - 1개",
                            "총 수익률은 40601100.0%입니다."
                    );
                },
                List.of(1,2,3,4,5,6),
                List.of(2,3,4,5,6,7),
                List.of(3,4,5,6,7,8),
                List.of(4,5,6,7,8,9),
                List.of(5,6,7,8,9,10)
        );
    }

    @DisplayName("수익률 계산 및 출력 확인")
    @Test
    void profitTest() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("1000", "1,2,3,4,5,6", "7");
                    assertThat(output()).contains(
                            "1개를 구매했습니다.",
                            "[4, 5, 6, 7, 8, 9]",
                            "3개 일치 (5,000원) - 1개",
                            "4개 일치 (50,000원) - 0개",
                            "5개 일치 (1,500,000원) - 0개",
                            "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
                            "6개 일치 (2,000,000,000원) - 0개",
                            "총 수익률은 500.0%입니다."
                    );
                },
                List.of(4,5,6,7,8,9)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
