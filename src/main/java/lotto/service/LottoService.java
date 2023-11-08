package lotto.service;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;
import static lotto.constants.Constants.INCREMENT_BY_ONE;
import static lotto.constants.Constants.INITIAL_COUNT;
import static lotto.constants.Constants.INITIAL_VALUE_ZERO;
import static lotto.constants.Constants.LOTTO_NUMBER_COUNT;
import static lotto.constants.Constants.MAX_LOTTO_NUMBER;
import static lotto.constants.Constants.MIN_LOTTO_NUMBER;
import static lotto.constants.Constants.MIN_PURCHASE_AMOUNT;
import static lotto.constants.Constants.PERCENTAGE_MULTIPLIER;
import static lotto.constants.Constants.START_INDEX;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.PurchaseAmount;
import lotto.domain.Rank;
import lotto.domain.WinningLotto;

public class LottoService {

    public ArrayList<Lotto> generateLotto(PurchaseAmount purchaseAmount) {
        ArrayList<Lotto> lottos = new ArrayList<>();
        int count = purchaseAmount.getMoney() / MIN_PURCHASE_AMOUNT;

        for (int i = START_INDEX; i < count; i++) {
            Lotto lotto = new Lotto(generateLottoNumbers());
            lottos.add(lotto);
        }

        return lottos;
    }

    public Map<Rank, Integer> generateLottoStatistics(WinningLotto winningLotto, ArrayList<Lotto> lottos) {
        Map<Rank, Integer> rankCount = new HashMap<>();

        for (Lotto lotto : lottos) {
            Rank rank = winningLotto.calculateRank(lotto);
            rankCount.put(rank, rankCount.getOrDefault(rank, INITIAL_COUNT) + INCREMENT_BY_ONE);
        }

        return rankCount;
    }

    public double calculateProfitRate(Map<Rank, Integer> rankCount, PurchaseAmount purchaseAmount) {
        int totalWinningAmount = INITIAL_VALUE_ZERO;

        for (Rank rank : Rank.values()) {
            totalWinningAmount += rank.getWinningAmount() * rankCount.getOrDefault(rank, INITIAL_COUNT);
        }

        return (double) totalWinningAmount / (double) purchaseAmount.getMoney() * PERCENTAGE_MULTIPLIER;
    }

    private List<Integer> generateLottoNumbers() {
        ArrayList<Integer> numbers = new ArrayList<>(pickUniqueNumbersInRange(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER, LOTTO_NUMBER_COUNT));
        Collections.sort(numbers);
        return numbers;
    }
}