package lotto.util;

import lotto.model.BonusNumber;
import lotto.model.Winning;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NumberException {
    private static Set<Integer> set;

    public static void validateNumber(String input){
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] : 숫자만 입력해주세요.");
        }
    }

    public static Winning validateLottoNumber(List<Integer> numbers){
        validSize(numbers);
        validRange(numbers);
        validDuplicates(numbers);
        return new Winning(numbers);
    }

    public static BonusNumber validateBonusNumber(int number){
        checkNumberRange(number);
        checkDuplicate(number);
        return new BonusNumber(number);
    }

    private static void validSize(List<Integer> numbers){
        if (numbers.size() != 6){
            throw new IllegalArgumentException("[ERROR] : 기본 숫자는 6개를 입력하셔야 합니다.");
        }
    }

    private static void validRange(List<Integer> numbers){
        for (int number : numbers) {
            checkNumberRange(number);
        }
    }

    private static void checkNumberRange(int number){
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException("[ERROR] : 로또의 범위는 1부터 45입니다.");
        }
    }

    private static void validDuplicates(List<Integer> numbers) {
        set = new HashSet<>();
        for (int number : numbers){
            checkDuplicate(number);
        }
    }

    private static void checkDuplicate(int number){
        if (!set.add(number)){
            throw new IllegalArgumentException("[ERROR] : 중복된 값은 입력할 수 없습니다.");
        }
    }
}

