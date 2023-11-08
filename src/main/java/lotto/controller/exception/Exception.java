package lotto.controller.exception;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Exception extends IllegalArgumentException{

    private Exception(String message) {
        super(message);
    }

    public static void price(int price){
        if (price < 1000 || price % 1000 != 0) {
            throw new IllegalArgumentException(Errorcode.INVALID_PRICE.getMessage());
        }
    }

    public static void lotto(List<Integer> numbers){
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != 6) {
            throw new IllegalArgumentException(Errorcode.NOT_6_UNIQUE_NUMBERS.getMessage());
        }

        for (Integer number : numbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException(Errorcode.NOT_IN_RANGE.getMessage());
            }
        }
    }

    public static void bonus(int number, List<Integer> winning){
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException(Errorcode.NOT_IN_RANGE.getMessage());
        }
        if (winning.contains(number)) {
            throw new IllegalArgumentException("입력된 로또 번호에 중복이 있습니다.");
        }
    }
}
