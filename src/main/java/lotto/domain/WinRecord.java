package lotto.domain;

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
        for (List<Integer> ticket : tickets) {
            List<Integer> commonNumbers = new ArrayList<>(ticket);
            commonNumbers.retainAll(this.lotto);

            this.winRecord.add(commonNumbers.size());
        }
    }

    public List<Integer> getWinRecord() {
        return this.winRecord;
    }
}
