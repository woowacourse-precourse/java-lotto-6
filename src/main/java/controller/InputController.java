package controller;

import static validator.BonusNumberValidator.bonusNumberValidate;
import static validator.MoneyValidator.moneyValidate;
import static validator.WinningNumbersValidator.winningNumbersValidate;
import static view.View.bonusNumbersMessagePrint;
import static view.View.moneyMessagePrint;
import static view.View.winningNumbersMessagePrint;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class InputController {
    public static int getMoneyInput() {
        moneyMessagePrint();
        while (true) {
            try {
                String money = Console.readLine();
                moneyValidate(money);
                int moneyNumber = Integer.parseInt(money);
                return moneyNumber;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static List<Integer> getWinningNumbersInput() {
        winningNumbersMessagePrint();
        while (true) {
            try {
                String winningNumbers = Console.readLine();
                List<Integer> lottoWinningNumbers = winningNumbersValidate(winningNumbers);
                return lottoWinningNumbers;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static int getBonusNumberInput(List<Integer> lottoWinningNumbers) {
        bonusNumbersMessagePrint();
        while (true) {
            try {
                String BonusNumber = Console.readLine();
                int lottoBonusNumber = bonusNumberValidate(BonusNumber, lottoWinningNumbers);
                return lottoBonusNumber;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
