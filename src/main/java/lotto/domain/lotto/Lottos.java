package lotto.domain.lotto;

import java.util.HashMap;
import java.util.List;
import lotto.domain.WinningResult;

public class Lottos {

    private static final int BONUS = 7;

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

    public WinningResult determineWinnings(Lotto winningLotto, Bonus bonus) {
        List<Integer> winningNumbers = winningLotto.getNumbers();
        HashMap<Integer,Integer>winningResult = new HashMap<>();
        for (Lotto lotto : lottos) {
            int winningNumbersCount = lotto.countWinningNumbers(winningNumbers);
            if(isWinningNumberCountFive(winningNumbersCount) && hasBonusNumber(lotto,bonus)){
                winningNumbersCount = BONUS;
            }
            int lottoCount = winningResult.getOrDefault(winningNumbersCount,0);
            winningResult.put(winningNumbersCount,lottoCount+1);
        }
        return new WinningResult(winningResult);
    }

    private boolean isWinningNumberCountFive(int winningNumberCount){
        return winningNumberCount == 5;
    }

    private boolean hasBonusNumber(Lotto lotto, Bonus bonus){
        return lotto.hasSameNumber(bonus.getBonusNumber());
    }

}
