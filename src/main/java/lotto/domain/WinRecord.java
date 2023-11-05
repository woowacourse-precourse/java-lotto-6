package lotto.domain;

import static lotto.ApplicationContext.getPrizeAmount;
import static lotto.constant.LottoConstant.MATCH_ALL_SEVEN_COUNT;
import static lotto.constant.LottoConstant.MATCH_ALL_SIX_COUNT;

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
                    int lottoCount = sameLottoCount(ticket);
                    int bonusCount = sameBonusCount(ticket);
                    return matchAllCount(lottoCount, bonusCount);
                })
                .collect(Collectors.toList());
    }

    private int sameBonusCount(List<Integer> ticket) {
        int bonusCount = 0;

        if (ticket.contains(bonus)) {
            bonusCount = 1;
        }

        return bonusCount;
    }

    private int sameLottoCount(List<Integer> ticket) {
        return (int) ticket.stream()
                .filter(this.lotto::contains)
                .count();
    }

    private int matchAllCount(int lottoCount, int bonusCount) {
        int sumCount = lottoCount + bonusCount;

        if (sumCount == MATCH_ALL_SIX_COUNT && lottoCount == 6) {
            sumCount = MATCH_ALL_SEVEN_COUNT;
        }

        return sumCount;
    }

    public void print() {
        prizeAmount.classifyWin(this.winRecord);
    }

    public List<Integer> getWinRecord() {
        return this.winRecord;
    }
}
