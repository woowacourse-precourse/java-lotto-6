package lotto.service;

import lotto.domain.AnswerLotto;
import lotto.domain.Ranking;
import lotto.domain.UserLotto;
import lotto.domain.WinningResult;
import lotto.dto.LottoDto;
import lotto.dto.WinningResultDto;

import java.util.Arrays;
import java.util.EnumMap;
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

        Map<Ranking, Integer> rankingCount2 = new EnumMap<>(Ranking.class);
        Arrays.stream(Ranking.values())
                .forEach(ranking -> rankingCount2.put(ranking, rankingCount.get(ranking)));

        return new WinningResultDto(rankingCount2, winningResult.getReturnRate());
    }
}
