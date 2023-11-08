package lotto.model;

import java.util.List;

import static lotto.util.MagicNumbers.MIN_NUMBER;
import static lotto.util.MagicNumbers.MAX_NUMBER;
import static lotto.util.MagicNumbers.LOTTO_COUNT;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    //여기에 validate 이 있어야할 이유가 있나? 따로 class 하는게 나을 것 같은데
    private void validate(List<Integer> numbers) {
        if (numbers.size() != LOTTO_COUNT) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 총 6개여야 합니다.");
        }//코드의 형태를 유지해야하나 싶어 method 를 따로 생성하지 않음
        for(int number: numbers){
            if(MIN_NUMBER > number || number > MAX_NUMBER)
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
        checkDuplicate(numbers);
    }


    private static void checkDuplicate(List<Integer> numbers){
        if(numbers.stream().distinct().count() != LOTTO_COUNT){
            throw new IllegalArgumentException("[ERROR] 숫자가 중복되지 않아야합니다.");
        }
    }

    public boolean contains(int number) {
        return numbers.contains(number);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}

