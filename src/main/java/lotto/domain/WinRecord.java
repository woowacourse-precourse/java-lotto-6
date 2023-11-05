package lotto.domain;

import static lotto.ApplicationContext.getPrizeAmount;

import java.util.ArrayList;
import java.util.List;
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
        int lottoCount = 0;
        int bonusCount = 0;

        for (List<Integer> ticket : tickets) {
            List<Integer> commonNumbers = new ArrayList<>(ticket);
            commonNumbers.retainAll(this.lotto);
            lottoCount = commonNumbers.size();

            if(ticket.contains(bonus)){
                bonusCount = 1;
            }

            int matchAllCount = this.prizeAmount.matchAllCount(lottoCount, bonusCount);
            winRecord.add(matchAllCount);
        }
    }

    public void print() {
        prizeAmount.classifyWin(this.winRecord);
    }

    public List<Integer> getWinRecord() {
        return this.winRecord;
    }
}
