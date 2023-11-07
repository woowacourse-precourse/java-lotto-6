package lotto;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class LottoTicket {
    private List<Integer> numbers = new ArrayList<>();
    private int matchCount;
    private boolean bonusNumberMatch = false;

    public LottoTicket(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public void setMatchCount(int matchCount) {
        this.matchCount = matchCount;
    }

    public boolean isBonusNumberMatch() {
        return bonusNumberMatch;
    }

    public void setBonusNumberMatch(boolean bonusNumberMatch) {
        this.bonusNumberMatch = bonusNumberMatch;
    }
}
