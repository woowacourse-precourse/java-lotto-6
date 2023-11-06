package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class LottoMachineTest {
    private LottoMachine lottoMachine;

    @BeforeEach
    void setting() {
        lottoMachine = new LottoMachine();
    }

    @DisplayName("잘못된 금액일 경우 예외")
    @ParameterizedTest(name = "{displayName} ({0}원)")
    @ValueSource(ints = {20500, 500})
    void getLottoCountFromPriceException(int userMoney) {
        assertThatThrownBy(() -> lottoMachine.getLottoCount(userMoney)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 개수 확인")
    @Test
    void getLottoCountFromPrice() {
        int result = lottoMachine.getLottoCount(15000);
        assertThat(result).isEqualTo(15);
    }
}