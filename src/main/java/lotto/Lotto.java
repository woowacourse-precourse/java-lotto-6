package lotto;
import camp.nextstep.edu.missionutils.Randoms;
import static lotto.Input.*;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

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

    public static void dup_check(List<Integer> numbers){
        Set<Integer> dup = new LinkedHashSet<>();
        for(int i : numbers){
            dup.add(i);
        }
        if(dup.size() != 6){
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
