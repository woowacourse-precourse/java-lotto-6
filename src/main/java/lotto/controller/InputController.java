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
    public static void validate (Runnable validation) {
        try {
            validation.run();
        } catch (IllegalArgumentException e) {
            throw e;
        }
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

        try {
            validateWinningNumbers(numberStrings);
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] " + e.getMessage());
            inputWinningNumbers();
        }
    }
    public static void validateWinningNumbers(String[] numberStrings) {
        validate(()-> validator.checkWinningNumRangeOver());
        validate(()-> validator.checkWinningNumDuplication());
        validate(()-> validator.checkWinningNumAmount());
        validate(()-> validator.checkWinningNumBlank(numberStrings));
    }
    public static void inputBonusNumber() {
        String userInputBonusNumbers = readLine();
        bonusNumber = Integer.parseInt(userInputBonusNumbers);

        try {
            validateBonusNumber();
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] " + e.getMessage());
            inputBonusNumber();
        }
    }
    public static void validateBonusNumber() {
        validate(()-> validator.checkBonusNumDuplication());
        validate(()-> validator.checkBonusNumRangeOver());
    }
}
