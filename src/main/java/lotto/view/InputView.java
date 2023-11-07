package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InputView {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private static final String SEPARATOR = ",";
    private static final String REQUEST_INPUT_MONEY = "구입금액을 입력해 주세요.";
    private static final String REQUEST_WINNING_NUMBER = "당첨 번호를 입력해 주세요.";
    private static final String REQUEST_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";

    public int getInputMoney() {
        System.out.println(REQUEST_INPUT_MONEY);
        String input = Console.readLine();
        System.out.println();
        validateNumeric(input);
        return Integer.parseInt(input);
    }

    public List<Integer> getWinningNumber() {
        System.out.println(REQUEST_WINNING_NUMBER);
        String input = Console.readLine();
        System.out.println();
        List<String> inputValue = parseWinningNumber(input);

        // refactor 통해 삭제 예정
        return Stream.of(input.split(","))
                .map(Integer::parseInt)
                .peek(num -> validateNumeric(num.toString()))
                .collect(Collectors.toList());
    }

    public Integer getBonusNumber() {
        System.out.println(REQUEST_BONUS_NUMBER);
        String input = Console.readLine();
        System.out.println();
        validateNumeric(input);
        return Integer.parseInt(input);
    }

    private List<String> parseWinningNumber(String input) {
        return new ArrayList<>(Arrays.asList(input.split(SEPARATOR)));
    }

    private static void validateNumeric(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    private static void validateRangeNumber(int number) {
        if (number < MIN_NUMBER || number > MAX_NUMBER) {
            throw new IllegalArgumentException();
        }
    }
}
