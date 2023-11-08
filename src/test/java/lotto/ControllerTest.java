package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

class ControllerTest extends NsTest {
    private static final String ERROR_MESSAGE = "[ERROR]";

    @Test
    void 발행한_로또번호_출력() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    runException("4000");
                    assertThat(output()).contains(
                            "4개를 구매했습니다.",
                            "[1, 2, 3, 4, 5, 6]",
                            "[39, 40, 41, 42, 43, 44]",
                            "[7, 11, 16, 35, 36, 44]",
                            "[1, 8, 11, 31, 41, 42]"
                    );
                },
                List.of(1, 2, 3, 4, 5, 6),
                List.of(39, 40, 41, 42, 43, 44),
                List.of(7, 11, 16, 35, 36, 44),
                List.of(1, 8, 11, 31, 41, 42)
        );
    }

    @Test
    void 올바른_구입금액_입력_까지_재입력() {
        assertSimpleTest(() -> {
            runException("1000j", "2002", "2000");
            assertThat(output()).containsAnyOf(
                    ERROR_MESSAGE,
                    "개를 구매했습니다."
            );
        });
    }

    @Test
    void 발행한_로또번호_오름차순으로_출력() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    runException("2000");
                    assertThat(output()).contains(
                            "2개를 구매했습니다.",
                            "[1, 2, 3, 4, 5, 6]",
                            "[7, 11, 16, 35, 36, 44]"
                    );
                },
                List.of(1, 6, 5, 4, 2, 3),
                List.of(35, 11, 44, 7, 36, 16)
        );
    }

    @Test
    void 수익률은_소수점_둘째_자리에서_반올림하여_출력() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    runException("3000", "1,2,3,43,44,45", "42");
                    assertThat(output()).contains(
                            "총 수익률은 166.7%입니다."
                    );
                },
                List.of(1, 2, 3, 4, 5, 6),
                List.of(7,8,9,10,11,12),
                List.of(7,8,9,10,11,12)
        );
    }

    @Test
    void 수익률은_소수점_첫째_자리까지_출력() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    runException("1000", "1,2,3,43,44,45", "42");
                    assertThat(output()).contains(
                            "총 수익률은 500.0%입니다."
                    );
                },
                List.of(1, 2, 3, 4, 5, 6)
        );
    }

    @Test
    void 수익률은_정수부의_3자리마다_콤마로_구분해서_출력() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    runException("1000", "1,2,3,4,5,6", "42");
                    assertThat(output()).contains(
                            "총 수익률은 200,000,000.0%입니다."
                    );
                },
                List.of(1, 2, 3, 4, 5, 6)
        );
    }
    @Test
    void int범위를_벗어나는_당첨금의_수익률_출력() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    runException("12000", "1,2,3,4,5,6", "7");
                    assertThat(output()).contains(
                            "총 수익률은 183,333,333.3%입니다."
                    );
                },
                List.of(1, 2, 3, 4, 5, 6),
                List.of(1, 2, 3, 4, 5, 6),
                List.of(1, 2, 3, 4, 5, 6),
                List.of(1, 2, 3, 4, 5, 6),
                List.of(1, 2, 3, 4, 5, 6),
                List.of(1, 2, 3, 4, 5, 6),
                List.of(1, 2, 3, 4, 5, 6),
                List.of(1, 2, 3, 4, 5, 6),
                List.of(1, 2, 3, 4, 5, 6),
                List.of(1, 2, 3, 4, 5, 6),
                List.of(1, 2, 3, 4, 5, 6),
                List.of(7,8,9,10,11,12)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
