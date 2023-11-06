package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class LottoBonusNumberTest {
    
    @DisplayName("보너스 번호를 입력하면 LottoBonusNumber 클래스의 인스턴스를 생성한다.")
    @Test
    void Given_BonusNumber_When_CreateLottoBonusNumber_Then_isEqualNumber() throws Exception {
        // Given
        int bonusNumber = 20;
                
        // When
        LottoBonusNumber lottoBonusNumber = new LottoBonusNumber(bonusNumber);

        // Then
        assertThat(lottoBonusNumber).isNotNull();
        assertThat(lottoBonusNumber.getNumber()).isEqualTo(bonusNumber);
    }

    @DisplayName("유효 범위에 포함되지 않는 보너스 번호를 입력하면 예외가 발생한다.")
    @Test
    void Given_NotInRangeNumber_When_CreateLottoBonusNumber_Then_ThrowException() throws Exception {
        // Given
        int bonusNumber = 100;

        // When & Then
        assertThatThrownBy(() -> new LottoBonusNumber(bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("유효하지 않은 보너스 번호입니다.");
    }
}
