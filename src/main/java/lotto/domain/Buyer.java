package lotto.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Buyer {

    private static final int LOTTO_PRICE = 1000;

    private static final int BONUS_CORRECT_INDEX = 7;

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
        for(int i=3; i<=7; i++){
            winningLotto.put(i,0);
        }
    }

    public void buyLotto(){
        final LotteryGenerator generator = new LotteryGenerator();
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

        if(correctBonus && matchCount==5){
            winningLotto.put(BONUS_CORRECT_INDEX,winningLotto.getOrDefault(BONUS_CORRECT_INDEX,0)+1);
            return;
        }
        winningLotto.put(matchCount,winningLotto.getOrDefault(matchCount,0)+1);

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
