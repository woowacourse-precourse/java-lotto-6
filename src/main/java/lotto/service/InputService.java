package lotto.service;

import lotto.domain.Lotto;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static java.lang.Long.parseLong;
import static lotto.domain.constant.StringConstant.*;

public class InputService {
    public static long readExpense() {
        String input = readLine();

        validateNumberType(input);
        validateExpenseValue(input);
        
        return parseLong(input);
    }

    // 리팩토링 필요 !!!
    private static void validateExpenseValue(String input) {
        for (int i = 1; i < 4; i++)
            if (input.charAt(input.length() - i) != '0')
                throw new IllegalArgumentException();
    }
    
    private static void validateNumberType(String input) {
        try {
            parseLong(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }


    public static List<Integer> readWinNumbers() {
        List<Integer> winNumbers = new ArrayList<>();
        String[] input = readLine().split(SPLIT_DELIMITER);

        for (String num : input) {
            validateNumberType(num);
            winNumbers.add(Integer.parseInt(num));
        }

        winNumbers.sort(Integer::compareTo);
        return winNumbers;
    }

    public static int readBonusNumber() {
        String input = readLine();

        validateNumberType(input);

        int bonusNumber = Integer.parseInt(input);
        Lotto.validateNumberInRange(List.of(bonusNumber));

        return bonusNumber;
    }
}
