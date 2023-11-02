package lotto.Model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import lotto.View.ExceptionMessage;

public class RandomLottos {
    private static List<Integer> randomLottos;
    public static List<Integer> pickRandomNums(){
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(ExceptionMessage.MIN_NUM, ExceptionMessage.MAX_NUM, ExceptionMessage.LOTTO_LENGTH);
        Collections.sort(numbers);
        return numbers;
    }

    public static  List<List<Integer>> SetRandomLottos(int ticketsAmount){
        List<List<Integer>> totalNumbers = new ArrayList<>();
        for (int i = 0 ; i < ticketsAmount; i++){
            List<Integer> randomNumbers = pickRandomNums();
            totalNumbers.add(randomNumbers);
        }
        return totalNumbers;
    }
}
