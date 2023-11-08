package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    private static final List<Integer> ANSWER = List.of(1, 2, 3, 4, 5, 6);

    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 금액이 1,000단위가 아니면 예외가 발생한다.")
    @Test
    void createThousandLottoMoney() {
        assertThatThrownBy(() -> new LottoMoney("1200"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 금액이 숫자가 아니면 예외가 발생한다.")
    @Test
    void createNumberLottoMoney() {
        assertThatThrownBy(() -> new LottoMoney("1000J"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 금액이 1,000원 이상이 아니면 예외가 발생한다.")
    @Test
    void createLottoMoneyUnderPrice() {
        assertThatThrownBy(() -> new LottoMoney("0"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호의 범위가 1부터 45사이가 아니면 예외가 발생한다.")
    @Test
    void createLottoByOverRange() {
        assertThatThrownBy(() -> new Lotto(List.of(41, 42, 43, 44, 45, 46)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 로또 번호가 숫자가 아니면 예외가 발생한다.")
    @Test
    void createBonusNumberLottoMoney() {
        assertThatThrownBy(() -> new LuckeyLotto(ANSWER, "7a"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createBonusLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> new LuckeyLotto(ANSWER, "5"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 로또 번호의 범위가 1부터 45사이가 아니면 예외가 발생한다.")
    @Test
    void createBonusLottoByOverRange() {
        assertThatThrownBy(() -> new LuckeyLotto(ANSWER, "50"))
                .isInstanceOf(IllegalArgumentException.class);
    }

}