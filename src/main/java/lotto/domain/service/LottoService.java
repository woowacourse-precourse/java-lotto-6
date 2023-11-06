package lotto.domain.service;

import lotto.domain.*;
import lotto.global.utils.console.ConsoleUtil;
import lotto.global.utils.constant.OutputType;
import lotto.global.utils.generator.RandomNumberGenerator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoService {

    public AllOfRandomLottoList getLottoList(int lottoCount) {
        AllOfRandomLottoList allOfRandomLottoList = new AllOfRandomLottoList();
        ConsoleUtil.commonOutputLine(lottoCount + OutputType.OUTPUT_NUMBER_OF_PURCHASES.getComment());

        for (int index = 0; index < lottoCount; index++) {
            RandomLottoList randomLottoList = new RandomLottoList(new RandomNumberGenerator());
            allOfRandomLottoList.increaseLottoCount();
            allOfRandomLottoList.addRandomLottoList(randomLottoList);
            ConsoleUtil.outputRandomList(randomLottoList.getRandomLottoList());
        }
        return allOfRandomLottoList;
    }

    public void outputCorrectLottoList(AllOfRandomLottoList allOfRandomLottoList, Lotto inputLotto, BonusNumber bonusNumber) {
        CorrectLottoList correctLottoList = getCorrectLottoList(allOfRandomLottoList, inputLotto, bonusNumber);
        List<Integer> correctCountList = getCorrectCountList(correctLottoList);
        ConsoleUtil.commonOutputLine(OutputType.OUTPUT_WINNING_STATISTICS_5.getComment()
                + correctCountList.get(4) + OutputType.OUTPUT_COUNT.getComment());
        ConsoleUtil.commonOutputLine(OutputType.OUTPUT_WINNING_STATISTICS_4.getComment()
                + correctCountList.get(3) + OutputType.OUTPUT_COUNT.getComment());
        ConsoleUtil.commonOutputLine(OutputType.OUTPUT_WINNING_STATISTICS_3.getComment()
                + correctCountList.get(2) + OutputType.OUTPUT_COUNT.getComment());
        ConsoleUtil.commonOutputLine(OutputType.OUTPUT_WINNING_STATISTICS_2.getComment()
                + correctCountList.get(1) + OutputType.OUTPUT_COUNT.getComment());
        ConsoleUtil.commonOutputLine(OutputType.OUTPUT_WINNING_STATISTICS_1.getComment()
                + correctCountList.get(0) + OutputType.OUTPUT_COUNT.getComment());
        ConsoleUtil.commonOutputLine(OutputType.OUTPUT_RESULT_1.getComment() + getRateOfReturn(correctCountList,
                allOfRandomLottoList.getLottoCount()) + OutputType.OUTPUT_RESULT_2.getComment());
    }

    private double getRateOfReturn(List<Integer> correctCountList, int lottoCount) {
        int winningPrice = 0;
        winningPrice += (correctCountList.get(0) * 2000000000 + correctCountList.get(1) * 30000000
                + correctCountList.get(2) * 1500000 + correctCountList.get(3) * 50000
                + correctCountList.get(4) * 5000);
        double rateBeforeRound = (winningPrice / (lottoCount * 1000.0)) * 100.0;
        return Math.round(rateBeforeRound * 10.0) / 10.0;
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
        if (correctCount == 6) {
            correctCountList.set(0, correctCountList.get(0) + 1);
        }
        if (correctCount == 5 && correctBonusCount == 1) {
            correctCountList.set(1, correctCountList.get(1) + 1);
        }
        if (correctCount == 5 && correctBonusCount == 0) {
            correctCountList.set(2, correctCountList.get(2) + 1);
        }
        if (correctCount == 4) {
            correctCountList.set(3, correctCountList.get(3) + 1);
        }
        if (correctCount == 3) {
            correctCountList.set(4, correctCountList.get(4) + 1);
        }
    }

    private CorrectLottoList getCorrectLottoList(AllOfRandomLottoList allOfRandomLottoList, Lotto inputLotto, BonusNumber bonusNumber) {
        CorrectLottoList correctLottoList = new CorrectLottoList();
        int lottoCount = allOfRandomLottoList.getLottoCount();
        ConsoleUtil.commonOutputLine(OutputType.OUTPUT_WINNING_STATISTICS.getComment());

        for (int index = 0; index < lottoCount; index++) {
            RandomLottoList randomLottoList = allOfRandomLottoList.getAllOfRandomLottoList().get(index);
            LottoManage lottoManage = new LottoManage();
            lottoManage.getWinningCount(inputLotto, bonusNumber, randomLottoList);
            correctLottoList.addCorrectLottoList(lottoManage);
        }
        return correctLottoList;
    }
}
