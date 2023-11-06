package lotto.model;

import java.util.ArrayList;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningResultTest {

    @DisplayName("당첨 번호와 로또 번호의 일치하는 숫자 개수 계산 테스트 (2등 테스트)")
    @Test
    public void checkCorrectLottoNumber() {
        //given
        List<Integer> winningNumber = List.of(1, 2, 3, 4, 5, 6);

        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(List.of(1, 2, 3, 4, 5, 7)));
        lottos.add(new Lotto(List.of(2, 3, 4, 5, 6, 7)));
        lottos.add(new Lotto(List.of(3, 4, 5, 6, 7, 8)));

        //when
        WinningResult.checkWinning(7, winningNumber, lottos);
        int result = WinningResult.SIX_WINNING_WITH_BONUS.getWinningCount();

        //then
        int expect = 2;
        Assertions.assertThat(result).isEqualTo(expect);
    }
}