package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

import lotto.view.PrintView;


public class LottoController {


    public int getInputMoney() {
        while (true) {
            PrintView.inputMoneyView();
            String inputMoney = Console.readLine();

        }
    }

    public List<Integer> getInputWinningNumbers() {
        while (true) {
            PrintView.inputWinningNumbersView();
            String inputWinningNumbers = Console.readLine();

        }
    }

    public int getInputBonusNumber() {
        while (true) {
            PrintView.inputBonusNumberView();
            String inputBonusNumber = Console.readLine();

        }
    }


}
