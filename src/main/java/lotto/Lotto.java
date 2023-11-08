package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        final String RANGE_EXCEPTION_MESSAGE = "[ERROR] 로또 번호는 1~45 사이의 숫자여야합니다.";
        final String UNIQUE_NUMBER_EXCEPTION_MESSAGE ="[ERROR] 로또 번호는 중복되지 않아야합니다.";
        final String NUMBER_SIZE_EXCEPTION_MESSAGE = "[ERROR] 로또 번호는 6개입니다.";

        if (numbers.size() != 6) {
            throw new IllegalArgumentException(NUMBER_SIZE_EXCEPTION_MESSAGE);
        }
        if(new HashSet<Integer>(numbers).size() != numbers.size()){
            throw new IllegalArgumentException(UNIQUE_NUMBER_EXCEPTION_MESSAGE);
        }
        for(Integer i : numbers){
            if(i > 45 || i < 1){
                throw new IllegalArgumentException(RANGE_EXCEPTION_MESSAGE);
            }
        }
    }

    boolean isContainNumber(int number){
        return numbers.contains(number);
    }

    @Override
    public String toString() {
        List<Integer> temp = new ArrayList<>();
        temp.addAll(numbers);
        temp.sort(Comparator.naturalOrder());
        return temp.toString();
    }

}
