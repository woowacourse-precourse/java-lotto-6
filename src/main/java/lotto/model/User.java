package lotto.model;

import java.util.List;

public class User {
    private int money;

    private int loopCount;

    private List<Integer> userInputNumbers;

    private int bonusNumber;

    private List<Integer> correctCounts;

    private List<Lotto> lottoTickets;

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getLoopCount() {
        return loopCount;
    }

    public void setLoopCount(int loopCount) {
        this.loopCount = loopCount;
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

    public void inputCorrectCount(int count){
        correctCounts.add(count);
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

}
