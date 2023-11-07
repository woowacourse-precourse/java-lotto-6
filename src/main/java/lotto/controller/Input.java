package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lotto.Lotto;
import lotto.view.View;

public class Input {

    public static int moneyForBuyLotto() {
        View.moneyForBuyLotto();
        var input = Console.readLine();
        View.println();

        return Tool.unsafeString2Int(input);
    }


    public static Lotto prizeNumber() {
        final String SEPARATION_PATTERN = ",";
        View.inputPrizeNumber();
        String input = Console.readLine();
        List<String> numString = Arrays.stream(input.split(SEPARATION_PATTERN)).toList();
        List<Integer> numbers = new ArrayList<>();

        for (String s : numString) {
            int value = Tool.unsafeString2Int(s);
            Tool.uniqueAdd(numbers, value);
        }
        Validation.validatePrizeNumbers(numbers);
        View.println();
        return new Lotto(numbers);
    }

    public static int bonusNumber() {
        View.inputBonusNumber();
        String str = Console.readLine();
        int num = Tool.unsafeString2Int(str);
        Validation.validateNumberRange(num);
        View.println();

        return num;
    }

}
