package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

public class LottoWinningTest extends NsTest {
    private static final String ERROR_MESSAGE = "[ERROR]";
    private static final String WINNING_NUMBERS_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";
    private static final String WINNING_STATISTICS_MESSAGE = "당첨 통계";
    private static final String THREE_MATCH_MESSAGE = "3개 일치 (5,000원) - 1개";
    private static final String FOUR_MATCH_MESSAGE = "4개 일치 (50,000원) - 0개";
    private static final String FIVE_MATCH_MESSAGE = "5개 일치 (1,500,000원) - 0개";
    private static final String FIVE_BONUS_MATCH_MESSAGE = "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개";
    private static final String SIX_MATCH_MESSAGE = "6개 일치 (2,000,000,000원) - 0개";
    private static final String TOTAL_MARGIN_MESSAGE = "총 수익률은 100.0%입니다.";
    private static final String price = "5000";
    private static final String rightWinningNumbers = "1,2,3,4,5,6";
    private static final String rightBonusNumber = "7";

    @DisplayName("당첨번호가 숫자가 아닌 값일 때 예외 처리")
    @Test
    void 숫자가_아닌_당첨번호() {
        assertSimpleTest(() -> {
            runException(price, "1,2,3,4,5,a");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("당첨번호가 1~45 범위를 벗어났을 때 예외 처리")
    @Test
    void 범위를_벗어난_당첨번호() {
        assertSimpleTest(() -> {
            runException(price, "1,2,3,4,5,46");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("당첨번호가 6자리가 아닐 때 예외 처리")
    @Test
    void 여섯개가_아닌_당첨번호() {
        assertSimpleTest(() -> {
            runException(price, "1,2,3,4,5,6,7");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("당첨번호 예외 처리 후 재실행")
    @Test
    void 당첨번호_예외처리_재실행() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run(price, "1,2,3,4,5,6,7", rightWinningNumbers, rightBonusNumber);
                    assertThat(output()).contains(
                            ERROR_MESSAGE,
                            WINNING_NUMBERS_MESSAGE,
                            BONUS_NUMBER_MESSAGE
                    );
                },
                List.of(1, 8, 11, 31, 41, 42),
                List.of(13, 14, 16, 38, 42, 45),
                List.of(7, 11, 30, 40, 42, 43),
                List.of(2, 13, 22, 32, 38, 45),
                List.of(1, 3, 5, 14, 22, 45)
        );
    }

    @DisplayName("보너스 번호가 숫자가 아닌 값일 때 예외 처리")
    @Test
    void 숫자가_아닌_보너스_번호() {
        assertSimpleTest(() -> {
            runException(price, rightWinningNumbers, "a");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("보너스 번호가 1~45 범위를 벗어났을 때 예외 처리")
    @Test
    void 범위를_벗어난_보너스_번호() {
        assertSimpleTest(() -> {
            runException(price, rightWinningNumbers, "46");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("보너스 번호 예외 처리 후 재실행")
    @Test
    void 보너스_번호_예외처리_재실행() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run(price, rightWinningNumbers, "46", rightBonusNumber);
                    assertThat(output()).contains(
                            ERROR_MESSAGE,
                            WINNING_NUMBERS_MESSAGE,
                            BONUS_NUMBER_MESSAGE,
                            WINNING_STATISTICS_MESSAGE
                    );
                },
                List.of(1, 8, 11, 31, 41, 42),
                List.of(13, 14, 16, 38, 42, 45),
                List.of(7, 11, 30, 40, 42, 43),
                List.of(2, 13, 22, 32, 38, 45),
                List.of(1, 3, 5, 14, 22, 45)
        );
    }

    @DisplayName("당첨 통계 테스트")
    @Test
    void 당첨_통계_테스트() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run(price, rightWinningNumbers, rightBonusNumber);
                    assertThat(output()).contains(
                            WINNING_NUMBERS_MESSAGE,
                            BONUS_NUMBER_MESSAGE,
                            WINNING_STATISTICS_MESSAGE,
                            THREE_MATCH_MESSAGE,
                            FOUR_MATCH_MESSAGE,
                            FIVE_MATCH_MESSAGE,
                            FIVE_BONUS_MATCH_MESSAGE,
                            SIX_MATCH_MESSAGE
                    );
                },
                List.of(1, 8, 11, 31, 41, 42),
                List.of(13, 14, 16, 38, 42, 45),
                List.of(7, 11, 30, 40, 42, 43),
                List.of(2, 13, 22, 32, 38, 45),
                List.of(1, 3, 5, 14, 22, 45)
        );
    }

    @DisplayName("총 수익률 테스트")
    @Test
    void 총_수익률_테스트() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run(price, rightWinningNumbers, rightBonusNumber);
                    assertThat(output()).contains(
                            WINNING_NUMBERS_MESSAGE,
                            BONUS_NUMBER_MESSAGE,
                            WINNING_STATISTICS_MESSAGE,
                            THREE_MATCH_MESSAGE,
                            FOUR_MATCH_MESSAGE,
                            FIVE_MATCH_MESSAGE,
                            FIVE_BONUS_MATCH_MESSAGE,
                            SIX_MATCH_MESSAGE,
                            TOTAL_MARGIN_MESSAGE
                    );
                },
                List.of(1, 8, 11, 31, 41, 42),
                List.of(13, 14, 16, 38, 42, 45),
                List.of(7, 11, 30, 40, 42, 43),
                List.of(2, 13, 22, 32, 38, 45),
                List.of(1, 3, 5, 14, 22, 45)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
