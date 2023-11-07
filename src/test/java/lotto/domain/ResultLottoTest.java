package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class ResultLottoTest {


    @Test
    void 로또_정상_집계_테스트() {
        ResultLotto resultLotto = new ResultLotto(RankingLotto.makeHashMapLottoRanking());
        AmountLotto amountLotto = new AmountLotto("2000");
        List<Lotto> lotto = Arrays.asList(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(1, 2, 3, 4, 5, 7))
        );
        MyLottos myLottos = new MyLottos(lotto);
        WinningLotto winningLotto = new WinningLotto("1,2,3,4,5,6", "7");

        resultLotto.matchTotalLotto(amountLotto, myLottos, winningLotto);

        assertThat(resultLotto.getScore().get(RankingLotto.ONE)).isEqualTo(1);
        assertThat(resultLotto.getScore().get(RankingLotto.TWO)).isEqualTo(1);

    }

    @Test
    void 금액_수익률_테스트() {
        ResultLotto resultLotto = new ResultLotto(RankingLotto.makeHashMapLottoRanking());
        AmountLotto amountLotto = new AmountLotto("8000");
        List<Lotto> lotto = Arrays.asList(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(1, 2, 3, 4, 5, 7)),
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(1, 2, 3, 4, 5, 7)),
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(1, 2, 3, 4, 5, 7)),
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(10, 11, 12, 13, 14, 15))
        );
        MyLottos myLottos = new MyLottos(lotto);
        WinningLotto winningLotto = new WinningLotto("10,11,12,20,21,22", "7");

        resultLotto.matchTotalLotto(amountLotto, myLottos, winningLotto);

        assertThat(resultLotto.totalReward(amountLotto)).isEqualTo(62.5);


    }
}