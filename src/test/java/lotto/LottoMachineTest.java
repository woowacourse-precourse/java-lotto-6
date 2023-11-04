package lotto;

import lotto.domain.LottoMachine;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatNoException;

public class LottoMachineTest {
    @DisplayName("랜덤 로또가 제대로 생성된다.")
    @Test
    void publishRandomLottoTest() {
        LottoMachine machine = new LottoMachine();

        assertThatNoException().isThrownBy(machine::publishRandomLotto);
    }

}
