package lotto.domain;

import static lotto.ApplicationContext.getPrizeAmount;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.rule.PrizeAmount;

public class WinRecord {
    private PrizeAmount prizeAmount = getPrizeAmount();
    private List<Integer> winRecord = new ArrayList<>();
    private final List<Integer> lotto;
    private final int bonus;

    public WinRecord(List<Integer> lotto, int bonus) {
        this.lotto = lotto;
        this.bonus = bonus;
    }

    public void compareWinning(List<List<Integer>> tickets) {
        this.winRecord = tickets.stream()
                .map(ticket -> {
                    int lottoCount = (int) ticket.stream()
                            .filter(this.lotto::contains)
                            .count();
                    int bonusCount = 0;

                    if (ticket.contains(bonus)) {
                        bonusCount = 1;
                    }

                    return prizeAmount.matchAllCount(lottoCount, bonusCount);
                })
                .collect(Collectors.toList());
    }

    public void print() {
        prizeAmount.classifyWin(this.winRecord);
    }

    public List<Integer> getWinRecord() {
        return this.winRecord;
    }
}
