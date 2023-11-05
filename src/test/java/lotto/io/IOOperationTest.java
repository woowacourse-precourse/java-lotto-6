package lotto.io;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class IOOperationTest {

    @Test
    void 가격이_1000원_단위로_나누어_떨어지지_않을_시_예외_리턴() {
        assertThatThrownBy(() -> {
            IOOperation.isPriceCorrect(10001);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 가격이_1000원_단위로_나누어_떨어질_시_true_리턴() {
        assertThat(IOOperation.isPriceCorrect(20000)).isTrue();
    }
}
