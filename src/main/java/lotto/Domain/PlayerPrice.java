package lotto.Domain;

import static lotto.Util.LottoNumberGenerator.createLottoNumberTickets;

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

    public int getBuyingPay() {
        return buyingPay;
    }

    public int getWinningMoney() {
        return winningMoney;
    }

    public void addWinningMoney(int money) {
        winningMoney += money;
    }
}
