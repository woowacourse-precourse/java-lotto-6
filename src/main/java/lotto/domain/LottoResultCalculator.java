package lotto.domain;

import static lotto.constant.WinPriceMessage.*;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoResultCalculator {
    private List<Integer> numbers;
    private List<Integer> randomNumbers;
    private int bonusNumber;
    private long moneySum;
    private List<Integer> winCount;

    public LottoResultCalculator(List<Integer> numbers, List<Integer> randomNumbers, int bonusNumber){
        this.numbers = numbers;
        this.randomNumbers = randomNumbers;
        this.bonusNumber = bonusNumber;
        this.moneySum = 0;
        this.winCount = Arrays.asList(0,0,0,0,0);
    }


    public LottoResultCalculator calculateResult() {
        long matchingNumberCount = countMatchingNumbers(this.numbers, this.randomNumbers);
        calculatePrizes(matchingNumberCount, this.numbers, this.bonusNumber);
        return this;
    }


    private long countMatchingNumbers(List<Integer> numbers, List<Integer> randomNumbers) {
        return numbers.stream()
                .filter(randomNumbers::contains)
                .count();

    }

    private void calculatePrizes(long matchingNumberCount, List<Integer> numbers, int bonusNumber) {
        awardFirstPrize(matchingNumberCount);
        awardSecondPrize(matchingNumberCount, numbers, bonusNumber);
        awardThirdPrize(matchingNumberCount, numbers, bonusNumber);
        awardFourthPrize(matchingNumberCount);
        awardFifthPrize(matchingNumberCount);
    }

    private void awardFirstPrize(long count) {
        if (count == 6) {
            moneySum += First.getPrize();
            winCount.set(0, winCount.get(0) + 1);
        }
    }

    private void awardSecondPrize(long count, List<Integer> numbers, int bonusNumber) {
        if (count == 5 && containsBonusNumber(numbers, bonusNumber)) {
            moneySum += Second.getPrize();
            winCount.set(1, winCount.get(1) + 1);
        }
    }

    private void awardThirdPrize(long count, List<Integer> numbers, int bonusNumber) {
        if (count == 5 && !containsBonusNumber(numbers, bonusNumber)) {
            moneySum += Third.getPrize();
            winCount.set(2, winCount.get(2) + 1);
        }
    }

    private void awardFourthPrize(long count) {
        if (count == 4) {
            moneySum += Fourth.getPrize();
            winCount.set(3, winCount.get(3) + 1);
        }
    }

    private void awardFifthPrize(long count) {
        if (count == 3) {
            moneySum += Fifth.getPrize();
            winCount.set(4, winCount.get(4) + 1);
        }
    }

    private boolean containsBonusNumber(List<Integer> numbers, int bonusNumber) {
        return numbers.contains(bonusNumber);
    }

    public long getMoneySum() {
        return moneySum;
    }

    public List<Integer> getWinCount() {
        return winCount;
    }

    public static List<LottoResultCalculator> generateResultCalculators(List<Integer> numbers, int bonusNumber, List<List<Integer>> allRandomNumbers) {
        return allRandomNumbers.stream()
                .map(randomNumbers -> new LottoResultCalculator(numbers, randomNumbers, bonusNumber).calculateResult())
                .collect(Collectors.toList());
    }


}