package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoPurchaseTest {
    
    @DisplayName("올바르지 않은 금액일 경우, 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 100, 500})
    void inputNotValidAmount(int amount) {
        // when // then
        assertThatThrownBy(() -> new LottoPurchase(amount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }
    
    @DisplayName("해당 금액으로 구매할 수 있는 개당 1000원짜리 로또의 개수를 구한다.")
    @ParameterizedTest
    @CsvSource(value = {"1000=1", "5000=5", "10000=10"}, delimiter = '=')
    void calculateTicketCount(int amount, int expectedCount) {
        // given
        LottoPurchase lottoPurchase = new LottoPurchase(amount);
        
        // when
        int actualCount = lottoPurchase.calculateTicketCount();
        
        // then
        assertThat(actualCount).isEqualTo(expectedCount);
    }
}
