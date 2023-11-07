package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class AmountTest {

    @Test
    public void 도메인생성테스트(){
        Amount amount = new Amount(10000, 100);

        Assertions.assertThat(amount.getCount()).isEqualTo(100);
        Assertions.assertThat(amount.getTotal()).isEqualTo(10000);
    }

    @DisplayName("입력된 구입 금액이 기준 미만이다")
    @Test
    void inputAmountIsSmallerThanMin() {
        assertThatThrownBy(() -> new Amount(900, 1000))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("이상");
    }

    @DisplayName("입력된 구입 금액이 기준 금액으로 나누어 떨어지지 않는다")
    @Test
    void inputAmountIsNotDividable() {
        assertThatThrownBy(() -> new Amount(1200, 1000))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("단위");
    }
}
