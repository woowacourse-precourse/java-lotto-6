package lotto.domain.amount;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class AmountTest {

    @ParameterizedTest
    @ValueSource(ints = {20, 2323, 421323, 3434, 3000})
    @DisplayName("생성자 정상 작동 테스트")
    void constructorTest(final int amount) {
        final Amount purchaseAmount = new Amount(amount);
        Assertions.assertThat(purchaseAmount.getAmount()).isEqualTo(amount);
    }
}
