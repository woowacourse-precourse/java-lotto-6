package lotto.model;

import java.util.ArrayList;
import java.util.List;

public final class Lotto {
    private static final String DUPLICATED_LOTTO_NUMBER_EXCEPTION = "로또에 중복된 숫자가 있습니다.";
    private static final String LOTTO_SIZE_EXCEPTION = "로또는 %d개의 숫자로 이루어져야 합니다.";
    private static final int LOTTO_SIZE = 6;

    private final List<LottoNumber> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = toLottoNumbers(numbers);
    }

    private void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplicated(numbers);
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            String exceptionMessage = String.format(LOTTO_SIZE_EXCEPTION, LOTTO_SIZE);
            throw new IllegalArgumentException(exceptionMessage);
        }
    }

    private void validateDuplicated(List<Integer> numbers) {
        if (isDuplicated(numbers)) {
            throw new IllegalArgumentException(DUPLICATED_LOTTO_NUMBER_EXCEPTION);
        }
    }

    private boolean isDuplicated(List<Integer> numbers) {
        return numbers.stream()
                .distinct()
                .count() != LOTTO_SIZE;
    }

    private List<LottoNumber> toLottoNumbers(List<Integer> numbers) {
        return numbers.stream()
                .map(LottoNumber::from)
                .toList();
    }

    public static Lotto from(List<Integer> numbers) {
        return new Lotto(numbers);
    }

    public static Lotto create(NumberGenerator numberGenerator) {
        List<Integer> uniqueNumbers = numberGenerator.generateUniqueNumbers(LottoNumber.MIN_NUMBER,
                LottoNumber.MAX_NUMBER,
                LOTTO_SIZE);
        return new Lotto(uniqueNumbers);
    }

    public LottoPrize calculatePrize(WinningTicket winningTicket) {
        int matchCount = getMatchCount(winningTicket);
        boolean hasBonusNumber = hasBonusNumber(winningTicket);

        return LottoPrize.of(matchCount, hasBonusNumber);
    }

    private boolean hasBonusNumber(WinningTicket winningTicket) {
        return numbers.stream()
                .anyMatch(winningTicket::containsBonusNumber);
    }

    private int getMatchCount(WinningTicket winningTicket) {
        return (int) numbers.stream()
                .filter(winningTicket::containsLottoNumber)
                .count();
    }

    public boolean contains(LottoNumber number) {
        return numbers.contains(number);
    }

    public List<LottoNumber> getNumbers() {
        return new ArrayList<>(numbers);
    }
}
