package lotto.domain;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static constant.MessageList.TOTAL_LOTTO_NUMBER_IN_LIST;

public class LottoWinningResult {
    private Map<Rank, Integer> prizeCount;
    private List<Integer> numberFromPlayer;
    private List<List<Integer>> quantityOfLotto;
    private int bonusNumber;
    private int correctCount;

    public LottoWinningResult(List<Integer> numberFromPlayer, int bonusNumber, List<List<Integer>> quantityOfLotto) {
        this.numberFromPlayer = sortList(numberFromPlayer);
        this.quantityOfLotto = quantityOfLotto;
        this.bonusNumber = bonusNumber;
        this.prizeCount = setPrizeCount();
    }

    private List<Integer> sortList(List<Integer> number) {
        return number.stream().sorted().collect(Collectors.toList());
    }

    private Map<Rank, Integer> setPrizeCount() {
        prizeCount = new LinkedHashMap<>();
        for (Rank rank : Rank.values()) {
            prizeCount.put(rank, 0);
        }
        return prizeCount;
    }

    public Map<Rank, Integer> getPrizeCount() {
        return prizeCount;
    }

    private void compareLotto(List<Integer> numberFromPlayer, List<Integer> lotto) {
        correctCount = 0;
        List<Integer> match = lotto.stream().filter(o -> numberFromPlayer.stream().anyMatch(Predicate.isEqual(o))).collect(Collectors.toList());
        for (int number : match) {
            correctCount++;
        }

        if (correctCount == Rank.FIRST.correctCount) {
            prizeCount.put(Rank.FIRST, prizeCount.get(Rank.FIRST) + 1);
        }
        if (correctCount == Rank.SECOND.correctCount && isSecondPlace(lotto)) {
            prizeCount.put(Rank.SECOND, prizeCount.get(Rank.SECOND) + 1);
        }
        if (correctCount == Rank.SECOND.correctCount && !isSecondPlace(lotto)) {
            prizeCount.put(Rank.THIRD, prizeCount.get(Rank.THIRD) + 1);
        }
        if (correctCount == Rank.FOURTH.correctCount) {
            prizeCount.put(Rank.FOURTH, prizeCount.get(Rank.FOURTH) + 1);
        }
        if (correctCount == Rank.FIFTH.correctCount) {
            prizeCount.put(Rank.FIFTH, prizeCount.get(Rank.FIFTH) + 1);
        }
    }

    private boolean isSecondPlace(List<Integer> lotto) {
        for (int i = 0; i < TOTAL_LOTTO_NUMBER_IN_LIST; i++) {
            if (lotto.get(i) == bonusNumber) {
                return true;
            }
        }
        return false;
    }

    public void compare(List<Integer> numberFromPlayer, List<List<Integer>> quantityOfLotto) {
        for (List<Integer> lotto : quantityOfLotto) {
            compareLotto(numberFromPlayer, lotto);
        }
    }

    public double calculateRateOfReturn(int purchaseAmount, int prizeMoney) {
        prizeMoney += prizeCount.get(Rank.FIRST) * Rank.FIRST.prizeMoney;
        prizeMoney += prizeCount.get(Rank.SECOND) * Rank.SECOND.prizeMoney;
        prizeMoney += prizeCount.get(Rank.THIRD) * Rank.THIRD.prizeMoney;
        prizeMoney += prizeCount.get(Rank.FOURTH) * Rank.FOURTH.prizeMoney;
        prizeMoney += prizeCount.get(Rank.FIFTH) * Rank.FIFTH.prizeMoney;

        return (double) prizeMoney / (double) purchaseAmount * 100;
    }
}
