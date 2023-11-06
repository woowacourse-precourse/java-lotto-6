package lotto;

import lotto.controller.GameController;
import lotto.domain.Lotto;
import lotto.domain.Money;
import lotto.domain.constants.ExceptionMessage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
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

    @DisplayName("사용자는 로또 구입 금액을 입력할 수 있다.")
    @Test
    void createMoneyByInput() {
        assertThat(new Money("5000")).isNotNull();
    }

    @DisplayName("로또 구입 금액을 입력할 때 숫자가 아닌 값이 포함되어 있으면 예외가 발생한다.")
    @Test
    void createMoneyByNonNumericalValue() {
        assertThatThrownBy(() -> new Money("AAA"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.NOT_NUMBER.getMessage());
    }

    @DisplayName("로또 구입 금액을 입력할 때 1,000원 단위가 아니면 예외가 발생한다.")
    @Test
    void createMoneyByNon1000Units() {
        assertThatThrownBy(() -> new Money("50"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.INPUT_MONEY_NOT_PRICE_UNIT.getMessage());
    }
}