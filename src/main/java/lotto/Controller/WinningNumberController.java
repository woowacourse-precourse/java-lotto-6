package lotto.Controller;

import lotto.View.InputUI;
import lotto.View.OutputUI;
import java.util.List;

public class WinningNumberController extends Controller{
    List<Integer> winningNumber;
    int bonusNumber;
    @Override
    public void run(){
        OutputUI.printRequestWinningNumber();
        winningNumber = InputUI.inputWinningNumber();   // inherent validating
        OutputUI.printRequestBonusNumber();
        bonusNumber = InputUI.inputBonusNumber(winningNumber);   // inherent validating
    }
}
