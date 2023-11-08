package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoCountTest {
    @DisplayName("1000원단위의 금액이 아니면 예외 발생")
    @Test
    void validateUnitTest() {
        assertThatThrownBy(() -> new LottoCount(1234))
                .isInstanceOf(IllegalArgumentException.class);

    }
}
