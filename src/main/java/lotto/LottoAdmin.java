package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoAdmin {
    private List<Integer> winningNumbers;
    private Integer bonusNumber;

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

    public void printPrize(LottoPlayer player) {
        List<LottoRank> ranks = checkLottos(player);
        System.out.print("당첨 통계\n---\n");
        System.out.printf(LottoRank.FIFTH.getMessage() + " - %d개\n", Collections.frequency(ranks, LottoRank.FIFTH));
        System.out.printf(LottoRank.FOURTH.getMessage() + " - %d개\n", Collections.frequency(ranks, LottoRank.FOURTH));
        System.out.printf(LottoRank.THIRD.getMessage() + " - %d개\n", Collections.frequency(ranks, LottoRank.THIRD));
        System.out.printf(LottoRank.SECOND.getMessage() + " - %d개\n", Collections.frequency(ranks, LottoRank.SECOND));
        System.out.printf(LottoRank.FIRST.getMessage() + " - %d개\n", Collections.frequency(ranks, LottoRank.FIRST));
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

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public void setWinningNumbers(List<Integer> winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    public void setBonusNumber(Integer bonusNumber) {
        this.bonusNumber = bonusNumber;
    }
}
