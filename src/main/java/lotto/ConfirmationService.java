package lotto;

import java.util.HashMap;
import java.util.List;

public class ConfirmationService {
    private HashMap<Winning, Integer> winningCount;
    private List<Lotto> lottos;
    private int winningPrizeAmount;

    public ConfirmationService(List<Lotto> lottos) {
        this.lottos = lottos;
        this.winningPrizeAmount = 0;
        this.winningCount = new HashMap<>();
    }

    public void confirmWinnings(List<Integer> winningNumbers, int bonus){
        for(Lotto lotto : lottos){
            Winning winning = lotto.getWinning(winningNumbers, bonus);
            winningCount.put(winning, winningCount.getOrDefault(winning, 0)+1);
            winningPrizeAmount += winning.getAmount();
        }
    };
    public int getWinningPrizeAmount(){
        return winningPrizeAmount;
    };

    public int getWinningCount(Winning winning){
        return winningCount.get(winning);
    };

}
