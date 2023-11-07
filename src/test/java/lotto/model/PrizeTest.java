package lotto.model;
import lotto.model.Lotto;
import lotto.utils.PrizeNumberValidator;
import lotto.view.InputView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
public class PrizeTest {
    @DisplayName("6개 이상의 당첨번호가 입력되면 예외가 발생한다.")
    @Test
    void checkOverSixNumbers() {
        assertThatThrownBy(() -> new PrizeNumberValidator(List.of(1, 2, 3, 4, 5, 6, 7), 1))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("6개 이하의 당첨번호가 입력되면 예외가 발생한다.")
    @Test
    void checkUnderSixNumbers() {
        assertThatThrownBy(() -> new PrizeNumberValidator(List.of(1, 2, 3, 4, 5), 1))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호가 숫자가 아니면 예외가 발생한다.")
    @Test
    void notContainNumbers() {
        assertThatThrownBy(() -> InputView.numberList("1,d,3,4"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호가 1~45사이의 숫자가 아니면 예외가 발생한다.")
    @Test
    void correctRangeOfPrizeNumber() {
        assertThatThrownBy(() -> new PrizeNumberValidator(List.of(0, 2, 3, 4, 5, 6),1))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 숫자가 아니면 예외가 발생한다.")
    @Test
    void checkBonusInputIsNumber() {
        assertThatThrownBy(() -> InputView.conventToInt("a"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 1~45사이의 숫자가 아니면 예외가 발생한다.")
    @Test
    void correctRangeOfBonusNumber() {
        assertThatThrownBy(() -> new PrizeNumberValidator(List.of(1, 2, 3, 4, 5, 6), 99))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void hasDuplicatedInPrizeNumber() {
        assertThatThrownBy(() -> new PrizeNumberValidator(List.of(1, 2, 3, 4, 5, 6), 1))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
