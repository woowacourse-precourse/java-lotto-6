package lotto.util;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.Test;

import static lotto.util.Validator.*;

class ValidatorTest {

    @Test
    void 로또_구매_금액_검증_예외_테스트() {

        assertThatThrownBy(()->{
            Validator.validateAmount("1000g");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]")
                .hasMessageContaining("숫자만");

        assertThatThrownBy(()->{
            Validator.validateAmount("34800");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]")
                .hasMessageContaining("1000단위로");
    }
}