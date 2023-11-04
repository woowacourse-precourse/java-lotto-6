package lotto.service;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;
import static lotto.settings.LottoRange.MAX_VALUE;
import static lotto.settings.LottoRange.MIN_VALUE;
import static lotto.settings.LottoRange.SIZE;

import java.util.List;
import lotto.view.View;

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

    public static void createWinningNumber(int purchaseCount){
        View.requestWinningNumber();
        InputService.winningNumbers();

        View.requestBonusNumber();
        InputService.number();
    }
}
