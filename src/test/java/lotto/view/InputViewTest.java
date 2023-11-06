package lotto.view;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.AppConfig;
import lotto.constant.errorMessage.amount.AmountExceptionStatus;
import lotto.constant.errorMessage.amount.NotNumericAmountException;
import lotto.constant.errorMessage.amount.NullAmountException;
import lotto.view.reader.CustomReader;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullSource;

class InputViewTest {

    private static final String PROVIDER_PATH = "lotto.view.provider.AmountInputTestProvider#";
    private static final AppConfig APP_CONFIG = AppConfig.getInstance();

    private final CustomReader customReader = APP_CONFIG.reader;
    private final InputView inputView = APP_CONFIG.inputView;

    @ParameterizedTest
    @NullSource
    @DisplayName("NULL 값은 입력할 수 없다.")
    void amountNullExceptionTest(final String input) {
        customReader.initInput(input);
        assertThatThrownBy(inputView::readAmount)
                .isInstanceOf(NullAmountException.class)
                .hasMessageContaining(AmountExceptionStatus.AMOUNT_IS_NULL.getMessage());
    }

    @ParameterizedTest
    @MethodSource(PROVIDER_PATH + "provideValuesForNotNumericException")
    @DisplayName("숫자 이외의 값은 입력할 수 없다.")
    void amountNotNumericExceptionTest(final String input) {
        customReader.initInput(input);
        assertThatThrownBy(inputView::readAmount)
                .isInstanceOf(NotNumericAmountException.class)
                .hasMessageContaining(AmountExceptionStatus.AMOUNT_IS_NOT_NUMERIC.getMessage());
    }

    @ParameterizedTest
    @MethodSource(PROVIDER_PATH + "provideValuesForNormalInput")
    @DisplayName("로또 구입 금액 입력 테스트")
    void readAmountTest(final String input, final int expected) {
        customReader.initInput(input);
        final int amount = inputView.readAmount();
        assertThat(amount).isEqualTo(expected);
    }
}
