package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Bonus;
import lotto.domain.Constant.InputViewMessage;
import lotto.domain.Lotto;
import lotto.domain.Player;

import java.util.Arrays;

public class InputView {
    public static final String SPLIT_DELIMETER = ",";
    public static final String REGEX = "[0-9]+";

    public static int inputCash() {
        System.out.println(InputViewMessage.INPUT_CASH.getMessage());
        String input = Console.readLine();
        validateCash(input);
        int cash = Integer.parseInt(input);
        return cash;
    }

    public static Lotto inputWinningLotto() {
        System.out.println();
        System.out.println(InputViewMessage.INPUT_WINNING_LOTTO.getMessage());
        String input = Console.readLine();
        String[] splitedInput = input.split(InputViewMessage.SPLIT_DELIMETER.getMessage());
        Lotto lotto = new Lotto(Arrays.stream(splitedInput).map(Integer::valueOf).toList());
        return lotto;
    }

    public static Bonus inputBonus(Lotto winningLotto) {
        System.out.println();
        System.out.println(InputViewMessage.INPUT_BONUS.getMessage());
        String input = Console.readLine();
        Bonus bonus = new Bonus(Integer.parseInt(input), winningLotto);

        return bonus;
    }

    private static void validateCash(String input) {
        if (!input.matches(InputViewMessage.REGEX.getMessage())) {
            throw new IllegalArgumentException(InputViewMessage.VALIDATE_CASH.getMessage());
        }
    }
}
