package lotto.Controller;

import lotto.View.InputUI;
import lotto.View.OutputUI;
import java.util.List;

public class WinningNumberController extends Controller{
    List<Integer> winningNumber;
    @Override
    public void run(){
        OutputUI.printRequestWinningNumber();
        winningNumber = InputUI.inputWinningNumber();   // inherent validating
    }
}
