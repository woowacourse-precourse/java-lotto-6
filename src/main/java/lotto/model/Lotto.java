package lotto.model;

import java.util.List;

public class Lotto {
    private static final String ERRORHEAD ="[ERROR]" ;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }
    public static Lotto newInstance(List<Integer> numbers){
        return new Lotto(numbers);
    }

    public Integer matchUp(Lotto givenLotto) {
        return (int)numbers.stream()
                .filter(givenLotto::haveSameBall)
                .count();
    }
    public boolean haveSameBall(Integer number) {
        return this.numbers.contains(number);
    }
    public List<Integer> getNumbersForMessage() {
        return numbers;
    }
    public void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateRange(numbers);
        validateDuplicate(numbers);
    }
    public void validateSize(List<Integer> numbers) {
        if (numbers.size() != 6) throw new IllegalArgumentException(ERRORHEAD);
    }

    public void validateDuplicate(List<Integer> numbers) {
        long distinctCount = numbers.stream().distinct().count();
        if (numbers.size() != distinctCount) {
            throw new IllegalArgumentException(ERRORHEAD);
        }
    }

    public  static void validateRange(List<Integer> numbers) {
        numbers.stream()
                .filter(number -> number < 1 || number > 45)
                .findAny()
                .ifPresent(number -> {
                    throw new IllegalArgumentException(ERRORHEAD);
                });
    }
}
