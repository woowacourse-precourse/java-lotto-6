package lotto.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class BonusNumberTest {

    @Test
    @DisplayName("보너스 번호가 1~45 사이의 숫자가 아닌 경우 예외를 발생시킨다.")
    void validateBonusNumber() {
        /**
         * given : 요구 조건을 벗어난 보너스 번호(46)가 주어진다.
         * when : BonusNumber 객체를 생성한다.
         * then : IllegalArgumentException 예외가 발생한다.
         */
        String bonusNumInput = "46";

        Assertions.assertThatThrownBy(() -> {new BonusNumber(bonusNumInput);})
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("보너스 번호는 1부터 45까지의 숫자만 가능합니다.");
    }
}