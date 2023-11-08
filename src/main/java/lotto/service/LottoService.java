package lotto.service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import lotto.Lotto;
import lotto.View.OutputView;
import lotto.domain.WinningLotto;
import lotto.domain.enums.Rank;

public class LottoService {
    public LottoService() {
    }

    private static List<Lotto> lottoList;
    private static WinningLotto winningLotto;

    // 당첨 통계
    public void getWinningTotal(List<Lotto> lottoList, WinningLotto winningLotto) {

        Map<Rank, Integer> result = setResult();
        Rank rank;

        for (int i = 0; i < lottoList.size(); i++) {
            rank = winningLotto.match(lottoList.get(i));
            result.put(rank, result.get(rank) + 1);
        }

        printTotalResult(result);
        printEarningRate(result, lottoList);
    }

    private void printTotalResult(Map<Rank, Integer> result) {
        for (int i = Rank.values().length - 1; i >= 0; i--) {
            Rank.values()[i].printMessage(result.get(Rank.values()[i]));
        }
    }

    private void printEarningRate(Map<Rank, Integer> result, List<Lotto> lottoList) {
        double earningRate = 0;
        int lottoAmount = lottoList.size();

        for (Rank rank : result.keySet()) {
            earningRate += ((double) rank.getWinningAmount() / (lottoAmount * 1000) * result.get(rank) * 100);
        }
        OutputView.printRevenueRate(earningRate);
    }

    private Map<Rank, Integer> setResult() {
        Map<Rank, Integer> result = new LinkedHashMap<>();

        for (Rank rank : Rank.values()) {
            result.put(rank, 0);
        }
        return result;
    }
}
