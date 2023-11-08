package lotto.model;


public class NumberOfLottoTickets {

    private final int countLottoTickets;

    public NumberOfLottoTickets(int money) {
        this.countLottoTickets = publishLotto(money);
    }

    private int publishLotto(int money) {
        return money / 1000;
    }

    public int getCountLottoTickets() {
        return countLottoTickets;
    }
}
