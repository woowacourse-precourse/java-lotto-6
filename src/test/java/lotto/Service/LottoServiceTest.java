package lotto.Service;

import lotto.Domain.Lotto;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoServiceTest {

    @Test
    void 로또를_구매금액만큼_발행할수있다() {

        LottoService ls = new LottoService(2000);
        Integer purchasedLottoCount = 2;

        List<Lotto> lottos = ls.createLottos(purchasedLottoCount);
        assertThat(lottos.size()).isEqualTo(purchasedLottoCount);
    }

    @Test
    void 당첨번호와_로또번호가_6개_일치하는_로또를_찾을수있다() {

        LottoService ls = new LottoService(1000);
        Integer purchasedLottoCount = 1;
        Integer bonusNumber = 9;

        List<Integer> winningNumbers = Arrays.asList(1,2,3,4,5,6);
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(Arrays.asList(1,2,3,4,5,6)));

        List<Integer> result = ls.findMatcingCount(purchasedLottoCount, bonusNumber, winningNumbers, lottos);
        assertThat(result.get(4)).isEqualTo(1);

    }

    @Test
    void 당첨번호와_로또번호가_5개_일치하며_보너스숫자도_일치하는_로또를_찾을수있다() {

        LottoService ls = new LottoService(1000);
        Integer purchasedLottoCount = 1;
        Integer bonusNumber = 9;

        List<Integer> winningNumbers = Arrays.asList(1,2,3,4,5,6);
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(Arrays.asList(1,2,3,4,5,9)));

        List<Integer> result = ls.findMatcingCount(purchasedLottoCount, bonusNumber, winningNumbers, lottos);
        assertThat(result.get(3)).isEqualTo(1);
    }

    @Test
    void 당첨번호와_로또번호가_5개_일치하는_로또를_찾을수있다() {

        LottoService ls = new LottoService(1000);
        Integer purchasedLottoCount = 1;
        Integer bonusNumber = 9;

        List<Integer> winningNumbers = Arrays.asList(1,2,3,4,5,6);
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(Arrays.asList(1,2,3,4,5,10)));

        List<Integer> result = ls.findMatcingCount(purchasedLottoCount, bonusNumber, winningNumbers, lottos);
        assertThat(result.get(2)).isEqualTo(1);

    }

    @Test
    void 당첨번호와_로또번호가_4개_일치하는_로또를_찾을수있다() {

        LottoService ls = new LottoService(1000);
        Integer purchasedLottoCount = 1;
        Integer bonusNumber = 9;

        List<Integer> winningNumbers = Arrays.asList(1,2,3,4,5,6);
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(Arrays.asList(1,2,3,4,40,41)));

        List<Integer> result = ls.findMatcingCount(purchasedLottoCount, bonusNumber, winningNumbers, lottos);
        assertThat(result.get(1)).isEqualTo(1);

    }

    @Test
    void 당첨번호와_로또번호가_3개_일치하는_로또를_찾을수있다() {

        LottoService ls = new LottoService(1000);
        Integer purchasedLottoCount = 1;
        Integer bonusNumber = 9;

        List<Integer> winningNumbers = Arrays.asList(1,2,3,4,5,6);
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(Arrays.asList(1,2,3,40,41,42)));

        List<Integer> result = ls.findMatcingCount(purchasedLottoCount, bonusNumber, winningNumbers, lottos);
        assertThat(result.get(0)).isEqualTo(1);
    }

    @Test
    void 당첨번호와_로또번호가_3개_미만으로_일치하는_로또는_개수를_세지_않는다() {

        LottoService ls = new LottoService(3000);
        Integer purchasedLottoCount = 3;
        Integer bonusNumber = 9;

        List<Integer> winningNumbers = Arrays.asList(1,2,3,4,5,6);
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(Arrays.asList(1,2,39,40,41,42)));
        lottos.add(new Lotto(Arrays.asList(1,38,39,40,41,42)));
        lottos.add(new Lotto(Arrays.asList(37,38,39,40,41,42)));

        List<Integer> result = ls.findMatcingCount(purchasedLottoCount, bonusNumber, winningNumbers, lottos);
        assertThat(result.stream().filter(
                i -> i.equals(0))
                .collect(Collectors.toList())
                .size())
                .isEqualTo(5);

    }

    @Test
    void 총_수익률을_계산할수_있다() {

        List<Integer> matchingCount = Arrays.asList(2,3,0,0,0);

        LottoService ls = new LottoService(5000);
        double result = ls.findEarningRate(5000, matchingCount);

        assertThat(String.valueOf(result)).isEqualTo("3200.0");

    }


}