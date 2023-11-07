package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

class ApplicationTest extends NsTest {
    private static final String ERROR_MESSAGE = "[ERROR]";

    @Test
    void 기능_테스트() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("8000", "1,2,3,4,5,6", "7");
                    assertThat(output()).contains(
                            "8개를 구매했습니다.",
                            "[8, 21, 23, 41, 42, 43]",
                            "[3, 5, 11, 16, 32, 38]",
                            "[7, 11, 16, 35, 36, 44]",
                            "[1, 8, 11, 31, 41, 42]",
                            "[13, 14, 16, 38, 42, 45]",
                            "[7, 11, 30, 40, 42, 43]",
                            "[2, 13, 22, 32, 38, 45]",
                            "[1, 3, 5, 14, 22, 45]",
                            "3개 일치 (5,000원) - 1개",
                            "4개 일치 (50,000원) - 0개",
                            "5개 일치 (1,500,000원) - 0개",
                            "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
                            "6개 일치 (2,000,000,000원) - 0개",
                            "총 수익률은 62.5%입니다."
                    );
                },
                new ArrayList<>(Arrays.asList(8, 21, 23, 41, 42, 43)),
                new ArrayList<>(Arrays.asList(3, 5, 11, 16, 32, 38)),
                new ArrayList<>(Arrays.asList(7, 11, 16, 35, 36, 44)),
                new ArrayList<>(Arrays.asList(1, 8, 11, 31, 41, 42)),
                new ArrayList<>(Arrays.asList(13, 14, 16, 38, 42, 45)),
                new ArrayList<>(Arrays.asList(7, 11, 30, 40, 42, 43)),
                new ArrayList<>(Arrays.asList(2, 13, 22, 32, 38, 45)),
                new ArrayList<>(Arrays.asList(1, 3, 5, 14, 22, 45))
        );
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() -> {
            runException("1000j");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }

    @Test
    void 당첨숫자6개미만입력() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("1000", "1,2,3,4,5", "1,2,3,4,5,6", "7");
                    assertThat(output()).contains(
                            "[ERROR] 로또 번호는 6개의 숫자를 입력해야 합니다."
                    );
                },
                new ArrayList<>(Arrays.asList(8, 21, 23, 41, 42, 43))
        );
    }

    @Test
    void 당첨숫자로또범위밖입력() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("1000", "1,2,3,4,5,60", "-1,2,3,4,5,6", "1,2,3,4,5,6", "7");
                    assertThat(output()).contains(
                            "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."
                    );
                },
                new ArrayList<>(Arrays.asList(8, 21, 23, 41, 42, 43))
        );
    }

    @Test
    void 당첨숫자중복입력() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("1000", "1,2,3,4,5,5", "1,2,3,4,5,6", "7");
                    assertThat(output()).contains(
                            "[ERROR] 로또 번호는 중복되지 않은 숫자여야 합니다."
                    );
                },
                new ArrayList<>(Arrays.asList(8, 21, 23, 41, 42, 43))
        );
    }
    @Test
    void 보너스숫자중복입력() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("1000", "1,2,3,4,5,6", "6", "7");
                    assertThat(output()).contains(
                            "[ERROR] 보너스 번호는 로또 번호와 중복되지 않은 숫자여야 합니다."
                    );
                },
                new ArrayList<>(Arrays.asList(8, 21, 23, 41, 42, 43))
        );
    }

    @Test
    void 보너스숫자범위밖입력() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("1000", "1,2,3,4,5,6", "70", "7");
                    assertThat(output()).contains(
                            "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."
                    );
                },
                new ArrayList<>(Arrays.asList(8, 21, 23, 41, 42, 43))
        );
    }

    @Test
    void 금액숫자이외입력() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("1000j", "1000", "1,2,3,4,5,6", "70", "7");
                    assertThat(output()).contains(
                            "[ERROR] 입력은 숫자만 가능합니다."
                    );
                },
                new ArrayList<>(Arrays.asList(8, 21, 23, 41, 42, 43))
        );
    }

    @Test
    void 금액1000단위이외입력() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("1100", "1000", "1,2,3,4,5,6", "70", "7");
                    assertThat(output()).contains(
                            "[ERROR] 입력 단위는 1,000원 단위여야 합니다."
                    );
                },
                new ArrayList<>(Arrays.asList(8, 21, 23, 41, 42, 43))
        );
    }
}
