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

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
