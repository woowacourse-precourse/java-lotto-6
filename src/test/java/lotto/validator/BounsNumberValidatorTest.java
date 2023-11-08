package lotto.validator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class BounsNumberValidatorTest {

    BounsNumberValidator bounsNumberValidator;
    @BeforeEach
    void setUp() {
        bounsNumberValidator = new BounsNumberValidator();
    }

    @DisplayName("숫자 외에 다른 문자가 입력되면 예외처리를 위해 false를 전달한다.")
    @Test
    void validOtherString() {
        boolean result = bounsNumberValidator.validate("안녕", List.of(1,2,3,4,5,6));
        assertThat(result).isFalse();
    }

    @DisplayName("1보다 작은 수가 입력되면 예외처리를 위해 false를 전달한다.")
    @Test
    void validNumLess1() {
        boolean result = bounsNumberValidator.validate("0", List.of(1,2,3,4,5,6));
        assertThat(result).isFalse();
    }

    @DisplayName("45보다 큰 수가 입력되면 예외처리를 위해 false를 전달한다.")
    @Test
    void validNumOver45() {
        boolean result = bounsNumberValidator.validate("500", List.of(1,2,3,4,5,6));
        assertThat(result).isFalse();
    }

    @DisplayName("당첨 번호와 중복되는 수가 입력되면 예외처리를 위해 false를 전달한다.")
    @Test
    void validLottoNumOverLap() {
        boolean result = bounsNumberValidator.validate("1", List.of(1,2,3,4,5,6));
        assertThat(result).isFalse();
    }
}