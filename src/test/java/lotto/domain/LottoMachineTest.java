package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoMachineTest {
    private LottoMachine lottoMachine;

    @BeforeEach
    void setUp() {
        lottoMachine = new LottoMachine();
    }

    @DisplayName("1000원단위가 아니면 예외가 발생한다.")
    @Test
    void purchaseAmountTextToInt() {
        String purchaseAmountText = "14500";

        assertThatThrownBy(() -> lottoMachine.purchaseAmountTextToInt(purchaseAmountText))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨번호를 바르게 입력한 경우")
    @Test
    void textToLotto() {
        String winningNumberText = "1,2,3,4,5,6";

        Lotto actual = lottoMachine.textToLotto(winningNumberText);
        Lotto expected = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));

        assertThat(actual)
                .usingRecursiveComparison()
                .isEqualTo(expected);
    }

    @DisplayName("당첨번호를 6개 입력하지 않은 경우, 중복된 번호를 입력한 경우, 1~45를 넘는 번호를 입력한경우 예외 발생")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,6,7", "1,2,3,4,5", "1,1,2,2,3,4", "0,1,2,3,46,5"})
    void textToLotto(String value) {
        String winningNumberText = value;

        assertThatThrownBy(() -> lottoMachine.textToLotto(winningNumberText))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 당첨번호를 적절히 입력한 경우")
    @Test
    void BonusNumberTextToInt() {
        String winningNumberText = "1,2,3,4,5,6";
        String bonusNumberText = "7";

        lottoMachine.textToLotto(winningNumberText);
        int actual = lottoMachine.BonusNumberTextToInt(bonusNumberText);

        assertThat(actual).isEqualTo(7);

    }

    @DisplayName("보너스 번호가 1~45범위를 넘으면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"0", "46"})
    void BonusNumberTextToInt_예외(String value) {
        String bonusNumberText = value;

        assertThatThrownBy(() -> lottoMachine.BonusNumberTextToInt(bonusNumberText))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 당첨번호와 중복되면 예외가 발생한다.")
    @Test
    void BonusNumberTextToInt_예외() {
        String winningNumberText = "1,2,3,4,5,6";
        String bonusNumberText = "1";

        lottoMachine.textToLotto(winningNumberText);

        assertThatThrownBy(() -> lottoMachine.BonusNumberTextToInt(bonusNumberText))
                .isInstanceOf(IllegalArgumentException.class);
    }
}