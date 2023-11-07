package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoManagerTest {

    @DisplayName("숫자가 아닌 값이 들어오면 예외가 발생한다.")
    @Test
    void notIntegerPrice() {
        assertThatThrownBy(() -> LottoManager.priceInput("string"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("설정한 금액 단위로 나누어 떨어지지 않으면 예외가 발생한다.")
    @Test
    void notDividePrice() {
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
    void lottoCount() {
        int price = LottoManager.priceInput("8000");
        assertThat(price / Const.PRICE_UNIT).isEqualTo(8);
    }

    @DisplayName("숫자가 아닌 로또번호 입력시 예외가 발생한다.")
    @Test
    void notIntegerNumbers() {
        String[] wrongNumbers = {"a", "1", "2", "3", "4", "5"};

        assertThatThrownBy(() -> LottoManager.createUserNumbers(wrongNumbers)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("1~45의 범위를 벗어나면 예외가 발생한다.")
    @Test
    void outOfRangeNumbers() {
        String[] wrongNumbers = {"46", "0", "2", "3", "4", "5"};

        assertThatThrownBy(() -> LottoManager.createUserNumbers(wrongNumbers)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호의 개수가 6개가 아니면 예외가 발생한다.")
    @Test
    void incorrectCount() {
        String[] wrongNumbers = {"2", "3", "4", "5"};

        assertThatThrownBy(() -> LottoManager.createUserNumbers(wrongNumbers)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void duplicateNumber() {
        String[] wrongNumbers = {"1", "1", "2", "3", "4", "5"};

        assertThatThrownBy(() -> LottoManager.createUserNumbers(wrongNumbers)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("숫자가 아닌 보너스 번호 입력시 예외가 발생한다.")
    @Test
    void notIntegerBonusNumber() {
        assertThatThrownBy(() -> LottoManager.bonusNumberInput("aaa", List.of(1, 2, 3, 4, 5, 6))).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("범위를 벗어난 보너스 번호 입력시 예외가 발생한다.")
    @Test
    void outOfRangeBonusNumber() {
        assertThatThrownBy(() -> LottoManager.bonusNumberInput("70", List.of(1, 2, 3, 4, 5, 6))).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호와 당첨 번호가 중복되면 예외가 발생한다.")
    @Test
    void duplicateWithLotto() {
        assertThatThrownBy(() -> LottoManager.bonusNumberInput("1", List.of(1, 2, 3, 4, 5, 6))).isInstanceOf(IllegalArgumentException.class);
    }
}