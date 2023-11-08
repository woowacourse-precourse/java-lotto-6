package lotto;

import java.util.*;

public class Lotto {
    private static final String ERROR_MESSAGE = "[ERROR]";

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateSize(numbers);
        validateRange(numbers);
        validateLottoDuplication(numbers);
        this.numbers = numbers;
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            System.out.println(ERROR_MESSAGE + " 로또 번호는 총 6개여야 합니다.");
            throw new IllegalArgumentException();
        }
    }

    private void validateRange(List<Integer> numbers) {
        boolean rangeCheck = numbers.stream().anyMatch(number -> number > 45 || number < 1);
        if (rangeCheck) {
            System.out.println(ERROR_MESSAGE + " 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            throw new IllegalArgumentException();
        }
    }

    private void validateLottoDuplication(List<Integer> numbers) {
        HashSet<Integer> duplicateCheck = new HashSet<>(numbers);
        if (duplicateCheck.size() != 6) {
            System.out.println(ERROR_MESSAGE + " 로또 번호는 중복이 없어야 합니다.");
            throw new IllegalArgumentException();
        }
    }

    protected void validateBonusDuplication(int bonus) {
        HashSet<Integer> duplicateCheck = new HashSet<>(numbers);
        duplicateCheck.add(bonus);

        if (duplicateCheck.size() != 7) {
            System.out.println(ERROR_MESSAGE + " 보너스 번호는 로또 번호와 중복이 없어야 합니다.");
            throw new IllegalArgumentException();
        }
    }

    protected int analysisLottoStatistic(List<Integer> compareLotto) {
        int unionCount = compareLotto.size() + numbers.size();
        compareLotto.addAll(numbers);
        HashSet<Integer> unionLotto = new HashSet<>(compareLotto);

        return unionCount - unionLotto.size();
    }
}
