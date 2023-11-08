package lotto.service;

import lotto.domain.Ranking;
import lotto.domain.generator.LottoNumberGenerator;
import lotto.domain.generator.NumberGenerator;
import lotto.domain.lotto.AnswerLotto;
import lotto.domain.lotto.Lottos;
import lotto.domain.lotto.PurchasePrice;
import lotto.domain.WinningResult;
import lotto.dto.LottoDto;
import lotto.dto.RankingDto;
import lotto.dto.WinningResultDto;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class LottoService {

    private PurchasePrice purchasePrice;
    private Lottos lottos;
    private AnswerLotto answerLotto;
    private WinningResult winningResult;

    public void buyLottos(int purchasePrice) {
        this.purchasePrice = new PurchasePrice(purchasePrice);
        NumberGenerator<List<Integer>> numberGenerator = LottoNumberGenerator.getInstance();
        this.lottos = new Lottos(numberGenerator, purchasePrice);
    }

    public List<LottoDto> getLottoDtos() {
        return lottos.getLottos().stream()
                .map(lotto -> new LottoDto(lotto.getNumbers()))
                .toList();
    }

    public void drawAnswerLotto(List<Integer> lottoNumbers, int bonusNumber) {
        answerLotto = new AnswerLotto(lottoNumbers, bonusNumber);
    }

    public void calculateWinningResult() {
        List<Ranking> rankings = lottos.calculateWinningResult(answerLotto);
        winningResult = new WinningResult(rankings, purchasePrice.getPurchasePrice());
    }

    public WinningResultDto getWinningResultDto() {
        Map<Ranking, Integer> rankingCount = winningResult.getRankingCount();
        List<RankingDto> rankingDtos = Arrays.stream(Ranking.values())
                .map(ranking -> new RankingDto(ranking.name(), ranking.getMatchCount(), ranking.getReward(), rankingCount.get(ranking)))
                .toList();

        return new WinningResultDto(rankingDtos, winningResult.getReturnRate());
    }
}
