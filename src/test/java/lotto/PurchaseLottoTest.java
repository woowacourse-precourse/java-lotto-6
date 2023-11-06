package lotto;

import lotto.validator.PurchaseLottoValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PurchaseLottoTest {

    @ParameterizedTest
    @ValueSource(ints = {1000, 100000})
    @DisplayName("성공 - 구입 가능 금액 범위 이내")
    void valid_Purchase_amount_Range(int amount) {
        //when
        //then
        PurchaseLottoValidator.checkAmountRange(amount);
    }

    @ParameterizedTest
    @ValueSource(ints = {999, 100001})
    @DisplayName("실패 - 구입 가능 금액 범위 초과")
    void purchase_Amount_Range_Over(int amount) {
        //when
        //then
        assertThatThrownBy(() -> PurchaseLottoValidator.checkAmountRange(amount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 최소 1000원, 최대 100000원까지 구매 가능합니다.\n");
    }

    @ParameterizedTest
    @ValueSource(ints = {1000, 2000, 10000, 51000})
    @DisplayName("성공 - 로또 가격과 나누어 떨어짐")
    void no_Remainder_Amount(int amount) {
        //when
        //then
        PurchaseLottoValidator.checkRemainder(amount);
    }

    @ParameterizedTest
    @ValueSource(ints = {1001, 2010, 10500, 50100})
    @DisplayName("실패 - 로또 가격과 안 나누어 떨어짐")
    void exist_Remainder_Amount(int amount) {
        //when
        //then
        assertThatThrownBy(() -> PurchaseLottoValidator.checkRemainder(amount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 금액이 나누어 떨어지지 않습니다.\n");
    }
}
