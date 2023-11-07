package lotto.domain;

import lotto.function.PrintMessageFunction;

import java.util.List;
import java.util.function.Predicate;


public class LottoResult {

    private final PrintMessageFunction printMessageFunction = new PrintMessageFunction();
    private final WinningLottoCount winningLottoCount = new WinningLottoCount();
    private final GetWinningNumbers winningNumbersInfo;

    public LottoResult(GetWinningNumbers getWinningNumbersInfo) {
        this.winningNumbersInfo = getWinningNumbersInfo;
    }

    public int getWinningCount(List<Integer> userNums) {
        return Long.valueOf(winningNumbersInfo.getWinningNums()
                .stream()
                .filter(lottoNums -> userNums.stream()
                        .anyMatch(Predicate.isEqual(lottoNums)))
                .count()).intValue();
    }

    private int getBonusCount(List<Integer> userNums, int winningCount) {
        if (winningCount == 5 && userNums.contains(winningNumbersInfo.getBonusNum())) {
            return winningCount + 2;
        }
        return winningCount;
    }

    private String getRateOfReturn(int buyMoney, long winningCount) {
        if (winningCount == 0) {
            return "0";
        }

        double rateOfReturn = (double) winningCount / (double) buyMoney * 100;
        return String.format("%.1f", rateOfReturn);
    }

    private void setWinningCount(int winningCount) {
        if(winningCount == 3) {
            winningLottoCount.addWinningThree();
        }
        if(winningCount == 4) {
            winningLottoCount.addWinningFour();
        }
        if(winningCount == 5) {
            winningLottoCount.addWinningFive();
        }
        if(winningCount == 6) {
            winningLottoCount.addWinningSix();
        }
        if(winningCount == 7) {
            winningLottoCount.addWinningBonus();
        }
    }

    private long getTotalWinningMoney() {
        return (long) winningLottoCount.getWinningThree() * 5000
                + (long) winningLottoCount.getWinningFour() * 50000
                + (long) winningLottoCount.getWinningFive() * 1500000
                + (long) winningLottoCount.getWinningSix() * 2000000000
                + (long) winningLottoCount.getWinningBonus() * 30000000;
    }

    private void printWinningResult(int buyMoney) {
        printMessageFunction.printThreeWinningResult(winningLottoCount.getWinningThree());
        printMessageFunction.printFourWinningResult(winningLottoCount.getWinningFour());
        printMessageFunction.printFiveWinningResult(winningLottoCount.getWinningFive());
        printMessageFunction.printBonusWinningResult(winningLottoCount.getWinningBonus());
        printMessageFunction.printSixWinningResult(winningLottoCount.getWinningSix());

        long totalWinningMoney = getTotalWinningMoney();
        double rateOfReturn = Double.parseDouble(getRateOfReturn(buyMoney,totalWinningMoney));

        printMessageFunction.printRateOfReturn(rateOfReturn);
    }

    public void getLottoResult(List<Lotto> userLottos, int buyMoney) {
        printMessageFunction.printWinningStat();

        for(Lotto userLotto : userLottos) {
            List<Integer> userLottoNums = userLotto.getLottoNumbers();
            int matchCount = getWinningCount(userLottoNums);
            setWinningCount(getBonusCount(userLottoNums, matchCount));
        }

        printWinningResult(buyMoney);
    }

}
