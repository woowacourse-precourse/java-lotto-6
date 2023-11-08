package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
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

    @DisplayName("금액에 따라 로또 구매 횟수 테스트")
    @ParameterizedTest(name = "{displayName} ({0}원)")
    @CsvSource({"15000, 15", "1000, 1", "0, 0"})
    void getLottoCountFromPrice(int userMoney, int expectedCount) {
        int result = lottoMachine.getLottoCount(userMoney);
        assertThat(result).isEqualTo(expectedCount);
    }
}