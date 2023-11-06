package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.constant.ErrorMessage;
import lotto.validator.InputValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PurchaseTest {

    @DisplayName("구입 금액 입력값이 공백일 경우 예외가 발생한다.")
    @Test
    void 구입_금액_입력이_비어있는지_검증_실패_테스트() {
        String input = "";
        String expectedErrorMessage = ErrorMessage.INPUT_EMPTY.get();

        assertThatThrownBy(() -> InputValidator.validateEmpty(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(expectedErrorMessage);
    }

    @DisplayName("구입 금액 입력이 숫자면 입력값 유효성 검사에 성공한다.")
    @Test
    void 구입_금액_입력이_숫자인지_검증_성공_테스트() {
        String input = "1242";
        int expectedResult = 1242;

        int actualResult = InputValidator.validateNumber(input);

        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @DisplayName("구입 금액 입력이 숫자가 아니면 예외가 발생한다.")
    @Test
    void 구입_금액_입력이_숫자인지_검증_실패_테스트() {
        String input = "asdf";
        String expectedErrorMessage = ErrorMessage.INPUT_NOT_NUMBER.get();

        assertThatThrownBy(() -> InputValidator.validateNumber(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(expectedErrorMessage);
    }

    @DisplayName("구입 금액 입력이 0이면 예외가 발생한다.")
    @Test
    void 구입_금액_입력_0일때_실패_테스트() {
        int purchaseMoney = 0;
        String expectedErrorMessage = ErrorMessage.PURCHASE_MONEY_NOT_BIGGER_THAN_ZERO.get();

        assertThatThrownBy(() -> new Purchase(purchaseMoney))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(expectedErrorMessage);
    }

    @DisplayName("구입 금액 입력이 1000의 배수이면 로또 개수를 정상적으로 반환한다.")
    @Test
    void 구입_금액_입력_1000원_단위인지_검증_성공_테스트() {
        int purchaseMoney = 25000;
        int expectedLottoAmount = 25;

        Purchase purchase = new Purchase(purchaseMoney);
        int actualLottoAmount = purchase.getLottoAmount();

        assertThat(actualLottoAmount).isEqualTo(expectedLottoAmount);
    }

    @DisplayName("구입 금액 입력이 1000의 배수가 아니면 예외가 발생한다.")
    @Test
    void 구입_금액_입력_1000원_단위인지_검증_실패_테스트() {
        int purchaseMoney = 123;
        String expectedErrorMessage = ErrorMessage.PURCHASE_MONEY_NOT_MULTIPLE_OF_1000.get();

        assertThatThrownBy(() -> new Purchase(purchaseMoney))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(expectedErrorMessage);
    }
}