package lotto.view;

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
    @MethodSource("provideValuesForNormalInput")
    @DisplayName("로또 구입 금액 입력 테스트")
    void readPurchaseAmountTest(final String input, final int expected) {
        customReader.initInput(input);
        final int amount = inputView.readPurchaseAmount();
        Assertions.assertThat(amount).isEqualTo(expected);
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
}
