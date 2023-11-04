package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.view.message.Error;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class PurchaseAmountTest {

    @ParameterizedTest
    @DisplayName("input이 1000의 배수가 아닌 경우에 에러 발생")
    @ValueSource(strings = {"dk", "", " ", "0.2", "-1000", "0", "500", "700"})
    public void 입력값이_유효하지_않은_경우(String input) {
        //when + then
        assertThatThrownBy(() -> {
            PurchaseAmount.create(input);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Error.PURCHASE_AMOUNT_VALIDATION_ERROR.getMessage());
    }

    @ParameterizedTest
    @DisplayName(("input이 1000의 배수인 경우 PurchaseAmount 인스턴스 생성"))
    @ValueSource(strings = {"1000", "2000", "12000"})
    public void 입력값이_유효한_경우(String input) {
        //when
        PurchaseAmount purchaseAmount = PurchaseAmount.create(input);

        //then
        assertThat(purchaseAmount.getPurchaseAmount()).isEqualTo(Integer.parseInt(input));
    }
}
