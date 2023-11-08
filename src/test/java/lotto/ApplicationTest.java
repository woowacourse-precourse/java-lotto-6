package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static lotto.exception.errorcode.InputErrorCode.DUPLICATED_LOTTO_NUMBER;
import static lotto.exception.errorcode.InputErrorCode.INCLUDE_BONUS_NUMBER_IN_WINNING_NUMBER;
import static lotto.exception.errorcode.InputErrorCode.INPUT_NOT_NUMERIC;
import static lotto.exception.errorcode.InputErrorCode.INPUT_SPLIT_SIZE;
import static lotto.exception.errorcode.InputErrorCode.INVALID_BONUS_NUMBER_RANGE;
import static lotto.exception.errorcode.InputErrorCode.INVALID_LOTTO_NUMBER_RANGE;
import static lotto.exception.errorcode.InputErrorCode.INVALID_LOTTO_PURCHASE_PRICE_RANGE;
import static org.assertj.core.api.Assertions.assertThat;

class ApplicationTest extends NsTest {
    @Test
    void 기능_테스트_5등_1개() {
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
    void 기능_테스트_2등_1개() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("8000", "8,21,23,41,43,44", "42");
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
                            "3개 일치 (5,000원) - 0개",
                            "4개 일치 (50,000원) - 0개",
                            "5개 일치 (1,500,000원) - 0개",
                            "5개 일치, 보너스 볼 일치 (30,000,000원) - 1개",
                            "6개 일치 (2,000,000,000원) - 0개",
                            "총 수익률은 375000.0%입니다."
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
    void 기능_테스트_1등_1개() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("8000", "8,21,23,41,42,43", "45");
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
                            "3개 일치 (5,000원) - 0개",
                            "4개 일치 (50,000원) - 0개",
                            "5개 일치 (1,500,000원) - 0개",
                            "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
                            "6개 일치 (2,000,000,000원) - 1개",
                            "총 수익률은 25000062.0%입니다."
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

    @DisplayName("구매 금액이 숫자가 아닌 경우 예외가 발생한다.")
    @Test
    void 구매금액_숫자가_아닌경우() {
        assertSimpleTest(() -> {
            runException("1000j");
            assertThat(output()).contains(INPUT_NOT_NUMERIC.getMessage());
        });
    }

    @DisplayName("구매 금액이 1000원 이하인 경우 예외가 발생한다.")
    @Test
    void 구매금액_천원_미만인_경우() {
        assertSimpleTest(() -> {
            runException("80");
            assertThat(output()).contains(INVALID_LOTTO_PURCHASE_PRICE_RANGE.getMessage());
        });
    }

    @DisplayName("당첨 번호 분할 시 6개가 아닌 경우 예외가 발생한다.")
    @Test
    void 당첨번호_분할된_개수가_잘못된_경우() {
        assertSimpleTest(() -> {
            runException("1000", "1,2,3,4,5");
            assertThat(output()).contains(INPUT_SPLIT_SIZE.getMessage());
        });
    }

    @DisplayName("당첨 번호 분할된 값이 숫자가 아닌 경우 예외가 발생한다.")
    @Test
    void 당첨번호_분할된_값이_숫자가_아닌경우() {
        assertSimpleTest(() -> {
            runException("1000", "1,2,3,4,5,A");
            assertThat(output()).contains(INPUT_NOT_NUMERIC.getMessage());
        });
    }

    @DisplayName("당첨 번호 범위가 벗어난 경우 예외가 발생한다.")
    @Test
    void 당첨번호_분할된_값이_범위가_벗어난_경우() {
        assertSimpleTest(() -> {
            runException("1000", "1,2,3,4,5,50", "1");
            assertThat(output()).contains(INVALID_LOTTO_NUMBER_RANGE.getMessage());
        });
    }

    @DisplayName("당첨 번호가 중복되는 경우 예외가 발생한다.")
    @Test
    void 당첨번호_분할된_값이_중복되는_경우() {
        assertSimpleTest(() -> {
            runException("1000", "1,2,3,4,5,5", "1");
            assertThat(output()).contains(DUPLICATED_LOTTO_NUMBER.getMessage());
        });
    }

    @DisplayName("보너스 번호가 범위를 벗어난 경우 예외가 발생한다.")
    @Test
    void 보너스_번호가_범위를_벗어난_경우() {
        assertSimpleTest(() -> {
            runException("1000", "1,2,3,4,5,6", "-1");
            assertThat(output()).contains(INVALID_BONUS_NUMBER_RANGE.getMessage());
        });
    }

    @DisplayName("보너스 번호가 당첨 번호에 포함되는 경우 예외가 발생한다.")
    @Test
    void 보너스_번호가_당첨번호에_포함되는_경우() {
        assertSimpleTest(() -> {
            runException("1000", "1,2,3,4,5,6", "6");
            assertThat(output()).contains(INCLUDE_BONUS_NUMBER_IN_WINNING_NUMBER.getMessage());
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
