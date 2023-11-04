package lotto.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import lotto.domain.validation.LottoMachineValidationHandler;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.assertj.core.api.Assertions.*;

class LottoMachineTest {

    LottoMachine lottoMachine = new LottoMachine();

    @ParameterizedTest
    @CsvSource(value = {"1:1","2:2","5:5", "10:10", "100:100"}, delimiter = ':')
    @DisplayName("구매 갯수가 1개 이상일 때 구매 갯수 만큼 로또를 발행한다.")
    void generateLottos(int userPurchaseCount, int generateLottoCount) {
        // given // when
        List<Lotto> lottos = lottoMachine.generateLottos(userPurchaseCount);

        // then
        assertThat(lottos).hasSize(generateLottoCount);
    }

    @Test
    @DisplayName("구매 갯수가 0개이면 로또를 발행할 때 예외가 발생한다.")
    void generateLottosException() {
        // given
        int purchaseLottoCount = 0;

        // when // then
        assertThatThrownBy(() -> lottoMachine.generateLottos(purchaseLottoCount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LottoMachineValidationHandler.INVALID_LOTTO_GENERATE_COUNT_MESSAGE);
    }
}