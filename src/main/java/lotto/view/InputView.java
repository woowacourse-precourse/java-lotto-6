package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InputView {
    public static int inputMoney() {
        OutputView.printAskMoneyMessage();
        return Integer.parseInt(Console.readLine());
    }

    public static List<Integer> inputWinningNumbers() {
        OutputView.printAskWinningNumbersMessage();
        String input = Console.readLine();
        List<Integer> numbers = new ArrayList<>();
        Arrays.stream(input.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .forEach(numbers::add);
        return numbers;
    }

    public static String inputBonusNumber() {
        OutputView.printAskBonusNumberMessage();
        return Console.readLine();
    }

    private void validateMoney(int amount) {
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 잘못된 금액입니다.");
        }
    }
}