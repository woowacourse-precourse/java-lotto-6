package lotto.service;

import static camp.nextstep.edu.missionutils.Randoms.*;
import static lotto.settings.LottoRange.*;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import lotto.settings.LottoRange;

public class LottoService {

    public static void createRandomNumber(int purchaseCount){
        while(purchaseCount>0){
            List<Integer> numbers = pickUniqueNumbersInRange(MIN_VALUE.getNumber(), MAX_VALUE.getNumber(),
                    SIZE.getNumber());
            String[] array = numbers.stream().map(String::valueOf).toArray(String[]::new);
            String join = String.join(",", array);
            System.out.println("["+join+"]");
            purchaseCount --;
        }
    }
}
