package lotto.domain;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import lotto.Config;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = sortNumbers(numbers);
    }

    private void validate(List<Integer> numbers) {
        validateLength(numbers);
        validateDuplication(numbers);
        validateRange(numbers);
    }

    /**
     * 숫자 리스트를 정렬한다.
     *
     * @param numbers : 숫자 리스트
     * @return : 정렬된 숫자 리스트
     */
    private List<Integer> sortNumbers(List<Integer> numbers) {
        List<Integer> sorted = new ArrayList<>(numbers);
        sorted.sort(Comparator.naturalOrder());
        return sorted;
    }

    /**
     * 숫자 리스트의 길이를 확인한다.
     *
     * @param numbers : 숫자 리스트
     * @throws IllegalArgumentException : 숫자가 6개가 아닌 경우
     */
    private void validateLength(List<Integer> numbers) throws IllegalArgumentException {
        if (numbers.size() != Config.LOTTO_LENGTH) {
            throw new IllegalArgumentException("[ERROR] 6개의 숫자를 입력해야 합니다.");
        }
    }

    /**
     * 숫자 중복을 확인한다.
     *
     * @param numbers : 숫자 리스트
     * @throws IllegalArgumentException : 중복되는 숫자가 있는 경우
     */
    private void validateDuplication(List<Integer> numbers) throws IllegalArgumentException {
        List<Integer> checker = new ArrayList<>();

        for (int number : numbers) {
            if (checker.contains(number)) {
                throw new IllegalArgumentException("[ERROR] 숫자는 중복될 수 없습니다.");
            }
            checker.add(number);
        }
    }

    /**
     * 숫자가 범위 내에 속하는지 확인한다.
     *
     * @param numbers : 숫자 리스트
     * @throws IllegalArgumentException : 숫자가 범위 내에 속하지 않는 경우
     */
    private void validateRange(List<Integer> numbers) throws IllegalArgumentException {
        for (int number : numbers) {
            if (number < Config.MIN_VALUE || number > Config.MAX_VALUE) {
                throw new IllegalArgumentException("[ERROR] 1 ~ 45 범위의 숫자만 가능합니다.");
            }
        }
    }

    /**
     * 숫자 리스트를 반환한다.
     *
     * @return : unmodifiableList로 변환된 숫자 리스트
     */
    public List<Integer> getNumbers() {
        return numbers.stream().toList();
    }

    /**
     * 숫자 리스트에 있는 숫자인지 확인한다.
     *
     * @param number : 확인할 숫자
     * @return : 숫자 포함 여부
     */
    public boolean hasNumber(int number) {
        return this.numbers.contains(number);
    }

    /**
     * 숫자 리스트를 문자열로 변환한다.
     *
     * @return : 문자열로 변환된 숫자 리스트
     */
    public String toString() {
        StringBuilder string = new StringBuilder("[" + numbers.get(0));

        for (int number : numbers.subList(1, numbers.size())) {
            string.append(", ");
            string.append(number);
        }
        string.append("]");
        return String.valueOf(string);
    }
}