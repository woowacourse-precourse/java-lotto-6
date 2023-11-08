package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoPurchaseTest {
    private static final String NON_ZERO_AMOUNT_ERROR_MESSAGE = "[ERROR] 0보다 큰 숫자여야 합니다.";
    private static final String NOT_PROPER_UNIT_ERROR_MESSAGE = "[ERROR] 1000원 단위의 숫자여야 합니다.";
    
    @DisplayName("구매 금액은 0보다 큰 숫자여야 한다.")
    @Test
    void biggerPurchaseAmountThanZero() {
        // given
        int purchaseAmount = 0;
        
        // when // then
        assertThatThrownBy(() -> new LottoPurchase(purchaseAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(NON_ZERO_AMOUNT_ERROR_MESSAGE);
    }
    
    @DisplayName("구매 금액은 1000원 단위의 숫자여야 한다.")
    @ParameterizedTest
    @ValueSource(ints = {-100, -1, 1, 500, 999})
    void purchaseAmountInThousandsUnit(int amount) {
        // when // then
        assertThatThrownBy(() -> new LottoPurchase(amount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(NOT_PROPER_UNIT_ERROR_MESSAGE);
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
