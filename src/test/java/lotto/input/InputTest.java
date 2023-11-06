package lotto.input;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static lotto.exception.ExceptionMessage.DIFFERENT_FORMAT_EXCEPTION_MESSAGE;
import static lotto.exception.ExceptionMessage.NOT_NUMBER_EXCEPTION_MESSAGE;
import static lotto.exception.ExceptionMessage.NULL_POINTER_EXCEPTION_MESSAGE;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import lotto.exception.LottoApplicationException;
import lotto.validator.InputValidator;
import lotto.view.InputView;

public class InputTest {

    private InputView inputView = new InputView();
    private InputValidator inputValidator = new InputValidator();

    @ParameterizedTest
    @CsvSource(value = {"   공 백 테 스트,공백테스트", "  공백 테스   트,공백테스트"})
    @DisplayName("공백 제거 정상적으로 작동하는 지 테스트")
    public void 공백_제거_테스트(String input, String expected) {
        assertThat(inputView.removeWhitespace(input)).isEqualTo(expected);
    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("입력에 Null값이 들어가는 경우")
    public void Null_입력_예외(String input) {
        assertThatThrownBy(() -> inputValidator.validateNotNull(input))
                .isInstanceOf(LottoApplicationException.class)
                .hasMessageContaining(NULL_POINTER_EXCEPTION_MESSAGE.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"1a2b3c",".2.","3 c"})
    @DisplayName("입력에 숫자외 문자가 들어갈 경우")
    public void 숫자_외_문자_입력_테스트(String input) {
        assertThatThrownBy(() -> inputValidator.validateNumber(input))
                .isInstanceOf(LottoApplicationException.class)
                .hasMessageContaining(NOT_NUMBER_EXCEPTION_MESSAGE.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"1111","0","1023","100000001","999","111"})
    @DisplayName("금액이 1,000원 단위가 아닌 입력시, 예외 테스트")
    public void 금액_단위_테스트(String input) {
        assertThatThrownBy(() -> inputValidator.validatePurchasePrice(input))
                .isInstanceOf(LottoApplicationException.class)
                .hasMessageContaining(DIFFERENT_FORMAT_EXCEPTION_MESSAGE.getMessage());
    }


}
