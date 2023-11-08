package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoMachineTest {

    @DisplayName("1000원단위가 아니면 예외가 발생한다.")
    @Test
    void purchaseAmountTextToInt() {
        LottoMachine lottoMachine = new LottoMachine();
        String purchaseAmountText = "14500";

        assertThatThrownBy(() -> lottoMachine.purchaseAmountTextToInt(purchaseAmountText))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨번호를 바르게 입력한 경우")
    @Test
    void textToLotto() {
        LottoMachine lottoMachine = new LottoMachine();
        String winningNumberText = "1,2,3,4,5,6";

        Lotto actual = lottoMachine.textToLotto(winningNumberText);
        Lotto expected = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));

        assertThat(actual)
                .usingRecursiveComparison()
                .isEqualTo(expected);
    }

    @DisplayName("당첨번호를 6개 입력하지 않은 경우 예외 처리")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,6,7", "1,2,3,4,5", "1,1,2,2,3,4", "0,1,2,3,46,5"})
    void textToLotto(String value) {
        LottoMachine lottoMachine = new LottoMachine();
        String winningNumberText = value;

        assertThatThrownBy(() -> lottoMachine.textToLotto(winningNumberText))
                .isInstanceOf(IllegalArgumentException.class);
    }
}