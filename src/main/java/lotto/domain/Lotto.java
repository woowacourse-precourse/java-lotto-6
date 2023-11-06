package lotto.domain;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        sortNumbers(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        checkNumOfLotto(numbers);
        checkRangeOfLotto(numbers);

    }

    // TODO: 추가 기능 구현
    // TODO: 숫자가 아닌 문자 입력, 1~45 사이의 숫자가 아닌 숫자 입력, 중복된 숫자 입력에 대한 예외처리 필요

    public void checkNumOfLotto(List<Integer> numbers){
        if(numbers.size() != 6){
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개만 입력해주세요.");
        }
    }

    private void checkRangeOfLotto(List<Integer> numbers) {
        if(numbers.stream().anyMatch(x -> x < 1 || x > 45)){
            throw new IllegalArgumentException("[ERROR] 1~45 사이의 숫자만 입력해주세요.");
        }
    }

    public void sortNumbers(List<Integer> numbers){
        Collections.sort(numbers);
    }

    @Override
    public String toString() {
        return numbers.toString();
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }

    public LottoValue match(Lotto winningLotto, int bonusNum) {
        int count = 0;
        for (Integer number : this.numbers) {
            if (winningLotto.getNumbers().contains(number)) {
                count++;
            }
        }
        if (count == 5 && this.numbers.contains(bonusNum)) {
            return LottoValue.FIVE_BONUS;
        }
        return LottoValue.getLottoValue(count);
    }
}
