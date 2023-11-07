package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoMachineTest {
    @Test
    @DisplayName("전달받은 개수만큼 로또를 생성한다.")
    void createLotto() throws Exception {
        // given
        final List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        final LottoMachine lottoMachine = new LottoMachine(() -> numbers);

        // when
        final List<Lotto> lottos = lottoMachine.createLotto(14);

        // then
        assertThat(lottos).hasSize(14);
    }

    @Test
    @DisplayName("로또 당첨 번호를 전달받아 당첨 로또를 생성한다.")
    void createWinningLotto() throws Exception {
        // given
        final List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        final LottoMachine lottoMachine = new LottoMachine(() -> numbers);

        // when
        final Lotto winningLotto = lottoMachine.createWinningLotto(numbers);
        final List<Integer> result = winningLotto.getNumbers();

        // then
        assertThat(result).containsExactly(1, 2, 3, 4, 5, 6);
    }
}
