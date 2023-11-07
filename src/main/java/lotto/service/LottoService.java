package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumMap;
import java.util.List;
import java.util.StringTokenizer;
import lotto.model.Lotties;
import lotto.model.Lotto;
import lotto.model.Rank;

public class LottoService {
    private static final int PRICE_PER_LOTTO = 1000;

    public Lotties buyLotties(int money) {
        validateMoney(money);
        return new Lotties(generateLotties(money));
    }

    private List<Lotto> generateLotties(int money) {
        List<Lotto> lotties = new ArrayList<>();
        for (int i = 0; i < money / PRICE_PER_LOTTO; i++) {
            lotties.add(generateLotto());
        }
        return lotties;
    }

    private Lotto generateLotto() {
        List<Integer> unsortedNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        List<Integer> sortNumbers = new ArrayList<>(unsortedNumbers);
        Collections.sort(sortNumbers);
        return new Lotto(sortNumbers);
    }

    private void validateMoney(int money) {
        if (money % PRICE_PER_LOTTO != 0) {
            throw new IllegalArgumentException();
        }
    }

    public Lotto convertLottoNumbers(String winningNumbers) {
        StringTokenizer stringTokenizer = new StringTokenizer(winningNumbers, ",");
        try {
            return convertToLotto(stringTokenizer);
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }

    public Lotto convertToLotto(StringTokenizer stringTokenizer) {
        List<Integer> numbers = new ArrayList<>();
        while (stringTokenizer.hasMoreTokens()) {
            numbers.add(Integer.parseInt(stringTokenizer.nextToken()));
        }
        return new Lotto(numbers);
    }

    public void validateBonusNumber(int bonusNumber) {
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException();
        }
    }

    public double getProfitability(EnumMap<Rank, Integer> rankCounts, int money) {
        double profitability = 0L;
        for (Rank rank : Rank.values()) {
            int winning = rank.getPrize();
            if (rank == Rank.MATCH_5_BONUS) {

            }
            int matchLottoCount = rankCounts.getOrDefault(rank, 0);
            profitability += matchLottoCount * winning;
        }
        return profitability / money * 100;
    }

    public EnumMap<Rank, Integer> getWinningStatistics(Lotties purchasedLotties, Lotto winningLotto, int bonusNumber) {
        EnumMap<Rank, Integer> rankCounts = new EnumMap<>(Rank.class);
        for (int i = 0; i < purchasedLotties.size(); i++) {
            Lotto lotto = purchasedLotties.get(i);
            Rank rank = lotto.determineRank(winningLotto, bonusNumber);
            if (rank != null) {
                int count = rankCounts.getOrDefault(rank, 0);
                rankCounts.put(rank, count + 1);
            }
        }
        return rankCounts;
    }
}
