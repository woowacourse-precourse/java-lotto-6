package lotto.Validation;

import lotto.model.Lotto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class InputValidatorTest {

    private InputValidator validator;

    @BeforeEach
    void setUp() {
        validator = new InputValidator();
    }

    @DisplayName("입력값에 빈 값이 있으면 예외가 발생한다.")
    @Test
    void validateInputHasBlankString() {
        assertThatThrownBy(() -> validator.checkIsNotBlank(" "))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력값을 정수로 변환할 수 없으면 예외가 발생한다.")
    @Test
    void validateInputCanParseInt() {
        assertThatThrownBy(() -> validator.checkCanParseInt("100j"))
                .isInstanceOf(IllegalArgumentException.class);
    }

}