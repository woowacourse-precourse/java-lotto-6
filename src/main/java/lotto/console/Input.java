package lotto.console;

import camp.nextstep.edu.missionutils.Console;
import lotto.data.Messages;
import lotto.domain.Asset;
import lotto.domain.Lotto;
import lotto.service.Utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Input {
    public static Asset askMoney() {
        try {
            System.out.println(Messages.ASK_MONEY);
            Double money = Utils.convertInput(Console.readLine());
            return new Asset(money);
        } catch (IllegalArgumentException e) {
            printErrorMessage(e.getMessage());
            
            return askMoney();
        }
    }

    public static Lotto askWinningNum() {
        try {
            System.out.println(Messages.ASK_WINNIG_NUMBERS);
            String inputString = Console.readLine();

            List<Integer> numbers = Arrays.stream(inputString.split(Messages.SPLIT_STRING))
                    .map(Integer::valueOf)
                    .collect(Collectors.toList());

            return new Lotto(numbers);
        } catch (IllegalArgumentException e) {
            printErrorMessage(e.getMessage());

            return askWinningNum();
        }
    }

    public static Integer askBonusNum() {
        try {
            System.out.println(Messages.ASK_BONUS_NUMBER);

            return Integer.valueOf(Console.readLine());
        } catch (IllegalArgumentException e) {
            printErrorMessage(e.getMessage());

            return askBonusNum();
        }
    }

    private static void printErrorMessage(String message) {
        System.out.println(Messages.ERROR_PREFIX + message);
    }
}
