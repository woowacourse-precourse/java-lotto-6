package InputManager;

import ErrorMessages.CustomErrorMessages;
import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class InputManager {
    public static Integer inputCost() {
        while (true) {
            try {
                Integer cost = inputOneCost();
                return cost;
            }catch(IllegalArgumentException err) {
                System.out.println(err.getMessage());
            }
        }
    }

    public static List<Integer> inputWinningNumbers() {
        while (true) {
            try {
                List<Integer> winningNumberList = inputOneWinningNumbers();
                return winningNumberList;
            }catch(IllegalArgumentException err) {
                System.out.println(err.getMessage());
            }
        }
    }

    public static Integer inputBonusNumber(List<Integer> winningNumbers) {
        while (true) {
            try {
                Integer cost = inputOneBonusNumber(winningNumbers);
                return cost;
            }catch(IllegalArgumentException err) {
                System.out.println(err.getMessage());
            }
        }
    }

    private static Integer inputOneCost() {
        System.out.println("구입금액을 입력해 주세요.");
        String inputText = Console.readLine();

        if (!Pattern.matches(InputRegex.COST_NUMBER_REGEX.getRegex(), inputText)) {
            throw new IllegalArgumentException(CustomErrorMessages.UNMATCHED_WITH_INPUT_FORM.getMsg());
        }

        Integer ret = Integer.parseInt(inputText);
        if (ret % 1000 != 0) {
            throw new IllegalArgumentException(CustomErrorMessages.CANNOT_DIVIDED_WITH_1000.getMsg());
        }

        return ret;
    }

    private static List<Integer> inputOneWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String inputText = Console.readLine();
        if (!Pattern.matches(InputRegex.WINNING_NUMBER_REGEX.getRegex(), inputText)) {
            throw new IllegalArgumentException(CustomErrorMessages.UNMATCHED_WITH_INPUT_FORM.getMsg());
        }

        List<Integer> winningNumberList = getIntegerWinningNumberList(inputText);
        if (!validateWinningNumberList(winningNumberList)) {
            throw new IllegalArgumentException(CustomErrorMessages.OUT_OF_VALID_NUMBER_RANGE.getMsg());
        }

        return winningNumberList;
    }

    private static boolean validateWinningNumberList(List<Integer> list) {
        if (list.size() != 6) {
            return false;
        }
        for (Integer num : list) {
            if (num < 1 || num > 45) {
                return false;
            }
        }
        return true;
    }

    private static List<Integer> getIntegerWinningNumberList(String inputText) {
        List<String> numberStringList = Arrays.asList(inputText.split(","));

        return numberStringList.stream()
                .map(element -> Integer.parseInt(element))
                .collect(Collectors.toList());
    }

    private static Integer inputOneBonusNumber(List<Integer> winningNumberList) {
        System.out.println("보너스 번호를 입력해 주세요.");
        String inputText = Console.readLine();

        if (!Pattern.matches(InputRegex.BONUS_NUMBER_REGEX.getRegex(), inputText)) {
            throw new IllegalArgumentException(CustomErrorMessages.UNMATCHED_WITH_INPUT_FORM.getMsg());
        }

        Integer bonusNum = Integer.parseInt(inputText);
        validateBonusNumber(bonusNum, winningNumberList);

        return bonusNum;
    }

    private static void validateBonusNumber(Integer bonusNum, List<Integer> winningNumberList) {
        if (bonusNum < 1 || bonusNum > 45) {
            throw new IllegalArgumentException(CustomErrorMessages.OUT_OF_VALID_NUMBER_RANGE.getMsg());
        }
        if (winningNumberList.contains(bonusNum)) {
            throw new IllegalArgumentException(CustomErrorMessages.DUPLICATED_BONUS_NUMBER.getMsg());
        }
    }
}
