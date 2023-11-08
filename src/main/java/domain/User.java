package domain;

import domain.result.TotalWinningResult;

import java.util.ArrayList;

public class User {
    public static final int INFINITE_MONEY = -1;
    private ArrayList<LottoTicket> lottoTickets;
    private TotalWinningResult totalWinningResult;
    private Integer money;

    private User(Integer money) {
        this.lottoTickets = new ArrayList<LottoTicket>();
        this.totalWinningResult = new TotalWinningResult();
        this.money = money;
    }

    public static User playUserFrom(Integer money) {
        return new User(money);
    }

    public static User ComUser() {
        return new User(INFINITE_MONEY);
    }

    public void drawSingleLotto() {

    }

    public void drawLottoWithAllMoney() {

    }

    public TotalWinningResult getTotalWinningResult() {
        return totalWinningResult;
    }





}
