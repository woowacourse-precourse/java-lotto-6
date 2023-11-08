package lotto.validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.Test;

public class LottoValidatorTest {
    @Test
    void 숫자_형식_확인() {
        String number = "a";

        assertThatThrownBy(() -> LottoValidator.validateNumber(number))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 숫자_범위_확인() {
        String number1 = "0";
        String number2 = "46";

        assertThatThrownBy(() -> LottoValidator.validateNumber(number1))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> LottoValidator.validateNumber(number2))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 보너스_번호_중복_확인() {
        List<Integer> lottos = List.of(1, 2, 3, 4, 5, 6);
        String bonusNumber = "1";

        assertThatThrownBy(() -> LottoValidator.validateBonusNumber(lottos, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
