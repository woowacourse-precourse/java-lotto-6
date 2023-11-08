package lotto.domain;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.CommonLotto;
import lotto.view.LottoView;

public class LottoResults {
    LottoGame lottoGame;
    public LottoResults(LottoGame lottoGame){
        this.lottoGame = lottoGame;
    }
    public void lottoResult() {
        Map<Ranking, Integer> result = setResult();
        List<Ranking> ranks = matcher();
        ranks.stream().forEach(rank -> result.put(rank, result.get(rank) + 1));
        printResult(result);
        printEarningRate(result, calculateAmount());
    }
    public void printResult(Map<Ranking, Integer> result) {
        Arrays.stream(Ranking.values())
                .sorted(Comparator.reverseOrder())
                .forEach(rank -> rank.printMessage(result.get(rank)));
    }
    public void printEarningRate(Map<Ranking, Integer> result, int lottoAmount) {
        double EarningRate = 0;
        EarningRate = result.entrySet().stream()
                .mapToDouble(e -> ((double) (e.getKey().getWinningAmount()) / (lottoAmount * CommonLotto.LOTTO_PRICE) * (e.getValue())) * 100)
                .sum();
        LottoView.msgRevenueRate(EarningRate);
    }

    public Map<Ranking, Integer> setResult() {
        Map<Ranking, Integer> result = new LinkedHashMap<>();
        Arrays.stream(Ranking.values())
                .forEach(rank -> result.put(rank,0));
        return result;
    }
    public List<Ranking> matcher() {
        List<Integer> matchCount = totalCountMatch();
        List<Boolean> bonusMatch = totalBonusMatch();

        List<Ranking> rank = IntStream.range(0,matchCount.size())
                .mapToObj(i -> Ranking.valueOf(matchCount.get(i), bonusMatch.get(i)))
                .collect(Collectors.toList());
        return rank;
    }
    public List<Integer> totalCountMatch() {
        return lottoGame.lottoGames.stream()
                .map(lotto -> lotto.countMatch(lottoGame.winningNum))
                .collect(Collectors.toList());
    }
    public List<Boolean> totalBonusMatch() {
        return lottoGame.lottoGames.stream()
                .map(lotto -> lotto.bonusMatch(lottoGame.bonusNum))
                .collect(Collectors.toList());
    }
    private int calculateAmount() {
        return this.lottoGame.lottoGames.size();
    }
}
