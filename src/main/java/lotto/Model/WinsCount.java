package lotto.Model;

import java.util.ArrayList;
import java.util.List;

public class WinsCount {
    private final int FIVE_MATCH = 5;
    private final int SIX_MATCH = 6;

    private final List<Integer> winsCount;

    public WinsCount (List<Lotto> lottos, List<Integer> winningNumbers,int bonus) {
        this.winsCount = matchLotto(lottos,winningNumbers,bonus);
    }

    private List<Integer> matchLotto(List<Lotto> lottos, List<Integer> winningNumbers,int bonus) {
        List<Integer> result = new ArrayList<>();
        for (Lotto lotto : lottos) {
            int count = countMatch(lotto, winningNumbers, bonus);
            result.add(count);
        }
        return result;
    }

    private int countMatch(Lotto lotto, List<Integer> winningNumbers, int bonus) {
        List<Integer> lottoNumbers = lotto.getNumbers();
        int count = 0;
        boolean hasBonus = false;
        for (int number : lottoNumbers) {
            if (winningNumbers.contains(number))
                count++;
            if (number == bonus)
                hasBonus = true;
        }
        if ((count == FIVE_MATCH && hasBonus) || count == SIX_MATCH)
            count++;
        return count;
    }

    public List<Integer> getWinsCount() {
        return winsCount;
    }

}
