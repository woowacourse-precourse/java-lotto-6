package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.exception.InputException;
import lotto.gameUtil.GameLogic;

public class InputView {
    private OutputView outputView;
    private InputException inputException;
    private GameLogic gameLogic;
    public InputView(){
        outputView = new OutputView();
        inputException = new InputException();
        gameLogic = new GameLogic();
    }
    public int inputAmount(){
        outputView.amountMessage();
        String amount = Console.readLine();
        inputException.inputExceptionCheck(amount);
        return Integer.parseInt(amount);
    }
    public String winningNumber(){
        outputView.winningNumberMessage();
        String winningNumber = Console.readLine();
        String[] winningNumbers = gameLogic.splitNumber(winningNumber);
        inputException.checkExceptionWinningNumber(winningNumbers);
        return winningNumber;
    }
    public int bonusNumber(){
        outputView.bonusNumberMessage();
        return Integer.parseInt(Console.readLine());
    }

}
