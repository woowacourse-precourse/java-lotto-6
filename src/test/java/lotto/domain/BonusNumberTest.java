package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BonusNumberTest {
    private static final Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

    @DisplayName("문자 입력하면 예외 발생")
    @Test
    void createAmountByString() {
        String input = "1,2";
        assertThatThrownBy(() -> new BonusNumber(input, lotto))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("숫자로만 이루어진 값을 입력해주세요.");
    }

    @DisplayName("1~45 범위를 벗어나는 숫자 입력하면 예외 발생")
    @Test
    void createAmountByWrongRange() {
        String input = "46";
        assertThatThrownBy(() -> new BonusNumber(input, lotto))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 번호는 1~45 사이의 숫자를 입력해주세요.");
    }

    @DisplayName("당첨 번호에 있는 값 입력하면 예외 발생")
    @Test
    void createAmountByNumberInLotto() {
        String input = "6";
        assertThatThrownBy(() -> new BonusNumber(input, lotto))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 중복된 숫자가 포함되어 있습니다.");
    }
}
