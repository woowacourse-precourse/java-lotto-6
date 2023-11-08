package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class InputLottoNumber {
    List<Integer> winningNumber;

    public List<Integer> InputLottoNumber () {
        for (int i=0; i<6; i++) {
            winningNumber.add(i, Integer.parseInt(Console.readLine()));
        }
        OutputView outputView = new OutputView();
        outputView.print_Input_Bonus_Number();

        winningNumber.add(Integer.parseInt(Console.readLine()));
        return winningNumber;
    }
}
