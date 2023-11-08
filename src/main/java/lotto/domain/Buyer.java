package lotto.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Buyer {

    private static final int LOTTO_PRICE = 1000;
    private static final int RANK = 7;

    private List<Lotto> lottos;

    private int lottoAmount;

    private HashMap<Integer,Integer> winningLotto;

    public Buyer(int money) {
        this.lottos = new ArrayList<>();
        this.lottoAmount = money / LOTTO_PRICE;
        winningLottoInit();
    }

    private void winningLottoInit(){
        this.winningLotto = new HashMap<>();
        for(int i=1; i<=5; i++){
            winningLotto.put(i,0);
        }
    }

    public void buyLotto(LotteryGenerator generator){
        for(int i=0; i<lottoAmount; i++){
            this.lottos.add(generator.getLotto());
        }
    }

    public void checkEachLottoLine(WinningManager manager){
        for(Lotto lotto : lottos){
            checkLine(lotto,manager);
        }
    }

    private void checkLine(Lotto lotto, WinningManager manager){
        int matchCount = compareWinningNumber(lotto,manager.getWinningNumber());
        boolean correctBonus = compareBonusNumber(lotto,manager.getBonusNumber());
        saveRanking(matchCount,correctBonus);
    }

    private void saveRanking(int matchCount,boolean correctBonus){
        if(matchCount == 6){
            winningLotto.put(RANK-matchCount,winningLotto.getOrDefault(RANK-matchCount,0)+1);
        }
        if(matchCount==5){
            judgeSecondAndThird(correctBonus);
        }
        winningLotto.put(RANK+1-matchCount, winningLotto.getOrDefault(RANK - matchCount, 0) + 1);
    }

    private void judgeSecondAndThird(boolean correctBonus){
        if(correctBonus){
            winningLotto.put(2, winningLotto.getOrDefault(2, 0) + 1);
            return;
        }
        winningLotto.put(3, winningLotto.getOrDefault(3, 0) + 1);
    }

    public int compareWinningNumber(Lotto numbers,List<Integer> winningNumber){
        int matchCount = 0;
        for(int targetNumber : numbers.getNumbers()) {
            if(winningNumber.contains(targetNumber)){
                matchCount++;
            }
        }
        return matchCount;
    }
    public boolean compareBonusNumber(Lotto numbers,int bonusNumber){
        if(numbers.getNumbers().contains(bonusNumber)){
            return true;
        }
        return false;
    }

    public List<Lotto> getLottos(){
        return lottos;
    }

    public int getLottoAmount() {
        return lottoAmount;
    }

    public HashMap<Integer, Integer> getWinningLotto() {
        return winningLotto;
    }
}
