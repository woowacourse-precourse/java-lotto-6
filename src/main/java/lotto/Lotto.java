package lotto;

import java.util.*;

import camp.nextstep.edu.missionutils.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateWinningNumber(numbers);
        validateDuplicateNumber(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 들어올 수 있는 번호의 숫자는 6개 입니다.");
        }
    }

    // TODO: 추가 기능 구현

    //당첨 번호 넘기기.
    public List<Integer> lottoNumber() {
        return numbers;
    }

    // 보너스 숫자 넣기.
    public void bonusNumber(int number) {
        validateBonusNumber(number);
        validateWinningNumber(number);
        numbers.add(number);
    }

    // 보너스 숫자 입증 확인.
    private void validateBonusNumber(int number) {
        for (Integer num : numbers) {
            if (num == number) {
                throw new IllegalArgumentException("[ERROR] 보너스 번호는 기존 로또 번호와 중복 되면 안됩니다.");
            }
        }
    }


    // 1~45 숫자 입증 확인.
    private static void validateWinningNumber(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number < 1 || 45 < number) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
        }
    }

    // 1~45 숫자 입증 확인.
    private static void validateWinningNumber(int numbers) {
        if (numbers < 1 || 45 < numbers) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    //중복된 숫자 확인.
    private static void validateDuplicateNumber(List<Integer> numbers) {
        Set<Integer> numSet = new HashSet<>(numbers);
        if (numSet.size() != numbers.size()) {
            throw new IllegalArgumentException("중복된 숫자가 존재 합니다.");
        }
    }

}
