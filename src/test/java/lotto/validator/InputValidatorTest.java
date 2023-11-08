package lotto.validator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputValidatorTest {

    private static final String ERROR_MESSAGE = "[ERROR]";

    @Test
    void 인풋_단위_테스트() {
        assertThatThrownBy(() -> new InputValidator().validateInputData(1049))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 인풋_타입_테스트() {
        assertThatThrownBy(() -> new InputValidator().validateInputType("asdf"))
                .isInstanceOf(IllegalArgumentException.class);
    }

}