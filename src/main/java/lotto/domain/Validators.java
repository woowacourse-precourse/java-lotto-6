package lotto.domain;


import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validators {
    private static final int TICKET_UNIT = 1000;

    public static boolean validateMoney(String inputMoney) {
        try {
            validateStringIsIntegerConvertable(inputMoney);
            validateMoneyIsLottoAffordable(Integer.parseInt(inputMoney));
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 구입금액은 1,000원 이상의 1,000원 단위 숫자여야 합니다.");
            return false;
        }
        return true;
    }

    public static void validateStringIsIntegerConvertable(String inputString) {
        if (inputString.isEmpty()) {
            System.out.println("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            throw new IllegalArgumentException();
        }
        try {
            Integer.parseInt(inputString);
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            throw new IllegalArgumentException();
        }
    }

    private static void validateMoneyIsLottoAffordable(int money) {
        if (money % TICKET_UNIT != 0 || money == 0) {
            throw new IllegalArgumentException();
        }
    }

    public static boolean validateWinningNumbers(String inputWinningNumbers) {
        try {
            validateSixNumbers(inputWinningNumbers);
            validateIntegerListConvertable(inputWinningNumbers);
            String[] stringWinningNumbers = inputWinningNumbers.split(",");
            List<Integer> winningNumbers = Manager.convertStringToIntegerList(stringWinningNumbers);
            validateRedundancy(winningNumbers);
        } catch (IllegalArgumentException e) {
            return false;
        }
        return true;
    }

    public static void validateIntegerListConvertable(String inputNumbers) {
        String[] commaSeperated = inputNumbers.split(",");
        try {
            for (String stringNumber : commaSeperated) {
                validateStringIsIntegerConvertable(stringNumber);
            }
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException();
        }
    }

    public static void validateBonusNumber(int number, List<Integer> winningNumbers) {
        if (winningNumbers.contains(number)) {
            throw new IllegalArgumentException();
        }
    }

    public static void validateRedundancy(List<Integer> numberList) {
        Set<Integer> numberSet = new HashSet<>(numberList);
        if (numberSet.size() < 6) {
            System.out.println("[ERROR] 로또 번호는 서로 중복되지 않아야 합니다.");
            throw new IllegalArgumentException();
        }
    }

    private static void validateSixNumbers(String inputStringComma) {
        String[] commaSeperatedString = inputStringComma.split(",");
        if (commaSeperatedString.length != 6) {
            System.out.println("[ERROR] 로또 번호는 쉼표(,)를 기준으로 6개를 입력하여야 합니다.");
            throw new IllegalArgumentException();
        }
    }
}
