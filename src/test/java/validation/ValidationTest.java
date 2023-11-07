package validation;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ValidationTest {
    @Test
    void 천원단위_아니면Error(){
        Validation validation = new Validation();

        assertThatThrownBy(()-> validation.validateMoney(1400))
                .isInstanceOf(IllegalArgumentException.class);
    }

}