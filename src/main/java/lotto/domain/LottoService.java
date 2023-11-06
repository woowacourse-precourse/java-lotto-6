package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class LottoService {

    public static List<Lotto> generatePlayerLotto(Money money){
        List<Lotto> playerLotto = new ArrayList<>();
        int amount = money.getAmount();
        int lottoCount = calculateLottoCount(amount);
        for(int i = 0;i < lottoCount;i++){
            Lotto lotto = generateLotto();
            sortLotto(lotto);
            playerLotto.add(lotto);
        }
        return playerLotto;
    }

    private static List<Integer> generateSixNumbers(){
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    private static Lotto generateLotto(){
        List<Integer> sixNumbers = generateSixNumbers();
        return new Lotto(sixNumbers);
    }

    private static Integer calculateLottoCount(Integer amount){
        Integer moneyUnit = Money.MONEY_UNIT;
        return amount/moneyUnit;
    }

    private static void sortLotto(Lotto originLotto){
        List<Integer> originLottoNumbers = originLotto.getNumbers();
        Collections.sort(originLottoNumbers);
    }
}
