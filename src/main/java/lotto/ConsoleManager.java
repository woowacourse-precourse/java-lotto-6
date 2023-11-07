package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class ConsoleManager {
    private static final String PURCHASE_AMOUNT_MESSAGE = "구입 금액을 1000원 단위로 입력하세요: ";
    private static final String LOTTO_NUMBER_MESSAGE = "로또 번호 6개를 입력하세요 (쉼표로 구분): ";
    private static final String BONUS_NUMBER_MESSAGE = "보너스 번호를 입력하세요: ";

    public int getPurchaseAmount() {
        while (true) {
            try {
                System.out.print(PURCHASE_AMOUNT_MESSAGE);
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
        return Integer.parseInt(input) / 1000;
    }

    public List<Integer> getManualInputNumbers() {
        while (true) {
            try {
                System.out.print(LOTTO_NUMBER_MESSAGE);
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
                System.out.print(BONUS_NUMBER_MESSAGE);
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
