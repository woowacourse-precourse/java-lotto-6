package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class LottoBonusNumberTest {
    
    @DisplayName("보너스 번호를 입력하면 LottoBonusNumber 클래스의 인스턴스를 생성한다.")
    @Test
    void createLottoBonusNumber() throws Exception {
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
    void createLottoBonusNumberWithNotInRangeInput() throws Exception {
        // Given
        int bonusNumber = 100;

        // When & Then
        assertThatThrownBy(() -> new LottoBonusNumber(bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("유효하지 않은 보너스 번호입니다.");
    }

    @DisplayName("입력된 로또 번호에 보너스 번호가 포함되어 있다면 true를 반환한다.")
    @Test
    void returnIsBonusNumberContainInLottoNumbers() throws Exception {
        // Given
        LottoBonusNumber lottoBonusNumber = new LottoBonusNumber(4);
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        // When
        boolean hasBonusNumber = lottoBonusNumber.checkLottoHasBonusNumber(lotto);

        // Then
        assertThat(hasBonusNumber).isTrue();
    }
}
