package lotto;

import lotto.model.vo.Money;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class MoneyTest {

    @DisplayName("입력 받은 돈이 빈 값일 경우 예외가 발생한다.")
    @ValueSource(strings = {"", " "})
    @ParameterizedTest
    void should_throwException_when_isBlank(String input) {
        assertThatThrownBy(() -> new Money(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("빈 값을 입력하면 안됩니다.");
    }

    @DisplayName("입력 받은 돈이 숫자 형식이 아닐 경우 예외가 발생한다.")
    @Test
    void should_throwException_when_isNotNumeric() {
        assertThatThrownBy(() -> new Money("park"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자 형식이 아닙니다.");
    }

    @DisplayName("돈 객체가 불변할 경우 True를 반환한다.")
    @Test
    void should_true_when_immutable() {
        Money money = new Money("1000");

        assertThat(money.equals(new Money("1000")))
                .isTrue();
    }
}
