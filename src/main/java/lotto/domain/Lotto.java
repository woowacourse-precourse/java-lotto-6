package lotto.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        HashSet<Integer> hashSet = new HashSet<>(numbers);

        if (numbers.size() != 6 || hashSet.size() != numbers.size()) {
            throw new IllegalArgumentException();
        }
    }

    public int getMatchNumber(ArrayList<Integer> lottoNumbers) {
        return (int) lottoNumbers.stream().filter(number -> numbers.contains(number)).count();
    }

    public boolean isContain(int lottoNumber) {
        return numbers.contains(lottoNumber);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");

        numbers.stream().forEach(element -> {
            sb.append(element).append(", ");
        });
        sb.delete(sb.length() - 2, sb.length()).append("]");

        return sb.toString();
    }

}
