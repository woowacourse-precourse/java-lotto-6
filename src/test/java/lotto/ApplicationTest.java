package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.domain.Cash;
import lotto.dto.RequestCash;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

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


    // test when user entered the wrong cash
    @Test
    void 예외_테스트() {
        assertSimpleTest(() -> {
            runException("1000j");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }


    @Test
    @DisplayName("공백을 입력한 경우 예외 발생")
    void inputBlankExceptionTest() {
        assertSimpleTest(() -> {
            runException(" ");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("1000원 보다 작은 값을 압력한 경우 에외 발생")
    @ParameterizedTest
    @ValueSource(strings = {"100", "200", "300", "999", "-1000"})
    void inputAmountSmallThanUnitExceptionTest(String amountSmallThanUnit) {
        assertSimpleTest(() -> {
            runException(amountSmallThanUnit);
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("1000원 으로 나누어 떨어지지 않는 값을 압력한 경우 예외 발생")
    @ParameterizedTest
    @ValueSource(strings = {"1001", "2002", "3003", "4004", "9999"})
    void inputNotDivisibleByUnitExceptionTest(String notDivisibleByUnit) {
        assertSimpleTest(() -> {
            runException(notDivisibleByUnit);
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }


    // test when user entered the wrong numbers of winning lotto
    @DisplayName("입력한 당첨 로또 번호에 숫자 이외의 값을 입력한 경우 예외 발생")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,ㄹ,5", "1,2,3,4, ,5", "1,2,3,4,a,5", "1,2,3,4,%,5"})
    void inputWinnerNumbersIncludeNotNumberExceptionTest(String wrongWinnerNumbers) {
        assertSimpleTest(
                () -> {
                    runException("8000", wrongWinnerNumbers);
                    assertThat(output()).contains(ERROR_MESSAGE);
                }
        );
    }

    @DisplayName("입력한 당첨 로또 번호에 1~45 범위를 벗어난 숫자 이외의 값을 입력한 경우 예외 발생")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,0,5", "1,2,3,4,100,5", "1,2,3,4,-12,5", "1,2,3,4,50,5"})
    void inputWinnerNumbersIncludeOverRangedNumberExceptionTest(String wrongWinnerNumbers) {
        assertSimpleTest(
                () -> {
                    runException("8000", wrongWinnerNumbers, "45");
                    assertThat(output()).contains(ERROR_MESSAGE);
                }
        );

    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
