package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Lottos;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {
    public static final String COMMA = ",";
    public static final String ERROR_MESSAGE = "[ERROR]";
    private static final String INPUT_MONEY = "구입금액을 입력해 주세요.";
    private static final String INPUT_WINNING_NUMBERS = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";

    public static List<Integer> winningsNumbersCon;

    public static int inputMoney() {
        System.out.println(INPUT_MONEY);
        String price = Console.readLine();

        if (!validateUserMoney(price)) {
            return inputMoney();
        }

        return Integer.parseInt(price);
    }

    public static List<Integer> inputWinningNumbers() {
        List<Integer> winningNumbers = null;
        boolean isValidInput = false;

        while (!isValidInput) {
            System.out.println(INPUT_WINNING_NUMBERS);
            String input = Console.readLine();
            List<String> inputNumbers = Arrays.asList(input.split(COMMA));

            isValidInput = validateWinningNumbers(inputNumbers);
            if (isValidInput) {
                winningNumbers = inputNumbers.stream().map(Integer::parseInt).collect(Collectors.toList());
                winningsNumbersCon = winningNumbers;
            }
        }
        return winningNumbers;
    }

    public static int inputBonusNumber() {
        System.out.println("\n" + INPUT_BONUS_NUMBER);
        String input = Console.readLine();

        if (!validateBonusNumber(input)) {
            return inputBonusNumber();
        }

        return Integer.parseInt(input);
    }

    private static boolean validateUserMoney(String price) {
        try {
            isNotNumber(price);
            isNotDivided(Lottos.LOTTO_PRICE, Integer.parseInt(price));
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    private static boolean validateWinningNumbers(List<String> inputNumbers) {
        List<Integer> numbers = inputNumbers.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        try {
            isNotSizeToSix(inputNumbers);
            isNotNumberClude(inputNumbers);
            checkDuplicate(numbers);
            checkRangeOneToFortyFive(numbers);
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    private static boolean validateBonusNumber(String input) {
        try {
            isNotNumber(input);
            checkRangeOneToFortyFive(Integer.parseInt(input));
            checkBonusNumberNotDuplicatedWithWinningNumbers(winningsNumbersCon, Integer.parseInt(input));
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    private static void isNotNumber(String number) {
        if (!number.matches("\\d+")) {
            throw new IllegalArgumentException(ERROR_MESSAGE + "입력 값이 숫자가 아닙니다: ");
        }
    }

    private static void isNotNumberClude(List<String> list) {
        List<String> strings = list.stream()
                .map(str -> {
                    try {
                        Integer.parseInt(str);
                        return str;
                    } catch (NumberFormatException e) {
                        throw new IllegalArgumentException(ERROR_MESSAGE + "숫자가 아닌 문자가 있습니다.");
                    }
                })
                .collect(Collectors.toList());
    }

    private static void isNotSizeToSix(List<String> winningNumbers) {
        if (winningNumbers.size() != 6) {
            throw new IllegalArgumentException(InputView.ERROR_MESSAGE + "숫자 6자리를 입력하셔야 합니다.");
        }
    }

    private static void isNotDivided(int lottoPrice, int inputPrice) {
        if (inputPrice % lottoPrice != 0) {
            throw new IllegalArgumentException(InputView.ERROR_MESSAGE + "입력하신 금액이 1000원으로 나눠떨어지지 않습니다.");
        }
    }

    private static void checkDuplicate(List<Integer> numbers) {
        if (numbers.size() != new HashSet<>(numbers).size()) {
            throw new IllegalArgumentException(ERROR_MESSAGE + "중복된 숫자가 있습니다.");
        }
    }

    public static void checkBonusNumberNotDuplicatedWithWinningNumbers(List<Integer> numbers, int bonusNumber) {
        if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(ERROR_MESSAGE + "보너스 번호가 당첨 번호와 중복됩니다.");
        }
    }

    private static void checkRangeOneToFortyFive(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException(ERROR_MESSAGE + "입력 값이 1~45 범위를 벗어났습니다.");
            }
        }
    }

    private static void checkRangeOneToFortyFive(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException(ERROR_MESSAGE + "입력 값이 1~45 범위를 벗어났습니다: ");
        }
    }
}
