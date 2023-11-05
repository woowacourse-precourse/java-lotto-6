package lotto;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;

public class InputTest {
    Application application = new Application();

    @ParameterizedTest
    @EmptySource
    void 입력_하지_않았을_때_예외_발생(String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> application.checkEmpty(input))
                .withMessage(ErrorMessage.REQUIRED_VALUE);
    }
}
