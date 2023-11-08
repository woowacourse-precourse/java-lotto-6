package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GameManager {
    private int moneyYouPut;
    private final Result result;
    private final List<Lotto> lottos;
    private List<Integer> winningNumbers;
    private Integer bonusNumber;
    
    public GameManager() {
        this.result = new Result();
        this.lottos = new ArrayList<>();
        this.winningNumbers = null;
        this.bonusNumber = null;
        this.moneyYouPut = 0;
    }
    public int getMoneyYouPut() {
        return this.moneyYouPut;
    }
    public void setMoneyYouPut(int money) {
        this.moneyYouPut = money;
    }
    public Result getResult() {
        return this.result;
    }
    public List<Lotto> getLottos() {
        return this.lottos;
    }
    
    public void generateLotto() {
        int iterNum = moneyYouPut / Constants.LOTTOCOST;
        for(int i = 0; i < iterNum; i++) {
            List<Integer> numbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            Collections.sort(numbers);
            Lotto lotto = new Lotto(numbers);
            this.lottos.add(lotto);
        }
    }
    public Integer getGameSize() {
        return this.lottos.size();
    }
    
    public List<Integer> getWinningNumbers() { return this.winningNumbers; }
    
    public Integer getBonusNumber() { return this.bonusNumber; }
    
    public void setWinningNumbers(List<Integer> winningNumbers) {
        this.winningNumbers = winningNumbers;
    }
    
    public void setBonusNumber(Integer bonusNumber) {
        this.bonusNumber = bonusNumber;
    }
    
    public void updateResult() {
        this.result.makeScores(winningNumbers,bonusNumber,this.lottos);
    }
    
    public void updateProfit() { this.result.findProfitRate(result, moneyYouPut); }
}
