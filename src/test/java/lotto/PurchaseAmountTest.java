package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.domain.Customer;
import lotto.util.TypeConverter;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PurchaseAmountTest {

    private static TypeConverter typeConverter = new TypeConverter();


    @DisplayName("구입금액 정상 입력")
    @Test
    void testValidPurchaseInput() {
        Customer customer = typeConverter.convertStringToCustomer("10000");
        Assertions.assertThat(customer.getLottoCount()).isEqualTo(10);
        Assertions.assertThat(customer.getPaymentAmount()).isEqualTo(10000);
    }

    @DisplayName("1000으로 나누어 떨어지지 않는 수 입력")
    @Test
    void testInvalidNumberInput() {
        assertThatThrownBy(() ->typeConverter.convertStringToCustomer("100"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("1000원 단위의 숫자가 입력되지 않은 경우")
    @Test
    void testInvalidCharInput() {
        assertThatThrownBy(() ->typeConverter.convertStringToCustomer("list"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
