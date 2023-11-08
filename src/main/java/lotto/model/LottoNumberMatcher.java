package lotto.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoNumberMatcher {
    private static final int SUM_WINNING_NUMBER_SIZE_LOTTO_NUMBER_SIZE = 12;

    private static final int RATE_FACTOR = 100;

    private LotteryPrize firstPrize = LotteryPrize.FIRST;
    private LotteryPrize secondPrize = LotteryPrize.SECOND;
    private LotteryPrize thirdPrize = LotteryPrize.THIRD;
    private LotteryPrize fourthPrize = LotteryPrize.FOURTH;
    private LotteryPrize fifthPrize = LotteryPrize.FIFTH;

    public void checkWinning(List<Integer> myLottoNumbers, String winningNumber, String bonusNumber) {
            Set<Integer> winningNumberSet = winningNumberStringToIntegerSet(winningNumber);
            Set<Integer> bonusNumberSet = stringToIntegerSet(bonusNumber);

            bonusNumberSet.addAll(myLottoNumbers);
            winningNumberSet.addAll(myLottoNumbers);
            calculatorWinningTicketCount(winningNumberSet.size(),bonusNumberSet.size());
    }

    public void calculatorWinningTicketCount(int addMyLottoNumberWinningNumberSetSize, int addMyLottoNumberaddBonusNumberSetSize) {
        int rightNumbersCount = SUM_WINNING_NUMBER_SIZE_LOTTO_NUMBER_SIZE - addMyLottoNumberWinningNumberSetSize;
        if (rightNumbersCount == 6) {
            firstPrize.addCount();
        }
        if (rightNumbersCount == 5 && addMyLottoNumberaddBonusNumberSetSize == 6) {
            secondPrize.addCount();
        }
        if (rightNumbersCount == 5) {
            thirdPrize.addCount();
        }
        if (rightNumbersCount == 4) {
            fourthPrize.addCount();
        }
        if (rightNumbersCount == 3) {
            fifthPrize.addCount();
        }
    }

    public LotteryPrize getFirstPrize() {
        return firstPrize;
    }

    public LotteryPrize getSecondPrize() {
        return secondPrize;
    }

    public LotteryPrize getThirdPrize() {
        return thirdPrize;
    }

    public LotteryPrize getFourthPrize() {
        return fourthPrize;
    }

    public LotteryPrize getFifthPrize() {
        return fifthPrize;
    }

    public double calculateRateOfReturn(int purchaseAmount){
        double totalProfit = fifthPrize.getProfit() + fourthPrize.getProfit() + thirdPrize.getProfit() + secondPrize.getProfit() + firstPrize.getProfit();
        return  (totalProfit / purchaseAmount) * RATE_FACTOR;
    }

    public Set<Integer> winningNumberStringToIntegerSet(String inputNumber) {
        Set<Integer> numbersSet = new HashSet<>();
        String[] numbersArray = inputNumber.split(",");
        for (String number : numbersArray) {
            numbersSet.add(Integer.parseInt(number.trim()));
        }
        return numbersSet;
    }
    public Set<Integer> stringToIntegerSet(String inputNumber) {
        Set<Integer> numberSet = new HashSet<>();
        int number = Integer.parseInt(inputNumber);
        numberSet.add(number);
        return numberSet;
    }
}
