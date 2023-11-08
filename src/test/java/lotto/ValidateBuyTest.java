package lotto;

import lotto.util.ValidateInputBuy;
import lotto.util.ValidateNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ValidateBuyTest {

    @DisplayName("구입 금액이 0보다 큰 정수가 아니면 예외가 발생한다.")
    @Test
    void createNotPositiveInteger() {

        assertThatThrownBy(() -> ValidateNumber.isPositiveInteger("1.2"))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> ValidateNumber.isPositiveInteger("-1"))
                .isInstanceOf(IllegalArgumentException.class);

    }

    @DisplayName("구입 금액이 1000원 단위가 아니면 예외가 발생한다.")
    @Test
    void createNotThousand() {

        assertThatThrownBy(() -> ValidateInputBuy.isThousand(1001))
                .isInstanceOf(IllegalArgumentException.class);

    }

}
