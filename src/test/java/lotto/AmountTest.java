package lotto;

import lotto.model.Amount;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class AmountTest {

    @DisplayName("입력값이 1000원 단위가 아닐시 오류가 발생한다.")
    @Test
    void inputNotThousand(){
        assertThatThrownBy(() -> new Amount(1234)).
                isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력값이 0일시 오류가 발생한다.")
    @Test
    void inputZero(){
        assertThatThrownBy(() -> new Amount(0)).
                isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력값이 음수일시 오류가 발생한다.")
    @Test
    void inputNegative(){
        assertThatThrownBy(() -> new Amount(-1000))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
