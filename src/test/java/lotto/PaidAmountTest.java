package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PaidAmountTest {

    @DisplayName("지불금액이 0일때, 로또 가격으로 나누어떨어지지 않을 때 에러")
    @ParameterizedTest
    @ValueSource(ints = {0, 1001})
    void validateTest(int paid) {
        assertThatThrownBy(() -> new PaidAmount(paid))
                .isInstanceOf(IllegalArgumentException.class);
    }
}