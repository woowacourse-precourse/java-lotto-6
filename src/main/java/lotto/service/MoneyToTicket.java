package lotto.service;

public class MoneyToTicket {
    private final static int MONEY_UNIT = 1000;
    static int lottoTicket = 0;
    public int getTicket(int money) {
        lottoTicket = money / 1000;
        return lottoTicket;
    }
}
