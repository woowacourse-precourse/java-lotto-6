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

}