package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.model.lotto.Lotto;
import lotto.model.machine.LottoMachine;
import lotto.model.machine.RandomLottoMachine;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RandomLottoMachineTest {
    private LottoMachine lottoMachine;

    @BeforeEach
    void setUp(){
        lottoMachine = new RandomLottoMachine();
    }

    @DisplayName("로또 생성 테스트")
    @Test
    void creatELotto(){
        assertThat(lottoMachine.generateLotto()).isInstanceOf(Lotto.class);
    }
}
