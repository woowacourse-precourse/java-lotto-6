package lotto;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static lotto.global.enums.ErrorMessage.DUPLICATE_NUMBER_ERROR_MESSAGE;
import static lotto.global.enums.ErrorMessage.EXCEED_LENGTH_ERROR_MESSAGE;
import static lotto.global.enums.ErrorMessage.MONEY_AMOUNT_ERROR_MESSAGE;
import static lotto.global.enums.ErrorMessage.NOT_NUMBER_INPUT_ERROR_MESSAGE;
import static lotto.global.enums.ErrorMessage.NUMBER_OUT_OF_RANGE_ERROR_MESSAGE;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import org.junit.jupiter.api.Test;

class LottoGameTest extends NsTest {

    @Test
    void 구입_금액_숫자_아님_예외_테스트() {
        assertSimpleTest(() -> {
            runException("a", " ");
            assertThat(output()).contains(NOT_NUMBER_INPUT_ERROR_MESSAGE.getMessage());
        });
    }

    @Test
    void 구입_금액_1000원_단위_예외_테스트() {
        assertSimpleTest(() -> {
            runException("0", "-1", "999", "-1000");
            assertThat(output()).contains(MONEY_AMOUNT_ERROR_MESSAGE.getMessage());
        });
    }

    @Test
    void 당첨_번호_숫자_아님_예외_테스트() {
        assertSimpleTest(() -> {
            runException("1000", "a,1,2,3,4,5");
            assertThat(output()).contains(NOT_NUMBER_INPUT_ERROR_MESSAGE.getMessage());
        });
    }

    @Test
    void 당첨_번호_공백_포함_예외_테스트() {
        assertSimpleTest(() -> {
            runException("1000", "1,2,2,3,4, 5", "1,  2, 3,4,5,6");
            assertThat(output()).contains(NOT_NUMBER_INPUT_ERROR_MESSAGE.getMessage());
        });
    }

    @Test
    void 당첨_번호_중복_예외_테스트() {
        assertSimpleTest(() -> {
            runException("1000", "1,2,2,3,4,5");
            assertThat(output()).contains(DUPLICATE_NUMBER_ERROR_MESSAGE.getMessage());
        });
    }

    @Test
    void 당첨_번호_길이_초과_예외_테스트() {
        assertSimpleTest(() -> {
            runException("1000", "1,2,3,4,5,6,7");
            assertThat(output()).contains(EXCEED_LENGTH_ERROR_MESSAGE.getMessage());
        });
    }

    @Test
    void 당첨_번호_범위_초과_예외_테스트() {
        assertSimpleTest(() -> {
            runException("1000", "1,2,3,4,5,46", "0,1,2,3,4,5", "-1,1,2,3,4,5");
            assertThat(output()).contains(NUMBER_OUT_OF_RANGE_ERROR_MESSAGE.getMessage());
        });
    }

    @Test
    void 보너스_번호_숫자_아님_예외_테스트() {
        assertSimpleTest(() -> {
            runException("1000", "1,2,3,4,5,6", "a");
            assertThat(output()).contains(NOT_NUMBER_INPUT_ERROR_MESSAGE.getMessage());
        });
    }

    @Test
    void 보너스_번호_당첨_번호_중복_예외_테스트() {
        assertSimpleTest(() -> {
            runException("1000", "1,2,3,4,5,6", "1");
            assertThat(output()).contains(DUPLICATE_NUMBER_ERROR_MESSAGE.getMessage());
        });
    }

    @Test
    void 보너스_번호_범위_초과_예외_테스트() {
        assertSimpleTest(() -> {
            runException("1000", "1,2,3,4,5,6", "0", "46", "-1");
            assertThat(output()).contains(NUMBER_OUT_OF_RANGE_ERROR_MESSAGE.getMessage());
        });
    }

    @Test
    void 정상_작동_테스트() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("8000", "1,41,3,42,43,11", "45");
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
                            "3개 일치 (5,000원) - 2개",
                            "4개 일치 (50,000원) - 1개",
                            "5개 일치 (1,500,000원) - 0개",
                            "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
                            "6개 일치 (2,000,000,000원) - 0개",
                            "총 수익률은 750.0%입니다."
                    );
                },
                List.of(21, 8, 23, 41, 42, 43),
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
    void 반올림_정상_작동_테스트() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("3000", "1,2,3,4,5,6", "1", "7");
                    assertThat(output()).contains(
                            "3개를 구매했습니다.",
                            "[1, 2, 3, 11, 43, 45]",
                            "[15, 22, 25, 30, 40, 41]",
                            "[9, 10, 11, 12, 13, 14]",
                            "3개 일치 (5,000원) - 1개",
                            "4개 일치 (50,000원) - 0개",
                            "5개 일치 (1,500,000원) - 0개",
                            "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
                            "6개 일치 (2,000,000,000원) - 0개",
                            "총 수익률은 166.7%입니다."
                    );
                },
                List.of(1, 2, 3, 11, 45, 43),
                List.of(40, 41, 15, 30, 25, 22),
                List.of(9, 10, 11, 12, 13, 14)
        );
    }


    @Override
    public void runMain() {
        Application.main(new String[]{});
    }

}
