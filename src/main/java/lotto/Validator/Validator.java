package lotto.Validator;

import static lotto.Validator.ValidatorConstant.*;

import java.util.List;

public class Validator {
    private static final int LOTTO_PRICE = 1000;

    public static int validateParseInt(String input) {
        try {
            int result = Integer.parseInt(input);
            return result;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(PARSE_INT_ERROR.getMessage());
        }
    }

    public static void validateDivisibleBy1000(int input) {
        if (input % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(Not_DIVISION_BY_1000_ERROR.getMessage());
        }
    }

    private static void valiateEqualNums(int num1, int num2) {
        if (num1 == num2) {
            throw new IllegalArgumentException();
        }
    }

    public static void valiateDuplicateNums(List<Integer> numbers) {
        for (int i = 0; i < numbers.size() - 1; i++) {
            for (int j = i + 1; j < numbers.size(); j++) {
                valiateEqualNums(numbers.get(i), numbers.get(j));
            }
        }
    } 
}
