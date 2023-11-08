package lotto.controller;

import lotto.domain.BonusNum;
import lotto.domain.Money;
import lotto.domain.WinningNum;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class InputController {

    private Money money;
    private WinningNum winningNum;
    private BonusNum bonusNum;

    public Money inputMoney() {
        try {
            money = new Money(InputView.inputMoney());
            OutputView.printBlank();
            return money;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputMoney();
        }
    }

    public List<Integer> inputWinningNum() {
        try {
            winningNum = new WinningNum(InputView.inputWinningNum());
            return winningNum.getWinningNum();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputWinningNum();
        }
    }

    public BonusNum inputBonusNum() {
        try {
            bonusNum = new BonusNum(InputView.inputBonusNum(), winningNum.getWinningNum());
            return bonusNum;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputBonusNum();
        }
    }
}
