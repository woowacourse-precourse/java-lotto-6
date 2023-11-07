package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

class ApplicationUserTest extends NsTest {
    private static final String ERROR_MESSAGE = "[ERROR]";

    @DisplayName("정상 구입금액 입력 테스트")
    @Test
    void validPurchaseAmountInputTest() {
        assertSimpleTest(
                () -> {
                    run("3000", "1,2,3,4,5,6", "7");
                    assertThat(output()).contains("3개를 구매했습니다.");

                });
    }

    @DisplayName("잘못된 구입금액 입력 테스트")
    @Test
    void invalidPurchaseAmountInputTest() {
        assertSimpleTest(() -> {
            runException("1000j");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("정상 당첨번호 입력 테스트")
    @Test
    void validWinningNumberInputTest() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("5000", "1,2,3,4,5,6", "7");
                    assertThat(output()).contains(
                            "5개를 구매했습니다.",
                            "3개 일치 (5,000원) - 1개",
                            "4개 일치 (50,000원) - 1개",
                            "5개 일치 (1,500,000원) - 1개",
                            "5개 일치, 보너스 볼 일치 (30,000,000원) - 1개",
                            "6개 일치 (2,000,000,000원) - 1개"
                    );
                },
                List.of(1, 2, 3, 4, 5, 6),
                List.of(2, 3, 4, 5, 6, 7),
                List.of(2, 3, 4, 5, 6, 45),
                List.of(2, 3, 4, 5, 44, 45),
                List.of(4, 5, 6, 43, 44, 45)
        );
    }

    @DisplayName("잘못된 당첨번호 입력 테스트")
    @Test
    void invalidWinningNumberInputTest() {
        assertSimpleTest(() -> {
            runException("3000", "1,2");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("잘못된 당첨번호 중복 입력 테스트")
    @Test
    void invalidWinningNumberDuplicateInputTest() {
        assertSimpleTest(() -> {
            runException("3000", "1,2,1,2,1,2");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("정상 보너스번호 입력 테스트")
    @Test
    void validBonusNumberInputTest() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("3000", "1,2,3,4,5,6", "7");
                    assertThat(output()).contains("보너스 번호를 입력해 주세요.");
                },
                List.of(1, 2, 3, 4, 5, 6)
        );
    }

    @DisplayName("잘못된 보너스번호 입력 테스트")
    @Test
    void invalidBonusNumberInputTest() {
        assertSimpleTest(() -> {
            runException("3000", "1,2,3,4,5,6", "46");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("잘못된 보너스번호 중복 입력 테스트")
    @Test
    void invalidBonusNumberDuplicateInputTest() {
        assertSimpleTest(() -> {
            runException("3000", "1,2,3,4,5,6", "6");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
