package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class ConsoleManager {
    private static final String PURCHASE_AMOUNT_MESSAGE = "구입 금액을 1000원 단위로 입력하세요: ";
    private static final String LOTTO_NUMBER_MESSAGE = "로또 번호 6개를 입력하세요 (쉼표로 구분): ";
    private static final String ERROR_INVALID_NUMBER = "[ERROR] 숫자를 입력해주세요.";
    private static final String ERROR_NOT_THOUSAND_UNIT = "[ERROR] 1000원 단위로 입력해주세요.";

    public int getPurchaseAmount() {
        while (true) {
            try {
                System.out.print(PURCHASE_AMOUNT_MESSAGE);
                int purchaseAmount = parseInputToAmount(Console.readLine());
                validateThousandUnit(purchaseAmount);
                return purchaseAmount;
            } catch (NumberFormatException e) {
                System.out.println(ERROR_INVALID_NUMBER);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private int parseInputToAmount(String input) {
        return Integer.parseInt(input) / 1000;
    }

    private void validateThousandUnit(int amount) {
        if (amount % 1 != 0) {
            throw new IllegalArgumentException(ERROR_NOT_THOUSAND_UNIT);
        }
    }

    public List<Integer> getManualInputNumbers() {
        List<Integer> numbers = new ArrayList<>();
        while (true) {
            try {
                System.out.print(LOTTO_NUMBER_MESSAGE);
                String input = Console.readLine();
                String[] numberStrings = input.split(",");
                for (String number : numberStrings) {
                    numbers.add(parseInputToNumber(number.trim()));
                }
                return numbers;
            } catch (NumberFormatException e) {
                System.out.println(ERROR_INVALID_NUMBER);
                numbers.clear();
            }
        }
    }

    private int parseInputToNumber(String input) {
        return Integer.parseInt(input);
    }
}
