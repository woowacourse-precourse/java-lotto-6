package lotto.service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoRank;
import lotto.domain.lotto.WinnerLotto;
import lotto.repository.LottoRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoWinnerServiceTest {

    @DisplayName("구매한 로또 당첨 등수 체크")
    @Test
    void checkRanking() {
        LottoWinnerService lottoWinnerService = new LottoWinnerService();
        LottoRepository instance = LottoRepository.getInstance();
        List<Integer> winner = new ArrayList<>();

        for (int lottoNumber = 1; lottoNumber < 7; lottoNumber++) {
            winner.add(lottoNumber);
        }
        Lotto singleLotto = new Lotto(winner);
        instance.addLotto(singleLotto);
        WinnerLotto winnerLotto = new WinnerLotto(winner, 8);
        List<LottoRank> lottoRanks = lottoWinnerService.checkRanking(winnerLotto);
        List<LottoRank> lottoRankResult = new ArrayList<>();
        lottoRankResult.add(LottoRank.FIRST);
        Assertions.assertThat(lottoRanks).isEqualTo(lottoRankResult);
    }

    @Test
    void setLottoResult() {
        LottoWinnerService lottoWinnerService = new LottoWinnerService();
        List<LottoRank> lottoRanks = new ArrayList<>();
        Map<LottoRank, Integer> lottoRankResult1 = new LinkedHashMap<>(6);

        lottoRanks.add(LottoRank.FIRST);
        lottoRankResult1.put(LottoRank.LOSING, 0);
        lottoRankResult1.put(LottoRank.FIFTH, 0);
        lottoRankResult1.put(LottoRank.FOURTH, 0);
        lottoRankResult1.put(LottoRank.THIRD, 0);
        lottoRankResult1.put(LottoRank.SECOND, 0);
        lottoRankResult1.put(LottoRank.FIRST, 1);
        Map<LottoRank, Integer> lottoRankResult2 = lottoWinnerService.setLottoResult(lottoRanks);
        Assertions.assertThat(lottoRankResult1).isEqualTo(lottoRankResult2);
    }
}