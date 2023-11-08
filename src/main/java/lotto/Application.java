package lotto;

import lotto.v3.controller.*;
import lotto.v3.model.Lotto;
import lotto.v3.model.LottoBonusNumber;
import lotto.v3.model.LottoMachine;
import lotto.v3.model.LottoWinningNumber;
import lotto.v3.service.LottoYieldCalculatorService;
import lotto.v3.view.*;

import java.util.List;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {

        /** 로또 구입금액 */
        LottoPurchaseView purchaseView = new LottoPurchaseView();
        LottoPurchaseController numberOfLottoTickets = new LottoPurchaseController(purchaseView);

        /** 로또 생산 */
        LottoGenerateView generateView = new LottoGenerateView();
        LottoMachine machine = new LottoMachine();
        LottoGenerationController  lottoGenerationController = new LottoGenerationController(generateView, machine);

        int numberOfTickets = numberOfLottoTickets.startPurchaseProcess();
        List<Lotto> lottos = lottoGenerationController.generateLottoTickets(numberOfTickets);
        List<List<Integer>> lottoTickets = lottos.stream()
                .map(Lotto::getNumbers)
                .collect(Collectors.toList());

        /** 로또 당첨번호 */
        LottoWinningNumbersView LottoWinningNumbersView = new LottoWinningNumbersView();
        LottoWinningNumberController winningNumberController = new LottoWinningNumberController(LottoWinningNumbersView);
        LottoWinningNumber winningNumber = winningNumberController.createWinningNumber();

        /** 로또 보너스번호 */
        LottoBonusNumberView bonusNumberView = new LottoBonusNumberView();
        LottoBonusNumberController bonusNumberController = new LottoBonusNumberController(bonusNumberView, winningNumber);
        LottoBonusNumber bonusNumber = bonusNumberController.createBonusNumber();

        /** 로또 당첨 결과 */
        LottoResultController resultController = new LottoResultController(new LottoResultView());
        resultController.showResults(lottoTickets, winningNumber.getNumbers(), bonusNumber.getBonusNumber());

        /** 로또 수익률 계산 */
        LottoYieldView yieldView = new LottoYieldView();
        LottoYieldCalculatorService yieldCalculatorService = new LottoYieldCalculatorService();
        LottoYieldController yieldController = new LottoYieldController(yieldView, yieldCalculatorService);
        yieldController.processLottoYield(lottoTickets, winningNumber.getNumbers(), bonusNumber.getBonusNumber());

    }
}
