package lotto.ui;

import static lotto.global.LottoInformation.LOTTO_BALLS_NUMBER;
import static lotto.global.LottoInformation.LOTTO_MAX_NUMBER;
import static lotto.global.LottoInformation.LOTTO_MIN_NUMBER;
import static lotto.global.LottoInformation.LOTTO_PRICE_UNIT;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Input {
    private static final String PURCHASE_PRICE_INPUT = "구입금액을 입력해 주세요.";
    private static final String USER_NUMBER_INPUT = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_INPUT = "보너스 번호를 입력해 주세요.";
    private static final String COMMA_SEPARATOR = ",";
    private static final String INVALID_NATURAL_NUMBER_ERROR = "입력값은 자연수여야 합니다.";
    private static final String INVALID_LOTTO_NUMBER_ERROR = "유효하지 않는 로또 번호입니다.";
    private static final String INVALID_LOTTO_SIZE_ERROR = "유효하지 않는 로또 번호 개수입니다.";
    private static final String INVALID_PRICE_UNIT_ERROR = "1,000원 단위로 입력해야 합니다.";
    private static final int ZERO = 0;

    public static int getPurchasePrice() {
        System.out.println(PURCHASE_PRICE_INPUT);
        String userInput = Console.readLine();
        return validPurchasePrice(userInput);
    }

    private static int validPurchasePrice(String userInput) {
        checkInteger(userInput);
        int price = StringToInt(userInput);
        checkNaturalNumber(price);
        checkPurchaseAmount(price);
        return price;
    }

    private static void checkInteger(String userInput) {
        try {
            StringToInt(userInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_NATURAL_NUMBER_ERROR);
        }
    }

    private static void checkNaturalNumber(int price) {
        if (price <= ZERO) {
            throw new IllegalArgumentException(INVALID_NATURAL_NUMBER_ERROR);
        }
    }

    private static void checkPurchaseAmount(int price) {
        if (price % LOTTO_PRICE_UNIT.getValue() != ZERO) {
            throw new IllegalArgumentException(INVALID_PRICE_UNIT_ERROR);
        }
    }

    public static List<Integer> getUserNumbers() {
        System.out.println(USER_NUMBER_INPUT);
        String userInput = Console.readLine();
        List<Integer> userNumbers = parseIntegers(userInput);
        validUserNumbers(userNumbers);
        return userNumbers;
    }

    private static List<Integer> parseIntegers(String userInput) {
        try {
            return Arrays.stream(userInput.split(COMMA_SEPARATOR))
                    .map(number -> Integer.parseInt(number.trim()))
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_NATURAL_NUMBER_ERROR);
        }
    }

    private static void validUserNumbers(List<Integer> userNumbers) {
        checkNumberSize(userNumbers);
        for (Integer number : userNumbers) {
            checkNaturalNumber(number);
            checkInRange(number);
        }
    }

    private static void checkNumberSize(List<Integer> userNumbers) {
        if (userNumbers.size() != LOTTO_BALLS_NUMBER.getValue()) {
            throw new IllegalArgumentException(INVALID_LOTTO_SIZE_ERROR);
        }
    }

    private static void checkInRange(int number) {
        if (number < LOTTO_MIN_NUMBER.getValue() || number > LOTTO_MAX_NUMBER.getValue()) {
            throw new IllegalArgumentException(INVALID_LOTTO_NUMBER_ERROR);
        }
    }

    public static int getBonusNumber() {
        System.out.println();
        System.out.println(BONUS_NUMBER_INPUT);
        String userInput = Console.readLine();
        return validBonusNumber(userInput);
    }

    private static int validBonusNumber(String userInput) {
        checkInteger(userInput);
        int bonusNumber = StringToInt(userInput);
        checkInRange(bonusNumber);
        return bonusNumber;
    }

    private static int StringToInt(String userInput) {
        return Integer.parseInt(userInput);
    }
}
