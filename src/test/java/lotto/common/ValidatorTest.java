package lotto.common;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class ValidatorTest {

    @DisplayName("타겟이 단위로 나누어 떨어지면 true 를 반환한다.")
    @Test
    void 단위_나누기_검증_테스트() {
        int unit = 1000;
        int validTarget = 8000;
        int inValidTarget = 8200;

        boolean trueResult = Validator.isMultipleOfNumber(validTarget, unit);
        boolean falseResult = Validator.isMultipleOfNumber(inValidTarget, unit);

        assertThat(trueResult).isTrue();
        assertThat(falseResult).isFalse();
    }
}