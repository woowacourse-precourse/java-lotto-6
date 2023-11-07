package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final int NUMBERS_SIZE = 6;
    private final int MIN_LOTTO_NUM = 1;
    private final int MAX_LOTTO_NUM = 45;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public int bonusNumber(int bounusNumber) {
        validateBonusNumber(bounusNumber);
        return bounusNumber;
    }

    private void validate(List<Integer> numbers) {
        validateNumbersSize(numbers);
        validateDuplicatedNumber(numbers);
        validateNumberRange(numbers);
    }

    private void validateBonusNumber(int bonusNumber) {
        validateDuplicatedBonusNumber(numbers, bonusNumber);
        validateBonusRange(bonusNumber);
    }

    private void validateNumbersSize(List<Integer> numbers) {
        if (numbers.size() != NUMBERS_SIZE) {
            System.out.println("[ERROR] 입력이 필요한 숫자는 6개 입니다.");
            throw new IllegalArgumentException("[ERROR] 입력이 필요한 숫자는 6개 입니다.");
        }
    }

    private void validateDuplicatedNumber(List<Integer> numbers) {
        Set<Integer> validator = new HashSet<>();
        validator.addAll(numbers);
        if (validator.size() != NUMBERS_SIZE) {
            System.out.println("[ERROR] 중복된 숫자가 입력 되었습니다.");
            throw new IllegalArgumentException("[ERROR] 중복된 숫자가 입력 되었습니다.");
        }
    }

    private void validateNumberRange(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < MIN_LOTTO_NUM || number > MAX_LOTTO_NUM) {
                System.out.println("[ERROR] 입력이 필요한 숫자의 범위는 1 ~ 45 입니다.");
                throw new IllegalArgumentException("[ERROR] 입력이 필요한 숫자의 범위는 1 ~ 45 입니다.");
            }
        }
    }

    private void validateDuplicatedBonusNumber(List<Integer> numbers, int bonusNumber) {
        for (int number : numbers) {
            if (number == bonusNumber) {
                System.out.println("[ERROR] 당첨 번호와 보너스 번호가 중복 되었습니다.");
                throw new IllegalArgumentException("[ERROR] 당첨 번호와 보너스 번호가 중복 되었습니다.");
            }
        }
    }

    private void validateBonusRange(int bonus) {
        if (bonus < MIN_LOTTO_NUM || bonus > MAX_LOTTO_NUM) {
            System.out.println("[ERROR] 입력이 필요한 숫자의 범위는 1 ~ 45 입니다.");
            throw new IllegalArgumentException("[ERROR] 입력이 필요한 숫자의 범위는 1 ~ 45 입니다.");
        }
    }

    public List<Integer> getLotto() {
        return numbers;
    }
}