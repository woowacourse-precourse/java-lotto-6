package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.Rank;
import lotto.dto.AnswerLotto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
class LottoServiceTest {

    @Test
    void 로또와_당첨번호를_전달하면_당첨결과를_반환한다(){
        //given
        LottoService lottoService = new LottoService();
        AnswerLotto answerLotto = new AnswerLotto(Arrays.asList(1, 2, 3, 4, 5, 6), 7);
        Lotto lotto1 = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lotto lotto2 = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7));
        Lotto lotto3 = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 8));
        Lotto lotto4 = new Lotto(Arrays.asList(1, 2, 3, 4, 10, 11));
        Lotto lotto5 = new Lotto(Arrays.asList(1, 2, 3, 10, 11, 12));
        Lotto lotto6 = new Lotto(Arrays.asList(1, 2, 10, 11, 12, 13));

        List<Lotto> lottos = new ArrayList<>();
        lottos.add(lotto1);
        lottos.add(lotto2);
        lottos.add(lotto3);
        lottos.add(lotto4);
        lottos.add(lotto5);
        lottos.add(lotto6);
        //when
        List<Rank> winningResult = lottoService.findWinningResult(lottos, answerLotto);
        //then
        Assertions.assertThat(winningResult.get(0)).isEqualTo(Rank.FIRST_PLACE);
        Assertions.assertThat(winningResult.get(1)).isEqualTo(Rank.SECOND_PLACE);
        Assertions.assertThat(winningResult.get(2)).isEqualTo(Rank.THIRD_PLACE);
        Assertions.assertThat(winningResult.get(3)).isEqualTo(Rank.FOURTH_PLACE);
        Assertions.assertThat(winningResult.get(4)).isEqualTo(Rank.FIFTH_PLACE);
        Assertions.assertThat(winningResult.get(5)).isEqualTo(Rank.NOTHING);
    }

    @Test
    void Rank리스트를_전달하면_수익률을_알수있다(){
        //given
        LottoService lottoService = new LottoService();
        AnswerLotto answerLotto = new AnswerLotto(Arrays.asList(1, 2, 3, 4, 5, 6), 7);
        Lotto lotto1 = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lotto lotto2 = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7));

        List<Lotto> lottos = new ArrayList<>();
        lottos.add(lotto1);
        lottos.add(lotto2);
        //when
        List<Rank> winningResult = lottoService.findWinningResult(lottos, answerLotto);
        double rateOfReturn = lottoService.findRateOfReturn(winningResult);
        int sum = Rank.FIRST_PLACE.getWinningPrice() + Rank.SECOND_PLACE.getWinningPrice();
        int ticketPrice = 2 * 1000;
        double rate = sum/(double)ticketPrice * 100;
        rate = Math.round(rate * 100) / 100.0;

        //then
        Assertions.assertThat(rate).isEqualTo(rateOfReturn);
    }
}