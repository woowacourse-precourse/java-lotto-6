package lotto;

import java.util.ArrayList;

public class LottoRank {

    private final Lotto lotto;
    private Rank rank = Rank.FAIL;

    public LottoRank(Lotto lotto) {
        this.lotto = lotto;
    }

    public void setRank(ArrayList<Integer> winningNumbers, int bonusNumber) {
        int count = 0;
        boolean checkBonus = false;
        StringBuilder sb = new StringBuilder();
        for (Integer number : this.lotto.getNumbers()) {
            if (winningNumbers.contains(number)) {
                ++count;
            }
            if (number == bonusNumber) {
                checkBonus = true;
            }
        }
        sb.append(count);
        if (checkBonus) {
            sb.append("B");
        }
        this.rank = rank.calcurateRank(sb.toString());
    }

    public Rank getRank() {
        return this.rank;
    }
}
