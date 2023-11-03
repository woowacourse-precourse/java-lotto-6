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

    @DisplayName("숫자가 아닌 로또번호 입력시 예외가 발생한다.")
    @Test
    void numbersFormatValidate() {
        LottoManager manager = new LottoManager();
        String[] wrongNumbers = {"a", "1", "2", "3", "4", "5"};

        assertThatThrownBy(() -> manager.createLotto(wrongNumbers)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("1~45의 범위를 벗어나면 예외가 발생한다.")
    @Test
    void arrangeValidate() {
        LottoManager manager = new LottoManager();
        String[] wrongNumbers = {"46", "0", "2", "3", "4", "5"};

        assertThatThrownBy(() -> manager.createLotto(wrongNumbers)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호의 개수가 6개가 아니면 예외가 발생한다.")
    @Test
    void countValidate() {
        LottoManager manager = new LottoManager();
        String[] wrongNumbers = {"2", "3", "4", "5"};

        assertThatThrownBy(() -> manager.createLotto(wrongNumbers)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void duplicateValidate() {
        LottoManager manager = new LottoManager();
        String[] wrongNumbers = {"1", "1", "2", "3", "4", "5"};

        assertThatThrownBy(() -> manager.createLotto(wrongNumbers)).isInstanceOf(IllegalArgumentException.class);
    }
}