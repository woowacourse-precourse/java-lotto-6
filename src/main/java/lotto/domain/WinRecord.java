package lotto.domain;

import static lotto.ApplicationContext.getPrizeAmount;

import java.util.ArrayList;
import java.util.List;

public class WinRecord {
    private List<Integer> winRecord = new ArrayList<>();
    private final List<Integer> lotto;
    private final int bonus;

    public WinRecord(List<Integer> lotto, int bonus) {
        this.lotto = lotto;
        this.bonus = bonus;
    }

    public void compareWinning(List<List<Integer>> tickets) {
        PrizeAmount prizeAmount = getPrizeAmount();
        int lottoCount = 0;
        int bonusCount = 0;

        for (List<Integer> ticket : tickets) {
            List<Integer> commonNumbers = new ArrayList<>(ticket);
            commonNumbers.retainAll(this.lotto);
            lottoCount = commonNumbers.size();

            if(ticket.contains(bonus)){
                bonusCount = 1;
            }

            int matchAllCount = prizeAmount.matchAllCount(lottoCount, bonusCount);
            winRecord.add(matchAllCount);
        }
    }

    public void print() {
        PrizeAmount prizeAmount = getPrizeAmount();
        prizeAmount.classifyWin(this.winRecord);
    }

}
