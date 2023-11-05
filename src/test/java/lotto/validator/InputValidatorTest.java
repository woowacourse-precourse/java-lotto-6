package lotto.validator;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputValidatorTest {

    private static final String ERROR_MESSAGE = "[ERROR]";

    @Test
    void 인풋_길이_테스트() {
        assertThatThrownBy(() -> new InputValidator().validateLength(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 인풋_중복_테스트() {
        assertThatThrownBy(() -> new InputValidator().validateLottoDuplication(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatNoException().isThrownBy(() -> new InputValidator()
                .validateLottoDuplication(List.of(1, 2, 3, 4, 5, 6)));
    }

    @Test
    void 인풋_범위_테스트() {
        assertThatThrownBy(() -> new InputValidator().validateLottoNumberRange(List.of(-1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> new InputValidator().validateLottoNumberRange(List.of(1, 2, 3, 4, 5, 46)))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatNoException().isThrownBy(() -> new InputValidator()
                .validateLottoNumberRange(List.of(1, 2, 3, 4, 5, 6)));

    }

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