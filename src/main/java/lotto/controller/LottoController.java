package lotto.controller;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.HashMap;
import java.util.List;

public class LottoController {
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();

    public void startProgram() {
        Lottos lottos = purchaseLottos();
        FinalWinningNumber finalWinningNumber = setWinningNumber();
        printResult(lottos, finalWinningNumber);
    }

    private Lottos purchaseLottos() {
        Lottos lottos = initLottos();
        printAllLottoNumbers(lottos);
        return lottos;
    }

    private Lottos initLottos() {
        try {
            return new Lottos(inputView.inputPurchaseAmount());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return initLottos();
        }
    }

    private void printAllLottoNumbers(Lottos lottos) {
        outputView.outputPurchaseNumber(lottos.getNumberOfLottos());
        for (List<Integer> lotto : lottos.getAllLottoNumbers()) {
            outputView.outputLottoNumber(lotto);
        }
    }

    private FinalWinningNumber setWinningNumber() {
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

    private void printResult(Lottos lottos, FinalWinningNumber finalWinningNumber) {
        outputView.outputWinningStatistics();
        HashMap<LottoRank, Integer> rankCount = lottos.getLottosResult(finalWinningNumber);
        for(LottoRank rank : rankCount.keySet()) {
            outputView.outputRankResult(rank.getRankContent(), rankCount.get(rank));
        }
        outputView.outputTotalRateOfReturn(lottos.calculateTotalRateOfReturn());
    }
}
