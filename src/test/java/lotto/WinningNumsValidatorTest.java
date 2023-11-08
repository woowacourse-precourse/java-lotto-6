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
public class WinningNumsValidatorTest {

    private WinningNumsValidator winningNumsValidator = new WinningNumsValidator();

    @Test
    @DisplayName("당첨 번호에 중복된 숫자가 있을 경우 예외 발생")
    void duplicateNum() {
        List<Integer> nums = List.of(1, 2, 3, 4, 4, 4);
        assertThatThrownBy(() -> winningNumsValidator.isValid(nums))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("당첨 번호 개수가 안 맞을 경우 예외 발생")
    void notMatchSize() {
        List<Integer> nums = List.of(1, 2, 3, 4, 5);
        assertThatThrownBy(() -> winningNumsValidator.isValid(nums))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("당첨 번호에 0이 포함된 경우 예외 발생")
    void includeZero() {
        List<Integer> nums = List.of(1, 2, 0, 4, 5, 6);
        assertThatThrownBy(() -> winningNumsValidator.isValid(nums))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("당첨 번호에 45가 넘는 값이 포함된 경우 예외 발생")
    void includeOverNum() {
        List<Integer> nums = List.of(1, 2, 0, 4, 5, 60);
        assertThatThrownBy(() -> winningNumsValidator.isValid(nums))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
