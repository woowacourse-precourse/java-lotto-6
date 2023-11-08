package lotto.util;


import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class ExceptionHandling {
    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 45;
    public static final int LOTTO_PRICE = 1000;

    public static void isValidPrice(int price) throws IllegalArgumentException {
        if (price % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("[ERROR] 금액이 나누어 떨어지지 않습니다");
        }
    }

    public static void isValidNumber(String number) throws IllegalArgumentException {
        if (!number.matches("\\d+")) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해주세요");
        }
    }

    public static void isSameNumber(List<Integer> numbers) throws IllegalArgumentException {
        Set<Integer> set = new HashSet<>(numbers);
        if (numbers.size() != set.size()) {
            throw new IllegalArgumentException("[ERROR] 중복된 숫자는 로또번호가 될수 없습니다");
        }

    }

    public static void isSameBonusNumber(List<Integer> numbers, int bonusNumber) throws IllegalArgumentException {
        if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 중복된 숫자는 보너스 넘버가 될수 없습니다");
        }

    }

    public static void isOverSize(List<Integer> numbers) throws IllegalArgumentException {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개야 합니다");
        }
    }

    public static void isNumberOverRange(List<Integer> numbers) throws IllegalArgumentException {
        boolean isValid = numbers.stream().allMatch(number -> number >= MIN_NUMBER && number <= MAX_NUMBER);

        if (!isValid) {
            throw new IllegalArgumentException("[ERROR]각 숫자는 " + MIN_NUMBER + "부터 " + MAX_NUMBER + " 사이여야 합니다.");
        }

    }

}
