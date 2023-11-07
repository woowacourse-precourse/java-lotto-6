package lotto;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        checkNumberSize(numbers);
        circulationForDuplication(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("6개의 숫자를 입력하시오");
        }
    }

    private void checkNumberSize(List<Integer> numbers){
        for(int number : numbers){
            if(number<1||number>45){
                throw new IllegalArgumentException("범위 내 숫자를 입력하시오");
            }
        }
    }

    private void circulationForDuplication(List<Integer> numbers){
        for(int number : numbers){
            checkDuplication(number, numbers);
        }
    }

    private void checkDuplication(int number, List<Integer> criteriaNumbers){
        int check = 0;
        for(int criteriaNumber : criteriaNumbers){
            if(criteriaNumber == number){
                check ++;
            }
        }
        if(check != 1){
            throw new IllegalArgumentException("중복된 숫자가 있습니다");
        }
    }
}
