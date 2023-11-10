package lotto.view;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;

import lotto.domain.Lotto;

public class InputView {

    private static final int TICKET_PRICE = 1000;

    private static String testInput; // 테스트용 입력값

    public static String inputLine() {
        if (testInput != null) {
            String inputData = testInput;
            testInput = null; // 테스트용 입력값을 사용한 후 초기화
            return inputData;
        }

        return readUserInput();
    }

    private static String readUserInput() {
        return Console.readLine();
    }

    public static long inputPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = inputLine();
        try {
            return divideWithTicketPrice(input);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return inputPurchaseAmount();
    }

    public static List<Integer> inputWinningNumbers() {
        System.out.println();
        System.out.println("당첨 번호를 입력해 주세요.");
        String input = inputLine();
        try {
            return parseWinningNumbersOrThrowError(input);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return inputWinningNumbers();
    }

    public static int inputWinningBonusNumber() {
        System.out.println();
        System.out.println("보너스 번호를 입력해 주세요.");
        String input = inputLine();
        try {
            return WinningBonusNumberOrThrowError(input);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return inputWinningBonusNumber();
    }

    private static long divideWithTicketPrice(String input) {
        long purchaseAmount = parseLongOrThrowError(input);

        if (purchaseAmount % TICKET_PRICE != 0) {
            throw new IllegalArgumentException("[ERROR] 1000원 단위로 입력해야 합니다.");
        }

        return purchaseAmount;
    }

    private static long parseLongOrThrowError(String input) {
        try {
            return Long.parseLong(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자 형식이 아닌 값이 포함되어 있습니다.");
        }
    }

    private static List<Integer> parseWinningNumbersOrThrowError(String input) {
        String[] inputNumbers;
        try {
            inputNumbers = input.split(",");
        } catch (Exception e) {
            throw new IllegalArgumentException("[ERROR] 쉼표(,)로 구분하여 당첨 번호를 입력해 주세요.");
        }
        List<Integer> winningNumbers = new ArrayList<>();

        for (String inputNumber : inputNumbers) {
            Integer parsedNumber = parseIntegerOrThrowError(inputNumber);
            winningNumbers.add(parsedNumber);
        }

        new Lotto(winningNumbers);

        return winningNumbers;
    }

    private static int WinningBonusNumberOrThrowError(String input) {
        int winningBonusNumber = parseWinningBonusNumberOrThrowError(input);
        if (winningBonusNumber < 1 || winningBonusNumber > 45) {
            throw new IllegalArgumentException("[ERROR] 보너스 숫자는 1~45 사이의 숫자여야 합니다.");
        }
        return winningBonusNumber;
    }

    private static int parseWinningBonusNumberOrThrowError(String input) {
        try {
            return Integer.parseInt(input);
        } catch (Exception e) {
            throw new IllegalArgumentException("[ERROR] 숫자 형식으로 입력해 주세요.");
        }
    }

    private static Integer parseIntegerOrThrowError(String inputNumber) {
        try {
            return Integer.parseInt(inputNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자 형식이 아닌 값이 포함되어 있습니다.");
        }
    }

    public static void setInputForTesting(String input) {
        testInput = input;
    }
}
