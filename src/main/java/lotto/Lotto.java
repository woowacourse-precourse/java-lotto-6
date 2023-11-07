package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

import static lotto.messages.ErrorMessages.DUPLICATE_VALUE_FOUND;
import static lotto.messages.ErrorMessages.WINNING_NUMBERS_COUNT_ERROR;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        duplicate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return new ArrayList<>(numbers);
    }

    // 로또 6개 번호 생성
    public static Lotto generateLottoNumbers() {
        return new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(WINNING_NUMBERS_COUNT_ERROR.getMessage());
        }
    }

    private void duplicate(List<Integer> numbers) {
        Set<Integer> uniqueNumber = new HashSet<>(numbers);
        if (uniqueNumber.size() < numbers.size()) {
            throw new IllegalArgumentException(DUPLICATE_VALUE_FOUND.getMessage());
        }
    }

    // 몇개 일치하는지 확인
    public List<Integer> calculateMatchingNumbers(List<Integer> winningNumber, int bonusNumber) {
        List<Integer> result = new ArrayList<>(Collections.nCopies(7, 0));
        int count = matchingCount(winningNumber);

        if (count == 5 && winningNumber.contains(bonusNumber)) {
            int currentValue = result.get(0);
            result.set(0, currentValue + 1);
        } else if (count >= 3) {
            int currentValue = result.get(count);
            result.set(count, currentValue + 1);
        }
        System.out.println(result);

        return result;
    }

    // count값 조절로 결과 확인
    public List<Integer> calculateMatchingNumbers(int bonusNumber, int count) {
        List<Integer> result = new ArrayList<>(Collections.nCopies(7, 0));

        if (count == 5 && numbers.contains(bonusNumber)) {
            int currentValue = result.get(0);
            result.set(0, currentValue + 1);
        } else if (count >= 3) {
            int currentValue = result.get(count);
            result.set(count, currentValue + 1);
        }

        return result;
    }


    public int matchingCount(List<Integer> winningNumber) {
        int count = 0;
        for (int number : numbers) {
            if (winningNumber.contains(number)) {
                count++;
            }
        }
        return count;
    }


}
