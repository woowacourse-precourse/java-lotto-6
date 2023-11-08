package lotto;


import lotto.v3.controller.*;
import lotto.v3.model.LottoMachine;
import lotto.v3.model.LottoWinningNumber;
import lotto.v3.view.*;

import java.util.List;
import java.util.Set;

public class Application {
//    public static void main(String[] args) {
//        LottoPurchaseView purchaseView = new LottoPurchaseView();
//        LottoPurchaseController purchaseController = new LottoPurchaseController(purchaseView);
//
//        LottoGenerateView generateView = new LottoGenerateView();
//        LottoMachine machine = new LottoMachine();
//        LottoGenerationController generationController = new LottoGenerationController(generateView, machine);
//
//        int numberOfTickets = purchaseController.startPurchaseProcess();
//        generationController.generateLottoTickets(numberOfTickets);
//
//        LottoWinningNumbersView winningNumbersView = new LottoWinningNumbersView();
//        LottoWinningNumberController winningNumberController = new LottoWinningNumberController(winningNumbersView);
//        LottoWinningNumber winningNumber = winningNumberController.createWinningNumber();
//
//        LottoBonusNumberView bonusNumberView = new LottoBonusNumberView();
//        LottoBonusNumberController bonusNumberController = new LottoBonusNumberController(bonusNumberView, winningNumber);
//        bonusNumberController.createBonusNumber();
//
//        // TODO 로또 결과 출력
//        LottoResultView resultView = new LottoResultView();
//        LottoResultController resultController = new LottoResultController(resultView);
//
//        List<Set<Integer>> purchasedTickets = generationController.generateLottoTickets();
//        Set<Integer> winningNumbers = winningNumber.getWinningNumbers();
//        int bonusNumber = winningNumber.getBonusNumber();
//
//        resultController.showResults(purchasedTickets, winningNumbers, bonusNumber);
//
//
//    }
}
