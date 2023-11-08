package lotto.domain.generator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.stream.Stream;
import lotto.domain.money.Money;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LottoGeneratorTest {
    LottoGenerator lottoGenerator;

    @BeforeEach
    void setUp() {
        lottoGenerator = new LottoGenerator();
    }

    @DisplayName("올바르지 않은 당첨 번호에 대한 예외 처리 확인")
    @ParameterizedTest(name = "{0}")
    @MethodSource("provideInvalidWinningNumber")
    void createWinningLottoFromInput_WithInvalidWinningNumber(
            String testMessage,
            String input,
            String expectedErrorMessage
    ) {
        // 보너스 번호는 예외를 발생시키지 않는 값으로 설정
        int bonusNumber = 45;
        assertThatThrownBy(() -> lottoGenerator.createWinningLottoFromInput(input, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(expectedErrorMessage);

    }

    @DisplayName("올바르지 않은 보너스 번호에 대한 예외 처리 확인")
    @ParameterizedTest(name = "{0}")
    @MethodSource("provideInvalidBonusNumber")
    void createWinningLottoFromInput_WithInvalidBonusNumber(
            String testMessage,
            int input,
            String expectedErrorMessage
    ) {
        // 당첨 번호는 예외를 발생시키지 않는 값으로 설정
        String winningNumber = "1,2,3,4,5,6";
        assertThatThrownBy(() -> lottoGenerator.createWinningLottoFromInput(winningNumber, input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(expectedErrorMessage);
    }

    @DisplayName("올바르지 않은 금액 형식에 대한 예외 처리 확인")
    @ParameterizedTest(name = "{0}")
    @MethodSource("provideInvalidPrice")
    void createLottoByPrice_WithInvalidAmount(
            String testMessage,
            Money price,
            String expectedErrorMessage
    ) {
        assertThatThrownBy(() -> lottoGenerator.createLottoByPrice(price))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(expectedErrorMessage);
    }

    static Stream<Arguments> provideInvalidWinningNumber() {
        return Stream.of(
                arguments("비어있는 입력값", "", "입력이 존재하지 않습니다."),
                arguments("컴마가 아닌 다른 구분자", "1:2:3:4:5:6", "입력 형식이 올바르지 않습니다."),
                arguments("문자가 섞여있는 경우", "1,a,3,4,5,6", "입력 형식이 올바르지 않습니다."),
                arguments("컴마 사이에 공백이 있는 경우", "1, 2, 3, 4, 5, 6", "입력 형식이 올바르지 않습니다."),
                arguments("숫자를 5개만 입력한 경우", "1,2,3,4,5", "입력 숫자는 6개여야 합니다.")
        );
    }

    static Stream<Arguments> provideInvalidBonusNumber() {
        return Stream.of(
                arguments("음수인 보너스 번호", -1, "숫자 범위는 1부터 45까지 가능합니다."),
                arguments("45를 초과하는 보너스 번호", 46, "숫자 범위는 1부터 45까지 가능합니다."),
                arguments("당첨 번호와 중복되는 번호", 6, "당첨 번호와 보너스 번호는 중복될 수 없습니다.")
        );
    }

    static Stream<Arguments> provideInvalidPrice() {
        return Stream.of(
                arguments("1000원 단위가 아닌 금액", new Money(8156L), "금액은 1000원 단위로 입력해야 합니다."),
                arguments("1000원 미만의 금액", new Money(500L), "최소 1000원의 금액을 입력해야 합니다.")
        );
    }
}