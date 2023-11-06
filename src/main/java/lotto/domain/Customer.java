package lotto.domain;

import static lotto.constant.message.ErrorMessage.NOT_MONEY;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import lotto.constant.Prize;

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

    public Map<Prize, Integer> checkWinningResult(WinningNumbers winningNumbers) {
        Map<Prize, Integer> result = initResult();
        lotteryTicket.stream()
                .map(winningNumbers::checkPrize)
                .forEach(prize -> result.put(prize, result.get(prize) + 1));
        return result;
    }

    private Map<Prize, Integer> initResult() {
        Map<Prize, Integer> result = new LinkedHashMap<>();
        Arrays.stream(Prize.values())
                .forEach(prize -> result.put(prize, 0));
        return result;
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
