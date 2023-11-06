package lotto.service;

import lotto.domain.Ranking;
import lotto.domain.lotto.AnswerLotto;
import lotto.domain.lotto.userLotto.UserLotto;
import lotto.domain.WinningResult;
import lotto.dto.LottoDto;
import lotto.dto.RankingDto;
import lotto.dto.WinningResultDto;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class LottoService {

    private UserLotto userLotto;
    private AnswerLotto answerLotto;
    private WinningResult winningResult;

    public void buyLottos(int purchasePrice) {
        userLotto = new UserLotto(purchasePrice);
    }

    public List<LottoDto> getUserLottoDto() {
        List<LottoDto> lottoDtos = userLotto.getLottos().stream()
                .map(lotto -> new LottoDto(lotto.getNumbers()))
                .toList();
        return lottoDtos;
    }

    public void drawLotto(List<Integer> winningNumbers, int bonusNumber) {
        answerLotto = new AnswerLotto(winningNumbers, bonusNumber);
    }

    public void calculateWinningResult() {
        winningResult = userLotto.calculateWinningResult(answerLotto);
    }

    public WinningResultDto getWinningResultDto() {
        Map<Ranking, Integer> rankingCount = winningResult.getRankingCount();
        List<RankingDto> rankingDtos = Arrays.stream(Ranking.values())
                .map(ranking -> new RankingDto(ranking.name(), ranking.getMatchCount(), ranking.getReward(), rankingCount.get(ranking)))
                .toList();

        return new WinningResultDto(rankingDtos, winningResult.getReturnRate());
    }
}
