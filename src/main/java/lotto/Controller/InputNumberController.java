package lotto.Controller;

import java.util.List;
import lotto.Model.Lotto;
import lotto.View.InputView.InputBonus;
import lotto.View.InputView.InputWinningNumber;

public class InputNumberController {

    private final List<Integer> winningNumber;
    private final InputBonus inputBonus;

    public InputNumberController() {
        this.winningNumber = inputWinningNumber();
        inputBonus = new InputBonus(winningNumber);
    }

    private List<Integer> inputWinningNumber() {
        List<Integer> result;
        while (true) {
            try {
                InputWinningNumber inputWinningNumber = new InputWinningNumber();
                result = inputWinningNumber.getWinningNumber();
                Lotto lotto = new Lotto(result);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return result;
    }

    public List<Integer> getWinningNumber() {
        return winningNumber;
    }

    public int getBonus() {
        return inputBonus.getBonus();
    }

}
