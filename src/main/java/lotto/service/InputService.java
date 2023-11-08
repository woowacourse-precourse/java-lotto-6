package lotto.service;

import lotto.domain.Lotto;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
import static lotto.domain.constant.StringConstant.*;
import static lotto.utils.Validator.*;
import static lotto.service.OutputService.printError;

public class InputService {
    public static long readExpense() {
        String input = readLine();

        try {
            validateExpense(input);
            return parseLong(input);
        } catch (IllegalArgumentException e) {
            printError(e);
            return readExpense();
        }
    }


    public static Lotto readWinningLotto() {
        String[] input = trim(readLine().split(SPLIT_DELIMITER));

        try {
            validateLottoNumType(input);
            return Lotto.create(parseAndSort(input));
        } catch (IllegalArgumentException e) {
            printError(e);
            return readWinningLotto();
        }
    }

    private static String[] trim(String[] input) {
        String[] trimmed = new String[input.length];

        for (int i = 0; i < input.length; i++)
            trimmed[i] = input[i].trim();

        return trimmed;
    }

    private static List<Integer> parseAndSort(String[] input) {
        List<Integer> winningLotto = new ArrayList<>();

        for (String s : input)
            winningLotto.add(parseInt(s));

        winningLotto.sort(null);

        return winningLotto;
    }


    public static int readBonusNum(Lotto winningLotto) {
        String input = readLine();

        try {
            validateBonusNum(input, winningLotto);
            return parseInt(input);
        } catch (IllegalArgumentException e) {
            printError(e);
            return readBonusNum(winningLotto);
        }
    }
}
