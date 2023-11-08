package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;

import static lotto.domain.constants.DomainConstants.*;

public class WinningChecker {

    private final List<Lotto> myLottos;
    private final WinningNumbers winningNumbers;
    private final BonusNumber bonusNumber;

    public WinningChecker(List<Lotto> myLottos, WinningNumbers winningNumbers, BonusNumber bonusNumber) {
        this.myLottos = myLottos;
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public List<Integer> countWinningLottos() {
        List<Integer> matchedNumberCounts =
                myLottos.stream()
                        .map(lotto -> countMatchedNumbers(lotto))
                        .filter(matchedNumbersCount -> matchedNumbersCount >= WINNING_COUNT)
                        .collect(Collectors.toList());
        return countRanks(matchedNumberCounts);
    }

    private int countMatchedNumbers(Lotto lotto) {
        int matchedNumCount = winningNumbers.countMatchedNumber(lotto);
        return countMatchedBonusNumber(lotto.getNumbers(), matchedNumCount);
    }

    private int countMatchedBonusNumber(List<Integer> lottoNumbers, int matchedNumCount) {
        if (matchedNumCount == Rank.THIRD.getMatchedCount()) {
            if (bonusNumber.containBonusNumber(lottoNumbers)) {
                return matchedNumCount + Rank.SECOND.getIdentifier();
            }
        }
        return matchedNumCount;
    }

    private List<Integer> countRanks(List<Integer> matchedNumberCounts) {
        List<Integer> rankCounts = new ArrayList<>(Arrays.asList(0, 0, 0, 0, 0));
        matchedNumberCounts.forEach(matchedCount -> checkAndPlusCount(matchedCount, rankCounts));
        return rankCounts;
    }

    private void checkAndPlusCount(int matchedCount, List<Integer> rankCounts) {
        Map<Integer, Integer> matchedNumberWithRankIndex = matchingCountAndRankIndex();
        int rankIndex = matchedNumberWithRankIndex.get(matchedCount);
        plusOneCountOnRank(rankIndex, rankCounts);
    }

    private Map<Integer, Integer> matchingCountAndRankIndex() {
        return Arrays.stream(Rank.values())
                .collect(Collectors.toMap(Rank::getMatchedCount, Rank::getRankIndex));
    }

    private void plusOneCountOnRank(int rankIndex, List<Integer> rankCounts) {
        int count = rankCounts.get(rankIndex);
        rankCounts.set(rankIndex, ++count);
    }
}