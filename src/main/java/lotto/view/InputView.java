package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;
import java.util.stream.Collectors;

public class InputView {
    private static final String COMMA_SEPARATOR = ",";
    private static final String EMPTY_AMOUNT_ERROR = "[ERROR] 구입 금액을 입력해 주세요.";
    private static final String EMPTY_LOTTO_NUMBER_ERROR = "[ERROR] 로또 번호를 입력해 주세요.";
    private static final String NOT_INTEGER_LOTTO_NUMBER_ERROR = "[ERROR] 로또 번호는 정수여야 합니다.";
    private static final String EMPTY_BONUS_NUMBER_ERROR = "[ERROR] 보너스 번호를 입력해 주세요.";

    public static String inputPurchaseAmount() {
        String input = Console.readLine();
        if (input.isBlank()) {
            throw new IllegalArgumentException(EMPTY_AMOUNT_ERROR);
        }
        return input;
    }

    public static List<Integer> inputWinningNumbers() {
        String input = Console.readLine();
        if (input.isBlank()) {
            throw new IllegalArgumentException(EMPTY_LOTTO_NUMBER_ERROR);
        }
        try {
            return List.of(input.split(COMMA_SEPARATOR)).stream()
                    .map(numberStr -> Integer.parseInt(numberStr))
                    .collect(Collectors.toList());
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException(NOT_INTEGER_LOTTO_NUMBER_ERROR);
        }
    }

    public static String inputBonusNumber() {
        String input = Console.readLine();
        if (input.isBlank()) {
            throw new IllegalArgumentException(EMPTY_BONUS_NUMBER_ERROR);
        }
        return input;
    }
}
