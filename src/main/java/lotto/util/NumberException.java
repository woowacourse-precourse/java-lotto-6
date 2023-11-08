package lotto.util;


import java.util.List;
import static lotto.util.NumberCheck.*;

public class NumberException {
    public static void numberOfRangeException(int num) throws IllegalArgumentException{
        if(!checkRange(num)) {
            throw new IllegalArgumentException("[ERROR] : 로또 번호는 1부터 45 사이입니다.");
        }
    }

    public static void duplicateException(List<Integer> numbers) throws IllegalArgumentException {
        if (!checkDuplicate(numbers)) {
            throw new IllegalArgumentException("[ERROR] : 로또 번호는 중복되어선 안됩니다");
        }
    }

    public static void duplicateException(List<Integer> numbers, int bonus) throws IllegalArgumentException{
        if(!checkDuplicate(numbers, bonus)) {
            throw new IllegalArgumentException("[ERROR] : 보너스 번호도 중복 될 수 없습니다.");
        }
    }
}

