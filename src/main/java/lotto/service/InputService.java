package lotto.service;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static lotto.domain.constant.StringConstant.*;

public class InputService {
    public static Long readExpense() {
        String input = readLine();

        validateNumberType(input);
        validateExpense(input);
        
        return Long.parseLong(input);
    }

    // 리팩토링 필요
    private static void validateExpense(String input) {
        for (int i = 1; i < 4; i++)
            if (input.charAt(input.length() - i) != '0')
                throw new IllegalArgumentException();
    }
    
    private static void validateNumberType(String input) {
        try {
            Long.parseLong(input);
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

        return winNumbers;
    }
}
