package lotto.controller;

import lotto.util.CheckValidation;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputController {
    public static int money;
    public static List<Integer> winningNumbers;
    public static int bonusNumber;
    public static CheckValidation validator = new CheckValidation();

    public InputController() {
        money = 0;
        winningNumbers = new ArrayList<>();
        bonusNumber = 0;
    }

    public static void inputMoney() {
        String stringMoney = readLine();
        validator.checkInputMoneyFigure(stringMoney);
        money = Integer.parseInt(stringMoney);
        validator.checkInputMoneyUnit();
    }
    public static void inputWinningNumbers() {
        winningNumbers = new ArrayList<>();
        String[] numberStrings = readLine().split(",");

        for (String numberString : numberStrings) {
            numberString = numberString.trim();
            winningNumbers.add(Integer.parseInt(numberString));
        }

        // validator.checkWinningNumBlank(numberStrings);
        validator.checkWinningNumRangeOver();
        validator.checkWinningNumDuplication();
        validator.checkWinningNumAmount();
    }
    public static void inputBonusNumber() {
        String userInputBonusNumbers = readLine();
        bonusNumber = Integer.parseInt(userInputBonusNumbers);

        validator.checkBonusNumDuplication();
        validator.checkBonusNumRangeOver();
    }
}
