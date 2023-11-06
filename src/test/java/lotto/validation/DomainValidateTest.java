package lotto.validation;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class DomainValidateTest {
    private static final String ERROR_MESSAGE = "[ERROR]";

    @Test
    void testNumberRange() {
        // given
        int wrongNum = 49;
        int num = 7;

        // when & then
        assertThatThrownBy(() -> DomainValidate.validateNumberInRange(wrongNum))
                .isInstanceOf(IllegalArgumentException.class).hasMessageContaining(ERROR_MESSAGE);
        assertThatCode(() -> DomainValidate.validateNumberInRange(num)).doesNotThrowAnyException();
    }

}