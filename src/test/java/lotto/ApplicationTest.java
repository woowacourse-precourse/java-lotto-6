package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.util.*;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ApplicationTest extends NsTest {
    private static final String ERROR_MESSAGE = "[ERROR]";

    @Test
    void validateInput_ValidInput() {
        Application.validateInput(1000);
        Application.validateInput(2000);
        // 입력이 유효한 경우 예외가 발생하지 않아야 합니다.
    }

    @Test
    void validateInput_InvalidInput() {
        assertThrows(IllegalArgumentException.class, () -> Application.validateInput(1050));
        assertThrows(IllegalArgumentException.class, () -> Application.validateInput(-1000));
        // 입력이 유효하지 않은 경우 예외가 발생해야 합니다.
    }

    @Test
    void isValidWinningNumbers_ValidNumbers() {
        assertEquals(1, Application.isValidWinningNumbers("1"));
        assertEquals(45, Application.isValidWinningNumbers("45"));
        // 입력이 유효한 경우 해당 숫자가 반환되어야 합니다.
    }

    @Test
    void isValidWinningNumbers_InvalidNumbers() {
        assertThrows(IllegalArgumentException.class, () -> Application.isValidWinningNumbers("0"));
        assertThrows(IllegalArgumentException.class, () -> Application.isValidWinningNumbers("46"));
        assertThrows(IllegalArgumentException.class, () -> Application.isValidWinningNumbers("abc"));
        // 입력이 유효하지 않은 경우 예외가 발생해야 합니다.
    }

    @Test
    void isDuplicateNumber_NoDuplicate() {
        Set<Integer> uniqueNumbers = new HashSet<>();
        uniqueNumbers.add(1);
        uniqueNumbers.add(2);

        assertEquals(uniqueNumbers, Application.isDuplicateNumber(3, uniqueNumbers));
        // 중복되지 않은 숫자를 추가하는 경우 집합에 추가되어야 합니다.
    }

    @Test
    void isDuplicateNumber_WithDuplicate() {
        Set<Integer> uniqueNumbers = new HashSet<>();
        uniqueNumbers.add(1);
        uniqueNumbers.add(2);

        assertThrows(IllegalArgumentException.class, () -> Application.isDuplicateNumber(2, uniqueNumbers));
        // 중복된 숫자를 추가하는 경우 예외가 발생해야 합니다.
    }
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

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
