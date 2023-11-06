package lotto;

import lotto.model.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

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

    @DisplayName("번호를 받을 때 정수형이 아닌 문자열이 들어오면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {""," ","6k", "*"})
    void createLottoByNonInteger(String input) {
        InputSystem InputSystem = new InputSystem();
        assertThatThrownBy(() -> InputSystem.isNumberValid(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("숫자가 1 ~ 45 사이 수인지")
    @Test
    void createBonusByOverValue() {
        InputSystem InputSystem = new InputSystem();
        assertThatThrownBy(() -> InputSystem.isRangeValid("56"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력한 번호 6자리 중 보너스가 있을 때")
    @Test
    void isBonusInLotto() {
        InputSystem InputSystem = new InputSystem();
        assertThatThrownBy(() -> InputSystem.isDuplicate(List.of(1, 2, 3, 4, 5, 6), 6))
                .isInstanceOf(IllegalArgumentException.class);
    }
}