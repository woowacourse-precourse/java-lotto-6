package lotto.service;

import lotto.domain.Lotto;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
import static lotto.domain.constant.StringConstant.*;
import static lotto.utils.Validator.*;

public class InputService {
    public static long readExpense() {
        try {
            String input = readLine();

            validateNumberType(input);
            validateExpenseValue(input);

            return parseLong(input);
        } catch (IllegalArgumentException e) {
            return readExpense();
        }
    }


    public static Lotto readWinningLotto() {
        List<Integer> winningNumbers = new ArrayList<>();
        String[] input = trim(readLine().split(SPLIT_DELIMITER));

        try {
            for (String num : input) {
                validateNumberType(num);
                winningNumbers.add(parseInt(num));
            }

            winningNumbers.sort(null);
            return Lotto.create(winningNumbers);
        } catch (IllegalArgumentException e) {
            return readWinningLotto();
        }
    }

    private static String[] trim(String[] input) {
        String[] trimmed = new String[input.length];

        for (int i = 0; i < input.length; i++)
            trimmed[i] = input[i].trim();

        return trimmed;
    }


    public static int readBonusNum(Lotto winningLotto) {
        try {
            String input = readLine();
            validateNumberType(input);

            int bonusNum = parseInt(input);
            validateBonusNumInRange(bonusNum);
            validateBonusNumDuplicate(bonusNum, winningLotto);

            return bonusNum;
        } catch (IllegalArgumentException e) {
            return readBonusNum(winningLotto);
        }
    }
}
