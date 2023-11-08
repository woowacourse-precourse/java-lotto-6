package domain;

import domain.result.TotalWinningResult;
import strategy.LottoStrategy;

import java.util.ArrayList;

public class User {
    public static final int NO_BONUS = -1;
    public static final int INFINITE_MONEY = -1;
    public static final int MONEY_UNIT = 1_000;
    private ArrayList<LottoTicket> lottoTickets;
    private TotalWinningResult totalWinningResult;
    private LottoStrategy lottoStrategy;
    private Integer money;

    private User(Integer money, LottoStrategy lottoStrategy) {
        this.lottoTickets = new ArrayList<LottoTicket>();
        this.totalWinningResult = new TotalWinningResult();
        this.lottoStrategy = lottoStrategy;
        moneyUnitValidation(money);
        this.money = money;
    }

    public static User playUserFrom(Integer money, LottoStrategy lottoStrategy) {
        return new User(money, lottoStrategy);
    }

    public static User ComUser(LottoStrategy lottoStrategy) {
        return new User(INFINITE_MONEY, lottoStrategy);
    }

    public void drawSingleLotto(ArrayList<Integer> numbers, Integer bonusNumber) {
        hasEnoughMoney(this.money);
        Lotto lotto = lottoStrategy.issueLotto(numbers);
        Integer bonus = lottoStrategy.issueBonus(numbers, bonusNumber);
        LottoTicket lottoTicket;
        if (bonusNumber == NO_BONUS) {
            lottoTickets.add(LottoTicket.normalTicketFrom(lotto));
        }

        if (bonusNumber != NO_BONUS) {
            lottoTickets.add(LottoTicket.bonusTicketOf(lotto, bonusNumber));
        }
    }

    public ArrayList<LottoTicket> getTickets() {
        return lottoTickets;
    }

    public void updateResult(LottoTicket otherTicket) {
        for (LottoTicket ticket : lottoTickets) {
            totalWinningResult.increase(otherTicket.getWinningResult(ticket));
        }
    }

    public TotalWinningResult getTotalWinningResult() {
        return totalWinningResult;
    }

    public Integer getAttempt() {
        return money / MONEY_UNIT;
    }

    private void moneyUnitValidation(Integer money) {
        if (money == INFINITE_MONEY) {
            return;
        }
        if (money % MONEY_UNIT > 0) {
                throw new IllegalArgumentException("[ERROR] to돈은 1_000 단위 여야 합니다!");
        }
    }

    private void hasEnoughMoney(Integer money) {
        if (money == INFINITE_MONEY) {
            return;
        }
        if (money < MONEY_UNIT) {
            throw new IllegalArgumentException("[ERROR] 돈이 부족합니다!");
        }
    }
}