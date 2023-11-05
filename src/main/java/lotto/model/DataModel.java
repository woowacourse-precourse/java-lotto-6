package lotto.model;

import java.util.List;

public class DataModel {
    private int wallet;
    private List<List<Integer>> tickets;
    private List<Integer> lotto;
    private int bonus;
    private List<Integer> winRecord;

    public void saveWallet(int wallet) {
        this.wallet = wallet;
    }

    public void saveTicktet(List<List<Integer>> tickets) {
        this.tickets = tickets;
    }

    public void saveLotto(List<Integer> lotto) {
        this.lotto = lotto;
    }

    public void saveBonus(int bonus) {
        this.bonus = bonus;
    }

    public void saveWinRecord(List<Integer> winRecord) {
        this.winRecord = winRecord;
    }

    public int findWallet() {
        return this.wallet;
    }

    public List<List<Integer>> findTickets() {
        return this.tickets;
    }

    public List<Integer> findLotto() {
        return this.lotto;
    }

    public int findBonus() {
        return this.bonus;
    }

    public List<Integer> findWinRecord() {
        return this.winRecord;
    }

}
