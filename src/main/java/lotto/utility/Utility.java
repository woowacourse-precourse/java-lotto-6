package lotto.utility;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Utility {
    static final String ERROR_MESSAGE_PARSE_INT = "[ERROR] 입력값이 정수가 아닙니다.";
    static final int LOTTO_NUMBER_MIN = 1;
    static final int LOTTO_NUMBER_MAX = 45;

    public int parseInt(String input) {
        try {
            int number = Integer.parseInt(input);
            return number;
        } catch (NumberFormatException e) {
            System.out.println(ERROR_MESSAGE_PARSE_INT);
            throw new IllegalArgumentException(ERROR_MESSAGE_PARSE_INT);
        }
    }

    public List<Integer> getRandomNumbers(int length) {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(LOTTO_NUMBER_MIN, LOTTO_NUMBER_MAX, length);
        return numbers;
    }

    public String[] splitInput (String input) {
        String[] splitResult = input.split(",");
        return splitResult;
    }

    public List<Integer> getIntList (String[] inputs) {
        List<Integer> numbers = new ArrayList<>();

        for(String input : inputs) {
            int number = parseInt(input);
            numbers.add(number);
        }

        return numbers;
    }

    public double getReturnRate(int payment, long result) {
        double returnRate = (double) result / (double) payment;
        return returnRate;
    }
}
