package lotto.domain.lotto;

import java.util.HashMap;
import java.util.List;

public class Lottos {

    private static final int BONUS = 7;
    private static final int MINIMUM = 3;

    List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public int getSize() {
        return lottos.size();
    }

    public HashMap<Integer,Integer> determineWinningsCount(Lotto winningLotto, Bonus bonus) {
        List<Integer> winningNumbers = winningLotto.getNumbers();
        int bonusNumber = bonus.getBonusNumber();
        HashMap<Integer,Integer>winnings = new HashMap<>();
        for (Lotto lotto : lottos) {
            int winningNumbersCount = getWinningNumbersCount(lotto,winningNumbers,bonusNumber);
            if(winningNumbersCount>=MINIMUM) {
                int lottoCount = winnings.getOrDefault(winningNumbersCount, 0);
                winnings.put(winningNumbersCount, lottoCount + 1);
            }
        }
        return winnings;
    }

    private int getWinningNumbersCount(Lotto lotto, List<Integer> winningNumbers, int bonusNumber){
        int winningNumbersCount = lotto.countWinningNumbers(winningNumbers);
        if(isWinningNumberCountFive(winningNumbersCount) && hasBonusNumber(lotto,bonusNumber)){
            winningNumbersCount = BONUS;
        }
        return winningNumbersCount;
    }

    private boolean isWinningNumberCountFive(int winningNumberCount){
        return winningNumberCount == 5;
    }

    private boolean hasBonusNumber(Lotto lotto, int bonusNumber){
        return lotto.hasSameNumber(bonusNumber);
    }

}
