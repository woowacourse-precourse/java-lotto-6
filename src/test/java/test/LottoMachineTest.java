package test;

import lotto.config.LottoConfig;
import lotto.model.LottoMachine;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class LottoMachineTest {
    @Test
    void 금액_정상_입력() {
        assertThat(new LottoMachine(5000).getLottoCount())
                .isEqualTo(5);
    }

    @Test
    void 생성된_로또별_숫자_개수_확인() {
        assertThat(new LottoMachine(5000).getLottos()
                .stream()
                .allMatch(lotto -> lotto.getNumbers().size() == LottoConfig.LOTTO_NUMBER_COUNT.getNumber())
        ).isTrue();
    }

}
