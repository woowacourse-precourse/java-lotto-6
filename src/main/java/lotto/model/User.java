package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class User {
    private int money;

    private int loopCount;

    private List<Integer> userInputNumbers;

    private int bonusNumber;

    private List<Integer> correctCounts;

    private List<Boolean> correctBonusCounts;

    private List<Lotto> lottoTickets;

    private long resultMoney;

    public User(){
        this.userInputNumbers = new ArrayList<>();
        this.correctCounts = new ArrayList<>();
        this.correctBonusCounts = new ArrayList<>();
        this.lottoTickets = new ArrayList<>();
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getLoopCount() {
        return loopCount;
    }

    public List<Integer> getUserInputNumbers() {
        return userInputNumbers;
    }

    public void setUserInputNumbers(List<Integer> userInputNumbers) {
        this.userInputNumbers = userInputNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public void setBonusNumber(int bonusNumber) {
        this.bonusNumber = bonusNumber;
    }

    public void calculationLoopCount(){
        loopCount = money / 1000;
    }

    public void setLottoTicket(Lotto lotto){
        lottoTickets.add(lotto);
    }

    public List<Lotto> getLottoTickets(){
        return lottoTickets;
    }

    public void setCorrectCounts(int count){
        correctCounts.add(count);
    }

    public void setCorrectBonusCounts(boolean bonusCheck){
        correctBonusCounts.add(bonusCheck);
    }

    public List<Integer> getCorrectCounts() {
        return correctCounts;
    }

    public List<Boolean> getCorrectBonusCounts() {
        return correctBonusCounts;
    }

    public long getResultMoney() {
        return resultMoney;
    }

    public void setResultMoney(long resultMoney) {
        this.resultMoney = resultMoney;
    }
}
