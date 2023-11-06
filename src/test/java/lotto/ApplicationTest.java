package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.assertj.core.api.InputStreamAssert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    private static final String ERROR_MESSAGE = "[ERROR]";
    private InputHandler inputHandler = new InputHandler();
    private InputStream inputStream;

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
    @DisplayName("가격 입력이 잘못된 경우")
    void inputTest() {
        String input = "2145g";
        assertThatThrownBy(() -> {
            inputHandler.readCost(input);
                }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 숫자만을 입력해야 합니다.");
    }
    @Test
    @DisplayName("1000원 단위로 나누어 떨어지지 않는 경우")
    void inputTest2() {
        String input = "12345";
        assertThatThrownBy(() -> {
            inputHandler.readCost(input);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 1000원으로 나누어 떨어지는 숫자를 입력해야 합니다.");
    }

    @Test
    @DisplayName("제대로 된 입력값의 경우")
    void inputTest3() {
        String input = "12000";
        assertThat(inputHandler.readCost(input)).isEqualTo(12000);
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
