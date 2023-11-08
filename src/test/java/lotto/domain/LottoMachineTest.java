package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.Lotto;
import lotto.domain.machine.LottoMachine;
import lotto.domain.machine.LottoNumberGenerator;
import lotto.domain.machine.LottoNumberGeneratorImpl;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class LottoMachineTest {
    private static final LottoNumberGenerator generator = new LottoNumberGeneratorImpl();
    private static final LottoMachine lottoMachine = new LottoMachine(generator);
    public static final int PRICE_PER_LOTTO = 1000;

    @ParameterizedTest(name = "{0}원에 해당하는 양의 로또를 발행하다.")
    @ValueSource(ints = {1000, 10000})
    void 입력_금액에_맞는_로또를_발행하다(int inputMoney) {
        // Given
        int expectedAmount = inputMoney / PRICE_PER_LOTTO;

        // When
        List<Lotto> lottoList = lottoMachine.issueLottoListForInputMoney(inputMoney);

        // Then
        assertThat(lottoList.size()).isEqualTo(expectedAmount);
    }

    @ParameterizedTest(name = "구입 금액으로 {0}원을 입력하면 예외가 발생한다.")
    @ValueSource(ints = {-1, 1234})
    void 잘못된_금액을_입력하다(int invalidInputMoney) {
        // When
        assertThatThrownBy(() -> lottoMachine.issueLottoListForInputMoney(invalidInputMoney))
                // Then
                .isInstanceOf(IllegalArgumentException.class);
    }
}
