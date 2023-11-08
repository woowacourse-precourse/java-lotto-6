package lotto;

import lotto.domain.inputAmountLotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;


import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

public class inputAmountLottoTest {

    @ParameterizedTest
    @ValueSource(strings = {"1000j", "1100", "-1"})
    @DisplayName("올바르지 않은 금액")
    void failed(String inputAmount) {
        assertThatThrownBy(() -> new inputAmountLotto(inputAmount))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("구매한 로또 티켓 장수")
    void calculateLottoCount() {
        inputAmountLotto amount = new inputAmountLotto("1000");
        assertThat(amount.numberOfLottoTickets()).isEqualTo(1);
    }



}
