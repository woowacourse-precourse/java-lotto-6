package lotto.model;

import static lotto.model.LottoUtils.*;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoGame {
    private static final List<Integer> PRIZE_MONEY = List.of(0, 0,5000, 50000, 1500000, 30000000, 2000000000);
    private static final int PERCENTAGE = 100;
    List<Lotto> lottos = new ArrayList<>();

    public List<Integer> makeLottoNumbers() {
        List<Integer> lottoNumbers;
        lottoNumbers = Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUMBER,MAX_LOTTO_NUMBER,LOTTO_NUMBER_SIZE);
        return lottoNumbers;
    }

    public void purchaseLotto(Money money) {
        while (money.canPurchaseLotto()) {
            lottos.add(new Lotto(makeLottoNumbers()));
            money.purchaseLotto();
        }
    }

    public Map<Integer, Integer> countWinningLottoResult(WinningLotto winningLotto) {
        Map<Integer, Integer> winningLottoResult = Stream.of(FIRST_PRIZE,SECOND_PRIZE,THIRD_PRIZE,FOURTH_PRIZE,FIFTH_PRIZE)
                .collect(Collectors.toMap(
                        key -> key,
                        value -> 0
                ));
        for (Lotto lotto : lottos) {
            int result = winningLotto.judgePrize(lotto);
            if (winningLottoResult.containsKey(result)) {
                winningLottoResult.put(result, winningLottoResult.get(result) + 1);
            }
        }
        return winningLottoResult;
    }

    public long calculateEarnings(Map<Integer, Integer> winningLottoResult) {
        long earnings = 0;
        for (int prize = FIFTH_PRIZE; prize <= FIRST_PRIZE; prize++) {
            earnings += winningLottoResult.get(prize) * PRIZE_MONEY.get(prize - 1);
        }
        return earnings;
    }

    public double calculateEarningRate(Map<Integer, Integer> winningLottoResult, long cost) {
        return (double) calculateEarnings(winningLottoResult) * PERCENTAGE / (double) cost;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}