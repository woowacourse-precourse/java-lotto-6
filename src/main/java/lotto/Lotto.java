package lotto;

import lotto.validation.LottoValidation;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import static constant.LottoValue.LOTTO_SIZE;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        LottoValidation lottoValidation = new LottoValidation();
        lottoValidation.lottoValidate(numbers);
    }

    // TODO: 추가 기능 구현
    public void printLotto(){
        System.out.print("[");
        for (int i = 0; i < LOTTO_SIZE.value(); i++) {
            System.out.print(numbers.get(i));
            if(i!=LOTTO_SIZE.value()-1) System.out.print(", ");
        }
        System.out.println("]");
    }

    public boolean containSame(int i){
        if(numbers.contains(i)) {
            return true;
        }
        return false;
    }


    public int match(Lotto winningLotto){
        List<Integer> winningNumbers = new ArrayList<>(winningLotto.getList());
        return numbers.stream()
                .filter(o -> winningNumbers.stream().anyMatch(Predicate.isEqual(o)))
                .toList().size();
    }

    public List<Integer> getList(){
        return numbers;
    }


}
