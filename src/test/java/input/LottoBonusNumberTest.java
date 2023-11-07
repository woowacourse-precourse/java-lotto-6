package input;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.Application;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoBonusNumberTest extends NsTest {

    private static final String ERROR_MESSAGE1 = "[ERROR] 입력한 로또 당첨 보너스 번호는 1 ~ 45 사이의 숫자여야 합니다.";
    private static final String ERROR_MESSAGE2 = "[ERROR] 숫자를 입력해주세요.";
    private static final String ERROR_MESSAGE3 = "[ERROR] 입력한 보너스 번호는 로또 당첨 번호와 중복된 숫자가 존재합니다.";

    @DisplayName("보너스 번호 입력 시 1~45 숫자가 아닌 다른 값을 입력했을 경우 예외가 발생한다.")
    @ParameterizedTest
    @MethodSource("provideInputForInvalidInputBonusNumber")
    void createLottoBonusNumberByValidRange(String input, String expectedMessage) {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    assertThatThrownBy(() ->
                            run("3000", "1,2,3,4,5,6", input));
                    assertThat(output()).contains(expectedMessage);
                },
                List.of(8, 21, 23, 41, 42, 43),
                List.of(3, 5, 11, 16, 32, 38),
                List.of(7, 11, 16, 35, 36, 44)
        );
    }

    private static Stream<Arguments> provideInputForInvalidInputBonusNumber() {
        return Stream.of(
                Arguments.of("-1", ERROR_MESSAGE1),
                Arguments.of("0", ERROR_MESSAGE1),
                Arguments.of("46", ERROR_MESSAGE1),
                Arguments.of("1000000", ERROR_MESSAGE1),
                Arguments.of("!@#safdas", ERROR_MESSAGE2)
        );
    }

    @DisplayName("보너스 번호 입력 시 로또 당첨 번호 6개 중 중복인 경우 예외가 발생한다.")
    @ParameterizedTest
    @MethodSource("provideInputForInvalidInputUniqueNumber")
    void createLottoBonusNumberByUniqueValue(String input, String expectedMessage) {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    assertThatThrownBy(() ->
                            run("3000", "1,2,3,4,5,6", input));
                    assertThat(output()).contains(expectedMessage);
                },
                List.of(8, 21, 23, 41, 42, 43),
                List.of(3, 5, 11, 16, 32, 38),
                List.of(7, 11, 16, 35, 36, 44)
        );
    }

    private static Stream<Arguments> provideInputForInvalidInputUniqueNumber() {
        return Stream.of(
                Arguments.of("1", ERROR_MESSAGE3),
                Arguments.of("2", ERROR_MESSAGE3),
                Arguments.of("3", ERROR_MESSAGE3),
                Arguments.of("4", ERROR_MESSAGE3),
                Arguments.of("5", ERROR_MESSAGE3),
                Arguments.of("6", ERROR_MESSAGE3)
        );
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
