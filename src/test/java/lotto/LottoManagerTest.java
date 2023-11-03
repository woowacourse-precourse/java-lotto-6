package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoManagerTest {

    @DisplayName("숫자가 아닌 값이 들어오면 예외가 발생한다.")
    @Test
    void numberFormatValidate() {
        assertThatThrownBy(() -> new LottoManager("string"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("설정한 금액 단위로 나누어 떨어지지 않으면 예외가 발생한다.")
    @Test
    void unitValidate() {
        assertThatThrownBy(() -> new LottoManager("1300"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("정상적인 금액을 입력받았을시 사용자가 구매한 로또의 개수를 알 수 있다.")
    @Test
    void getLottoCount() {
        LottoManager lottoManager = new LottoManager("5000");
        assertThat(lottoManager.getPrice() / Const.priceUnit).isEqualTo(5);
    }
}