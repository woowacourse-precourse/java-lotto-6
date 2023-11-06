package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class LottoMachineTest {
    LottoMachine machine = new LottoMachine("8000");

    @Test
    void 로또생성_테스트() {
        LottoBundle bundle = machine.makeLottoBundle();
        assertThat(bundle.getBundle().size()).isEqualTo(8);
    }
}