package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.WinningNum;
import lotto.validation.InputValidator;

import java.util.ArrayList;
import java.util.Arrays;

public class InputView {

    public Integer inputMoney() {
        try {
            OutputView.moneyMessage();
            String money = Console.readLine();

            InputValidator.moneyValidate(money);

            return Integer.parseInt(money);
        } catch (IllegalArgumentException e) {
            return inputMoney();
        }
    }

    public WinningNum winningNumber() {
        try {
            OutputView.winningMessage();
            String[] winningNumber = Console.readLine().split(",",-1);

            InputValidator.winningValidate(winningNumber);

            return createWinningNumber(winningNumber);
        } catch (IllegalArgumentException e) {
            return winningNumber();
        }
    }

    public Integer bonusNumber(WinningNum winningNum) {
        try {
            OutputView.bonusMessage();
            String bonusNumber = Console.readLine();

            InputValidator.bonusValidate(bonusNumber);
            winningNum.setBonusNumber(Integer.parseInt(bonusNumber));

            return Integer.parseInt(bonusNumber);
        } catch (IllegalArgumentException e) {
            return bonusNumber(winningNum);
        }
    }

    private WinningNum createWinningNumber(String[] winningNumber) {
        ArrayList<Integer> winningNum = new ArrayList<>(Arrays.stream(winningNumber)
                .map(Integer::parseInt)
                .toList());

        return new WinningNum(winningNum);
    }
}
