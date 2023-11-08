package lotto.domain.service;

import lotto.domain.*;
import lotto.global.utils.constant.OutputType;
import lotto.global.utils.constant.WinningPrizeType;
import lotto.global.utils.generator.RandomNumberGenerator;
import lotto.global.utils.view.OutputView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoService {

    private static final double LOTTO_PRICE = 1000.0;
    private static final int PERCENTAGE_VALUE = 100;
    private static final double MULTIPLIER = 10.0;

    public AllOfRandomLottoList getLottoList(int lottoCount) {
        AllOfRandomLottoList allOfRandomLottoList = new AllOfRandomLottoList();
        OutputView.commonOutputLine(lottoCount + OutputType.OUTPUT_NUMBER_OF_PURCHASES.getComment());

        for (int index = 0; index < lottoCount; index++) {
            RandomLottoList randomLottoList = new RandomLottoList(new RandomNumberGenerator());
            allOfRandomLottoList.increaseLottoCount();
            allOfRandomLottoList.addRandomLottoList(randomLottoList);
            OutputView.outputRandomList(randomLottoList.getRandomLottoList());
        }
        return allOfRandomLottoList;
    }

    public void outputCorrectLottoList(AllOfRandomLottoList allOfRandomLottoList, Lotto inputLotto, BonusNumber bonusNumber) {
        CorrectLottoList correctLottoList = getCorrectLottoList(allOfRandomLottoList, inputLotto, bonusNumber);
        List<Integer> correctCountList = getCorrectCountList(correctLottoList);
        OutputView.outputStatistics(correctCountList);
        double rateOfReturn = getRateOfReturn(correctCountList, allOfRandomLottoList.getLottoCount());
        OutputView.outputRateOfReturn(rateOfReturn);
    }

    private double getRateOfReturn(List<Integer> correctCountList, int lottoCount) {
        int winningPrice = 0;
        winningPrice += (correctCountList.get(0) * WinningPrizeType.FIRST.getPrizePrice()
                + correctCountList.get(1) * WinningPrizeType.SECOND.getPrizePrice()
                + correctCountList.get(2) * WinningPrizeType.THIRD.getPrizePrice()
                + correctCountList.get(3) * WinningPrizeType.FORTH.getPrizePrice()
                + correctCountList.get(4) * WinningPrizeType.FIFTH.getPrizePrice());
        double rateBeforeRound = (winningPrice / (lottoCount * LOTTO_PRICE)) * PERCENTAGE_VALUE;
        return Math.round(rateBeforeRound * MULTIPLIER) / MULTIPLIER;
    }

    private List<Integer> getCorrectCountList(CorrectLottoList correctLottoList) {
        int lottoMangeCount = correctLottoList.getLottoMangeCount();
        List<Integer> correctCountList = new ArrayList<>(Collections.nCopies(5, 0));
        for (int index = 0; index < lottoMangeCount; index++) {
            LottoManage lottoManage = correctLottoList.getCorrectLottoList().get(index);
            updateCorrectCountList(correctCountList, lottoManage.getCorrectCount(), lottoManage.getCorrectBonusCount());
        }
        return correctCountList;
    }

    private void updateCorrectCountList(List<Integer> correctCountList, int correctCount, int correctBonusCount) {
        if (correctCount == WinningPrizeType.FIRST.getCorrectCount()) {
            correctCountList.set(0, correctCountList.get(0) + 1);
        }
        if (correctCount == WinningPrizeType.SECOND.getCorrectCount() && correctBonusCount == 1) {
            correctCountList.set(1, correctCountList.get(1) + 1);
        }
        if (correctCount == WinningPrizeType.THIRD.getCorrectCount() && correctBonusCount == 0) {
            correctCountList.set(2, correctCountList.get(2) + 1);
        }
        if (correctCount == WinningPrizeType.FORTH.getCorrectCount()) {
            correctCountList.set(3, correctCountList.get(3) + 1);
        }
        if (correctCount == WinningPrizeType.FIFTH.getCorrectCount()) {
            correctCountList.set(4, correctCountList.get(4) + 1);
        }
    }

    private CorrectLottoList getCorrectLottoList(AllOfRandomLottoList allOfRandomLottoList, Lotto inputLotto, BonusNumber bonusNumber) {
        CorrectLottoList correctLottoList = new CorrectLottoList();
        int lottoCount = allOfRandomLottoList.getLottoCount();
        OutputView.commonOutputLine(OutputType.OUTPUT_WINNING_STATISTICS.getComment());

        for (int index = 0; index < lottoCount; index++) {
            RandomLottoList randomLottoList = allOfRandomLottoList.getAllOfRandomLottoList().get(index);
            LottoManage lottoManage = new LottoManage();
            lottoManage.getWinningCount(inputLotto, bonusNumber, randomLottoList);
            correctLottoList.addCorrectLottoList(lottoManage);
        }
        return correctLottoList;
    }
}
