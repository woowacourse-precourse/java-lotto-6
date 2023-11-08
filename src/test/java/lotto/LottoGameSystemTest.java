package lotto;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Named.named;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Named;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.MethodSource;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class LottoGameSystemTest extends NsTest {

    public static final Named<String> EMPTY_STRING = named("빈 문자열", "");
    public static final Named<String> BLANK_STRING = named("공백 문자열", " ");
    public static final Named<String> NEGATIVE_INPUT_MONEY = named("-1원", "-1");
    public static final Named<String> INVALID_INPUT_MONEY_UNIT = named("1234원", "1234");

    public static final String NO_INPUT_MONEY = "0";
    public static final String WINNING_LOTTO_NUMBER = "1,2,3,4,5,6";
    public static final String BONUS_NUMBER = "7";
    public static final String ERROR_MESSAGE = "[ERROR]";

    @ParameterizedTest(name = "구입 금액 {0}원에 해당하는 로또를 발행하여 진행하다.")
    @MethodSource("provideValidSystemTestParameters")
    void 성공적으로_게임을_진행하다(String inputMoney, List<String> expected,
                        List<Integer> firstIssuedLotto, List<Integer>... subsequentIssuedLottoList) {
        assertRandomUniqueNumbersInRangeTest(() -> {
            run(inputMoney, WINNING_LOTTO_NUMBER, BONUS_NUMBER);
            assertThat(output()).contains(expected);
        }, firstIssuedLotto, subsequentIssuedLottoList);
    }

    private static Stream<Arguments> provideValidSystemTestParameters() {

        return Stream.of(
                arguments("0", List.of("0개를 구매했습니다.", "총 수익률은 0.0%입니다."), List.of(),
                        new List[]{}),
                arguments("7000", List.of("7개를 구매했습니다.", "총 수익률은 71.4%입니다."),
                        List.of(1, 23, 44, 4, 6, 7),
                        new List[]{List.of(1, 26, 45, 6, 7, 8), List.of(2, 43, 35, 6, 17, 8),
                                List.of(35, 26, 7, 4, 19, 10), List.of(10, 33, 5, 8, 13, 1),
                                List.of(42, 13, 8, 7, 19, 5), List.of(27, 35, 16, 22, 41, 8)}));
    }

    @Nested
    @TestInstance(Lifecycle.PER_CLASS)
    @DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
    class 예외_테스트 {

        @ParameterizedTest(name = "구입 금액으로 {0}을 입력하면 예외가 발생한다.")
        @MethodSource("provideInvalidInputMoney")
        void 잘못된_구입_금액_입력(String invalidInputMoney) {
            assertSimpleTest(() -> {
                runException(invalidInputMoney, NO_INPUT_MONEY, WINNING_LOTTO_NUMBER, BONUS_NUMBER);
                assertThat(output()).contains(ERROR_MESSAGE);
            });
        }

        @ParameterizedTest(name = "당첨 번호 중 하나에 {0} 입력하면 예외가 발생한다.")
        @MethodSource("provideInvalidWinningNumber")
        void 잘못된_당첨_번호_입력(String invalidWinningNumber) {
            assertSimpleTest(() -> {
                runException(NO_INPUT_MONEY, invalidWinningNumber, WINNING_LOTTO_NUMBER, BONUS_NUMBER);
                assertThat(output()).contains(ERROR_MESSAGE);
            });
        }

        @ParameterizedTest(name = "보너스 번호로 {0} 입력하면 예외가 발생한다.")
        @ArgumentsSource(BonusNumberTestArgumentsProvider.class)
        void 잘못된_보너스_번호_입력(String invalidBonusNumber) {
            assertSimpleTest(() -> {
                runException(NO_INPUT_MONEY, WINNING_LOTTO_NUMBER, invalidBonusNumber, BONUS_NUMBER);
                assertThat(output()).contains(ERROR_MESSAGE);
            });
        }

        private static Stream<Arguments> provideInvalidInputMoney() {
            return Stream.of(
                    arguments(EMPTY_STRING),
                    arguments(BLANK_STRING),
                    arguments(NEGATIVE_INPUT_MONEY),
                    arguments(INVALID_INPUT_MONEY_UNIT)
            );
        }

        private static Stream<Arguments> provideInvalidWinningNumber() {
            return Stream.of(
                    arguments(named("a를", "a,2,3,4,5,6")),
                    arguments(named("0을", "0,2,3,4,5,6")),
                    arguments(named("46을", "1,2,3,4,5,46")),
                    arguments(named("중복된 수를", "1,1,3,4,5,6"))
            );
        }

        static class BonusNumberTestArgumentsProvider implements ArgumentsProvider {

            @Override
            public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
                return Stream.of(
                        arguments(named("a를", "a")),
                        arguments(named("0을", "0")),
                        arguments(named("46을", "46")),
                        arguments(named("당첨 번호와 중복된 수를", "1"))
                );
            }
        }
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
