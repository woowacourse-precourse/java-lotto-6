package lotto.controller;

import lotto.util.CheckValidation;
import lotto.view.OutputView;

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
        try {
            validator.checkInputMoneyFigure(stringMoney);
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] " + e.getMessage());
            inputMoney();
            return;
        }
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
        try {
            validator.checkWinningNumRangeOver();
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] " + e.getMessage());
            inputWinningNumbers();
        }
        try {
            validator.checkWinningNumDuplication();
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] " + e.getMessage());
            inputWinningNumbers();
        }
        try {
            validator.checkWinningNumAmount();
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] " + e.getMessage());
            inputWinningNumbers();
        }
    }
    public static void inputBonusNumber() {
        String userInputBonusNumbers = readLine();
        bonusNumber = Integer.parseInt(userInputBonusNumbers);

        try {
            validator.checkBonusNumDuplication();
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] " + e.getMessage());
            inputBonusNumber();
        }
        try {
            validator.checkBonusNumRangeOver();
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] " + e.getMessage());
            inputBonusNumber();
        }
    }
}
