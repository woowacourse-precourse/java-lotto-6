package lotto.validator;

import lotto.model.Lotto;
import lotto.model.LottoResultCalculator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class AmountValidatorTest {

    AmountValidator amountValidator;
    @BeforeEach
    void setUp() {
        amountValidator = new AmountValidator();
    }

    @DisplayName("숫자 외에 다른 문자가 입력되면 예외처리를 위해 false를 전달한다.")
    @Test
    void validAmountOtherString() {
        boolean result = amountValidator.validate("안녕");
        assertThat(result).isFalse();
    }

    @DisplayName("1000보다 작은 수가 입력되면 예외처리를 위해 false를 전달한다.")
    @Test
    void validAmountLess1000() {
        boolean result = amountValidator.validate("500");
        assertThat(result).isFalse();
    }

    @DisplayName("1000으로 나누어 떨어지지 않는 수가 입력되면 예외처리를 위해 false를 전달한다.")
    @Test
    void validAmountUndivided1000() {
        boolean result = amountValidator.validate("1300");
        assertThat(result).isFalse();
    }
}