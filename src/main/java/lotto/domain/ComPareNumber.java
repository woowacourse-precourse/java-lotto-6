package lotto.domain;

import static lotto.constant.WinPriceMessage.*;


import java.util.Arrays;
import java.util.List;
import lotto.constant.WinPriceMessage;

public class ComPareNumber {
    private List<Integer> numbers;
    private List<Integer> randomNumbers;
    private int bonusNumber;
    private int moneySum;
    private List<Integer> winCount;

    public ComPareNumber(List<Integer> numbers, List<Integer> randomNumbers, int bonusNumber){
        this.numbers = numbers;
        this.randomNumbers = randomNumbers;
        this.bonusNumber = bonusNumber;
        this.moneySum = 0;
        this.winCount = Arrays.asList(0,0,0,0,0);
    }


    public void calculateResults() {
        long count = findWinNumber(this.numbers, this.randomNumbers, this.bonusNumber);
        winPrice(count, this.numbers, this.bonusNumber);

    }


    private long findWinNumber(List<Integer> numbers, List<Integer> randomNumbers,
            int bonusNumber) {
        return numbers.stream()
                .filter(randomNumbers::contains)
                .count();

    }

    private void winPrice(long count, List<Integer> numbers, int bonusNumber) {
        winFirst(count);
        winSecond(count, numbers, bonusNumber);
        winThird(count, numbers, bonusNumber);
        winFourth(count);
        winFifth(count);
    }

    private void winFirst(long count) {
        if (count == 6) {
            moneySum += First.getPrize();
            winCount.set(0, winCount.get(0) + 1);
        }
    }

    private void winSecond(long count, List<Integer> numbers, int bonusNumber) {
        if (count == 5 && checkBonusNumber(numbers, bonusNumber)) {
            moneySum += Second.getPrize();
            winCount.set(1, winCount.get(1) + 1);
        }
    }

    private void winThird(long count, List<Integer> numbers, int bonusNumber) {
        if (count == 5 && !checkBonusNumber(numbers, bonusNumber)) {
            moneySum += Third.getPrize();
            winCount.set(2, winCount.get(2) + 1);
        }
    }

    private void winFourth(long count) {
        if (count == 4) {
            moneySum += Fourth.getPrize();
            winCount.set(3, winCount.get(3) + 1);
        }
    }

    private void winFifth(long count) {
        if (count == 3) {
            moneySum += Fifth.getPrize();
            winCount.set(4, winCount.get(4) + 1);
        }
    }

    private boolean checkBonusNumber(List<Integer> numbers, int bonusNumber) {
        return numbers.contains(bonusNumber);
    }

    public int getMoneySum() {
        return moneySum;
    }

    public List<Integer> getWinCount() {
        return winCount;
    }


}
