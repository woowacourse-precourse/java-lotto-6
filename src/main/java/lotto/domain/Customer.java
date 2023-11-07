package lotto.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import lotto.constant.Prize;

public class Customer {
    private final List<Lotto> lotteryTicket;

    public Customer(List<Lotto> lottoTickets) {
        this.lotteryTicket = lottoTickets;
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

    public List<Lotto> getLotteryTicket() {
        return Collections.unmodifiableList(lotteryTicket);
    }
}
