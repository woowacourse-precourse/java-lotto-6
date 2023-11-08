package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public enum ExceptionChecker {
    INSTANCE;
    public void checkNull(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 입력값이 없습니다.");
        }
    }

    public void checkNumber(String input) {
        String numericRegex = "\\d+";
        if (!input.matches(numericRegex)) {
            throw new IllegalArgumentException("[ERROR] 숫자가 아닙니다.");
        }
    }

    public void checkDivisibleBy1000(String input) {
        int money = Integer.parseInt(input);
        if (!(money % 1000 == 0)) {
            throw new IllegalArgumentException("[ERROR] 1000원 단위로 입력해주세요.");
        }
    }

    public void checkListLength6(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    public void checkListNull(List<Integer> numbers) {
        if (numbers == null || numbers.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호가 없습니다.");
        }
    }

    public void checkListRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1~45 사이여야 합니다.");
            }
        }
    }

    public void checkDuplicateNumber(List<Integer> numbers, Integer bonusNumber) {
        if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 로또 번호와 중복될 수 없습니다.");
        }
    }

    public void checkListDuplicateNumbers(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>();
        for (Integer number : numbers) {
            if (!uniqueNumbers.add(number)) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 중복될 수 없습니다.");
            }
        }
    }

    public void checkRange(String number) {
        int numberInt = Integer.parseInt(number);
        if (numberInt < 1 || numberInt > 45) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1~45 사이여야 합니다.");
        }
    }

}
