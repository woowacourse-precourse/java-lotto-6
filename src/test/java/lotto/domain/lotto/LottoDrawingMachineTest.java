package lotto.domain.lotto;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.List;
import lotto.controller.dto.output.LottosDrawingResult;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

final class LottoDrawingMachineTest {
    @DisplayName("")
    @Test
    void test() {
        // given
        final WinningLotto winningLotto = new WinningLotto(List.of(1, 2, 3, 4, 5, 6), 7);
        final LottoDrawingMachine lottoDrawingMachine = new LottoDrawingMachine(winningLotto);

        final Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        final Lottos lottos = new Lottos(List.of(lotto));

        // when
        final LottosDrawingResult result = lottoDrawingMachine.draw(lottos);

        // then
        System.out.println(result);
        assertThat(result.firstCount()).isEqualTo(1);
    }
}