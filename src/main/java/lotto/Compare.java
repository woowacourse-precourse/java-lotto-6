package lotto;

import java.util.List;
import lotto.constant.Rank;
import view.OutputView;

public class Compare {

    private final Winning winning;
    private final Purchase purchase;
    private final Same same = new Same();

    public Compare(Winning winning, Purchase purchase){
        this.winning = winning;
        this.purchase = purchase;
    }

    public void calculateStatistics() {
        List<Lotto> myLotto = purchase.getMyLotto();

        for (Lotto lotto : myLotto) {
            int sameCount = calculateSameCount(lotto);
            boolean matchBonus = lotto.getNumbers().contains(winning.getBonusNumber());
            addSameCount(sameCount, matchBonus);
        }
    }

    private void addSameCount(int sameCount, boolean matchBonus) {
        if (sameCount == 3) {
            same.addThreeSame();
        }
        if (sameCount == 4) {
            same.addFourSame();
        }
        if (sameCount == 5) {
            if (matchBonus) {
                same.addFiveWithBonus();
            }
            same.addFiveSame();
        }
        if (sameCount == 6) {
            same.addSixWithSame();
        }
    }

    public void printResult() {
         OutputView outputView = new OutputView();
         outputView.printResult(same.getSixSame(), same.getFiveSame(), same.getFiveSameWithBonus(), same.getFourSame(), same.getThreeSame());
    }


    private int calculateSameCount(Lotto myLotto) {
        List<Integer> winningNumbers = winning.getNumbers();
        int count = 0;

        for (Integer lottoNumber : myLotto.getNumbers()) {
            if (winningNumbers.contains(lottoNumber)) {
                count++;
            }
        }
        return count;
    }

    public String computeEarningRate(int purchasePrice) {
        int winningAmount =
            Rank.FIRST.getMoney()*same.getSixSame() +
            Rank.SECOND.getMoney()*same.getFiveSameWithBonus() +
            Rank.THIRD.getMoney()*same.getFiveSame() +
            Rank.FOURTH.getMoney() * same.getFourSame() +
            Rank.FIFTH.getMoney() * same.getThreeSame();

        if (winningAmount == 0) {
            return "0";
        }

        double earningRate = (double) winningAmount / (double) purchasePrice * 100;
        return String.format("%.1f", earningRate);
    }
}




