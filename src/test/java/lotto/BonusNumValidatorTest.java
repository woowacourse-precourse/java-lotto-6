package lotto;

import lotto.validator.BonusNumValidator;
import lotto.validator.WinningNumsValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 * 로또 구입 금액 검증에 대한 테스트
 */
public class BonusNumValidatorTest {

    private BonusNumValidator bonusNumValidator = new BonusNumValidator();

    @Test
    @DisplayName("보너스 번호가 양의 정수가 아닐 경우 예외 발생")
    void notPositiveNum() {
        int num = -1;
        assertThatThrownBy(() -> bonusNumValidator.isValid(num))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("보너스 번호가 0일 경우 예외 발생")
    void zeroBonusNum() {
        int num = 0;
        assertThatThrownBy(() -> bonusNumValidator.isValid(num))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("보너스 번호가 45를 넘은 값일 경우 예외 발생")
    void overBonusNum() {
        int num = 60;
        assertThatThrownBy(() -> bonusNumValidator.isValid(num))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
