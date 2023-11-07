package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GameManager {
    private Result result;
    private List<Lotto> lottos;
    private List<Integer> winningNumbers;
    private Integer bonusNumber;
    
    public GameManager() {
        this.result = null;
        this.lottos = new ArrayList<>();
        this.winningNumbers = null;
        this.bonusNumber = null;
    }
    
    public void generateLotto(Integer money) {
        Integer iterNum = money / 1000;
        for(int i = 0; i < iterNum; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Collections.sort(numbers);
            Lotto lotto = new Lotto(numbers);
            lottos.add(lotto);
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
    
    public void printLottos() {
        for(Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }
    
}
