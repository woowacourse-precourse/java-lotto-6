package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

public class ValidateUserNumberTest {
    @Test
    void 리스트의_길이가_6이_아니면_안된다() {
        List<String> numbers = Arrays.asList("1","2","3","4","5","6","7");
        assertThatThrownBy(() -> ValidateUserNumber.isLengthSix(numbers)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 리스트의_각_값이_숫자가_아니면_예외() {
        List<String> numbers = Arrays.asList("1","2","3","4","o","6");
        assertThatThrownBy(() -> ValidateUserNumber.isValidNumber(numbers)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 숫자의_범위는_1부터_45까지() {
        List<String> numbers = Arrays.asList("1","2","3","4","5","46");
        assertThatThrownBy(() -> ValidateUserNumber.isValidNumber(numbers)).isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    void 숫자는_중복되지_않는다() {
        List<String> numbers = Arrays.asList("1","1","3","4","5","6");
        assertThatThrownBy(() -> ValidateUserNumber.isDuplicate(numbers)).isInstanceOf(IllegalArgumentException.class);
    }
}
