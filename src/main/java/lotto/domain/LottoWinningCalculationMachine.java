package lotto.domain;

import lotto.model.Lotto;
import lotto.model.Lottos;
import lotto.model.WinningLotto;
import lotto.model.WinningStatistics;

public class LottoWinningCalculationMachine {

    public int calculateWinningNumber(Lotto oneLotto, WinningLotto winningLotto) {
        int correctNumber = 0;
        Lotto lottoWinningNumber = winningLotto.getWinningNumber();
        for (int i = 0; i < oneLotto.size(); i++) {
            if (lottoWinningNumber.contains(oneLotto.get(i))) {
                correctNumber++;
            }
        }
        return correctNumber;
    }

    public int calculateBonusNumber(Lotto oneLotto, WinningLotto winningLotto) {
        int correctNumber = 0;
        int lottoBonusNumber = winningLotto.getBonusNumber();
        if (oneLotto.contains(lottoBonusNumber)) {
            correctNumber++;
        }
        return correctNumber;
    }

    public WinningStatistics calculateWinningStatistics(Lottos lottos, WinningLotto winningLotto) {
        WinningStatistics winningStatistics = new WinningStatistics();
        int lottoCount = lottos.size();

        for (int i = 0; i < lottoCount; i++) {
            int correctWinningNumber = calculateWinningNumber(lottos.get(i), winningLotto);
            int correctBonusNumber = calculateBonusNumber(lottos.get(i), winningLotto);
            calculatePlace(winningStatistics, correctWinningNumber, correctBonusNumber);
        }

        calculateWinningRate(winningStatistics, lottoCount);

        return winningStatistics;
    }

    public void calculatePlace(WinningStatistics winningStatistics, int correctWinningNumber, int correctBonusNumber) {
        if (correctWinningNumber == LottoPlaceCount.FIRST_PLACE.lottoPlaceCount) {
            winningStatistics.addFirstPlace();
        } else if (correctWinningNumber == LottoPlaceCount.SECOND_PLACE.lottoPlaceCount && correctBonusNumber == 1) {
            winningStatistics.addSecondPlace();
        } else if (correctWinningNumber == LottoPlaceCount.THIRD_PLACE.lottoPlaceCount) {
            winningStatistics.addThirdPlace();
        } else if (correctWinningNumber == LottoPlaceCount.FOURTH_PLACE.lottoPlaceCount) {
            winningStatistics.addFourthPlace();
        } else if (correctWinningNumber == LottoPlaceCount.FIFTH_PLACE.lottoPlaceCount) {
            winningStatistics.addFifthPlace();
        }
    }

    public long calculateTotalMoney(WinningStatistics winningStatistics) {
        long firstPlaceMoney = winningStatistics.getFirstPlace() * LottoPlaceMoney.FIRST_PLACE_MONEY.lottoPlaceMoney;
        long secondPlaceMoney = winningStatistics.getSecondPlace() * LottoPlaceMoney.SECOND_PLACE_MONEY.lottoPlaceMoney;
        long thirdPlaceMoney = winningStatistics.getThirdPlace() * LottoPlaceMoney.THIRD_PLACE_MONEY.lottoPlaceMoney;
        long fourthPlaceMoney = winningStatistics.getFourthPlace() * LottoPlaceMoney.FOURTH_PLACE_MONEY.lottoPlaceMoney;
        long fifthPlaceMoney = winningStatistics.getFifthPlace() * LottoPlaceMoney.FIFTH_PLACE_MONEY.lottoPlaceMoney;

        return firstPlaceMoney + secondPlaceMoney + thirdPlaceMoney + fourthPlaceMoney + fifthPlaceMoney;
    }

    public void calculateWinningRate(WinningStatistics winningStatistics, int lottoCount) {
        long winningMoney = calculateTotalMoney(winningStatistics);

        int money = lottoCount * 1000;
        double winningRate = (double) winningMoney / money * 100;
        double twoWinningRate = Math.round(winningRate * 100) / 100.0;
        winningStatistics.setWinningRate(twoWinningRate);
    }
}