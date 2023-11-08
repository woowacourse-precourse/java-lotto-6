package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현

    public static List<Integer> makeLotto(){

        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        Collections.sort(numbers);

        return numbers;
    }


    public String toString(){

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        for(int i=0;i<numbers.size() - 1;i++){
            stringBuilder.append(numbers.get(i)).append(", ");
        }
        stringBuilder.append(numbers.get(numbers.size()-1)).append("]");

        return stringBuilder.toString();
    }
}
