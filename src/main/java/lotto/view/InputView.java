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
        return parseNumbers(Console.readLine());
    }

    public static int inputBonusNumber() {
        System.out.println(INPUT_LOTTO_BONUS_NUMBER);
        return convertToIntegerValue(Console.readLine());
    }

    private static int convertToIntegerValue(String inputStringValue) {
        try {
            long parsedValue = Long.parseLong(inputStringValue);
            if (parsedValue < Integer.MIN_VALUE || parsedValue > Integer.MAX_VALUE) {
                throw new IllegalArgumentException(
                        "[ERROR] 구입 금액은 " + Integer.MIN_VALUE + "에서 " + Integer.MAX_VALUE + " 사이의 값이어야 합니다.");
            }
            return (int) parsedValue;
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
