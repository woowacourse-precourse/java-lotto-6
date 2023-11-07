package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PriceTest {
    @DisplayName("구입 금액이 1000원 단위가 아니면 예외가 발생한다.")
    @Test
    void EnterPriceByUnit() {
        assertThatThrownBy(() -> new Price(50500))
                .isInstanceOf(IllegalArgumentException.class);
        System.out.println("[ERROR] 1000단위로 입력해 주세요.");
    }
}
