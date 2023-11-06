package lotto.view;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.stream.Stream;
import lotto.AppConfig;
import lotto.view.reader.CustomReader;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class InputViewTest {

    private static final AppConfig APP_CONFIG = AppConfig.getInstance();

    private final CustomReader customReader = APP_CONFIG.reader;
    private final InputView inputView = APP_CONFIG.inputView;

    @ParameterizedTest
    @MethodSource("provideValuesForNotNumericException")
    @DisplayName("숫자 이외의 값은 입력할 수 없다.")
    void readPurchaseAmountTest(final String input) {
        customReader.initInput(input);
        assertThatThrownBy(inputView::readPurchaseAmount)
                .isInstanceOf(NumberFormatException.class);
    }

    @ParameterizedTest
    @MethodSource("provideValuesForNormalInput")
    @DisplayName("로또 구입 금액 입력 테스트")
    void readPurchaseAmountTest(final String input, final int expected) {
        customReader.initInput(input);
        final int amount = inputView.readPurchaseAmount();
        assertThat(amount).isEqualTo(expected);
    }

    private static Stream<Arguments> provideValuesForNormalInput() {
        return Stream.of(
                Arguments.of("1000", 1000),
                Arguments.of("2000", 2000),
                Arguments.of("3333", 3333),
                Arguments.of("0", 0),
                Arguments.of("-1", -1)
        );
    }

    private static Stream<Arguments> provideValuesForNotNumericException() {
        return Stream.of(
                Arguments.of("100-0"),
                Arguments.of("20-00"),
                Arguments.of(" er66-"),
                Arguments.of(" "),
                Arguments.of("")
        );
    }
}
