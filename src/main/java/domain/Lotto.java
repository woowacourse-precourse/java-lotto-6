package domain;

import static config.ErrorMessage.*;
import static config.LottoConst.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.HashSet;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateSize(Removeduplication(numbers));
        this.numbers = numbers;
    }

    private List<Integer> Removeduplication(List<Integer> numbers) {
        Set<Integer> lottoSet = new HashSet<>(numbers);
        return new ArrayList<>(lottoSet);
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE.getNumber()) {
            throw new IllegalArgumentException(LOTTO.getMessage());
        }
    }

    public boolean containsNumber(Integer number) {
        return numbers.contains(number);
    }

    @Override
    public String toString() {
        return numbers.toString();
    }

    public int compareLotto(Lotto lotto) {
        Set<Integer> orignLotto = new HashSet<>(numbers);
        int count = COUNT_INIT.getNumber();
        for(Integer number : lotto.numbers) {
            if(orignLotto.contains(number)) {
                count++;
            }
        }
        return count;
    }

}
