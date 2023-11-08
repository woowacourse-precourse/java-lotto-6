package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.*;

import static org.assertj.core.api.Assertions.*;

class LottoResultTest {

    @Test
    @DisplayName("주어진 로또와 우승 결과 비교가 정확하다: 1등")
    void lottoResult_FIRST() {
        // given
        List<Lotto> lottoBundle = new ArrayList<>();
        lottoBundle.add(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)));
        WinLotto winLotto = new WinLotto(Arrays.asList(1, 2, 3, 4, 5, 6), 7);

        // when
        LottoResult lottoResult = new LottoResult(lottoBundle, winLotto);

        // then
        Integer countFirst = lottoResult.getCountByRanking(Ranking.FIRST);
        Integer expectResults = 1;
        assertThat(countFirst).isEqualTo(expectResults);
    }

    @Test
    @DisplayName("주어진 로또와 우승 결과 비교가 정확하다: 2등")
    void lottoResult_SECOND() {
        // given
        List<Lotto> lottoBundle = new ArrayList<>();
        lottoBundle.add(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7)));
        lottoBundle.add(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7)));
        lottoBundle.add(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7)));
        lottoBundle.add(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 8)));
        WinLotto winLotto = new WinLotto(Arrays.asList(1, 2, 3, 4, 5, 6), 7);

        // when
        LottoResult lottoResult = new LottoResult(lottoBundle, winLotto);

        // then
        Integer countFirst = lottoResult.getCountByRanking(Ranking.SECOND);
        Integer expectResults = 3;
        assertThat(countFirst).isEqualTo(expectResults);
    }

    @ParameterizedTest
    @CsvSource(value = {"8000:25000000.0", "1000:200000000.0"}, delimiter = ':')
    @DisplayName("계산한 최종 수익률이 정확하다: 1등")
    void getTotalPrizeAmount_FIRST(Integer amount, Double expectEarningRatio) {
        // given
        Money money = new Money(amount);

        List<Lotto> lottoBundle = new ArrayList<>();
        lottoBundle.add(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)));
        WinLotto winLotto = new WinLotto(Arrays.asList(1, 2, 3, 4, 5, 6), 7);

        // when
        LottoResult lottoResult = new LottoResult(lottoBundle, winLotto);
        Double earningRatio = lottoResult.calculateEarningRatio(money);

        // then
        assertThat(earningRatio).isEqualTo(expectEarningRatio);
    }

    @ParameterizedTest
    @CsvSource(value = {"8000:375000.0", "1000:3000000.0"}, delimiter = ':')
    @DisplayName("계산한 최종 수익률이 정확하다: 2등")
    void getTotalPrizeAmount_SECOND(Integer amount, Double expectEarningRatio) {
        // given
        Money money = new Money(amount);

        List<Lotto> lottoBundle = new ArrayList<>();
        lottoBundle.add(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7)));
        WinLotto winLotto = new WinLotto(Arrays.asList(1, 2, 3, 4, 5, 6), 7);

        // when
        LottoResult lottoResult = new LottoResult(lottoBundle, winLotto);
        Double earningRatio = lottoResult.calculateEarningRatio(money);

        // then
        assertThat(earningRatio).isEqualTo(expectEarningRatio);
    }

}