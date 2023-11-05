package lotto.domain;

import static lotto.Exception.ExceptionMessage.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.lang.Integer;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateLottoLength(numbers);
        validateDuplicationNumber(numbers);
        this.numbers = numbers;
    }

    public List<Integer> sortLottoNumber() {
        return numbers.stream().sorted().toList();
    }

    public int getMatchCount(Lotto lotto) {
        List<Integer> myLottoNumbers = new ArrayList<>(this.numbers);
        myLottoNumbers.retainAll(lotto.sortLottoNumber());
        return myLottoNumbers.size();
    }

    public boolean bonusNumberContains(int bonusNumber){
        return numbers.contains(bonusNumber);
    }

    private void validateLottoLength(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private void validateDuplicationNumber(List<Integer> numbers) {
        if (new HashSet<>(numbers).size() != numbers.size()) {
            throw new IllegalArgumentException(DUPLICATION_LOTTO_NUMBER.getExceptionMessage());
        }
    }


}
