package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoAdmin {
    private final List<Integer> winningNumbers;
    private final Integer bonusNumber;

    public LottoAdmin(List<Integer> winningNumbers, Integer bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public List<LottoRank> checkLottos(LottoPlayer player) {
        List<LottoRank> ranks = new ArrayList<>();
        for(Lotto lotto : player.getLottos()) {
            ranks.add(getRank(lotto));
        }
        return ranks;
    }

    public void payPrizeMoney(LottoPlayer player) {
        for (LottoRank rank: checkLottos(player)) {
            player.addMoney(rank.getValue());
        }
    }

    private LottoRank getRank(Lotto lotto) {
        int correct = checkNumber(lotto);
        boolean isBonus = checkBonus(lotto);

        if (correct == 6) return LottoRank.FIRST;
        if (correct == 5 && isBonus) return LottoRank.SECOND;
        if (correct == 5) return LottoRank.THIRD;
        if (correct == 4) return LottoRank.FOURTH;
        if (correct == 3) return LottoRank.FIFTH;
        return LottoRank.NONE;
    }

    private int checkNumber(Lotto lotto) {
        int correct = 0;
        for (Integer number : lotto.getNumbers()) {
            if (winningNumbers.contains(number)) {
                correct += 1;
            }
        }
        return correct;
    }

    private boolean checkBonus(Lotto lotto) {
        for (Integer number : lotto.getNumbers()) {
            if (bonusNumber.equals(number)) {
                return true;
            }
        }
        return false;
    }
}
