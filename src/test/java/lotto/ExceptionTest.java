package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ExceptionTest {
    @DisplayName("숫자가 아닌 문자를 입력하면 예외가 발생한다.(구입금액, 보너스번호)")
    @Test
    void stringToInt() {
        assertThatThrownBy(() -> Exception.numberTypeValidate("one"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자를 입력하셔야 합니다.");
    }

    @DisplayName("숫자가 아닌 문자를 입력하면 예외가 발생한다.(당첨번호)")
    @Test
    void stringToIntegerList() {
        assertThatThrownBy(() -> Exception.numberTypeValidate("one,1,2,3,4,5"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자를 입력하셔야 합니다.");
    }

    @DisplayName("구입금액이 0원이면 예외가 발생한다.")
    @Test
    void priceIs0() {
        assertThatThrownBy(() -> Exception.priceValidate(0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또를 최소 1장 구입하셔야 합니다.");
    }

    @DisplayName("구입금액이 1000원 단위가 아닌 경우 예외가 발생한다.")
    @Test
    void priceFormat() {
        assertThatThrownBy(() -> Exception.priceValidate(2100))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또 1장의 가격은 1,000원입니다.");
    }

    @DisplayName("보너스번호가 1 미만인 경우 예외가 발생한다.")
    @Test
    void bonusNumberLessThan1() {
        assertThatThrownBy(() -> Exception.bonusNumberValidate(0, List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또 번호는 1부터 45 사이의 숫자여야 합니다.");
    }

    @DisplayName("보너스번호가 45 초과인 경우 예외가 발생한다.")
    @Test
    void bonusNumberOver45() {
        assertThatThrownBy(() -> Exception.bonusNumberValidate(46, List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또 번호는 1부터 45 사이의 숫자여야 합니다.");
    }

    @DisplayName("입력한 보너스번호가 당첨번호와 중복되는 경우 예외가 발생한다.")
    @Test
    void bonusNumberDuplicate() {
        assertThatThrownBy(() -> Exception.bonusNumberValidate(1, List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("당첨번호에 중복된 번호가 존재합니다.");
    }
}
