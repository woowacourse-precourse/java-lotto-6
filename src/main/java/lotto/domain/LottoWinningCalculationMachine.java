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
        int lottoCount = lottos.size();

        for (int i = 0; i < lottoCount; i++) {
            int correctWinningNumber = calculateWinningNumber(lottos.get(i), winningNumber);
            int correctBonusNumber = calculateBonusNumber(lottos.get(i), winningNumber);
            calculatePlace(winningStatistics, correctWinningNumber, correctBonusNumber);
        }

        calculateWinningRate(winningStatistics, lottoCount);

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

    public void calculateWinningRate(WinningStatistics winningStatistics, int lottoCount) {
        long firstPlaceMoney = winningStatistics.getFirstPlace() * LottoPlaceMoney.FIRST_PLACE_MONEY.lottoPlaceMoney;
        long secondPlaceMoney = winningStatistics.getSecondPlace() * LottoPlaceMoney.SECOND_PLACE_MONEY.lottoPlaceMoney;
        long thirdPlaceMoney = winningStatistics.getThirdPlace() * LottoPlaceMoney.THIRD_PLACE_MONEY.lottoPlaceMoney;
        long fourthPlaceMoney = winningStatistics.getFourthPlace() * LottoPlaceMoney.FOURTH_PLACE_MONEY.lottoPlaceMoney;
        long fifthPlaceMoney = winningStatistics.getFifthPlace() * LottoPlaceMoney.FIFTH_PLACE_MONEY.lottoPlaceMoney;

        long winningMoney = firstPlaceMoney + secondPlaceMoney + thirdPlaceMoney + fourthPlaceMoney + fifthPlaceMoney;

        int money = lottoCount * 1000;
        double winningRate = money / winningMoney * 100;
        double twoWinningRate = Math.round(winningRate * 100) / 100;
        winningStatistics.setWinningRate(twoWinningRate);
    }
}