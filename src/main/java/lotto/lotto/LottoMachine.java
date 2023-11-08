package lotto.lotto;

import static lotto.lotto.LottoValidator.*;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lotto.money.Money;

public class LottoMachine {

    private static final int LOTTO_PRICE = 1000;

    private LottoMachine() {
    }

    public static List<Lotto> buyLottos(Money money) {
        List<Lotto> lottos = new ArrayList<>();
        int lottoNum = money.divideBy(LOTTO_PRICE);
        for (int i = 0; i < lottoNum; i++) {
            List<Integer> randomNums
                    = Randoms.pickUniqueNumbersInRange(LOTTO_MIN_NUM, LOTTO_MAX_NUM, LOTTO_NUM_SIZE);
            randomNums = new ArrayList<>(randomNums);
            lottos.add(new Lotto(randomNums));
        }
        return lottos;
    }

    public static Map<Prize, Long> getResult(WinningNumber winningNumber, List<Lotto> lottos) {
        return lottos.stream()
                .map(lotto -> getPrize(winningNumber, lotto))
                .collect(Collectors.groupingBy(prize -> prize, Collectors.counting()));
    }

    public static Money receiveMoney(WinningNumber winningNumber, List<Lotto> lottos) {
        int amount = 0;
        for (Lotto lotto : lottos) {
            amount += getPrize(winningNumber, lotto).getPrizeMoney();
        }
        return new Money(amount);
    }

    private static Prize getPrize(WinningNumber winningNumber, Lotto lotto) {
        Long matchCount = winningNumber.countMatchingNumber(lotto);
        boolean isBonusMatch = winningNumber.checkBonusNumberMatch(lotto);
        return Prize.valueOf(matchCount, isBonusMatch);
    }

}
