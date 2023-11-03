package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoManagerTest {

    @DisplayName("숫자가 아닌 값이 들어오면 예외가 발생한다.")
    @Test
    void numberFormatValidate() {
        LottoManager manager = new LottoManager();

        assertThatThrownBy(() -> manager.setPrice("string"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("설정한 금액 단위로 나누어 떨어지지 않으면 예외가 발생한다.")
    @Test
    void unitValidate() {
        LottoManager manager = new LottoManager();

        assertThatThrownBy(() -> manager.setPrice("1500"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("정상적인 금액을 입력받았을시 사용자가 구매한 로또의 개수를 알 수 있다.")
    @Test
    void getLottoCount() {
        LottoManager manager = new LottoManager();
        manager.setPrice("5000");

        assertThat(manager.getPrice() / Const.priceUnit).isEqualTo(5);
    }

    @DisplayName("금액에 맞는 로또의 개수를 알 수 있다.")
    @Test
    void getLottos() {
        User user = new User(8000);
        assertThat(user.getLottos().size()).isEqualTo(8);
    }
}