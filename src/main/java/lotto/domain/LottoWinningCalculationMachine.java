package lotto.domain;

public class LottoWinningCalculationMachine {

    public int calculateWinningNumber(Lotto oneLotto, WinningNumber winningNumber) {
        int correctNumber = 0;
        Lotto lottoWinningNumber = winningNumber.getWinningNumber();
        for (int i = 0; i < oneLotto.size(); i++) {
            if (lottoWinningNumber.contains(oneLotto.get(i))) {
                correctNumber++;
            }
        }
        return correctNumber;
    }

    public int calculateBonusNumber(Lotto oneLotto, WinningNumber winningNumber) {
        int correctNumber = 0;
        int lottoBonusNumber = winningNumber.getBonusNumber();
        if (oneLotto.contains(lottoBonusNumber)) {
            correctNumber++;
        }
        return correctNumber;
    }

    public void calculateWinningRate(WinningStatistics winningStatistics) {

    }
}
