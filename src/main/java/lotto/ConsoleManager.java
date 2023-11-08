package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class ConsoleManager {
    private static final String PURCHASE_AMOUNT_MESSAGE = "구입 금액을 입력해주세요.";
    private static final String LOTTO_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";


    public List<Integer> getWinningNumbers() {
        while (true) {
            try {
                System.out.println(LOTTO_NUMBER_MESSAGE);
                String input = Console.readLine();
                List<Integer> numbers = parseInputToList(input);
                InputValidator validator = new InputValidator();
                validator.validateLottoNumbers(numbers);
                return numbers;
            } catch (NumberFormatException e) {
                InputValidator.validateInvalidNumber();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public int getPurchaseAmount() {
        while (true) {
            try {
                System.out.println(PURCHASE_AMOUNT_MESSAGE);
                int purchaseAmount = parseInputToAmount(Console.readLine());
                InputValidator.validateThousandUnit(purchaseAmount);
                return purchaseAmount;
            } catch (NumberFormatException e) {
                InputValidator.validateInvalidNumber();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private int parseInputToAmount(String input) {
        return Integer.parseInt(input);
    }

    public List<Integer> getManualInputNumbers() {
        while (true) {
            try {
                System.out.println(LOTTO_NUMBER_MESSAGE);
                String input = Console.readLine();
                List<Integer> numbers = parseInputToList(input);
                InputValidator validator = new InputValidator();
                validator.validateLottoNumbers(numbers);
                return numbers;
            } catch (NumberFormatException e) {
                InputValidator.validateInvalidNumber();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public int getBonusNumber() {
        while (true) {
            try {
                System.out.println(BONUS_NUMBER_MESSAGE);
                int bonusNumber = parseInputToNumber(Console.readLine());
                InputValidator.validateBonusNumber(bonusNumber);
                return bonusNumber;
            } catch (NumberFormatException e) {
                InputValidator.validateInvalidNumber();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private List<Integer> parseInputToList(String input) {
        List<Integer> numbers = new ArrayList<>();
        String[] numberStrings = input.split(",");
        for (String number : numberStrings) {
            numbers.add(parseInputToNumber(number.trim()));
        }
        return numbers;
    }

    private int parseInputToNumber(String input) {
        return Integer.parseInt(input);
    }
}
