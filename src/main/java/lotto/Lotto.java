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
            System.out.println("[ERROR] 로또 숫자는 6개 입니다.");
            throw new IllegalArgumentException();
        }
    }

    private void duplicates(List<Integer> numbers){
        boolean hasDuplicates = numbers.stream().distinct().count() != numbers.size();
        if (hasDuplicates){
            System.out.println("[ERROR] 로또 당첨 번호에는 중복이 없습니다.");
            throw new IllegalArgumentException();
        }
    }

    public List<Integer> getLottoNumber(){
        return this.numbers;
    }
    // TODO: 추가 기능 구현
}
