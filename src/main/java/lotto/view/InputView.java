package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.Lotto;
import lotto.exception.InputException;
import lotto.gameUtil.GameLogic;

public class InputView {
    private OutputView outputView;
    private InputException inputException;
    private GameLogic gameLogic;
    private String[] winningNumbers;
    public InputView(){
        outputView = new OutputView();
        inputException = new InputException();
        gameLogic = new GameLogic();
    }
    public int inputAmount(){
        outputView.amountMessage();
        String tmpMoney = Console.readLine();
        int money = inputException.inputExceptionCheck(tmpMoney);
        return money;
    }
    public String[] winningNumber(){
        outputView.winningNumberMessage();
        String winningNumber = Console.readLine();
        String[] tmpWinningNumbers = gameLogic.splitNumber(winningNumber);
        winningNumbers =  inputException.checkExceptionWinningNumber(tmpWinningNumbers);
        return winningNumbers;
    }
    public int bonusNumber(Lotto winningLotto){
        outputView.bonusNumberMessage();
        String tmpBonusNumber = Console.readLine();
        int bonusNumber = inputException.checkExceptionBonusNumber(tmpBonusNumber, winningLotto);
        return bonusNumber;
    }

}
