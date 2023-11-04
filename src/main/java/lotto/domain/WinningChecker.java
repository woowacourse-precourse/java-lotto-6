package lotto.domain;

import java.util.*;

public class WinningChecker {

    private final List<Lotto> myLottos;
    private final List<Integer> winningNumbers;
    private final int bonusNumber;

    public WinningChecker(List<Lotto> myLottos, List<Integer> winningNumbers, int bonusNumber) {
        this.myLottos = myLottos;
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public List<Integer> countWinningLottos() {
        List<Integer> matchedNumberCounts = new ArrayList<>();
        for (Lotto lotto : myLottos) {
            List<Integer> lottoNumbers = lotto.getNumbers();
            int matchedNumCount = countMatchedNumber(lottoNumbers);
            matchedNumCount = countMatchedBonusNumber(lottoNumbers, matchedNumCount);

            if (matchedNumCount >= Constants.WINNING_COUNT) {
                matchedNumberCounts.add(matchedNumCount);
            }
        }
        return countRanks(matchedNumberCounts);
    }

    private int countMatchedNumber(List<Integer> lottoNumbers) {
        return (int) lottoNumbers.stream()
                .filter(winningNumbers::contains)
                .distinct()
                .count();
    }

    private int countMatchedBonusNumber(List<Integer> lottoNumbers, int matchedNumCount) {
        if (matchedNumCount == Constants.MATCHED_FIVE_NUMBERS) {
            if (lottoNumbers.contains(bonusNumber)) {
                matchedNumCount += Constants.SECOND_RANK_IDENTIFIER;
            }
        }
        return matchedNumCount;
    }

    private List<Integer> countRanks(List<Integer> matchedNumberCounts) {
        List<Integer> rankCounts = new ArrayList<>(Arrays.asList(0, 0, 0, 0, 0));
        for (int count : matchedNumberCounts) {
            checkAndPlusCount(count, rankCounts);
        }
        return rankCounts;
    }

    private void checkAndPlusCount(int count, List<Integer> rankCounts) {
        Map<Integer, Integer> rankMapping = createRankMapping();
        int rank = rankMapping.get(count);
        plusOneCountOnRank(rank, rankCounts);
    }

    private Map<Integer, Integer> createRankMapping() {
        Map<Integer, Integer> rankWithMatchedCount = new HashMap<>();
        rankWithMatchedCount.put(Constants.MATCHED_SIX, Constants.FIRST_RANK);
        rankWithMatchedCount.put(Constants.MATCHED_FIVE_AND_BONUS, Constants.SECOND_RANK);
        rankWithMatchedCount.put(Constants.MATCHED_FIVE, Constants.THIRD_RANK);
        rankWithMatchedCount.put(Constants.MATCHED_FOUR, Constants.FOURTH_RANK);
        rankWithMatchedCount.put(Constants.MATCHED_THREE, Constants.FIFTH_RANK);
        return rankWithMatchedCount;
    }

    private void plusOneCountOnRank(int rank, List<Integer> rankCounts) {
        int count = rankCounts.get(rank);
        rankCounts.set(rank, ++count);
    }
}