package lotto.domain.lotto;

import lotto.exception.LottoNumDuplicateException;
import lotto.exception.LottoSizeException;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
//        if (numbers.size() != 6) {
//            throw new IllegalArgumentException();
//        }
        if (numbers.size() != 6) {
            throw new LottoSizeException();
        }
    }

    // TODO: 추가 기능 구현
    public boolean containBonusNum(int num) {
        return numbers.contains(num);
    }

    public boolean contains(int lottoNumber) {
        return numbers.contains(lottoNumber);
    }

    public int countSameNum(Lotto winningLotto) {
        return (int) numbers.stream()
                .filter(winningLotto::contains)
                .count();
    }

    public List<Integer> getLottoNums(){
        return numbers;
    }


}
