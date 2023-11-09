package lotto;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

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

    @ParameterizedTest(name = "[{index}차]시도: invalidMoney: {0}")
    @DisplayName("1000원 단위로 나뉘어지지 않거나, 작거나, 1억이 넘어가면 IllegalArgumentException 이 발생한다.")
    @ValueSource(strings = {"999", "1001", "2001", "100_000_001"})
    void failInputInvalidMoney(String invalidMoney) {
        // given
        // when
        // then
        assertSimpleTest(() -> {
            runException(invalidMoney);
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @ParameterizedTest(name = "[{index}차]시도: invalidWiningNumbers: {0}")
    @DisplayName("유효한 길이가 아니거나, 중복된 숫자가 존재하거나, 공백이 포함되거나, 제한된 범위의 숫자가 아니면 IllegalArgumentException 이 발생한다.")
    @MethodSource("getInvalidWinningNumbers")
    void failInputInvalidWinningNumbers(List<String> invalidWiningNumbers) {
        // given
        String money = "8000";
        String inputInvalidWiningNumbers = invalidWiningNumbers.stream().collect(Collectors.joining(","));
        // when
        // then
        assertSimpleTest(() -> {
            runException(money, inputInvalidWiningNumbers);
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @ParameterizedTest(name = "[{index}차]시도: invalidBonusNumber: {0}")
    @DisplayName("당첨번호에 포함된 번호이거나, 공백이거나, 숫자형이 아니거나, 제한된 범위의 숫자가 아니면면 IllegalArgumentException 이 발생한다.")
    @ValueSource(strings = {" ","1", "0","46"})
    void failInputInvalidBonusNumber(String bonusNumber) {
        // given
        String money = "8000";
        String winingNumbers = List.of("1","2","3","4","5","6").stream().collect(Collectors.joining(","));
        // when
        // then
        assertSimpleTest(() -> {
            runException(money, winingNumbers,bonusNumber);
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    static Stream<Arguments> getInvalidWinningNumbers() {
        return Stream.of(
                Arguments.arguments(List.of("1", "1", "3", "4", "5", "6")),
                Arguments.arguments(List.of("1", "2", "3", "4", "5", " ")),
                Arguments.arguments(List.of("0", "1", "3", "4", "5", "6")),
                Arguments.arguments(List.of("1", "3", "4", "5", "6"))
        );
    }


    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
