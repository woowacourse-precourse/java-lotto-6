package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinningLottoTest {

    @DisplayName("6개 이상의 숫자를 입력하면 예외 발생")
    @Test
    void enterLottoInputByOverSize() {
        Assertions.assertThatThrownBy(() -> new WinningLotto("1,2,3,4,5,6,7", "8"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("중복된 숫자를 입력하면 예외 발생")
    @Test
    void enterLottoInputByDuplicatedNumber() {
        Assertions.assertThatThrownBy(() -> new WinningLotto("1,2,3,4,5,5", "8"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 숫자가 이미 당첨 번호에 있는 경우 예외 발생")
    @Test
    void enterBonusNumberByDuplicatedNumber() {
        Assertions.assertThatThrownBy(() -> new WinningLotto("1,2,3,4,5,6", "5"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("1 ~ 45 사이 이외의 번호가 입력되면 예외 발생")
    @Test
    void enterLottoNumberByOutOfRange() {
        Assertions.assertThatThrownBy(() -> new WinningLotto("1,2,3,4,46,5", "8"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("숫자 이외의 타입을 입력하면 예외 발생")
    @Test
    void enterLottoNumberByOtherType() {
        Assertions.assertThatThrownBy(() -> new WinningLotto("1,2,3,4,5,6", "1,"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
