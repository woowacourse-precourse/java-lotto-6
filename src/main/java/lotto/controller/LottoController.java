package lotto.controller;

import java.util.List;
import lotto.view.Input;

public class LottoController {
    public void run(){
        System.out.println(Input.getMoney());
        List<Integer> winningNumber = Input.getWinningNumber();
        int bonusNumber = Input.getBonusNumber(winningNumber);

    }
}
