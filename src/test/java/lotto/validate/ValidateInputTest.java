package lotto.validate;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ValidateInputTest {

    private static final String EMPTY_STRING = "";
    private static final int LOTTO_PRICE = 1000;
    private static final String NON_EMPTY_MESSAGE = "[ERROR] 값을 입력해주세요.";
    private static final String NON_BLANK_MESSAGE = "[ERROR] 비어있는 값은 입력할 수 없습니다.";
    private static final String WRONG_TYPE_INPUT_MESSAGE = "[ERROR] 정수형태로 입력해주세요";
    private static final String CANNOT_DIVISIBLE_MESSAGE = "[ERROR] 금액을 " + LOTTO_PRICE + "원 단위로 나눌 수 없습니다.";


    @DisplayName("구입 금액을 미입력하면 예외가 발생한다.")
    @Test
    void 구입금액_미입력_예외_처리() {
        //given
        final String input = EMPTY_STRING;

        //when,then
        assertThatThrownBy(() -> ValidateInput.validatePurchaseAmount(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(NON_EMPTY_MESSAGE);
    }

    @DisplayName("구입 금액 사이에 공백이 들어오면 예외가 발생한다.")
    @Test
    void 구입금액_공백_예외_처리() {
        //given
        final String input = "10 00";

        //when,then
        assertThatThrownBy(() -> ValidateInput.validatePurchaseAmount(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(NON_BLANK_MESSAGE);
    }

    @DisplayName("구입 금액이 정수형태가 아니면 예외가 발생한다.")
    @Test
    void 구입금액_타입_예외_처리() {
        //given
        final String input = "나라사랑1000";

        //when,then
        assertThatThrownBy(() -> ValidateInput.validatePurchaseAmount(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(WRONG_TYPE_INPUT_MESSAGE);
    }

    @DisplayName("구입 금액이 Lotto 가격으로 나누어 떨어지지 않으면 예외가 발생한다.")
    @Test
    void 구입금액_나눗셈여부_예외_처리() {
        //given
        final String input = "2020";

        //when,then
        assertThatThrownBy(() -> ValidateInput.validatePurchaseAmount(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(CANNOT_DIVISIBLE_MESSAGE);
    }

}
