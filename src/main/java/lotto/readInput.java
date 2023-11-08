package lotto;

import camp.nextstep.edu.missionutils.Console;

public class readInput {
    public static Integer readPurchase() {
        while (true) {
            try {
                String purchaseAmount = Console.readLine().trim();
                purchaseException.isNumeric(purchaseAmount);
                int amount = Integer.parseInt(purchaseAmount);
                purchaseException.isDividedByThousand(amount);
                return amount;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] " + e.getMessage());
            }
        }
    }
    public static String readWinningNumbers() {
        while (true) {
            try {
                String inputWinningNumbers = Console.readLine();
                winningNumberException.isContainComma(inputWinningNumbers);
                winningNumberException.getBeWinningNumbers(inputWinningNumbers);
                return inputWinningNumbers;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] " + e.getMessage());
            }
        }
    }
    public static String readBonusNumber() {
        while (true) {
            try {
                String inputBonusNumber = Console.readLine();
                bonusNumberException.isBonusNumeric(inputBonusNumber);
                int bonusNumber =Integer.valueOf(inputBonusNumber);
                bonusNumberException.validateBonusNumber(bonusNumber);
                bonusNumberException.validateBonusNotDuplicate(bonusNumber);
                return inputBonusNumber;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] " + e.getMessage());
            }
        }
    }
}
