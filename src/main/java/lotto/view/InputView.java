package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static lotto.view.constant.viewMessage.*;

public class InputView {

    private static final Pattern COMMAPATTERN = Pattern.compile("^[\\d]+,[\\d]+,[\\d],+[\\d]+,[\\d]+,[\\d]+$");

    public Integer inputMoney() {
        System.out.print(INPUT_PURCHASE_AMOUNT);
        String input = Console.readLine();
        validateBlank(input);
        return inputParserInteger(input);
    }

    public List<Integer> inputWinningNumbers() {
        System.out.print(INPUT_WINNING_NUMBER);
        String input = Console.readLine();
        validateComma(input);
        return separateInputNumbers(input);
    }

    public Integer inputBonusNumber() {
        System.out.print(INPUT_BONUS_NUMBER);
        String input = Console.readLine();
        validateBlank(input);
        return inputParserInteger(input);
    }

    private static void validateBlank(String input) {
        if (input.trim().isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 공백은 입력될 수 없습니다.");
        }
    }

    private static void validateComma(String input) {
        if (!COMMAPATTERN.matcher(input).matches()) {
            throw new NumberFormatException("[ERROR] 올바른 형식으로 입력해주세요.");
        }
    }

    private static int inputParserInteger(String input) {
        try {
            return Integer.parseInt(input);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("[ERROR] 올바른 형식으로 입력해주세요.");
        }
    }

    private static List<Integer> separateInputNumbers(String input) {
        return Arrays.stream(input.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
