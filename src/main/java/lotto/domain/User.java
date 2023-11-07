package lotto.domain;

import lotto.ui.InputView;
import lotto.ui.OutputView;
import lotto.util.LottoRank;

import java.util.List;
import java.util.stream.Collectors;

import static lotto.ui.OutputView.outputLottoList;

public class User {

    private final int PURCHASE_AMOUNT;
    private List<Lotto> lottos;

    private User(int amount,List<Lotto> lottos){
        this.PURCHASE_AMOUNT = amount;
        this.lottos = lottos;
        outputLottoList(lottos.size(),toString());
    }

    public static User buyLotto(){
        int amount = InputView.inputAmount();
        List<Lotto> lottos = LottoStore.lottoIssuance(amount);
        return new User(amount,lottos);
    }


    private Long calculateWinningAmount(List<Integer> winningNumbers, int bonusNumber){
        Long totalWinningAmount = 0L;

        for(Lotto lotto: lottos){
            totalWinningAmount += lotto.getLottoRank(winningNumbers, bonusNumber)
                    .getWinningAmount();
        }
        return totalWinningAmount;
    }

    public double calculateRateOfReturn(List<Integer> winningNumbers, int bonusNumber){
        Long totalWinningAmount = calculateWinningAmount(winningNumbers, bonusNumber);

        return ((double)totalWinningAmount/PURCHASE_AMOUNT)*100;
    }

    public int[] getLottoResults(List<Integer> winningNumbers, int bonusNumber){
        int[] results = new int[LottoRank.values().length];

        for(Lotto lotto: lottos){
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