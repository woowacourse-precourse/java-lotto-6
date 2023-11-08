package lotto.handler;

import camp.nextstep.edu.missionutils.Console;
import lotto.view.ResultView;

import java.util.*;

public class UserHandler {
    public static int getAmountFromUser() {
        while(true) {
            try {
                System.out.println("구입금액을 입력해 주세요.");
                String userInput = Console.readLine();
                ResultView.printNewLine();

                return validateUserInput(userInput);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static int validateUserInput(String userInput) {
        if (userInput == null || userInput.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 금액을 입력해주세요.");
        }

        checkStartWithZero(userInput);
        checkNumerString(userInput);

        int amount = Integer.parseInt(userInput);

        checkUnitAmount(amount);

        return amount;
    }


    public static int getLottoCountFromUser(int amount) {
        return amount/1000;
    }

    private static void checkStartWithZero(String userInput) {
        if (userInput.startsWith("0")) {
            throw new IllegalArgumentException("[ERROR] 0으로 시작하는 숫자를 입력하지 마세요.");
        }
    }

    private static void checkNumerString(String userInput) {
        try {
            Integer.parseInt(userInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해주세요.");
        }
    }

    private static void checkUnitAmount(int amount) {
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 1000원 단위로 입력해주세요.");
        }

    }

    public static List<String> getWinningNumberFromUser() {
        List<String> winningNumbers = getAndValidateWinningNumbers();

        return winningNumbers;
    }

    private static List<String> getAndValidateWinningNumbers() {
        while (true) {
            try {
                ResultView.printNewLine();
                System.out.println("당첨 번호를 입력해 주세요.");
                String winningNumberInput = Console.readLine();

                return validateWinningNumberInput(winningNumberInput);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static int getAndValidateBonusNumber(List<String> winningNumbers) {
        while (true) {
            try {
                ResultView.printNewLine();
                System.out.println("보너스 번호를 입력해주세요.");
                String BonusNumberInput = Console.readLine();

                checkValidBonusNumberInput(BonusNumberInput);

                int bonusNumber = Integer.parseInt(BonusNumberInput);

                checkvalidateBonusNumber(bonusNumber);
                checkDuplicateWithWinningNumbers(bonusNumber, winningNumbers);

                return bonusNumber;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static List<String> validateWinningNumberInput(String winningNumberInput) {
        if (winningNumberInput == null || winningNumberInput.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 번호를 입력해주세요.");
        }

        List<String> winningNumbers = splitNumbers(winningNumberInput);
        checkWinningNumberSize(winningNumbers);
        checkDuplicateWinningNumber(winningNumbers);

        for (String winningNumber : winningNumbers) {
            validateWinningNumber(winningNumber);
        }
        return winningNumbers;
    }

    private static void checkCommaSeparated(String winningNumberInput) {
        if (!winningNumberInput.contains(",")) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 쉼표(,)로 구분해주세요.");
        }
    }

    private static List<String> splitNumbers(String winningNumberInput) {
        checkCommaSeparated(winningNumberInput);
        return Arrays.asList(winningNumberInput.split(","));
    }

    private static void checkWinningNumberSize(List<String> winningNumbers) {
        Set<String> uniqueNumbers = new HashSet<>(winningNumbers);

        if (uniqueNumbers.size() != winningNumbers.size()) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 중복될 수 없습니다.");
        }
    }

    private static void checkDuplicateWinningNumber(List<String> winningNumbers) {
        if (winningNumbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 6개를 입력해야 합니다.");
        }
    }

    private static void validateWinningNumber(String winningNumber) {
        int number;
        try {
            number = Integer.parseInt(winningNumber.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해주세요.");
        }

        if (number < 1 || number > 45) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45까지의 숫자입니다.");
        }
    }

    private static void checkvalidateBonusNumber(int bonusNumber) {
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45까지의 숫자입니다.");
        }
    }
    private static void checkDuplicateWithWinningNumbers(int bonusNumber, List<String> winningNumbers) {
        for (String winningNumber : winningNumbers) {
            if (Integer.parseInt(winningNumber) == bonusNumber) {
                throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
            }
        }
    }

    private static void checkValidBonusNumberInput(String bonusNumberInput) {
        if (bonusNumberInput == null || bonusNumberInput.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 다시 입력하세요.");
        }

        try {
            Integer.parseInt(bonusNumberInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력하세요.");
        }
    }
}
