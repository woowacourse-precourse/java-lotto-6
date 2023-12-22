package lotto.model;

import static lotto.constants.LottoDetails.LOTTO_SIZE;

import java.util.ArrayList;
import java.util.List;

public class LottoTicket {

    private final List<Integer> numbers;

    public LottoTicket(List<Integer> numbers) {
        this.numbers = new ArrayList<>(numbers);
        validateLottoSize(numbers);
        validateDistinctNumbers(numbers);
    }

    private void validateLottoSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException();
        }
    }

    private void validateDistinctNumbers(List<Integer> numbers) {
        if (numbers.stream().distinct().count() != numbers.size()) {
            throw new IllegalArgumentException();
        }
    }

    public boolean containsNumber(int number) {
        return numbers.contains(number);
    }

    public int match(LottoTicket lottoTicket) {
        return (int) numbers.stream().filter(lottoTicket::containsNumber).count();
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
