package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.util.ConvertInput;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ConvertInputTest {
    @DisplayName("구입 금액을 두 개 이상 입력하면 예외가 발생한다.")
    @Test
    void manyPurchaseAmountTest() {
        assertThatThrownBy(() -> ConvertInput.makePlayerMoneyToInt("1000,2000"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입 금액에 수가 아닌 값이 포함되면 예외가 발생한다.")
    @Test
    void AmountNumberIsNotNumberTest() {
        assertThatThrownBy(() -> ConvertInput.makePlayerMoneyToInt("1e"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 수가 아닌 값이 포함되면 예외가 발생한다.")
    @Test
    void LottoNumberHasNotNumberTest() {
        assertThatThrownBy(() -> ConvertInput.makeLottoNumberToList("1,w,4,5,6,7"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호을 두 개 이상 입력하면 예외가 발생한다.")
    @Test
    void manyBonusNumberTest() {
        assertThatThrownBy(() -> ConvertInput.makeBonusNumberToInt("1,2"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호에 수가 아닌 값이 포함되면 예외가 발생한다.")
    @Test
    void BonusNumberIsNotNumberTest() {
        assertThatThrownBy(() -> ConvertInput.makeBonusNumberToInt("1e"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
