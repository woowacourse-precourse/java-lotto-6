package lotto;

import java.util.HashMap;
import java.util.List;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;
    private final LottoService lottoService;

    public LottoController(InputView inputView, OutputView outputView, LottoService lottoService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoService = lottoService;
    }

    public void playGame() {
        Money money = requestMoney();
        int count = lottoService.calculateCount(money.getMoney());
        HashMap<Integer, Lotto> lotties = lottoService.makeLotto(count);
        outputView.printAmountOfLotto(count);
        outputView.printLotto(lotties);
        WinningNumber winningNumber = requestWinningNumber();
        BonusNumber bonusNumber = requestBonusNumber(winningNumber);
        HashMap<Integer, List<Integer>> result = lottoService.calculateCompareResult(count, lotties, winningNumber.getWinningNumbers(), bonusNumber.getBonusNumber());
        HashMap<Integer, Integer> finalResult = lottoService.calculateFinalResult(result, count);
        int totalReward = lottoService.calculateTotalReward(finalResult);
    }

    public Money requestMoney(){
        try{
            outputView.printMoneyInputMessage();
            Money money = lottoService.changeStringToInt(inputView.getInput());
            return money;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return requestMoney();
    }

    public WinningNumber requestWinningNumber(){
        try {
            outputView.printWinningNumbersInputMessage();
            WinningNumber winningNumber = lottoService.getWinningNumbers(inputView.getInput());
            return winningNumber;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return requestWinningNumber();
    }

    public BonusNumber requestBonusNumber(WinningNumber winningNumber) {
        try {
            outputView.printBonusNumberInputMessage();
            BonusNumber bonusNumber = lottoService.getBonusNumber(inputView.getInput());
            lottoService.isDuplicateWithWinningNumbers(bonusNumber, winningNumber);
            return bonusNumber;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return requestBonusNumber(winningNumber);
    }
}
