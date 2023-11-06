package lotto;

import java.util.List;

public class confirmationService {

    private List<Lotto> lottos;
    private int winningPrizeAmount;

    public confirmationService(List<Lotto> lottos) {
        this.lottos = lottos;
        this.winningPrizeAmount = 0;
    }

    public int confirmWinning(List<Integer> winningNumbers, int bonus){
        for(Lotto lotto : lottos){
            Winning winning = lotto.getWinning(winningNumbers, bonus);
            winningPrizeAmount += winning.getAmount();
        }
        return winningPrizeAmount;
    };

}
