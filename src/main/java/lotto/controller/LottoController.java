package lotto.controller;

import lotto.domain.lotto.LottoRank;
import lotto.domain.lotto.Lottos;
import lotto.domain.winningNumber.BonusNumber;
import lotto.domain.winningNumber.FinalWinningNumber;
import lotto.domain.winningNumber.WinningNumber;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.HashMap;
import java.util.List;

public class LottoController {
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();

    public void startProgram() {
        Lottos lottos = purchaseLottos();
        printLottoNumbers(lottos);
        FinalWinningNumber finalWinningNumber = setFinalWinningNumber();
        printLottoResult(lottos, finalWinningNumber);
    }

    private Lottos purchaseLottos() {
        try {
            return new Lottos(inputView.inputPurchaseAmount());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return purchaseLottos();
        }
    }

    private void printLottoNumbers(Lottos lottos) {
        outputView.outputPurchaseNumber(lottos.getNumberOfLottos());
        for (List<Integer> lotto : lottos.getAllLottoNumbers()) {
            outputView.outputLottoNumber(LottoService.sort(lotto));
        }
    }

    private FinalWinningNumber setFinalWinningNumber() {
        return new FinalWinningNumber(initWinningNumber(), initBonusNumber());
    }

    private WinningNumber initWinningNumber() {
        try {
            return new WinningNumber(inputView.inputWinningNumber());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return initWinningNumber();
        }
    }

    private BonusNumber initBonusNumber() {
        try {
            return new BonusNumber(inputView.inputBonusNumber());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return initBonusNumber();
        }
    }

    private void printLottoResult(Lottos lottos, FinalWinningNumber finalWinningNumber) {
        printWinningStatistics(lottos, finalWinningNumber);
        printTotalRateOfReturn(lottos);
    }

    private void printWinningStatistics(Lottos lottos, FinalWinningNumber finalWinningNumber) {
        outputView.outputWinningStatistics();
        HashMap<LottoRank, Integer> rankCount = lottos.getLottosResult(finalWinningNumber);
        for(LottoRank rank : rankCount.keySet()) {
            outputView.outputRankResult(rank.getRankContent(), rankCount.get(rank));
        }
    }

    private void printTotalRateOfReturn(Lottos lottos) {
        outputView.outputTotalRateOfReturn(lottos.calculateTotalRateOfReturn());
    }
}
