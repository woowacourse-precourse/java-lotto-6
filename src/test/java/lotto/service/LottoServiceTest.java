package lotto.service;

import lotto.Lotto;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static lotto.loader.ApplicationLoader.getContainer;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class LottoServiceTest {
    private static final Class<?> EXCEPTION_CLASS = IllegalArgumentException.class;
    private final LottoService lottoService = getContainer().getBean(LottoService.class);

    static Stream<Arguments> parsePaymentTestCases () {
        return Stream.of(
                Arguments.of("숫자를 제외한 다른 값을 입력한 경우 예외가 발생합니다.", "1000k", EXCEPTION_CLASS),
                Arguments.of("입력한 숫자가 0인 경우 예외가 발생합니다.", "0", EXCEPTION_CLASS),
                Arguments.of("입력한 숫자가 1000 단위가 아닌 경우 예외가 발생합니다.", "1001", EXCEPTION_CLASS),
                Arguments.of("값을 입력하지 않은 경우 예외가 발생합니다.", "", EXCEPTION_CLASS),
                Arguments.of("유효성 검사를 통과한 경우 그 숫자를 결과로 반환합니다.", "3000", null)
        );
    }

    @ParameterizedTest(name = "[{index}] {0}")
    @MethodSource("parsePaymentTestCases")
    @DisplayName("parsePayment()")
    void parsePayment(
            String testCaseName,
            String input,
            Class<?> expectedException
    ) {
        // given

        // when

        // then
        if (expectedException != null) {
            assertThatThrownBy(() -> lottoService.parsePayment(input))
                    .isInstanceOf(expectedException);
            return;
        }
        assertThat(lottoService.parsePayment(input)).isEqualTo(Integer.parseInt(input));
    }

    static Stream<Arguments> parseWinningNumbersTestCases() {
        return Stream.of(
                Arguments.of("유효성 검사를 통과한 경우 로또를 생성하여 반환합니다.", "1,2,3,4,5,6", null),
                Arguments.of("주어진 숫자 범위를 벗어난 경우 예외가 발생합니다.(1)", "0,1,2,3,4,5", EXCEPTION_CLASS),
                Arguments.of("주어진 숫자 범위를 벗어난 경우 예외가 발생합니다.(2)", "1,2,3,4,5,50", EXCEPTION_CLASS),
                Arguments.of("값을 입력하지 않은 경우 예외가 발생합니다.", "", EXCEPTION_CLASS),
                Arguments.of("숫자를 너무 많이 입력한 경우 예외가 발생합니다.", "1,2,3,4,5,6,7", EXCEPTION_CLASS),
                Arguments.of("숫자를 너무 적게 입력한 경우 예외가 발생합니다.", "1,2,3,4,5", EXCEPTION_CLASS),
                Arguments.of("숫자와 쉼표(,)가 아닌 문자를 입력한 경우 예외가 발생합니다.", "1,2,3,f,5,6", EXCEPTION_CLASS)
        );
    }

    @ParameterizedTest(name = "[{index}] {0}")
    @MethodSource("parseWinningNumbersTestCases")
    @DisplayName("parseWinningNumbers()")
    void parseWinningNumbers(
            String testCaseName,
            String input,
            Class<?> expectedException
    ) {
        // given

        // when

        // then
        if (expectedException != null) {
            assertThatThrownBy(() -> lottoService.parseWinningNumbers(input))
                    .isInstanceOf(expectedException);
            return;
        }
        assertThat(lottoService.parseWinningNumbers(input).getNumbers().toString()).contains("1, 2, 3, 4, 5, 6");
    }

    static Stream<Arguments> parseBonusNumberTestCases() {
        return Stream.of(
                Arguments.of("유효성 검사를 통과한 경우 해당 숫자를 반환합니다.", "10", null),
                Arguments.of("주어진 숫자 범위를 벗어난 경우 예외가 발생합니다.(1)", "0", EXCEPTION_CLASS),
                Arguments.of("주어진 숫자 범위를 벗어난 경우 예외가 발생합니다.(2)", "46", EXCEPTION_CLASS),
                Arguments.of("값을 입력하지 않은 경우 예외가 발생합니다.", "", EXCEPTION_CLASS),
                Arguments.of("숫자를 제외한 입력 시 예외가 발생합니다.", "k", EXCEPTION_CLASS),
                Arguments.of("당첨 번호와 중복된 보너스 번호 입력 시 예외가 발생합니다.", "1", EXCEPTION_CLASS)
        );
    }

    @ParameterizedTest(name = "[{index}] {0}")
    @MethodSource("parseBonusNumberTestCases")
    @DisplayName("parseBonusNumber()")
    void parseBonusNumber(
            String testCaseName,
            String input,
            Class<?> expectedException
    ) {
        // given
        Lotto winningNumbers = new Lotto(Arrays.asList(1,2,3,4,5,6));

        // when

        // then
        if (expectedException != null) {
            assertThatThrownBy(() -> lottoService.parseBonusNumber(input, winningNumbers))
                    .isInstanceOf(EXCEPTION_CLASS);
            return;
        }
        assertThat(lottoService.parseBonusNumber(input, winningNumbers)).isEqualTo(Integer.parseInt(input));
    }

    static Stream<Arguments> lotteryMatchTestCases() {
        return Stream.of(
                Arguments.of("유효성 검사를 통과한 경우 해당 숫자를 반환합니다.", "10", null)
        );
    }

    @Disabled("lotteryMatch() 변경 가능성")
    @ParameterizedTest(name = "[{index}] {0}")
    @MethodSource("lotteryMatchTestCases")
    @DisplayName("lotteryMatch()")
    void lotteryMatch(
            String testCaseName
    ) {
        // given

        // when

        // then

    }

    static Stream<Arguments> calculateRewardTestCases() {
        return Stream.of(
                Arguments.of(
                        "1등: 1개, 2등: 1개, 3등: 1개, 4등: 1개, 5등: 1개 -> 2,031,555,000", Arrays.asList(1,1,1,1,1), 2031555000
                ),
                Arguments.of(
                        "1등: 0개, 2등: 2개, 3등: 1개, 4등: 0개, 5등: 0개 -> 61,550,000", Arrays.asList(0,2,1,0,0), 61500000
                ),
                Arguments.of(
                        "1등: 0개, 2등: 0개, 3등: 0개, 4등: 0개, 5등: 0개 -> 0", Arrays.asList(0,0,0,0,0), 0
                )
        );
    }

    @ParameterizedTest(name = "[{index}] {0}")
    @MethodSource("calculateRewardTestCases")
    @DisplayName("calculateReward()")
    void calculateReward(
            String testCaseName,
            List<Integer> matchResult,
            int reward
    ) {
        // given

        // when

        // then
        assertThat(lottoService.calculateReward(matchResult)).isEqualTo(reward);
    }

    static Stream<Arguments> generatePurchasedLotteryTestCases() {
        return Stream.of(
                Arguments.of("6개의 정수를 가진 리스트를 반환합니다.")
        );
    }

    @ParameterizedTest(name = "[{index}] {0}")
    @MethodSource("generatePurchasedLotteryTestCases")
    @DisplayName("generatePurchasedLottery()")
    void generatePurchasedLottery(
            String testCaseName
    ) {
        // given

        // when

        // then
        assertThat(lottoService.generatePurchasedLottery().getNumbers().size()).isEqualTo(6);
    }

    static Stream<Arguments> getRateOfReturnTestCases() {
                return Stream.of(
                Arguments.of("소숫점 둘째자리에서 반올림합니다. (1)", 100000, 6666666, 6666.7),
                        Arguments.of("소숫점 둘째자리에서 반올림합니다. (2)", 100000, 3333333, 3333.3),
                        Arguments.of("결과가 0인 경우 0.0을 반환합니다.", 10000, 0, 0.0)
        );
    }

    @ParameterizedTest(name = "[{index}] {0}")
    @MethodSource("getRateOfReturnTestCases")
    @DisplayName("getRateOfReturn()")
    void getRateOfReturn(
            String testCaseName,
            int payment,
            int reward,
            double result
    ) {
        // given

        // when

        // then
        assertThat(lottoService.getRateOfReturn(payment, reward)).isEqualTo(result);
    }
}