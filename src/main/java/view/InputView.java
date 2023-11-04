package view;

import static constant.ConstantMessage.DELIMITER;
import static constant.ConstantMessage.INPUT_BONUS_NUMBER;
import static constant.ConstantMessage.INPUT_MONEY;
import static constant.ConstantMessage.INPUT_WINNING_NUMBERS;

import camp.nextstep.edu.missionutils.Console;
import domain.Lotto;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {
    private InputView() {
    }

    public static String money() {
        System.out.println(INPUT_MONEY.getMessage());
        String lottoMoney = Console.readLine();
        return lottoMoney.trim();
    }

    public static Lotto winningNumbers() {
        System.out.println(INPUT_WINNING_NUMBERS.getMessage());
        String userInputNumbers = Console.readLine().replace(" ", "");

        List<Integer> winningNumbers = Arrays.stream(userInputNumbers.split(DELIMITER.getMessage()))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        System.out.println();
        return new Lotto(winningNumbers);
    }

    public static String bonusNumber() {
        System.out.println(INPUT_BONUS_NUMBER.getMessage());
        return Console.readLine();
    }
}
