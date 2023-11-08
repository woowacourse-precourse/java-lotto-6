package lotto.validator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoPrizeNumberValidatorTest {

    LottoPrizeNumberValidator lottoPrizeNumberValidator;
    @BeforeEach
    void setUp() {
        lottoPrizeNumberValidator = new LottoPrizeNumberValidator();
    }

    @DisplayName("숫자와 쉼표(,) 외에 다른 문자가 입력되면 예외처리를 위해 false를 전달한다.")
    @Test
    void validOtherString() {
        boolean result = lottoPrizeNumberValidator.validate("안녕,2,3,4,5");
        assertThat(result).isFalse();
    }

    @DisplayName("1보다 작은 수가 입력되면 예외처리를 위해 false를 전달한다.")
    @Test
    void validNumLess1() {
        boolean result = lottoPrizeNumberValidator.validate("0,1,2,3,4,5");
        assertThat(result).isFalse();
    }

    @DisplayName("45보다 큰 수가 입력되면 예외처리를 위해 false를 전달한다.")
    @Test
    void validNumOver45() {
        boolean result = lottoPrizeNumberValidator.validate("1,2,3,4,5,47");
        assertThat(result).isFalse();
    }

    @DisplayName("중복되는 수가 입력되면 예외처리를 위해 false를 전달한다.")
    @Test
    void validLottoNumOverLap() {
        boolean result = lottoPrizeNumberValidator.validate("1,1,2,3,4,5");
        assertThat(result).isFalse();
    }
}