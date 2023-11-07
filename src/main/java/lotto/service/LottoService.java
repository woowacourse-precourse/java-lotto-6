package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.Rank;

public class LottoService {
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;
    private static final int LOTTO_COUNT = 6;

    private static final Map<Rank, Integer> lottoResult = new HashMap<>();
    private static final LottoService instance = new LottoService();
    public static LottoService getInstance() {
        return instance;
    }

    private LottoService() {
        for (Rank rank : Rank.values()) {
            lottoResult.put(rank, 0);
        }
    }



    public List<Lotto> getLottoNumbers(int buyAmount) {
        List<Lotto> userLottos = new ArrayList<>();
        for (int i = 0; i < buyAmount; ++i) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER, LOTTO_COUNT);
            Collections.sort(numbers);
            Lotto lotto = new Lotto(numbers);
            userLottos.add(lotto);
        }
        return userLottos;
    }

    public Map<Rank, Integer> calculateResult(List<Lotto> userLottos, List<Integer> winningNumber, int bonusNumber) {


        for (Lotto userLotto : userLottos) {
            int matchNumberCount = getMatchNumberCount(userLotto.getNumbers(), winningNumber);
            boolean isMatchBonusNumber = getBonusNumberMatch(userLotto.getNumbers(), bonusNumber);
            getRank(matchNumberCount, isMatchBonusNumber);
        }
        return lottoResult;
    }

    private void getRank(int matchNumberCount, boolean isMatchBonusNumber) {
        for (Rank rank : Rank.values()) {
            if (rank.matchCount == matchNumberCount) {
                checkSecondOrThird(rank, isMatchBonusNumber);
                checkRemain(rank);
            }
        }
    }

    private void checkRemain(Rank rank) {
        if (rank.matchCount != 5) {
            addResult(rank);
        }
    }

    private void checkSecondOrThird(Rank rank, boolean isMatchBonusNumber) {
        if (rank.matchCount == 5 && rank.isMatchBonusNumber == isMatchBonusNumber) {
            addResult(rank);
        }
    }

    private void addResult(Rank rank) {
        lottoResult.put(rank, lottoResult.get(rank) + 1);
    }

    private boolean getBonusNumberMatch(List<Integer> numbers, int bonusNumber) {
        return numbers.contains(bonusNumber);
    }

    private int getMatchNumberCount(List<Integer> userLotto, List<Integer> winningNumber) {
        int matchNumberCount = 0;
        for (Integer lotto : userLotto) {
            if (winningNumber.contains(lotto)) {
                ++matchNumberCount;
            }
        }
        return matchNumberCount;
    }

    public int calculateRevenueRate(int buyAmount, Map<Rank, Integer> lottoResult) {
        int totalRevenue = 0;
        Iterator<Rank> keys = lottoResult.keySet().iterator();
        while (keys.hasNext()) {
            Rank rank = keys.next();
            totalRevenue += lottoResult.get(rank) * rank.reward;
        }
        return totalRevenue / buyAmount * 1000;
    }
}
