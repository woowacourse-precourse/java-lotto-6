package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;
import lotto.domain.TypeChanger;
import lotto.domain.validator.ValidateNumber;
import lotto.domain.validator.ValidateUserNumber;
import org.junit.jupiter.api.Test;

public class ValidateUserNumberTest {
    TypeChanger typeChanger = TypeChanger.getTypeChanger();
    @Test
    void 리스트의_길이가_6이_아니면_안된다() {
        List<String> numbers = Arrays.asList("1","2","3","4","5","6","7");
        List<Integer> lottoNumbers = typeChanger.from(numbers);
        assertThatThrownBy(() -> ValidateUserNumber.isLengthSix(lottoNumbers)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 리스트의_각_값이_숫자가_아니면_예외() {
        List<String> numbers = Arrays.asList("1","2","3","4","o","6");
        assertThatThrownBy(() -> numbers.forEach(ValidateNumber::isNumber)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 숫자의_범위는_1부터_45까지() {
        List<String> numbers = Arrays.asList("1","2","3","4","5","46");
        List<Integer> lottoNumbers = typeChanger.from(numbers);
        assertThatThrownBy(() -> ValidateUserNumber.isInRange(lottoNumbers)).isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    void 숫자는_중복되지_않는다() {
        List<String> numbers = Arrays.asList("1","1","3","4","5","6");
        List<Integer> lottoNumbers = typeChanger.from(numbers);
        assertThatThrownBy(() -> ValidateUserNumber.isDuplicate(lottoNumbers)).isInstanceOf(IllegalArgumentException.class);
    }
}
