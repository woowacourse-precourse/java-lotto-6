package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoGeneratorTest {

    @DisplayName("구입 금액이 1,000원으로 나누어 떨어지지 않는 경우 예외가 발생한다.")
    @Test
    void createLottoListByInvalidPrice() {
        LottoGenerator generator = new LottoGenerator();
        assertThatThrownBy(() -> generator.createLottoList(1001))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
