package lotto.domain;

import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.Lottos;
import lotto.domain.roulette.Roulette;
import lotto.domain.roulette.RouletteResult;
import lotto.domain.roulette.WinningLotto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class RouletteTest {
    @Test
    @DisplayName("당첨번호와 구입한 로또를 비교하여 당첨결과를 조회한다.")
    public void matchWinningNumbersTest() throws Exception {
        // given
        Lotto winningNumbers = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 33;
        WinningLotto winningLotto = WinningLotto.of(winningNumbers, bonusNumber);

        List<Integer> numbers = new ArrayList<>(List.of(1, 2, 3, 9, 33, 4));
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(numbers));
        Lottos buyLottos = new Lottos(lottos);


        // when
        Roulette roulette = Roulette.of(winningLotto, buyLottos);
        RouletteResult rouletteResult = roulette.matchWinningNumbers(new Lotto(numbers));

        // then
        Assertions.assertThat(rouletteResult.getPrice())
                .isEqualTo(RouletteResult.FOUR_SAME_WINNING_NUMBER.getPrice());
    }

    @Test
    @DisplayName("당첨번호와 6개가 일치하다면 카운트가 된다.")
    public void matchLottoCountTest() throws Exception {
        // given
        Lotto winningNumbers = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 33;
        WinningLotto winningLotto = WinningLotto.of(winningNumbers, bonusNumber);

        List<Integer> numbers = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(numbers));
        Lottos buyLottos = new Lottos(lottos);

        // when
        Roulette roulette = Roulette.of(winningLotto, buyLottos);
        roulette.getRouletteLottos();

        // then
        Map<RouletteResult, Integer> result = roulette.getResult();
        Assertions.assertThat(result.get(RouletteResult.SIX_SAME_WINNING_NUMBER)).isEqualTo(1);
    }

    @Test
    @DisplayName("당첨번호와 5개와 보너스번호가 일치하다면 카운트가 된다.")
    public void matchLottoCountTest2() throws Exception {
        // given
        Lotto winningNumbers = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 33;
        WinningLotto winningLotto = WinningLotto.of(winningNumbers, bonusNumber);

        List<Integer> numbers = new ArrayList<>(List.of(1, 2, 3, 4, 5, 33));
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(numbers));
        Lottos buyLottos = new Lottos(lottos);

        // when
        Roulette roulette = Roulette.of(winningLotto, buyLottos);
        roulette.getRouletteLottos();

        // then
        Map<RouletteResult, Integer> result = roulette.getResult();
        Assertions.assertThat(result.get(RouletteResult.FIVE_AND_BONUS_SAME_WINNING_NUMBER)).isEqualTo(1);
    }

    @Test
    @DisplayName("당첨번호와 5개가 일치하다면 카운트가 된다.")
    public void matchLottoCountTest3() throws Exception {
        // given
        Lotto winningNumbers = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 33;
        WinningLotto winningLotto = WinningLotto.of(winningNumbers, bonusNumber);

        List<Integer> numbers = new ArrayList<>(List.of(1, 2, 3, 4, 5, 18));
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(numbers));
        Lottos buyLottos = new Lottos(lottos);

        // when
        Roulette roulette = Roulette.of(winningLotto, buyLottos);
        roulette.getRouletteLottos();

        // then
        Map<RouletteResult, Integer> result = roulette.getResult();
        Assertions.assertThat(result.get(RouletteResult.FIVE_SAME_WINNING_NUMBER)).isEqualTo(1);
    }
}
