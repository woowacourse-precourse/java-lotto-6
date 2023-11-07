package lotto;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static lotto.view.message.ErrorMessage.NOT_DEFAULT_LOTTO_SIZE;
import static lotto.view.message.ErrorMessage.NOT_NUMBER_FORM_ONE_TO_FORTY_FIVE;
import static lotto.view.message.ErrorMessage.NOT_PRICE_UNITS;
import static lotto.view.message.SystemMessage.INPUT_BONUS;
import static lotto.view.message.SystemMessage.OUTPUT_PURCHASE_AMOUNT;
import static lotto.view.message.SystemMessage.OUTPUT_RESULT;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import org.junit.jupiter.api.Test;

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
    void 예외_테스트() {
        assertSimpleTest(() -> {
            runException("1000j");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 로또_번호_오름차순_출력_테스트() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("2000", "1,2,3,4,5,6", "7");
                    assertThat(output()).contains(
                            "[8, 21, 23, 41, 42, 43]",
                            "[1, 3, 4, 5, 22, 43]"
                    );
                },
                List.of(23, 41, 8, 21, 42, 43),
                List.of(22, 43, 4, 1, 3, 5)
        );
    }

    @Test
    void 구입_금액_에러_메시지_출력_후_재입력_테스트() {
        assertSimpleTest(() -> {
            run("200", "7000", "1,2,3,4,5,6", "7");
            assertThat(output()).contains(
                    NOT_PRICE_UNITS.getErrorMessage(),
                    String.format(OUTPUT_PURCHASE_AMOUNT.getMessage(), 7)
            );
        });
    }

    @Test
    void 당첨_번호_에러_메시지_출력_후_재입력_테스트() {
        assertSimpleTest(() -> {
            run("7000", "1,2", "1,2,3,4,5,6", "7");
            assertThat(output()).contains(
                    NOT_DEFAULT_LOTTO_SIZE.getErrorMessage(),
                    INPUT_BONUS.getMessage()
            );
        });
    }

    @Test
    void 보너스_번호_에러_메시지_출력_후_재입력_테스트() {
        assertSimpleTest(() -> {
            run("7000", "1,2,3,4,5,6", "55", "7");
            assertThat(output()).contains(
                    NOT_NUMBER_FORM_ONE_TO_FORTY_FIVE.getErrorMessage(),
                    OUTPUT_RESULT.getMessage()
            );
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
