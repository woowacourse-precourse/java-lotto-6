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

    public WinningStatistics calculateWinningStatistics(Lottos lottos, WinningNumber winningNumber) {
        WinningStatistics winningStatistics = new WinningStatistics();

        for (int i = 0; i < lottos.size(); i++) {
            int correctWinningNumber = calculateWinningNumber(lottos.get(i), winningNumber);
            int correctBonusNumber = calculateBonusNumber(lottos.get(i), winningNumber);
            calculatePlace(winningStatistics, correctWinningNumber, correctBonusNumber);
        }

        calculateWinningRate(winningStatistics);

        return winningStatistics;
    }

    public void calculatePlace(WinningStatistics winningStatistics, int correctWinningNumber, int correctBonusNumber) {
        if (correctWinningNumber == LottoPlaceCount.FIRST_PLACE.lottoPlaceCount) {
            winningStatistics.addFirstPlace();
        } else if (correctWinningNumber == LottoPlaceCount.SECOND_PLACE.lottoPlaceCount) {
            winningStatistics.addSecondPlace();
        } else if (correctWinningNumber == LottoPlaceCount.THIRD_PLACE.lottoPlaceCount || correctBonusNumber == 1) {
            winningStatistics.addThirdPlace();
        } else if (correctWinningNumber == LottoPlaceCount.FOURTH_PLACE.lottoPlaceCount) {
            winningStatistics.addFourthPlace();
        } else if (correctWinningNumber == LottoPlaceCount.FIFTH_PLACE.lottoPlaceCount) {
            winningStatistics.addFifthPlace();
        }
    }

    public void calculateWinningRate(WinningStatistics winningStatistics) {

    }
}
