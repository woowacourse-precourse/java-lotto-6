package lotto;

import lotto.constant.NumberConstant;
import lotto.model.Lotto;
import lotto.service.GameService;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class Controller {

    private final GameService gameService = new GameService();

    public void run() {
        int purchaseAmount = inputPurchaseAmount();
        printIssuedLotto(purchaseAmount/NumberConstant.LOTTO_ONE_PRICE);
        inputWinningNumbers();
        inputBonusNumber();
        printWinningStatistics();
    }

    private int inputPurchaseAmount(){
        OutputView.inputPurchaseAmountMessage();
        return tryInputPurchaseAmount();
    }

    private int tryInputPurchaseAmount(){
        try{
            String input = InputView.input();
            return gameService.inputPurchaseAmount(input);
        } catch(IllegalArgumentException e){
            OutputView.errorMessage(e.getMessage());
            return tryInputPurchaseAmount();
        }
    }

    private void printIssuedLotto(int issuedLottoCount){
        OutputView.printIssuedLottoMessage(issuedLottoCount);
        List<Lotto> issuedLotto = gameService.createIssuedLotto(issuedLottoCount);
        for(Lotto lotto : issuedLotto){
            OutputView.printIssuedLotto(lotto.getSortedNumbers());
        }
    }

    private void inputWinningNumbers(){
        OutputView.inputWinningNumbersMessage();
        tryInputWinningNumbers();
    }

    private void tryInputWinningNumbers(){
        try{
            String input = InputView.input();
            gameService.inputWinningNumbers(input);
        } catch(IllegalArgumentException e){
            OutputView.errorMessage(e.getMessage());
            tryInputWinningNumbers();
        }
    }

    private void inputBonusNumber(){
        OutputView.inputBonusNumberMessage();
        tryInputBonusNumber();
    }

    private void tryInputBonusNumber(){
        try{
            String input = InputView.input();
            gameService.inputBonusNumber(input);
        } catch(IllegalArgumentException e){
            OutputView.errorMessage(e.getMessage());
            tryInputBonusNumber();
        }
    }

    private void printWinningStatistics(){
        OutputView.winningStatisticMessage();
        List<Integer> matchingCounts = gameService.calculateMatchingCount();
        OutputView.printMatchingCounts(matchingCounts);
        String returnRate = gameService.calculateTotalReturnRate();
        OutputView.printTotalReturnRate(returnRate);
    }
}
