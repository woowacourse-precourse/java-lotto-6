package lotto.Model;

import java.util.*;

public class Lotto {
    private final List<Integer> numbers;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private static final int LOTTO_SIZE = 6;

    private static final String ERROR_INPUT_LENGTH = "\n[ERROR] 로또 번호는 6개의 수를 입력해주세요.";
    private static final String ERROR_RANGE_NUMBER = "\n[ERROR] 로또 번호 1부터 45까지의 수로 입력해주세요.";
    private static final String ERROR_DUPLICATE_NUMBER = "\n[ERROR] 로또 수는 중복 없이 입력해주세요.";

    public Lotto(List<Integer> numbers) throws IllegalArgumentException {
        size_check(numbers);
        duplication_check(numbers);
        number_check(numbers);

        this.numbers = numbers;
    }

    private void size_check(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            System.out.println(ERROR_INPUT_LENGTH);
            throw new IllegalArgumentException();
        }

    }

    private void number_check(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number < MIN_NUMBER || number > MAX_NUMBER) {
                System.out.println(ERROR_RANGE_NUMBER);
                throw new IllegalArgumentException();
            }
        }
    }

    private void duplication_check(List<Integer> numbers) {
        Set<Integer> set = new HashSet<>(numbers);
        if (set.size() != LOTTO_SIZE) {
            System.out.println(ERROR_DUPLICATE_NUMBER);
            throw new IllegalArgumentException();
        }
    }

    public void check_bonusNumber(int bonusNumber) {
        if (numbers.contains(bonusNumber)) {
            System.out.println("\n[ERROR] 당첨 번호인 " + numbers + "를 제외한 번호를 입력해주세요.");
            throw new IllegalArgumentException();
        }
    }

    public int matchNumber(Lotto lottoNumbers) {

        return (int) lottoNumbers.numbers.stream()
                .filter(numbers::contains)
                .count();
    }

    public boolean checkBonusBall(int bonusBall){
        return numbers.contains(bonusBall);
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
