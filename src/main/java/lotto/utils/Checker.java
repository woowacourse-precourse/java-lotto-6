package lotto.utils;

import lotto.exception.LottoException;
import lotto.exception.Message;

import java.util.HashSet;
import java.util.List;

public class Checker {


    public static boolean isPositive(Integer number) {
        return number > 0;
    }

    public static boolean is1k(Integer number) {
        return number % 1000 == 0;
    }

    public static void validateUnique(List<Integer> numbers) {
        if (new HashSet<>(numbers).size() != numbers.size()) {
            throw LottoException.of(Message.NUMBER_UNIQUE);
        }
    }

    public static void validateSize(List<Integer> numbers, int size) {
        if (numbers.size() != size) {
            throw LottoException.of(Message.NUMBER_SIZE);
        }
    }

    public static void validateRange(List<Integer> numbers, int startNum, int endNum) {
        for (int number : numbers) {
            if (number < startNum || number > endNum) {
                throw LottoException.of(Message.NUMBER_RANGE);
            }
        }
    }

    public static boolean isValidateRange(Integer number, int startNum, int endNum) {
        return number >= startNum && number <= endNum;
    }
}
