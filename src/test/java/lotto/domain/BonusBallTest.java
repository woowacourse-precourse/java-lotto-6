package lotto.domain;

import lotto.exception.ErrorStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class BonusBallTest {


    @DisplayName("보너스 볼 생성시 기입한 정수가 로또의 최소값보다 작으면 예외를 발생시킨다.")
    @Test
    void validateRange() {
        // given
        int bonusNumber = 0;

        // when
        assertThatThrownBy(() -> new BonusBall(bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorStatus.BONUS_NUMBER_RANGE_ERROR.getMessage());
    }

    @DisplayName("보너스 볼 생성시 기입한 정수가 로또의 최대값보다 크면 예외를 발생시킨다.")
    @Test
    void validateRange2() {
        // given
        int bonusNumber = 46;

        // when
        assertThatThrownBy(() -> new BonusBall(bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorStatus.BONUS_NUMBER_RANGE_ERROR.getMessage());
    }

    @DisplayName("보너스 볼 생성시 기입한 정수를 다시 반환한다.")
    @Test
    void getBonusNumber() {
        // given
        int bonusNumber = 45;

        // when
        BonusBall bonusBall = new BonusBall(bonusNumber);

        // then
        assertThat(bonusBall.getBonusNumber()).isEqualTo(bonusNumber);
    }
}