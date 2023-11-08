package lotto.controller;

import lotto.domain.PurchaseAmount;
import lotto.utils.message.PurchaseAmountExceptionMessage;
import lotto.view.InputView;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

/*
 * while 무한 루프 내에서 요청하는
 * View, Domain Layer에 대한 Exception 테스트
 */
public class LayerTest {

    private static final String ERROR_CODE = "[ERROR]";

    @Nested
    @DisplayName("구매 금액 입력 했을 때")
    class PurchaseAmmountTest {
        @ParameterizedTest
        @ValueSource(strings = {"", " ", "  ", "   ", "     ", "\n", "\t", "\r"})
        @DisplayName("[Exception] 공백 입력 시 view에서 예외가 발생한다.")
        void blank(String wrongInput) {
            InputView inputView = new InputView(() -> wrongInput);
            Assertions.assertThatThrownBy(inputView::readPurchaseAmount)
                    .hasMessageContaining(ERROR_CODE)
                    .hasMessage(PurchaseAmountExceptionMessage.BLANK.getError());
        }

        @ParameterizedTest
        @ValueSource(strings = {" 1000", "2000 ", "1  ", "김준기   ", "꾸꾸     "})
        @DisplayName("[Exception] 공백 포함 입력 시 view에서 예외가 발생한다.")
        void blankMix(String wrongInput) {
            InputView inputView = new InputView(() -> wrongInput);
            Assertions.assertThatThrownBy(inputView::readPurchaseAmount)
                    .hasMessageContaining(ERROR_CODE)
                    .hasMessage(PurchaseAmountExceptionMessage.NOT_NUMERIC.getError());
        }

        @ParameterizedTest
        @ValueSource(strings = {"1234567890", "1          ", "           2"})
        @DisplayName("[Exception] 9자리 초과 입력 시 view에서 예외가 발생한다.")
        void exceedLength(String wrongInput) {
            InputView inputView = new InputView(() -> wrongInput);
            Assertions.assertThatThrownBy(inputView::readPurchaseAmount)
                    .hasMessageContaining(ERROR_CODE)
                    .hasMessage(PurchaseAmountExceptionMessage.EXCEED_LENGTH.getError());
        }

        @ParameterizedTest
        @ValueSource(strings = {"r1000", "200O ", "i000", "ㄱ000", "부부부"})
        @DisplayName("[Exception] 숫자가 아닌 문자 포함 시 view에서 예외가 발생한다.")
        void notNumeric(String wrongInput) {
            InputView inputView = new InputView(() -> wrongInput);
            Assertions.assertThatThrownBy(inputView::readPurchaseAmount)
                    .hasMessageContaining(ERROR_CODE)
                    .hasMessage(PurchaseAmountExceptionMessage.NOT_NUMERIC.getError());
        }

        @ParameterizedTest
        @ValueSource(strings = {"1000", "58571000", "2323000", "12312000", "100000000"})
        @DisplayName("[Exception] 공백 X, 9자리 이내, 숫자만 포함이면 view에서 예외가 발생하지 않는다.")
        void correct(String wrongInput) {
            InputView inputView = new InputView(() -> wrongInput);
            Assertions.assertThatCode(inputView::readPurchaseAmount)
                    .doesNotThrowAnyException();
        }

        @ParameterizedTest
        @ValueSource(strings = {"999", "-1", "0", "-123123", "100000001"})
        @DisplayName("[Exception] 1천원 ~ 1억 범위가 아닐 시 domain에서 예외가 발생한다.")
        void outOfRange(String wrongInput) {
            InputView inputView = new InputView(() -> wrongInput);
            Assertions.assertThatThrownBy(() -> new PurchaseAmount(inputView.readPurchaseAmount()))
                    .hasMessageContaining(ERROR_CODE)
                    .hasMessage(PurchaseAmountExceptionMessage.OUT_OF_AMOUNT_RANGE.getError());
        }

        @ParameterizedTest
        @ValueSource(strings = {"1100", "2010", "3001", "40000100", "5000999"})
        @DisplayName("[Exception] 1000원 단위가 아닐 시 domain에서 예외가 발생한다.")
        void invalidUnit(String wrongInput) {
            InputView inputView = new InputView(() -> wrongInput);
            Assertions.assertThatThrownBy(() -> new PurchaseAmount(inputView.readPurchaseAmount()))
                    .hasMessageContaining(ERROR_CODE)
                    .hasMessage(PurchaseAmountExceptionMessage.INVALID_AMOUNT_UNIT.getError());
        }

        @ParameterizedTest
        @ValueSource(strings = {"1000", "11000", "345000", "12345000", "1212000"})
        @DisplayName("[Exception] 올바른 구매 금액이면 view와 domain에서 예외가 발생하지 않는다.")
        void correctPurchaseAmount(String correctInput) {
            InputView inputView = new InputView(() -> correctInput);
            Assertions.assertThatCode(() -> new PurchaseAmount(inputView.readPurchaseAmount()))
                    .doesNotThrowAnyException();
        }
    }
}
