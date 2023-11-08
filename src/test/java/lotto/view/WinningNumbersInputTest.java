package lotto.view;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.AppConfig;
import lotto.constant.errorMessage.input.InputExceptionStatus;
import lotto.constant.errorMessage.exception.CustomNullPointAmountException;
import lotto.constant.errorMessage.exception.CustomNumberFormatAmountException;
import lotto.view.reader.CustomReader;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullSource;

class WinningNumbersInputTest {

    private static final String PROVIDER_PATH = "lotto.view.provider.WinningNumbersInputTestProvider#";
    private static final AppConfig APP_CONFIG = AppConfig.getInstance();

    private final CustomReader customReader = APP_CONFIG.reader;
    private final InputView inputView = APP_CONFIG.inputView;

    @ParameterizedTest
    @NullSource
    @DisplayName("당첨 번호는 NULL 값을 입력할 수 없다.")
    void winningNumbersNullExceptionTest(final String input) {
        customReader.initInput(input);
        assertThatThrownBy(inputView::readWinningNumbers)
                .isInstanceOf(CustomNullPointAmountException.class)
                .hasMessageContaining(InputExceptionStatus.READ_IS_NULL.getMessage());
    }

    @ParameterizedTest
    @MethodSource(PROVIDER_PATH + "provideValuesForNotNumericException")
    @DisplayName("당첨 번호는 숫자 이외의 값은 입력할 수 없다.")
    void winningNumbersNotNumericExceptionTest(final String input) {
        customReader.initInput(input);
        assertThatThrownBy(inputView::readWinningNumbers)
                .isInstanceOf(CustomNumberFormatAmountException.class)
                .hasMessageContaining(InputExceptionStatus.READ_IS_NOT_NUMERIC.getMessage());
    }

    @ParameterizedTest
    @MethodSource(PROVIDER_PATH + "provideValuesForNormalInput")
    @DisplayName("당첨 번호 입력 테스트")
    void readWinningNumbersTest(final String input, final List<Integer> expected) {
        customReader.initInput(input);
        final List<Integer> winningNumbers = inputView.readWinningNumbers();
        assertThat(winningNumbers).isEqualTo(expected);
    }
}
