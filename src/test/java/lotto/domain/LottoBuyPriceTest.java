package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class LottoBuyPriceTest {

    @DisplayName("로또 구입 금액을 입력하면, LottoBuyPrice의 인스턴스가 생성된다.")
    @Test
    void Given_LottoBuyPriceValue_When_CreateLottoBuyPrice_Then_CreatedInstance() throws Exception {
        // Given
        int lottoBuyPrice = 2000;
                
        // When
        LottoBuyPrice instance = new LottoBuyPrice(lottoBuyPrice);

        // Then
        assertThat(instance).isNotNull();
    }
    
    @DisplayName("로또 구입 금액으로 음수 값을 입력하면, 예외가 발생한다.")  
    @Test        
    void Given_NegativeLottoBuyPriceValue_When_CreateLottoBuyPrice_Then_ThrowException() throws Exception {
        // Given
        int lottoBuyPrice = -2000;

        // When & Then
        assertThatThrownBy(() -> new LottoBuyPrice(lottoBuyPrice))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("유효하지 않은 로또 구입 금액입니다.");
    }

    @DisplayName("로또 구입 금액으로 1,000으로 나누어떨어지지 않는 정수값을 입력하면, 예외가 발생한다.")
    @Test
    void Given_UndividedLottoBuyPriceValue_When_CreateLottoBuyPrice_Then_ThrowException() throws Exception {
        // Given
        int lottoBuyPrice = 3200;

        // When & Then
        assertThatThrownBy(() -> new LottoBuyPrice(lottoBuyPrice))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("유효하지 않은 로또 구입 금액입니다.");
    }

    @DisplayName("구입 가능한 로또의 개수를 반환한다.")
    @Test
    void Given_LottoBuyPrice_When_GetAvailableLottoBuyCount_Then_ReturnAvailableLottoBuyCount() throws Exception {
        // Given
        LottoBuyPrice lottoBuyPrice = new LottoBuyPrice(5000);

        // When
        int availableLottoBuyCount = lottoBuyPrice.getAvailableLottoBuyCount();

        // Then
        assertThat(availableLottoBuyCount).isEqualTo(5);
    }
}
