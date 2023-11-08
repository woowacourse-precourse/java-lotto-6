package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class LottoNumber {
    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 45;

    public static List<Integer> pickRandomNumbers(int counter) {
        return Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, counter);
    }

    public static void validateNumberRange(int number) {
        if (number < MIN_NUMBER || number > MAX_NUMBER) {
            throw new IllegalArgumentException("[ERROR] " + MIN_NUMBER + "~" + MAX_NUMBER + "사이의 숫자를 입력해주세요.");
        }
    }

    public static void validateDuplicated(List<Integer> numbers, int number) {
        if (numbers.contains(number)) {
            throw new IllegalArgumentException("[ERROR] 중복된 공입니다.");
        }
    }
}
