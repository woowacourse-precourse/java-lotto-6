package lotto;

import lotto.model.Lotto;
import lotto.model.LottoMachine;
import lotto.model.Lottos;
import lotto.model.WinningLotto;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class LottoMachineTest {
    private static Lottos lottos;
    private static WinningLotto winningLotto;
    private static LottoMachine lottoMachine;
    private static final List<Integer> HUMAN_LOTTO = List.of(1, 4, 5, 7, 9, 10);
    private static final List<Integer> WINNING_LOTTO = List.of(1, 2, 3, 4, 5, 6);
    private static final int BONUS = 7;
    private static final int COUNT = 1;

    @BeforeAll
    static void setup() {
        lottos = mock(Lottos.class);
        when(lottos.getLottos()).thenReturn(List.of(new Lotto(HUMAN_LOTTO)));

        winningLotto = new WinningLotto(WINNING_LOTTO, BONUS);

        lottoMachine = new LottoMachine(lottos, winningLotto, COUNT);
    }

    @DisplayName("당첨 로또와 구매한 로또의 차이를 제대로 비교하는가")
    @Test
    void lottoMachine_로또번호_비교() {
        assertThat(lottoMachine.compareLotto(lottos.getLottos().get(0))).isEqualTo(3);
    }

    @DisplayName("보너스 번호와 구매한 로또의 차이를 제대로 비교하는가?")
    @Test
    void lottoMachine_보너스번호_비교() {
        assertThat(lottoMachine.compareBonus(lottos.getLottos().get(0))).isEqualTo(true);
    }
}
