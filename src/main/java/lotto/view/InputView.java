package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.WinNumber;
import lotto.utils.GameRules;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class InputView {
    private static final String INPUT_MONEY_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String INPUT_WIN_NUMBER_MESSAGE = "\n당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER_MESSAGE = "\n보너스 번호를 입력해 주세요.";
    private static final String INVALID_AMOUNT_ERROR_MESSAGE = "[ERROR] 구입금액은 1,000원 단위로 입력해야 합니다.";
    private static final String INVALID_INPUT_ERROR_MESSAGE = "[ERROR] 금액(숫자)을 입력해주세요.";
    private static final String INVALID_INPUT_NUMBER_ERROR_MESSAGE = "[ERROR] 숫자만 입력해주세요.";
    private static final String INVALID_WIN_NUMBER_DUPLICATION_ERROR_MESSAGE = "[ERROR] 중복된 번호가 존재합니다.";
    private static final String INVALID_WIN_NUMBER_RANGE_ERROR_MESSAGE = "[ERROR] 1~45 범위 내 번호를 입력해주세요.";
    private static final String INVALID_NUMBER_COUNT_ERROR_MESSAGE = "[ERROR] 6개의 숫자를 입력해주세요.";
    private static final String INVALID_BONUS_NUMBER_DUPLICATION_ERROR_MESSAGE = "[ERROR] 당첨 번호와 중복됩니다.";
    private static final String NUMBER_SPLITTER = ",";

    public static int inputMoney() {
        try {
            System.out.println(INPUT_MONEY_MESSAGE);
            String inputMoneyAmount = Console.readLine();
            int money = validateMoneyNumber(inputMoneyAmount);
            validateMoneyUnit(money);
            return money;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return inputMoney();
    }

    private static int validateMoneyNumber(String inputMoneyAmount) {
        try {
            return Integer.parseInt(inputMoneyAmount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_INPUT_ERROR_MESSAGE);
        }
    }

    private static void validateMoneyUnit(int money) {
        if (money % GameRules.MINIMUN_UNIT.getValue() != 0) {
            throw new IllegalArgumentException(INVALID_AMOUNT_ERROR_MESSAGE);
        }
    }

    public static WinNumber inputWinNumbers() {
        try {
            List<Integer> win = inputWinNumber();
            int bonus = inputBonusNumber();
            validateDuplicationWithBonusNumber(win, bonus);
            WinNumber winNumber = WinNumber.from(win, bonus);
            return winNumber;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputWinNumbers();
        }
    }

    private static List<Integer> inputWinNumber() {
        try {
            System.out.println(INPUT_WIN_NUMBER_MESSAGE);
            String inputWinNumbers = Console.readLine();
            List<Integer> winNumbers = validateWinNumber(inputWinNumbers);
            validateNumberCount(winNumbers);
            validateDuplicationInWinNumber(winNumbers);
            validateWinNumberRange(winNumbers);
            return winNumbers;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputWinNumber();
        }
    }

    private static List<Integer> validateWinNumber(String inputWinNumbers) {
        try {
            return Arrays.stream(inputWinNumbers.split(NUMBER_SPLITTER))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_INPUT_NUMBER_ERROR_MESSAGE);
        }
    }

    private static void validateNumberCount(List<Integer> winNumbers) {
        if (winNumbers.size() != GameRules.NUMBERS_SIZE.getValue()) {
            throw new IllegalArgumentException(INVALID_NUMBER_COUNT_ERROR_MESSAGE);
        }
    }

    private static void validateDuplicationInWinNumber(List<Integer> winNumbers) {
        Set<Integer> pickNumbers = new HashSet<>(winNumbers);
        if (pickNumbers.size() != GameRules.NUMBERS_SIZE.getValue()) {
            throw new IllegalArgumentException(INVALID_WIN_NUMBER_DUPLICATION_ERROR_MESSAGE);
        }
    }

    private static void validateWinNumberRange(List<Integer> winNumbers) {
        if (winNumbers.stream().anyMatch(number -> number < GameRules.START_RANGE.getValue() || number > GameRules.END_RANGE.getValue())) {
            throw new IllegalArgumentException(INVALID_WIN_NUMBER_RANGE_ERROR_MESSAGE);
        }
    }

    private static int inputBonusNumber() {
        try {
            System.out.println(INPUT_BONUS_NUMBER_MESSAGE);
            String inputBonusNumber = Console.readLine();
            int bonusNumber = validateBonusNumber(inputBonusNumber);
            validateBonusNumberRange(bonusNumber);
            return bonusNumber;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputBonusNumber();
        }
    }

    private static int validateBonusNumber(String inputBonusNumber) {
        try {
            return Integer.parseInt(inputBonusNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_INPUT_NUMBER_ERROR_MESSAGE);
        }
    }

    private static void validateBonusNumberRange(int bonusNumber) {
        if (bonusNumber < GameRules.START_RANGE.getValue() || bonusNumber > GameRules.END_RANGE.getValue()) {
            throw new IllegalArgumentException(INVALID_WIN_NUMBER_RANGE_ERROR_MESSAGE);
        }
    }

    private static void validateDuplicationWithBonusNumber(List<Integer> pickNumbers, int bonusNumber) {
        if (pickNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(INVALID_BONUS_NUMBER_DUPLICATION_ERROR_MESSAGE);
        }
    }
}
