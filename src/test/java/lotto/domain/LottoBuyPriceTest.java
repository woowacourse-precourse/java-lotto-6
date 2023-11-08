package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class LottoBuyPriceTest {

    @DisplayName("로또 구입 금액을 입력하면, LottoBuyPrice의 인스턴스가 생성된다.")
    @Test
    void createLottoBuyPrice() throws Exception {
        // Given
        int lottoBuyPrice = 2000;
                
        // When
        LottoBuyPrice instance = new LottoBuyPrice(lottoBuyPrice);

        // Then
        assertThat(instance).isNotNull();
    }
    
    @DisplayName("로또 구입 금액으로 음수 값을 입력하면, 예외가 발생한다.")  
    @Test        
    void createLottoBuyPriceWithNegativePriceValue() throws Exception {
        // Given
        int lottoBuyPrice = -2000;

        // When & Then
        assertThatThrownBy(() -> new LottoBuyPrice(lottoBuyPrice))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("유효하지 않은 로또 구입 금액입니다.");
    }

    @DisplayName("로또 구입 금액으로 1,000으로 나누어떨어지지 않는 정수값을 입력하면, 예외가 발생한다.")
    @Test
    void createLottoBuyPriceWithNotDivide1000PriceValue() throws Exception {
        // Given
        int lottoBuyPrice = 3200;

        // When & Then
        assertThatThrownBy(() -> new LottoBuyPrice(lottoBuyPrice))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("유효하지 않은 로또 구입 금액입니다.");
    }

    @DisplayName("구입 가능한 로또의 개수를 반환한다.")
    @Test
    void returnAvailableLottoBuyCount() throws Exception {
        // Given
        LottoBuyPrice lottoBuyPrice = new LottoBuyPrice(5000);

        // When
        int availableLottoBuyCount = lottoBuyPrice.getAvailableLottoBuyCount();

        // Then
        assertThat(availableLottoBuyCount).isEqualTo(5);
    }
    
    @DisplayName("구입할 로또의 개수를 입력하면 총 로또 구입 금액을 반환한다.")
    @Test        
    void returnTotalLottoBuyPrice() throws Exception {
        // Given
        int lottoBuyCount = 5;
                
        // When
        int totalLottoBuyPrice = LottoBuyPrice.countTotalLottoPrice(lottoBuyCount);

        // Then
        assertThat(totalLottoBuyPrice).isEqualTo(5000);
    }
}
