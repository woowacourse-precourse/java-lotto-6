package lotto.validator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class BonusNumberValidatorTest {
    @Test
    void 보너스번호_성공_테스트() {
        String input = "23";
        BonusNumberValidator validator = new BonusNumberValidator();

        Assertions.assertThatCode(() -> validator.validate(input)).doesNotThrowAnyException();

    }

    @Test
    void 보너스번호_실패_테스트() {
        String input1 = "aaa";
        String input2= "0";
        String input3= "46";

        BonusNumberValidator validator = new BonusNumberValidator();

        Assertions.assertThatIllegalArgumentException().isThrownBy(
                () -> validator.validate(input1));
        Assertions.assertThatIllegalArgumentException().isThrownBy(
                () -> validator.validate(input2));
        Assertions.assertThatIllegalArgumentException().isThrownBy(
                () -> validator.validate(input3));

    }

}