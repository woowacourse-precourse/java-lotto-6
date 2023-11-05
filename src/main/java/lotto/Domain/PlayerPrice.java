package lotto.Domain;

import java.util.ArrayList;
import java.util.List;

public class PlayerPrice {
    private int buyingPay;
    private int winningMoney;
    private List<PlayerNumber> issuedLottoTickets;

    public PlayerPrice(int buyingPay) {
        issuedLottoTickets = new ArrayList<>();
        this.buyingPay = buyingPay;
        this.winningMoney = 0;
    }

    public void setUpLottoTickets(int buyingPay) {
        this.issuedLottoTickets = createLottoNumberTickets(buyingPay);
    }

    public List<PlayerNumber> getLottoTickets() {
        return issuedLottoTickets;
    }

    public int getBuyingPrice() {
        return buyingPay;
    }

    public int getWinningPrice() {
        return winningMoney;
    }

    public void addWinningPrice(int money) {
        winningMoney += money;
    }
}
