package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoGameTest {


    @DisplayName("입력 값이 1000으로 나누어지는 값인지 확인한다")
    @Test
    void checkMultipleOfThousand() {
        assertThatThrownBy(() -> new LottoGame().validateMultiple("12200"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 로또 한장이 1000원이므로 구매금액은 1000원 단위로 입력해야 합니다.");
    }


    @DisplayName("입력 값이 1과 45 사이의 숫자가 아닐때 예외가 발생한다.")
    @Test
    void createNumberByOutOfRange() {
        assertThatThrownBy(() -> new LottoGame().validateRange(new ArrayList<>(List.of(1, 2, 55))))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 1과 45 사이의 수를 입력하세요");
    }

    @DisplayName("입력 값이 6개의 숫자가 아닐때 예외가 발생한다.")
    @Test
    void createNumberByOverSize() {
        assertThatThrownBy(() -> new LottoGame().validateSize(new ArrayList<>(List.of(1, 2, 55))))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 로또 숫자 6개를 입력하지 않았습나다.");
    }

    @DisplayName("당첨 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> new LottoGame().validateDuplicate(new ArrayList<>(List.of(1, 2, 2, 3, 4, 5))))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 중복된 숫자가 존재합니다.");
    }

    @DisplayName("보너스 입력 값이 1과 45 사이의 숫자가 아닐때 예외가 발생한다.")
    @Test
    void createBonusNumberByOutOfRange() {
        assertThatThrownBy(() -> new LottoGame().validateRangeOne(90))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 1과 45 사이의 수를 입력하세요");
    }

    @DisplayName("보너스 값과 당첨 번호 값이 중복될 때 예외가 발생한다.")
    @Test
    void createBonusDuplication() {
        assertThatThrownBy(
                () -> new LottoGame().validateBonusDuplication(12, new ArrayList<>(List.of(1, 2, 12, 3, 4, 5))))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 당첨 번호와 보너스 번호는 서로 중복된 숫자가 없어야 합니다.");
    }
}
