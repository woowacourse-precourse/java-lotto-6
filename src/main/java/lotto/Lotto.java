package lotto;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;
    private static final String errorRange = " 로또 번호는 1부터 45 사이의 숫자여야 합니다.";

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            System.out.println(numbers.size());
            throw new IllegalArgumentException("서로 다른 6개의 숫자를 입력해주세요.");
        }
        numberValidate(numbers);
    }
    private void numberValidate(List<Integer> numbers){
        for(int num : numbers){
            if(!(num >= 1 && num <= 45)){
                    throw new IllegalArgumentException(errorRange);
            }
        }
    }

}
