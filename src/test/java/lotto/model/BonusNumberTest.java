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

    @Test
    @DisplayName("보너스 번호에 숫자가 아닌 문자가 포함되어 있다면, 예외를 발생시킨다.")
    void validateIsNumber_throwException() {
        /**
         * given : 요구 조건을 벗어난 보너스 번호(46j)가 주어진다.
         * when : BonusNumber 객체를 생성한다.
         * then : IllegalArgumentException 예외가 발생한다.
         */
        String bonusNumInput = "46j";

        Assertions.assertThatThrownBy(() -> {new BonusNumber(bonusNumInput);})
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("보너스 번호에 숫자 외의 문자와 공백은 포함될 수 없습니다. 1부터 45까지의 숫자를 입력해주세요.");
    }

    @Test
    @DisplayName("보너스 번호에 음수가 입력된다면, 예외를 발생시킨다.")
    void validateBonusIsPositive_throwException() {
        /**
         * given : 요구 조건을 벗어난 보너스 번호(-1)가 주어진다.
         * when : BonusNumber 객체를 생성한다.
         * then : IllegalArgumentException 예외가 발생한다.
         */
        String bonusNumInput = "-1";

        Assertions.assertThatThrownBy(() -> {new BonusNumber(bonusNumInput);})
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("보너스 번호는 음수일 수 없습니다. 1부터 45까지의 숫자를 입력해주세요.");
    }
}