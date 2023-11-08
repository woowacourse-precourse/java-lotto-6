package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CustomerTest {
    @DisplayName("입력한 수량만큼 랜덤하게 로또를 구입한다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 5, 10})
    void purchaseLottosRandomly(int purchaseAmount) {
        Customer customer = Customer.of(new LottoPurchaseAmount(purchaseAmount), new RandomLottoFactory());

        assertThat(customer.purchasedLottos()).hasSize(purchaseAmount);
    }
}
