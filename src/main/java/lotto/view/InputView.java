package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;
import java.util.stream.Collectors;

public class InputView {
    private static final String COMMA_SEPARATOR = ",";

    public static String inputPurchaseAmount() {
        return Console.readLine();
    }

    public static List<Integer> inputWinningNumbers() {
        try {
            return List.of(Console.readLine().split(COMMA_SEPARATOR)).stream()
                    .map(numberStr -> Integer.parseInt(numberStr))
                    .collect(Collectors.toList());
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 숫자여야 합니다.");
        }
    }

    public static String inputBonusNumber() {
        return Console.readLine();
    }
}
