package lotto.validation;

import java.util.List;
import lotto.constant.ErrorMessage;
import lotto.service.ValidateService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class validationTest {
    ValidateService validateService = new ValidateService();

    @Test
    @DisplayName("구입금액 입력시 숫자가 아닌값을 입력하면 예외가 일어난다")
    void 번호에_숫자가아닌값_입력() {
        String inputItem = "18000;";

        assertThatThrownBy(() -> validateService.validateNumber(inputItem)).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.INPUT_NUMBER_ERROR.getMessage());
    }

    @Test
    @DisplayName("구입금액은 1000원으로 나누어떨어지지 않으면 예외를 발생시킨다.")
    void 구입금액_테스트() {
        int purchasePrice = 3500;
        assertThatThrownBy(() -> validateService.validatePurchasePriceAll(purchasePrice)).isInstanceOf(
                        IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.DIVISIBILITY_CHECK_AMOUNT.getMessage());
    }

    @Test
    @DisplayName("구입금액은 1000원보다 낮으면 안된다")
    void 구입금액_모자람_테스트() {
        int purchasePrice = 500;
        assertThatThrownBy(() -> validateService.validatePurchasePriceAll(purchasePrice)).isInstanceOf(
                        IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.INSUFFICIENT_PRICE_MESSAGE.getMessage());
    }

    @Test
    @DisplayName("당첨번호 입력시 1~45 사이의 숫자가 아닐시 예외를 발생시킨다.")
    void 당첨번호_입력_범위_테스트() {
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 46);
        assertThatThrownBy(() -> validateService.validateInputWinningNumbersAll(winningNumbers)).isInstanceOf(
                        IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.INPUT_NUMBER_OVER_RANGE_ERROR.getMessage());
    }

    @Test
    @DisplayName("당첨번호 입력시 중복된 번호가 존재할 경우 예외를 발생시킨다.")
    void 당첨번호_중복_테스트() {
        List<Integer> winningNumbers = List.of(1, 2, 3, 3, 4, 5);
        assertThatThrownBy(() -> validateService.validateInputWinningNumbersAll(winningNumbers)).isInstanceOf(
                        IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.INPUT_DUPLICATE_NUMBER_ERROR.getMessage());
    }


}
