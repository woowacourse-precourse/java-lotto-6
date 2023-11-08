package lotto;

import message.ErrorMessage;
import model.LotteryNumbers;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        numbers = sort(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateRange(numbers);
        validateSameNumber(numbers);
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ErrorMessage.NUMBER_SIZE_IS_SIX);
        }
    }

    private void validateRange(List<Integer> numbers) {
        numbers.forEach((number) -> validateRange(number));
    }

    private void validateRange(Integer number) {
        if (!(1 <= number && number <= 45)) {
            throw new IllegalArgumentException(ErrorMessage.NUMBER_RANGE_ERROR);
        }
    }

    private void validateSameNumber(List<Integer> numbers) {
        Set<Integer> nonDuplicateNumbers = new HashSet<>(numbers);
        if (nonDuplicateNumbers.size() != 6) {
            throw new IllegalArgumentException(ErrorMessage.SAME_NUMBER_ERROR);
        }
    }

    public List<Integer> sort(List<Integer> numbers) {
        return numbers.stream().sorted().collect(Collectors.toList());
    }

    public boolean isContain(int number) {
        return numbers.contains(number);
    }

    public int getCorrectLottoNumber(LotteryNumbers lotteryNumbers) {
        return (int) numbers.stream().filter(number -> lotteryNumbers.isContain(number)).count();
    }

    @Override
    public String toString() { // toString메소드를 오버라이딩하고 있다. //  toString() 메소드는 자바의 Object 클래스에 정의된 메소드로, 모든 클래스는 이 메소드를 상속한다.
        return numbers.toString();
    }
}