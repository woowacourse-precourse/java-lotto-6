package lotto.ValidateTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import lotto.Validator.AmountInputValidate;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AmountInputTest {
    AmountInputValidate inputValidate = new AmountInputValidate();

    @DisplayName("금액 입력 테스트 : 숫자 변환 실패")
    @Test
    void isNumberTest() {
        assertThrows(IllegalArgumentException.class, () -> inputValidate.isNumber("AAA"));
    }

    @DisplayName("금액 입력 테스트 : 1000의 배수 입력")
    @Test
    void isDivided1000Test() {
        assertThrows(IllegalArgumentException.class, () -> inputValidate.isDivided1000(1234L));
    }

    @DisplayName("금액 입력 테스트 : 잘못된 입력")
    @Test
    void amountFailTest() {
        assertThrows(IllegalArgumentException.class, () -> inputValidate.valueValidate("1234"));
        assertThrows(IllegalArgumentException.class, () -> inputValidate.valueValidate("AAA"));

    }

    @DisplayName("금액 입력 테스트 : 입력 성공")
    @Test
    void amountPassTest() {
        assertThat(inputValidate.valueValidate("1000")).isEqualTo(1000L);
    }

}
