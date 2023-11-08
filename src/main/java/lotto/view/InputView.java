package lotto.view;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static String testInput; // 테스트용 입력값

    public static String inputLine() {
        if (testInput != null) {
            String inputData = testInput;
            testInput = null; // 테스트용 입력값을 사용한 후 초기화
            return inputData;
        }

        try {
            return Console.readLine();
        } catch (Exception e) {
            throw new IllegalArgumentException("[ERROR] 잘못 된 값을 입력하였습니다.");
        }
    }

    public static long inputPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        try {
            String input = inputLine();
            return parseLongOrThrowError(input);
        } catch (Exception e) {
            throw new IllegalArgumentException("[ERROR] 숫자 형식이 아닌 값이 포함되어 있습니다.");
        }
    }

    public static List<Integer> inputWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        try {
            String input = inputLine();
            return parseWinningNumbersOrThrowError(input);
        } catch (Exception e) {
            throw new IllegalArgumentException(e);
        }
    }

    private static long parseLongOrThrowError(String input) {
        try {
            return Long.parseLong(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자 형식이 아닌 값이 포함되어 있습니다.");
        }
    }

    private static List<Integer> parseWinningNumbersOrThrowError(String input) {
        List<Integer> winningNumbers = new ArrayList<>();
        String[] inputNumbers = input.split(",");

        for (String inputNumber : inputNumbers) {
            Integer winningNumber = parseSingleWinningNumber(inputNumber);
            checkDuplicateAndAdd(winningNumbers, winningNumber);
        }

        return winningNumbers;
    }

    private static Integer parseSingleWinningNumber(String inputNumber) {
        try {
            return Integer.parseInt(inputNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    private static void checkDuplicateAndAdd(List<Integer> winningNumbers, Integer number) {
        if (winningNumbers.contains(number)) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호에 중복된 숫자가 있습니다.");
        }

        winningNumbers.add(number);
    }

    public static void setInputForTesting(String input) {
        testInput = input;
    }
}
