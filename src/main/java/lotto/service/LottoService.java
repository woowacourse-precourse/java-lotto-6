package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumMap;
import java.util.Map;

import lotto.model.Lotto;
import lotto.model.LottoResult;
import lotto.model.Rank;

public class LottoService {

    private static long purchaseAmount = 0;
    private static final int LOTTO_PRICE = 1000;
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;
    private static final int LOTTO_LENGTH = 6;

    public static List<Lotto> purchaseLotto(int money) {
        purchaseAmount = money;
        List<Lotto> lottos = new ArrayList<>();
        int numberOfLotto = money / LOTTO_PRICE;

        for (int i = 0; i < numberOfLotto; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER, LOTTO_LENGTH);
            Collections.sort(numbers);
            lottos.add(new Lotto(numbers));
        }
        return lottos;
    }

    public static LottoResult calculateResult(List<Lotto> lottos, Lotto winningLotto, int boonusNumber) {
        Map<Rank, Integer> result = new EnumMap<>(Rank.class);
        for (Lotto lotto : lottos) {
            int count = calculateMathCount(lotto.getNumbers(), winningLotto);
            boolean bonusContain = lotto.contains(boonusNumber);
            Rank rank = Rank.checkRank(count, bonusContain);
            result.put(rank, result.getOrDefault(rank, 0) + 1);
        }
        return new LottoResult(result);
    }

    public static double getTotalReturn(LottoResult lottoResult) {
        double sum = 0;

        for (Rank rank : lottoResult.getRankInfo().keySet()) {
            sum += (double) rank.getPrize() * lottoResult.getRankInfo().get(rank);
        }

        return (sum / purchaseAmount) * 100;
    }

    private static int calculateMathCount(List<Integer> lotto, Lotto winningLotto) {
        return (int) lotto.stream()
                .filter(winningLotto::contains)
                .count();
    }

}

