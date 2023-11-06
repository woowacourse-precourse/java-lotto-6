package lotto.util;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class ExceptionUtilTest {

    @Test
    public void 메세지와_IllegalArgumentException발생() {
        // Given
        String message = "This is an invalid value.";

        // When && Then
        assertThatThrownBy(() -> ExceptionUtil.throwInvalidValueException(message))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("This is an invalid value.");
    }

}
