package lotto.View;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class ValidationTest {

    @Test
    void 문자열이_입력되면_예외가_발생한다() {
        assertThatThrownBy(() -> Validation.checkNotNumber("문자열"))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    void 숫자가_입력되면_예외가_발생하지_않는다() {
        assertDoesNotThrow(() -> Validation.checkNotNumber("123"));
    }

    @Test
    void 정수범위_이상의_값이_입력되면_예외가_발생한다() {
        assertThatThrownBy(() -> Validation.checkNotInteger("1111111111111111111111111"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 정수범위_내의_값이_입력되면_예외가_발생하지_않는다() {
        assertDoesNotThrow(() -> Validation.checkNotInteger("11"));
    }

    @Test
    void 구매금액이_1000으로_나누어_떨어지지_않으면_예외가_발생한다() {
        assertThatThrownBy(() -> Validation.checkNotDivided("1234"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 구매금액이_1000으로_나누어_떨어지면_예외가_발생하지_않는다() {
        assertDoesNotThrow(() -> Validation.checkNotDivided("2000"));
    }

    @Test
    void 공백이_입력되면_예외가_발생한다() {
        assertThatThrownBy(() -> Validation.checkNotBlank(" "))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또_범위_밖의_값이_입력되면_예외가_발생한다() {
        assertThatThrownBy(() -> Validation.checkNotInLottoRange(-1))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> Validation.checkNotInLottoRange(46))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또_범위_내의_값이_입력되면_예외가_발생하지_않는다() {
        assertDoesNotThrow(() -> Validation.checkNotInLottoRange(10));
    }

    @Test
    void 당첨_번호_개수가_6개가_아니라면_예외가_발생한다() {
        List<String> input = Arrays.asList("1","2","3","4");
        assertThatThrownBy(() -> Validation.checkLength(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 당첨_번호_개수가_6개라면_예외가_발생하지_않는다() {
        List<String> input = Arrays.asList("1","2","3","4","5","6");
        assertDoesNotThrow(() -> Validation.checkLength(input));
    }

    @Test
    void 당첨_번호에_중복된_값이_있으면_예외가_발생한다() {
        List<Integer> input = Arrays.asList(1,1,1,1,2,2);
        assertThatThrownBy(() -> Validation.checkWinningNumbersDuplication(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 당첨_번호에_중복된_값이_없으면_예외가_발생하지_않는다() {
        List<Integer> input = Arrays.asList(1,2,3,4,5,6);
        assertDoesNotThrow(() -> Validation.checkWinningNumbersDuplication(input));
    }

    @Test
    void 당첨_번호와_보너스_번호가_중복되면_예외가_발생한다() {
        List<Integer> input = Arrays.asList(1,2,3,4,5,6);
        Integer bonusNumber = 6;
        assertThatThrownBy(() -> Validation.checkBonusNumberDuplication(bonusNumber, input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 당첨_번호와_보너스_번호가_중복되지_않으면_예외가_발생하지_않는다() {
        List<Integer> input = Arrays.asList(1,2,3,4,5,6);
        Integer bonusNumber = 7;
        assertDoesNotThrow(() -> Validation.checkBonusNumberDuplication(bonusNumber, input));
    }
}