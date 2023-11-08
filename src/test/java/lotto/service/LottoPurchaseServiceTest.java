package lotto.service;

import lotto.constants.AppConstants;
import lotto.constants.ErrorConstants;
import lotto.utils.StringUtil;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatCode;

public class LottoPurchaseServiceTest {
    @ParameterizedTest
    @ValueSource(strings = {"", " "})
    @DisplayName("구매 금액이 빈 값인 경우 에러 발생")
    void validatePurchaseAmountIsNullError(String purchaseAmount) {
        Assertions.assertThatThrownBy(
                        () -> StringUtil.checkNotNull(purchaseAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorConstants.PLEASE_ENTER_VALUE.getData());
    }

    @ParameterizedTest
    @ValueSource(strings = {"10000", "20000"})
    @DisplayName("구매 금액이 빈 값이 아닐 경우 정상")
    void validatePurchaseAmountIsNullNormal(String purchaseAmount) {
        assertThatCode(() -> StringUtil.checkNotNull(purchaseAmount))
                .doesNotThrowAnyException();
    }

    @ParameterizedTest
    @ValueSource(strings = {"no", "a11", "ㅠㅠㅠ232", "423a"})
    @DisplayName("구매 금액이 숫자가 아닌 경우 에러 발생")
    void validatePurchaseAmountIsNumericError(String purchaseAmount) {
        Assertions.assertThatThrownBy(
                        () -> StringUtil.checkNumeric(purchaseAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorConstants.ONLY_ENTER_NUMBERS.getData());
    }
    @ParameterizedTest
    @ValueSource(strings = {"1234", "4555", "78 90", "11111111111"})
    @DisplayName("구매 금액이 숫자인 경우 정상")
    void validatePurchaseAmountIsNumericNormal(String purchaseAmount) {
        assertThatCode(() -> StringUtil.checkNotNull(purchaseAmount))
                .doesNotThrowAnyException();
    }
    @ParameterizedTest
    @ValueSource(ints = {10, 0, 999, 0})
    @DisplayName("구매 금액이 최소 금액보다 작을 경우 에러 발생")
    void validatePurchaseAmountMinimumError(int purchaseAmount) {
        LottoPurchaseService lottoPurchaseService = new LottoPurchaseService();
        Assertions.assertThatThrownBy(
                        () -> lottoPurchaseService.validateMinimumAmount(purchaseAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(String.format(ErrorConstants.INVALID_RANGE_INPUT.getData(),
                        AppConstants.LOTTO_TICKET_PRICE));
    }

    @ParameterizedTest
    @ValueSource(ints = {1111, 1234, 900099, 9999})
    @DisplayName("입력 금액 단위가 1000원이 아닐 경우 에러 발생")
    void validatePurchaseAmountRangeError(int purchaseAmount) {
        LottoPurchaseService lottoPurchaseService = new LottoPurchaseService();
        Assertions.assertThatThrownBy(
                        () -> lottoPurchaseService.validateAmountInUnit(purchaseAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(String.format(ErrorConstants.INVALID_UNIT_INPUT.getData(),
                        AppConstants.LOTTO_TICKET_PRICE));
    }
    @ParameterizedTest
    @ValueSource(ints = {9999000, 4555000,7890000, 111111000})
    @DisplayName("입력 금액 단위가 1000원이 인 경우 정상")
    void validatePurchaseAmountRangeNormal(int purchaseAmount) {
        LottoPurchaseService lottoPurchaseService = new LottoPurchaseService();
        assertThatCode(() -> lottoPurchaseService.validateAmountInUnit(purchaseAmount))
                .doesNotThrowAnyException();
    }
}