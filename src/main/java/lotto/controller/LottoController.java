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
        return new Lottos(inputView.inputPurchaseAmount());
    }

    private void printAllLottoNumbers(Lottos lottos) {
        outputView.outputPurchaseNumber(lottos.getNumberOfLottos());
        for (List<Integer> lotto : lottos.getAllLottoNumbers()) {
            outputView.outputLottoNumber(lotto);
        }
    }

    private FinalWinningNumber setWinningNumber() {
        WinningNumber winningNumber = new WinningNumber(inputView.inputWinningNumber());
        BonusNumber bonusNumber = new BonusNumber(inputView.inputBonusNumber());
        return new FinalWinningNumber(winningNumber, bonusNumber);
    }

    private void printResult(Lottos lottos, FinalWinningNumber finalWinningNumber) {
        outputView.outputWinningStatistics();
        HashMap<LottoRank, Integer> rankCount = lottos.getLottosResult(finalWinningNumber);
        for(LottoRank rank : rankCount.keySet()) {
            outputView.outputRankResult(rank.getRankContent(), rankCount.get(rank));
        }
    }
}
