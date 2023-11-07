package lotto.ui;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {

    private static final String PRINT_INPUT_MONEY_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String PRINT_INPUT_WINNING_NUMBERS = "당첨 번호를 입력해 주세요.";
    private static final String PRINT_INPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";

    public String inputMoney() {
        System.out.println(PRINT_INPUT_MONEY_MESSAGE);

        return Console.readLine();
    }

    public List<String> inputWinningNumbers() {
        System.out.println(PRINT_INPUT_WINNING_NUMBERS);

        return toList(Console.readLine());
    }

    public String inputBonusNumber() {
        System.out.println(PRINT_INPUT_BONUS_NUMBER);

        return Console.readLine();
    }

    public List<String> toList(String numbers) {
        return Arrays.stream(numbers.split(","))
                .map(String::trim)
                .collect(Collectors.toList());
    }
}
