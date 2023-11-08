package lotto;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("잘못된 값 입력시 재입력 테스트")
public class InputRetryTest extends NsTest {
    @DisplayName("구매 금액을 잘못 입력하면 재입력 받는다.")
    @Test
    void 구매_금액_예외_처리() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("", "asd", "1a2", "3010", "3100", "3000", "1,2,3,4,5,6", "7");
                    assertThat(output()).contains(
                            "[ERROR]",
                            "3개를 구매했습니다.",
                            "[8, 21, 23, 41, 42, 43]",
                            "[3, 5, 11, 16, 32, 38]",
                            "[1, 2, 7, 9, 40, 44]",
                            "3개 일치 (5,000원) - 1개",
                            "4개 일치 (50,000원) - 0개",
                            "5개 일치 (1,500,000원) - 0개",
                            "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
                            "6개 일치 (2,000,000,000원) - 0개",
                            "총 수익률은 166.7%입니다."
                    );
                },
                List.of(8, 21, 23, 41, 42, 43),
                List.of(3, 5, 11, 16, 32, 38),
                List.of(1, 2, 7, 9, 40, 44)
        );
    }

    @DisplayName("로또 숫자를 잘못 입력하면 재입력 받는다.")
    @Test
    void 로또_숫자_예외_처리() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("3000", "", "asd", "1a2", "1 2 3 4 5 6", "1,2,3,4,5", "1,2,3,4,a,6", "1,2,3,4,5,6", "7");
                    assertThat(output()).contains(
                            "[ERROR]",
                            "3개를 구매했습니다.",
                            "[8, 21, 23, 41, 42, 43]",
                            "[3, 5, 11, 16, 32, 38]",
                            "[1, 2, 7, 9, 40, 44]",
                            "3개 일치 (5,000원) - 1개",
                            "4개 일치 (50,000원) - 0개",
                            "5개 일치 (1,500,000원) - 0개",
                            "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
                            "6개 일치 (2,000,000,000원) - 0개",
                            "총 수익률은 166.7%입니다."
                    );
                },
                List.of(8, 21, 23, 41, 42, 43),
                List.of(3, 5, 11, 16, 32, 38),
                List.of(1, 2, 7, 9, 40, 44)
        );
    }

    @DisplayName("보너스 번호를 잘못 입력하면 재입력 받는다.")
    @Test
    void 보너스_번호_예외_처리() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("3000", "1,2,3,4,5,6", "", "a", "1a", "7");
                    assertThat(output()).contains(
                            "[ERROR]",
                            "3개를 구매했습니다.",
                            "[8, 21, 23, 41, 42, 43]",
                            "[3, 5, 11, 16, 32, 38]",
                            "[1, 2, 7, 9, 40, 44]",
                            "3개 일치 (5,000원) - 1개",
                            "4개 일치 (50,000원) - 0개",
                            "5개 일치 (1,500,000원) - 0개",
                            "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
                            "6개 일치 (2,000,000,000원) - 0개",
                            "총 수익률은 166.7%입니다."
                    );
                },
                List.of(8, 21, 23, 41, 42, 43),
                List.of(3, 5, 11, 16, 32, 38),
                List.of(1, 2, 7, 9, 40, 44)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
