package lotto;

import lotto.Domain.BonusNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BonusNumberTest {
    @DisplayName("정수가 아닌 문자를 입력할 경우 예외가 발생한다.")
    @Test
    void createInputBonusNumberNotInteger() {
        assertThatThrownBy(() -> Parser.parseBonusNumber("f"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 정수만 입력할 수 있습니다.\n");
    }

    @DisplayName("45보다 큰 정수를 입력할 경우 예외가 발생한다.")
    @Test
    void createInputBonusNumberOverOfRange() {
        assertThatThrownBy(() -> new BonusNumber(46, List.of(1,2,3,4,5,6)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 1~45 사이의 정수만 입력할 수 있습니다.\n");
    }

    @DisplayName("1보다 작은 정수를 입력할 경우 예외가 발생한다.")
    @Test
    void createInputBonusNumberUnderOfRange() {
        assertThatThrownBy(() -> new BonusNumber(0, List.of(1,2,3,4,5,6)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 1~45 사이의 정수만 입력할 수 있습니다.\n");
    }

    @DisplayName("당첨 번호에 있는 숫자를 보너스 번호로 입력하면 예외가 발생한다")
    @Test
    void createResultNumbersByContainBonusNumber() {
        assertThatThrownBy(() -> new BonusNumber(1, List.of(1, 2, 3, 4, 5, 6)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 당첨 번호에 없는 정수를 입력해야 합니다.\n");
    }
}
