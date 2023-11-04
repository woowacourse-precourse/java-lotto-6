package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public final class NumberGenerator {
    public static List<Integer> generateNumbers() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return numbers;
    }

    public static Integer generateNumber(List<Integer> numbers){
        Integer number;
        do{
            number = Randoms.pickNumberInRange(1, 45);
        } while(!numbers.contains(number));
        return number;
    }
}
