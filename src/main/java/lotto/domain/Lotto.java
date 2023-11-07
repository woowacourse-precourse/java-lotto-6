package lotto.domain;

import lotto.util.Validator;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 한 장의 로또를 표현하는 클래스.
 */
public class Lotto {
    private final List<Integer> numbers;

    /**
     * Lotto 객체를 생성한다.
     * @param numbers 로또 번호가 담긴 리스트. 번호의 개수는 6개여야 한다.
     *                번호에 중복이 없어야 한다. 각 번호의 범위는 1~45에 속해야 한다.
     */
    public Lotto(List<Integer> numbers) {
        this.numbers = numbers;
        validate(numbers);
        Collections.sort(numbers);
    }

    private void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplicate(numbers);
        validateRange(numbers);
    }

    private void validateSize(List<Integer> numbers) {
        Validator.validateNumOfWinningNumbers(numbers);
    }

    private void validateDuplicate(List<Integer> numbers) {
        Validator.validateDuplicate(numbers);
    }

    private void validateRange(List<Integer> numbers) {
        Validator.validateRangeOfWinningNumbers(numbers);
    }

    /**
     * 다른 로또와 비교해서 몇 개의 번호가 일치하는지 산출한다.
     * @param other 비교할 로또.
     * @return 일치하는 로또 번호의 개수.
     */
    public int compare(Lotto other) {
        Set<Integer> numberSetOfOther = new HashSet<>(other.numbers);
        int numOfMatches = 0;
        for (Integer number : this.numbers) {
            numOfMatches += getOneIfMatches(numberSetOfOther.contains(number));
        }
        return numOfMatches;
    }

    private int getOneIfMatches(boolean matches) {
        if (matches) {
            return 1;
        }
        return 0;
    }

    /**
     * 이 Lotto 객체가 파라미터로 제시된 number를 포함하는지 여부를 판단한다.
     * @param number 포함하는지 확인할 정수.
     * @return 객체가 number를 포함할 경우 true, 그렇지 않다면 false.
     */
    public boolean contains(Integer number) {
        return this.numbers.contains(number);
    }

    /**
     * @param obj 비교할 객체.
     * @return 이 객체가 포함하는 숫자들과 obj가 포함하는 숫자들이 모두 일치하는 경우 true,
     *         하나라도 일치하지 않는 경우 false.
     */
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Lotto compareTarget)) {
            return false;
        }
        for (Integer number : this.numbers) {
            if (!compareTarget.contains(number)) {
                return false;
            }
        }
        return true;
    }

    /**
     * @return 이 객체가 포함하는 모든 번호의 합.
     */
    @Override
    public int hashCode() {
        return this.numbers.stream().reduce(0, Integer::sum);
    }

    /**
     * 객체를 표현한 문자열을 반환한다. 문자열은 다음과 같은 형태를 띤다.
     * "[번호1, 번호2, 번호3, 번호4, 번호5, 번호6]"
     * 예시) 13, 25, 26, 37, 38, 45를 포함할 경우,
     * 문자열 "[13, 25, 26, 37, 38, 45]"를 반환한다.
     * 문자열 내 표시된 번호는 오름차순으로 정렬된다.
     * @return 위에 제시된 방법대로 생성된 문자열.
     */
    @Override
    public String toString() {
        List<String> convertedToStrings = this.numbers.stream().map(String::valueOf).toList();
        String commaJoined = String.join(", ", convertedToStrings);
        return "[" + commaJoined + "]";
    }
}
