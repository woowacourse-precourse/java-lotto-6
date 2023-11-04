package lotto.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.view.message.Error;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class PurchaseAmountTest {

    @ParameterizedTest
    @DisplayName("input이 숫자가 아닌 경우에 에러 발생")
    @ValueSource(strings = {"dk", "", " ", "안녕"})
    public void 입력값이_숫자가_아닌_경우(String input) {
        //when + then
        assertThatThrownBy(() -> {
            PurchaseAmount.create(input);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Error.PURCHASE_AMOUNT_VALIDATION_ERROR.getMessage());
    }
}
