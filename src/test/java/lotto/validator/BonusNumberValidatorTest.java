package lotto.validator;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.Test;

class BonusNumberValidatorTest {

    @Test
    void validateBonusNumber_정상입력() {
        //given
        String input = "45";
        List<Integer> winningNumbers = List.of(1, 3, 7, 23, 43, 44);

        //when & then
        assertThatNoException().isThrownBy(
                () -> BonusNumberValidator.validateBonusNumber(winningNumbers, input)
        );
    }

    @Test
    void validateBonusNumber_숫자_아닌_입력_예외() {
        //given
        String input = "A 9";
        List<Integer> winningNumbers = List.of(1, 3, 7, 23, 43, 44);

        //when & then
        assertThatThrownBy(() -> BonusNumberValidator.validateBonusNumber(winningNumbers, input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void validateBonusNumber_0으로_시작하는_잘못된_입력() {
        //given
        String input = "0011";
        List<Integer> winningNumbers = List.of(1, 3, 7, 23, 43, 44);

        //when & then
        assertThatThrownBy(() -> BonusNumberValidator.validateBonusNumber(winningNumbers, input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void validateBonusNumber_범위_벗어난_입력_예외_0() {
        //given
        String input = "0";
        List<Integer> winningNumbers = List.of(1, 3, 7, 23, 43, 44);

        //when & then
        assertThatThrownBy(() -> BonusNumberValidator.validateBonusNumber(winningNumbers, input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void validateBonusNumber_범위_벗어난_입력_예외_46() {
        //given
        String input = "46";
        List<Integer> winningNumbers = List.of(1, 3, 7, 23, 43, 44);

        //when & then
        assertThatThrownBy(() -> BonusNumberValidator.validateBonusNumber(winningNumbers, input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void validateBonusNumber_당첨번호와_중복_입력_예외() {
        //given
        String input = "1";
        List<Integer> winningNumbers = List.of(1, 3, 7, 23, 43, 44);

        //when & then
        assertThatThrownBy(() -> BonusNumberValidator.validateBonusNumber(winningNumbers, input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}