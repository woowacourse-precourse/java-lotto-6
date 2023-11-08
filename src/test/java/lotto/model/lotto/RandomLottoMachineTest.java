package lotto.model.lotto;

import static lotto.model.lotto.LottoConstant.LOTTO_SIZE;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashSet;
import java.util.Set;
import lotto.model.machine.LottoMachine;
import lotto.model.machine.RandomLottoMachine;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RandomLottoMachineTest {
    private LottoMachine lottoMachine;
    private Lotto lotto;

    @BeforeEach
    void setUp(){
        //given
        lottoMachine = new RandomLottoMachine();
        lotto = lottoMachine.generateLotto();
    }

    @DisplayName("로또 생성 테스트")
    @Test
    void createLotto(){
        // when & then
        assertThat(lotto).isInstanceOf(Lotto.class);
    }

    @DisplayName("6개 숫자 생성 테스트")
    @Test
    void assertLottoSizeIs6(){
        // when & then
        assertThat(lotto.getLotto().size()).isEqualTo(LOTTO_SIZE.getValue());
    }

    @DisplayName("로또 내 숫자가 중복되지 않는지 테스트")
    @Test
    void assertLottoHasNoDuplicate(){
        //given
        Set<Integer> uniqueLottos = new HashSet<>(lotto.getLotto());
        // when & then
        assertThat(uniqueLottos.size()).isEqualTo(lotto.getLotto().size());
    }
}
