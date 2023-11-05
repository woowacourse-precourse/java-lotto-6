package lotto.service;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;
import static lotto.settings.LottoRange.MAX_VALUE;
import static lotto.settings.LottoRange.MIN_VALUE;
import static lotto.settings.LottoRange.SIZE;

import java.util.List;
import lotto.domain.Lotto;
import lotto.view.View;

public class LottoService {

    public static void createRandomNumber(int purchaseCount){
        while(purchaseCount>0){
            Lotto lotto = new Lotto(getRandomNumbers());

            String[] array = getRandomNumbers().stream().map(String::valueOf).toArray(String[]::new);
            String join = String.join(",", array);
            System.out.println("["+join+"]");
            purchaseCount --;
        }
    }

    private static List<Integer> getRandomNumbers() {
        return pickUniqueNumbersInRange(
                MIN_VALUE.getNumber(),
                MAX_VALUE.getNumber(),
                SIZE.getNumber());
    }

    public static void createWinningNumber(){
        View.requestWinningNumber();
        InputService.winningNumbers();

        View.requestBonusNumber();
        InputService.number();
    }
}
