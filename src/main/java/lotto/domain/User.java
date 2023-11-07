package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class User {
    private int payMoney;
    private int count;
    private List<Lotto> lottos;
    private Lotto winningNumber;
    private int bonusNumber;
    private ArrayList<Integer> winnersResult;
    private int winnerMoney = 0;

    public User() {
    }

    public int getPayMoney() {
        return payMoney;
    }

    public void setPayMoney(int payMoney) {
        this.payMoney = payMoney;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public void setLottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public Lotto getWinningNumber() {
        return winningNumber;
    }

    public void setWinningNumber(Lotto winningNumber) {
        this.winningNumber = winningNumber;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public void setBonusNumber(int bonusNumber) {
        this.bonusNumber = bonusNumber;
    }

    public ArrayList<Integer> getWinnersResult() {
        return winnersResult;
    }

    public void setWinnersResult(ArrayList<Integer> winnersResult) {
        this.winnersResult = winnersResult;
    }

    public int getWinnerMoney() {
        return winnerMoney;
    }

    public void setWinnerMoney(int winnerMoney) {
        this.winnerMoney = winnerMoney;
    }
}
