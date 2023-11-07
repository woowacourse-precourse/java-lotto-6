package lotto.v3.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static lotto.v3.util.LottoConstants.LOTTO_NUMBERS_SIZE;

class LottoMachineTest {
    @DisplayName("LottoMachine은 중복되지 않는 번호로 로또를 생성해야 한다.")
    @Test
    void shouldGenerateLottoWithUniqueNumbers() {
        LottoMachine machine = new LottoMachine();
        Lotto lotto = machine.generateLottoNumbers();

        Assertions.assertThat(lotto.getNumbers()).hasSize(LOTTO_NUMBERS_SIZE.getValue())
                .doesNotHaveDuplicates();
    }

}