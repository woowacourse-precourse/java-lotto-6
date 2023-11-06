package lotto;

import java.util.List;
import java.util.StringJoiner;

public class Lotto {
    private static final int LOTTO_SIZE = 6;
    private final List<LottoNumber> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = convertToLottoNumber(numbers);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException();
        }
        if (isDuplicated(numbers)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isDuplicated(List<Integer> numbers) {
        int uniqueSize = numbers.stream().distinct().toList().size();

        return uniqueSize != LOTTO_SIZE;
    }

    private List<LottoNumber> convertToLottoNumber(List<Integer> numbers) {
        return numbers.stream()
                .map(LottoNumber::new)
                .toList();
    }

    public boolean isContains(LottoNumber number) {
        return numbers.contains(number);
    }

    public long getMatchCount(Lotto otherLotto) {
        return otherLotto.numbers.stream()
                .filter(this::isContains)
                .count();
    }

    public String getNumbersMessage() {
        List<LottoNumber> sortNumbers = getSortingNumbers();
        StringJoiner numberMessage = new StringJoiner(", ", "[", "]");
        sortNumbers.stream()
                .map(LottoNumber::getNumberMessage)
                .forEach(numberMessage::add);

        return numberMessage.toString();
    }

    private List<LottoNumber> getSortingNumbers() {
        return numbers.stream().sorted().toList();
    }
}
