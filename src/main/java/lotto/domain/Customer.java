package lotto.domain;

import static lotto.constant.message.ErrorMessage.NOT_MONEY;

import java.util.Collections;
import java.util.List;

public class Customer {
    private List<Lotto> lotteryTicket;
    private int money;

    public void scanPocket(String input) throws IllegalArgumentException {
        validateOnlyDigit(input);
        this.money = Integer.parseInt(input);
    }

    private void validateOnlyDigit(String input) {
        if (!input.chars().allMatch(Character::isDigit) || input.equals("0")) {
            throw new IllegalArgumentException(NOT_MONEY);
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
