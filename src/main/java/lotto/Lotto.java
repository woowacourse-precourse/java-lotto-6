package lotto;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    public static List<List<Integer>> numbers_list = new ArrayList<>();
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

    public static void lotto_random(int lotto_count){
        numbers_list = new ArrayList<>();
        for(int i  = 0; i<lotto_count; i++){
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            numbers_list.add(numbers);
        }
    }

    // TODO: 추가 기능 구현
}
