package lotto;

import lotto.constant.NumberConstant;
import lotto.service.GameService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Controller {

    private final GameService gameService = new GameService();

    public void run() {
        int purchaseAmount = inputPurchaseAmount();
        printIssuedLotto(purchaseAmount/ NumberConstant.LOTTO_ONE_PRICE);
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
    }

    private void inputWinningNumbers(){
    }

    private void inputBonusNumber(){
    }

    private void printWinningStatistics(){
    }
}
