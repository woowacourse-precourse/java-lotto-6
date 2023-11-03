package lotto.domain;

import static lotto.constant.message.ErrorMessage.NOT_MONEY;

import java.util.Collections;
import java.util.List;

public class Customer {
    private List<Lotto> lotteryTicket;
    private int money;

    public void scanPocket(int money) throws IllegalArgumentException {
        validateEmptyMoney(money);
        this.money = money;
    }

    private void validateEmptyMoney(int money) {
        if (money == 0) {
            throw new IllegalArgumentException(NOT_MONEY.getMessage());
        }
    }

    public int getMoney() {
        return money;
    }

    public void setLotteryTicket(List<Lotto> lotteryTicket) {
        this.lotteryTicket = lotteryTicket;
    }

    public List<Lotto> getLotteryTicket() {
        return Collections.unmodifiableList(lotteryTicket);
    }
}
