package lotto.domain;

import java.text.DecimalFormat;
import java.util.List;
import lotto.util.Constant;
import lotto.view.OutputView;
import lotto.view.ResultView;

public class Judge {
    private Lotto answerLotto;
    private int bonusNumber;
    private User user;
    private long money;

    public Judge(Lotto answerLotto, int bonusNumber, User user, long money) {
        this.answerLotto = answerLotto;
        this.bonusNumber = bonusNumber;
        this.user = user;
        this.money = money;
        OutputView.winningStatisticsInformationMessage();
    }

    public void finalResult() {
        ResultView.printResultView();
        ResultView.printRateView(calculateRate());
    }

    private String doubleToString(double money) {
        DecimalFormat formatter = new DecimalFormat(Constant.FORMAT_PATTERN);
        return formatter.format(money);
    }

    private String calculateRate() {
        if (calculatePrizeMoney() == 0) {
            return Constant.ZERO_PATTERN;
        }

        double rate = ((double) calculatePrizeMoney() / money);
        return doubleToString(rate);
    }

    private long calculatePrizeMoney() {
        long totalPrizeMoney = 0;
        for (Rank rank : Rank.values()) {
            totalPrizeMoney += (rank.getTotalPrize());
        }
        return totalPrizeMoney;
    }

    private void updateResult(int matchCount, boolean bonusNumber) {
        Rank.getRank(matchCount, bonusNumber).increaseCount();
    }

    public void checkWinning() {
        for (Lotto lotto : user.getLottos()) {
            boolean isBonus = isContainBonusNumber(lotto.getNumbers());
            int matchCount = checkWinningOneGame(lotto.getNumbers());

            updateResult(matchCount, isBonus);
        }
    }

    public int checkWinningOneGame(List<Integer> lottoNumbers) {
        lottoNumbers.retainAll(answerLotto.getNumbers());
        return lottoNumbers.size();
    }

    public boolean isContainBonusNumber(List<Integer> lottoNumbers) {
        return lottoNumbers.contains(bonusNumber);
    }
}
