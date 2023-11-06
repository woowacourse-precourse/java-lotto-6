package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import lotto.view.InputView;

public class InputController {

    private static final String IS_NOT_NUMBER_EXCEPTION_MASSAGE = "[ERROR] 숫자를 입력해주세요.";
    private static final String LOTTO_NUMBER_RANGE_EXCEPTION_MASSAGE = "[ERROR] 1~45 사이의 숫자를 입력해주세요.";
    private static final String AMOUNT_DIVISIBLE_EXCEPTION_MASSAGE = "[ERROR] 1,000원으로 나누어 떨어지는 수를 입력해주세요.";
    private static final String IS_NOT_POSITIVE_NUMBER_EXCEPTION_MASSAGE = "[ERROR] 양수를 입력해주세요.";
    private static final String LOTTO_NUMBER_COUNT_EXCEPTION_MASSAGE = "[ERROR] ','로 구분된 6개의 숫자를 입력해주세요.";
    private static final String LOTTO_NUMBER_DUPLICATED_EXCEPTION_MASSAGE = "[ERROR] 중복되지 않은 수로 입력해주세요.";
    private static final String BONUS_NUMBER_DUPLICATED_EXCEPTION_MASSAGE = "[ERROR] 당첨 번호와 중복되지 않은 수로 입력해주세요.";


    private InputController() {
    }

    public static int purchaseAmount() {
        int purchaseAmount;

        InputView.purchaseAmount();
        purchaseAmount = inputPurchaseAmount();

        return purchaseAmount;
    }

    public static List<Integer> winningNumbers() {
        List<Integer> winningNumbers;

        InputView.winningNumber();
        winningNumbers = inputWinningNumbers();

        return winningNumbers;
    }

    public static int bonusNumber(List<Integer> winningNumbers) {
        int bonusNumber;

        InputView.bonusNumber();
        bonusNumber = inputBonusNumber(winningNumbers);

        return bonusNumber;
    }

    private static int inputPurchaseAmount() {
        String input;
        int purchaseAmount;

        while (true) {
            input = Console.readLine();
            try {
                purchaseAmount = parseInt(input);
                validatePurchaseAmount(purchaseAmount);
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        return purchaseAmount;
    }

    private static List<Integer> inputWinningNumbers() {
        String input;
        List<Integer> winningNumbers;

        while (true) {
            input = Console.readLine();
            try {
                winningNumbers = stringToIntList(input, ",");
                validateWinningNumbers(winningNumbers);
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        return winningNumbers;
    }

    private static int inputBonusNumber(List<Integer> winningNumbers) {
        String input;
        int bonusNumber;

        while (true) {
            input = Console.readLine();
            try {
                bonusNumber = parseInt(input);
                validateBonusNumber(winningNumbers, bonusNumber);
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        return bonusNumber;
    }

    private static void validatePurchaseAmount(int purchaseAmount) {
        validatePositive(purchaseAmount);
    }

    private static void validateBonusNumber(List<Integer> winningNumbers, int bonusNumber) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(BONUS_NUMBER_DUPLICATED_EXCEPTION_MASSAGE);
        }
        validateNumberInLottoRange(bonusNumber);
    }

    private static void validateWinningNumbers(List<Integer> winningNumbers) {
        if (winningNumbers.size() != 6) {
            throw new IllegalArgumentException(LOTTO_NUMBER_COUNT_EXCEPTION_MASSAGE);
        }

        validateDuplicatedValue(winningNumbers);
        for (Integer winningNumber : winningNumbers) {
            validateNumberInLottoRange(winningNumber);
        }
    }

    private static void validatePositive(int number) {
        if (number <= 0) {
            throw new IllegalArgumentException(IS_NOT_POSITIVE_NUMBER_EXCEPTION_MASSAGE);
        }
        validateDivisibleNumber(number, 1000);
    }

    private static void validateNumberInLottoRange(int number) {
        if (!(number >= 1 && number <= 45)) {
            throw new IllegalArgumentException(LOTTO_NUMBER_RANGE_EXCEPTION_MASSAGE);
        }
    }

    private static void validateDivisibleNumber(int number, int divideNumber) {
        if (number % divideNumber != 0) {
            throw new IllegalArgumentException(AMOUNT_DIVISIBLE_EXCEPTION_MASSAGE);
        }
    }

    private static void validateDuplicatedValue(List<Integer> list) {
        if (new HashSet<>(list).size() != list.size()) {
            throw new IllegalArgumentException(LOTTO_NUMBER_DUPLICATED_EXCEPTION_MASSAGE);
        }
    }

    private static int parseInt(String s) {
        int result;

        try {
            result = Integer.parseInt(s);
        } catch (Exception e) {
            throw new NumberFormatException(IS_NOT_NUMBER_EXCEPTION_MASSAGE);
        }

        return result;
    }

    private static List<Integer> stringToIntList(String str, String separate) {
        return Arrays.stream(str.split(separate))
                .map(InputController::parseInt)
                .collect(Collectors.toList());
    }
}
