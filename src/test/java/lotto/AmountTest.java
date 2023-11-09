package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

import lotto.domain.Amount;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AmountTest {
    @Test
    @DisplayName("금액이 문자면 예외가 발생한다.")
    void createAmountByType() {
        assertThatThrownBy(() -> new Amount("ㅏ"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("금액이 1000원보다 작으면 예외가 발생한다.")
    void createAmountByMin() {
        assertThatThrownBy(() -> new Amount("900"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("금액이 1000원보다 작으면 예외가 발생한다.")
    void createAmountByDivision() {
        assertThatThrownBy(() -> new Amount("5678"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("금액을 입력하면 구매할 수 있는 로또 개수를 반환한다.")
    void calculateLottoCount() {
        Amount amount = new Amount("10000");
        int lottoCount = amount.getCountLotto();

        assertThat(lottoCount).isEqualTo(10);
    }
}
