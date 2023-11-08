package lotto.Util;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validation {

    private static int parseInteger(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해주세요.");
        }
    }

    private static void isValidUnit(int purchaseAmount) {
        if (purchaseAmount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 1,000원 단위로 입력해주세요.");
        }
    }

    private static void isValidRange(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 1 이상 45 이하의 정수로 입력해주세요.");
        }
    }

    private static void isValidNumbers(List<Integer> numbers) {
        Set<Integer> sample = new HashSet<>(numbers);

        if (sample.size() != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호 중 중복되는 번호가 있습니다.");
        }

        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 총 6개의 당첨 번호를 입력해주세요.");
        }
    }

    private static void isDuplicatedBonusNumber(List<Integer> winnerNumbers, int bonusNumber) {
        if (winnerNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호 중 보너스 번호와 중복되는 번호가 존재합니다.");
        }
    }

    public static int validatePurchaseAmount(String input) {
        int purchaseAmount = parseInteger(input);
        isValidUnit(purchaseAmount);
        return purchaseAmount;
    }

    public static List<Integer> validateWinnerNumbers(String input) {
        String[] numbers = input.split(",");
        List<Integer> winnerNumbers = new ArrayList<>();

        for (String elem : numbers) {
            int number = parseInteger(elem);
            isValidRange(number);
            winnerNumbers.add(number);
        }

        isValidNumbers(winnerNumbers);
        return winnerNumbers;
    }

    public static int validateBonusNumber(List<Integer> winnerNumbers, String input) {
        int bonusNumber = parseInteger(input);
        isValidRange(bonusNumber);
        isDuplicatedBonusNumber(winnerNumbers, bonusNumber);
        return bonusNumber;
    }
}
