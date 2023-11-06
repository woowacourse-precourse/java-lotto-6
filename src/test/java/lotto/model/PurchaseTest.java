package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.constant.ErrorMessage;
import lotto.validator.InputValidator;
import org.junit.jupiter.api.Test;

public class PurchaseTest {

    @Test
    void 구입_금액_입력이_비어있는지_검증_실패_테스트() {
        String input = "";
        String expectedErrorMessage = ErrorMessage.INPUT_EMPTY.get();

        assertThatThrownBy(() -> InputValidator.validateEmpty(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(expectedErrorMessage);
    }

    @Test
    void 구입_금액_입력이_숫자인지_검증_성공_테스트() {
        String input = "1242";
        int expectedResult = 1242;

        int actualResult = InputValidator.validateNumber(input);

        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test
    void 구입_금액_입력이_숫자인지_검증_실패_테스트() {
        String input = "asdf";
        String expectedErrorMessage = ErrorMessage.INPUT_NOT_NUMBER.get();

        assertThatThrownBy(() -> InputValidator.validateNumber(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(expectedErrorMessage);
    }

    @Test
    void 구입_금액_입력_0일때_실패_테스트() {
        int purchaseMoney = 0;
        String expectedErrorMessage = ErrorMessage.PURCHASE_MONEY_NOT_BIGGER_THAN_ZERO.get();

        assertThatThrownBy(() -> new Purchase(purchaseMoney))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(expectedErrorMessage);
    }

    @Test
    void 구입_금액_입력_1000원_단위인지_검증_성공_테스트() {
        int purchaseMoney = 25000;
        int expectedLottoAmount = 25;

        Purchase purchase = new Purchase(purchaseMoney);
        int actualLottoAmount = purchase.getLottoAmount();

        assertThat(actualLottoAmount).isEqualTo(expectedLottoAmount);
    }

    @Test
    void 구입_금액_입력_1000원_단위인지_검증_실패_테스트() {
        int purchaseMoney = 123;
        String expectedErrorMessage = ErrorMessage.PURCHASE_MONEY_NOT_MULTIPLE_OF_1000.get();

        assertThatThrownBy(() -> new Purchase(purchaseMoney))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(expectedErrorMessage);
    }
}