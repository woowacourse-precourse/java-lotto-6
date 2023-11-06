package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InputView {
    private static final String PURCHASE_PRICE_MESSAGE = "구입 금액을 입력해 주세요.";
    private static final String WINNING_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";

    public static int inputPurchasePrice() {
        System.out.println(PURCHASE_PRICE_MESSAGE);
        return Integer.parseInt(Console.readLine());
    }

    public static List<Integer> inputWinningNumbers() {
        System.out.println(WINNING_NUMBER_MESSAGE);
        String input = Console.readLine();
        return parseNumberList(input);
    }

    public static int inputBonusNumber() {
        System.out.println(BONUS_NUMBER_MESSAGE);
        return Integer.parseInt(Console.readLine());
    }

    private static List<Integer> parseNumberList(String input) {
        List<Integer> numbers = Stream.of(input.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        return numbers;
    }
}