package lotto.domain;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static constant.MessageList.*;

public class LottoResult {
    private List<Integer> numberFromPlayer;
    private int bonusNumber;
    private List<List<Integer>> quantityOfLotto;
    private int correctCount;
    private Map<Rank, Integer> prizeCount;
    private int prizeMoney;

    public LottoResult(List<Integer> numberFromPlayer, int bonusNumber, List<List<Integer>> quantityOfLotto) {
        this.numberFromPlayer = numberFromPlayer;
        this.bonusNumber = bonusNumber;
        this.quantityOfLotto = quantityOfLotto;
        this.prizeCount = setPrizeCount();
        prizeMoney = ZERO;
    }

    private Map<Rank, Integer> setPrizeCount() {
        prizeCount = new LinkedHashMap<>();
        for (Rank rank : Rank.values()) {
            prizeCount.put(rank, ZERO);
        }
        return prizeCount;
    }

    private void compareLotto(List<Integer> lotto) {
        correctCount = ZERO;
        List<Integer> match = lotto.stream().filter(o -> numberFromPlayer.stream().anyMatch(Predicate.isEqual(o))).collect(Collectors.toList());
        for (int matchNumber : match) {
            correctCount++;
        }

        if (correctCount == Rank.FIRST.correctCount) {
            prizeCount.put(Rank.FIRST, prizeCount.get(Rank.FIRST) + COUNT);
        }
        if (correctCount == Rank.SECOND.correctCount && isSecondPlace(lotto)) {
            prizeCount.put(Rank.SECOND, prizeCount.get(Rank.SECOND) + COUNT);
        }
        if (correctCount == Rank.SECOND.correctCount && !isSecondPlace(lotto)) {
            prizeCount.put(Rank.THIRD, prizeCount.get(Rank.THIRD) + COUNT);
        }
        if (correctCount == Rank.FOURTH.correctCount) {
            prizeCount.put(Rank.FOURTH, prizeCount.get(Rank.FOURTH) + COUNT);
        }
        if (correctCount == Rank.FIFTH.correctCount) {
            prizeCount.put(Rank.FIFTH, prizeCount.get(Rank.FIFTH) + COUNT);
        }
    }

    private boolean isSecondPlace(List<Integer> lotto) {
        for (int i = 0; i < TOTAL_LOTTO_SIZE; i++) {
            if (lotto.get(i) == bonusNumber) {
                return true;
            }
        }
        return false;
    }

    public Map<Rank, Integer> compare() {
        for (List<Integer> lotto : quantityOfLotto) {
            compareLotto(lotto);
        }
        return prizeCount;
    }

    private int calculatePrizeMoney() {
        prizeMoney += prizeCount.get(Rank.FIRST) * Rank.FIRST.prizeMoney;
        prizeMoney += prizeCount.get(Rank.SECOND) * Rank.SECOND.prizeMoney;
        prizeMoney += prizeCount.get(Rank.THIRD) * Rank.THIRD.prizeMoney;
        prizeMoney += prizeCount.get(Rank.FOURTH) * Rank.FOURTH.prizeMoney;
        prizeMoney += prizeCount.get(Rank.FIFTH) * Rank.FIFTH.prizeMoney;

        return prizeMoney;
    }

    public double getRateOfReturn(int purchaseAmount) {
        prizeMoney = calculatePrizeMoney();
        return (double) prizeMoney / (double) purchaseAmount * PERCENTAGE;
    }
}
