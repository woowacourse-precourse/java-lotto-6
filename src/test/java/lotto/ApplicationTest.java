package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.message.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
                List.of(8, 21, 23, 41, 42, 43),
                List.of(3, 5, 11, 16, 32, 38),
                List.of(7, 11, 16, 35, 36, 44),
                List.of(1, 8, 11, 31, 41, 42),
                List.of(13, 14, 16, 38, 42, 45),
                List.of(7, 11, 30, 40, 42, 43),
                List.of(2, 13, 22, 32, 38, 45),
                List.of(1, 3, 5, 14, 22, 45)
        );
    }

    @Test
    @DisplayName("티캣 구매 금액에는 문자가 포함 될 수 없다.")
    void 예외_테스트1() {
        assertSimpleTest(() -> {
            runException("1000j");
            assertThat(output()).contains(ErrorMessage.CHAR_STRING.getMessage());
        });
    }

    @Test
    @DisplayName("티캣 구매 금액은 티캣금액과 나눠떨어져야 한다.")
    void 예외_테스트2() {
        assertSimpleTest(() -> {
            runException("7500");
            assertThat(output()).contains(ErrorMessage.INVALID_TICKET_AMOUNT.getMessage());
        });
    }

    @Test
    @DisplayName("로또 winningNumber에 문자가 포함되면 안된다.")
    void 예외_테스트3() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("1000", "1,2,3,4,5,a", "1,2,3,4,5,6", "7");
                    assertThat(output()).contains(ErrorMessage.CHAR_STRING.getMessage());
                },
                List.of(1, 2, 3, 4, 5, 45)
        );
    }

    @Test
    @DisplayName("로또 bonusNumber에 문자가 포함되면 안된다.")
    void 예외_테스트4() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("1000", "1,2,3,4,5,6", "a", "7");
                    assertThat(output()).contains(ErrorMessage.CHAR_STRING.getMessage());
                },
                List.of(1, 2, 3, 4, 5, 45)
        );
    }

    @Test
    @DisplayName("로또 bonusNumber는 winningNumber와 중복되면 안된다.")
    void 예외_테스트5() {
        assertSimpleTest(() -> {
            run("1000", "1,2,3,4,5,45", "45", "10");
            assertThat(output()).contains(ErrorMessage.DUPLICATE_WITH_LOTTO.getMessage());
        });
        List.of(1, 2, 3, 4, 5, 45);
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
