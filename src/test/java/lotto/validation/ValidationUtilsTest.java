package lotto.validation;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class ValidationUtilsTest {

    @Test
    public void 유저_입력_금액_검증_테스트() {
        //given
        ValidationUtils validationUtils = new ValidationUtils();
        int input1 = 500;
        int input2 = 7000;
        int input3 = 13400;

        //when
        boolean isValid1 = validationUtils.validateUserAmount(input1);
        boolean isValid2 = validationUtils.validateUserAmount(input2);
        boolean isValid3 = validationUtils.validateUserAmount(input3);

        //then
        Assertions.assertThat(isValid1).isFalse();
        Assertions.assertThat(isValid2).isTrue();
        Assertions.assertThat(isValid3).isFalse();
    }
}
