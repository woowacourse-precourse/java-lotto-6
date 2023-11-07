package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import lotto.service.LottoPaymentService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class LottoPaymentServiceTest {
    private final LottoPaymentService lottoPaymentService = new LottoPaymentService();

    @ParameterizedTest
    @CsvSource({"1000,1", "2000,2", "9000,9", "100000,100"})
    void calculateNumberOfLottosTest(int money, int expectedAmount) {
        assertThat(lottoPaymentService.calculateNumberOfLottos(money)).isEqualTo(expectedAmount);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, -1, -1000})
    void validatePositive_throwsException(int money) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> lottoPaymentService.calculateNumberOfLottos(money));
    }

    @Test
    void validateNoRemainder_throwsException() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> lottoPaymentService.calculateNumberOfLottos(1001));
    }
}
