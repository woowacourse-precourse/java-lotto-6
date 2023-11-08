package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import lotto.constant.LottoGameConstant;

public class LottoGame {
    private int buyAmount;
    private int buyCount;

    private List<Lotto> lottos;

    private Lotto winNumbers;
    private int bonusNumber;

    private int[] winRankCount;

    public LottoGame(int buyAmount){
        this.buyAmount = buyAmount;
        this.buyCount = buyAmount/1000;
        this.lottos = new ArrayList<>();
        winRankCount = new int[5];
    }

    public void generateLottos(){
        for (int i=0; i<buyCount; i++){
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(
                    LottoGameConstant.GENERATE_MIN_VALUE,
                    LottoGameConstant.GENERATE_MAX_VALUE,
                    LottoGameConstant.GENERATE_NUM_SIZE
            );
            Collections.sort(numbers);
            Lotto newLotto = new Lotto(numbers);
            lottos.add(newLotto);
        }
    }

    public int getBuyCount() {
        return buyCount;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public void setWinNumbers(Lotto winNumbers) {
        this.winNumbers = winNumbers;
    }

    public void setBonusNumber(int bonusNumber) {
        this.bonusNumber = bonusNumber;
    }

    public Lotto getWinNumbers() {
        return winNumbers;
    }

    public void calculateWinLotto(){
        for (Lotto lotto : lottos){
            int matchCount = calculateWinRank(lotto);
            boolean isMatchBonus = checkMatchBonus(lotto);
        }
    }

    public int calculateWinRank(Lotto lotto){
        int matchCount = 0;
        for (int number : lotto.getNumbers()){
            if (winNumbers.getNumbers().contains(number))
                matchCount ++;
        }
        return matchCount;
    }

    public boolean checkMatchBonus(Lotto lotto){
        if (lotto.getNumbers().contains(bonusNumber)){
            return true;
        }
        return false;
    }
}
