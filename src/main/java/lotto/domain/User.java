package lotto.domain;

import lotto.util.LottoRank;

import java.util.List;
import java.util.stream.Collectors;

import static lotto.ui.OutputView.outputLottoList;

public class User {

    private final int PURCHASE_AMOUNT;
    private final List<Lotto> lottos;

    public User(int amount, List<Lotto> lottos) {
        this.PURCHASE_AMOUNT = amount;
        this.lottos = lottos;
        outputLottoList(lottos.size(), toString());
    }

    private Long calculateWinningAmount(List<Integer> winningNumbers, int bonusNumber) {
        Long totalWinningAmount = 0L;

        for (Lotto lotto : lottos) {
            totalWinningAmount += lotto.getLottoRank(winningNumbers, bonusNumber)
                    .getWinningAmount();
        }
        return totalWinningAmount;
    }

    public String calculateRateOfReturn(List<Integer> winningNumbers, int bonusNumber) {
        Long totalWinningAmount = calculateWinningAmount(winningNumbers, bonusNumber);
        double rateOfReturn = ((double) totalWinningAmount / PURCHASE_AMOUNT) * 100;
        return String.format("%.1f", rateOfReturn);
    }

    public int[] getLottoResults(List<Integer> winningNumbers, int bonusNumber) {
        int[] results = new int[LottoRank.values().length];

        for (Lotto lotto : lottos) {
            LottoRank lottoRank = lotto.getLottoRank(winningNumbers, bonusNumber);
            results[lottoRank.getRank()]++;
        }
        return results;
    }


    @Override
    public String toString() {
        return lottos.stream().map(Lotto::toString)
                .collect(Collectors.joining());
    }
}