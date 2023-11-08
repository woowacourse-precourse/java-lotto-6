package lotto;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        duplicates(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 숫자는 6개 입니다.");
        }
    }

    private void duplicates(List<Integer> numbers){
        boolean hasDuplicates = numbers.stream().distinct().count() != numbers.size();
        if (hasDuplicates){
            throw new IllegalArgumentException("[ERROR] 로또 숫자 중복이 없습니다.");
        }
    }

    public List<Integer> getLottoNumber(){
        return this.numbers;
    }
    // TODO: 추가 기능 구현
}
