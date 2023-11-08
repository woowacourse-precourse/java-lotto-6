package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoManagerTest {

    LottoManager lottoManager = new LottoManager();

    @DisplayName("입력받은 금액이 1000으로 나누어 떨어지지지 않으면 예외를 발생한다.")
    @Test
    void divideByThousand() {
        assertThatThrownBy(() -> lottoManager.validateValuePrice(1100))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력받은 금액이 정수 타입이 아니면  예외를 발생한다")
    @Test
    void priceIntegerType() {
        assertThatThrownBy(() -> lottoManager.validateNumber("1000j"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
