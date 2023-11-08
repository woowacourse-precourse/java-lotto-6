package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {

    private static final String ERROR_MESSAGE_HEADER = "[ERROR] ";
    private static final String ERROR_INVALID_SIZE = "로또 번호의 개수는 %d개입니다.";
    private static final String ERROR_REPETITION = "로또 번호의 중복이 존재합니다.";
    private static final int LOTTO_SIZE = 6;

    private final List<LottoNumber> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers.stream()
            .map(LottoNumber::new)
            .collect(Collectors.toList());
    }

    public List<Integer> getNumbers() {
        return numbers.stream()
            .map(LottoNumber::getLottoNumber)
            .collect(Collectors.toList());
    }

    public List<LottoNumber> getLottoNumbers() {
        return Collections.unmodifiableList(numbers);
    }

    public boolean contains(LottoNumber lottoNumber) {
        return numbers.contains(lottoNumber);
    }

    private void validate(List<Integer> numbers) {
        validateLottoSize(numbers);
        validateRepetitionOfLottoNumber(numbers);
    }

    private void validateLottoSize(List<Integer> numbers) {
        if (isInvalidSize(numbers)) {
            throw new IllegalArgumentException(
                ERROR_MESSAGE_HEADER + String.format(ERROR_INVALID_SIZE, LOTTO_SIZE));
        }
    }

    private void validateRepetitionOfLottoNumber(List<Integer> numbers) {
        if (hasRepetition(numbers)) {
            throw new IllegalArgumentException(ERROR_MESSAGE_HEADER + ERROR_REPETITION);
        }
    }

    private boolean isInvalidSize(List<Integer> numbers) {
        return numbers.size() != LOTTO_SIZE;
    }

    private boolean hasRepetition(List<Integer> numbers) {
        return numbers.size() != numbers.stream().distinct().count();
    }
}
