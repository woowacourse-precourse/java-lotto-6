package lotto;

import java.util.List;

public class LottoRank {

    private final Lotto lotto;
    private Rank rank = Rank.FAIL;

    public LottoRank(Lotto lotto) {
        this.lotto = lotto;
    }

    /**
     * 몇번째 Rank 인지를 검사
     */
    public void setRank(List<Integer> winningNumbers, int bonusNumber) {
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
        if (checkBonus && count == 5) {
            sb.append("B");
        }
        this.rank = rank.calcurateRank(sb.toString());
    }

    public Rank getRank() {
        return this.rank;
    }
}
