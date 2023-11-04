package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoManagerTest {

    @DisplayName("숫자가 아닌 값이 들어오면 예외가 발생한다.")
    @Test
    void notIntegerInput() {
        assertThatThrownBy(() -> LottoManager.priceInput("string"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("설정한 금액 단위로 나누어 떨어지지 않으면 예외가 발생한다.")
    @Test
    void notDivide() {
        assertThatThrownBy(() -> LottoManager.priceInput("1500"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("정상적인 금액을 입력받았을시 알맞은 금액을 반환한다.")
    @Test
    void correctInput() {
        assertThat(LottoManager.priceInput("5000")).isEqualTo(5000);
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
        String[] wrongNumbers = {"a", "1", "2", "3", "4", "5"};

        assertThatThrownBy(() -> LottoManager.createUserNumbers(wrongNumbers)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("1~45의 범위를 벗어나면 예외가 발생한다.")
    @Test
    void arrangeValidate() {
        String[] wrongNumbers = {"46", "0", "2", "3", "4", "5"};

        assertThatThrownBy(() -> LottoManager.createUserNumbers(wrongNumbers)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호의 개수가 6개가 아니면 예외가 발생한다.")
    @Test
    void countValidate() {
        String[] wrongNumbers = {"2", "3", "4", "5"};

        assertThatThrownBy(() -> LottoManager.createUserNumbers(wrongNumbers)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void duplicateValidate() {
        String[] wrongNumbers = {"1", "1", "2", "3", "4", "5"};

        assertThatThrownBy(() -> LottoManager.createUserNumbers(wrongNumbers)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호와 당첨 번호가 중복되면 예외가 발생한다.")
    @Test
    void duplicateWithLotto() {
        LottoManager manager = new LottoManager();
        User user = new User(1000);
        user.setUserLotto(Lotto.createUserNumbers(List.of(1, 2, 3, 4, 5, 6)));

        assertThatThrownBy(() -> manager.createBonusNumber("1", user)).isInstanceOf(IllegalArgumentException.class);
    }
}