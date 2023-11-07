package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class Register {
    private List<Lotto> lottoTickets;
    private Money money;
    private Lotto firstPrizeLotto;
    private Bonus bonus;

    public Register() {
        this.lottoTickets = new ArrayList<>();
    }

    public List<Lotto> getLottoTickets() {
        return new ArrayList<>(this.lottoTickets);
    }

    public void addLottoTicket(Lotto lotto) {
        this.lottoTickets.add(lotto);
    }

    public Money getMoney() {
        return money;
    }

    public void setMoney(Money money) {
        this.money = money;
    }

    public Lotto getFirstPrizeLotto() {
        return firstPrizeLotto;
    }

    public void setFirstPrizeLotto(Lotto firstPrizeLotto) {
        this.firstPrizeLotto = firstPrizeLotto;
    }

    public Bonus getBonus() {
        return bonus;
    }

    public void setBonus(Bonus bonus) {
        this.bonus = bonus;
    }
}
