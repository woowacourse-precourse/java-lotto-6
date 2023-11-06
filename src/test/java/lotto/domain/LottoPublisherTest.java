package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoPublisherTest {
    @ParameterizedTest
    @ValueSource(strings = {"0", "1500", "-1000"})
    void 구입_금액이_올바르지_않을_경우(String money) {
        assertThatThrownBy(() -> new LottoPublisher(money))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
