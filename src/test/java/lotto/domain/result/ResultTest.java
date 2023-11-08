package lotto.domain.result;

import lotto.domain.customer.Customer;
import lotto.domain.winningnumber.WinningNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class ResultTest {
    private Result result;
    private Customer customer = new Customer("5000");
    private WinningNumber winningNumber = new WinningNumber("1,2,3,4,5,6", "7");

    @DisplayName("customer와 winningNumer를 인자로 받아서 result 객체 생성")
    @Test
    void createWithCustomerAndWinningNumber() {
        result = new Result(customer, winningNumber);
        assertThat(result).isNotEqualTo(null);
    }
}