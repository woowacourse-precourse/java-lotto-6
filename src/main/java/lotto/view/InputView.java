package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {
    private static final String INPUT_LOTTO_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";
    private static final String INPUT_LOTTO_WINNING_NUMBERS = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_LOTTO_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";
    private static final String INVALID_NUMBER_FORMAT = "[ERROR] 숫자만 입력이 가능해요";

    private InputView() {
    }

    public static int inputLottoPurchaseAmount() {
        System.out.println(INPUT_LOTTO_PURCHASE_AMOUNT);
        return convertToIntegerValue(Console.readLine());
    }

    public static List<Integer> inputWinningNumbers() {
        System.out.println(INPUT_LOTTO_WINNING_NUMBERS);
        List<Integer> numbers = parseNumbers(Console.readLine());
        System.out.println();
        System.out.println(INPUT_LOTTO_BONUS_NUMBER);
        int bonusNumber = convertToIntegerValue(Console.readLine());
        numbers.add(bonusNumber);
        return numbers;
    }

    private static int convertToIntegerValue(String inputStringValue) {
        try {
            return Integer.parseInt(inputStringValue);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_NUMBER_FORMAT);
        }
    }

    private static List<Integer> parseNumbers(String inputStringValue) {
        return Arrays.stream(inputStringValue.split(","))
                .map(InputView::convertToIntegerValue)
                .collect(Collectors.toList());
    }
}
