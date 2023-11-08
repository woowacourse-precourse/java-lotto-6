package lotto;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CheckResultTest extends NsTest {

    @DisplayName("일치하는 숫자의 개수 계산, 수익률 계산이 맞는지 확인한다.")
    @Test
    void checkResult() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("2000", "1,2,3,4,5,6", "7");
                    assertThat(output()).contains(
                            "2개를 구매했습니다.",
                            "[1, 2, 3, 4, 8, 9]",
                            "[1, 2, 3, 8, 9, 10]",
                            "3개 일치 (5,000원) - 1개",
                            "4개 일치 (50,000원) - 1개",
                            "5개 일치 (1,500,000원) - 0개",
                            "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
                            "6개 일치 (2,000,000,000원) - 0개",
                            "총 수익률은 2750.0%입니다."
                    );
                },
                List.of(1, 2, 3, 4, 8, 9),
                List.of(1, 2, 3, 8, 9, 10)
        );
    }

    @DisplayName("숫자 5개가 일치하고 보너스 볼을 포함한 로또 개수를 확인한다.")
    @Test
    void checkFiveMatchWithBonusNumber() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("2000", "1,2,3,4,5,6", "7");
                    assertThat(output()).contains(
                            "2개를 구매했습니다.",
                            "[1, 2, 3, 4, 5, 7]",
                            "[1, 2, 3, 8, 9, 10]",
                            "3개 일치 (5,000원) - 1개",
                            "4개 일치 (50,000원) - 0개",
                            "5개 일치 (1,500,000원) - 0개",
                            "5개 일치, 보너스 볼 일치 (30,000,000원) - 1개",
                            "6개 일치 (2,000,000,000원) - 0개",
                            "총 수익률은 1500250.0%입니다."
                    );
                },
                List.of(1, 2, 3, 4, 5, 7),
                List.of(1, 2, 3, 8, 9, 10)
        );
    }

    @DisplayName("일치하는 숫자 개수가 5개가 아니고 보너스 볼을 포함 경우 일치하는 경우를 확인한다.")
    @Test
    void checkNotFiveMatchWithBonusNumber() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("2000", "1,2,3,4,5,6", "7");
                    assertThat(output()).contains(
                            "2개를 구매했습니다.",
                            "[1, 2, 3, 4, 7, 8]",
                            "[1, 2, 7, 8, 9, 10]",
                            "3개 일치 (5,000원) - 0개",
                            "4개 일치 (50,000원) - 1개",
                            "5개 일치 (1,500,000원) - 0개",
                            "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
                            "6개 일치 (2,000,000,000원) - 0개"
                    );
                },
                List.of(1, 2, 3, 4, 7, 8),
                List.of(1, 2, 7, 8, 9, 10)
        );
    }


    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
