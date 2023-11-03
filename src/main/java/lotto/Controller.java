package lotto;

import lotto.service.GameService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Controller {

    private final GameService gameService = new GameService();

    public void run() {
        purchaseAmount();
        printIssuedLotto();
        inputWinningNumbers();
        inputBonusNumber();
        printWinningStatistics();
    }

    private void purchaseAmount(){
        OutputView.inputPurchaseAmountMessage();
        inputPurchaseAmount();
    }

    private void inputPurchaseAmount(){
        try{
            String input = InputView.input();
            gameService.inputPurchaseAmount(input);
        } catch(IllegalArgumentException e){
            OutputView.errorMessage(e.getMessage());
            inputPurchaseAmount();
        }
    }

    private void printIssuedLotto(){
    }

    private void inputWinningNumbers(){
    }

    private void inputBonusNumber(){
    }

    private void printWinningStatistics(){
    }
}
