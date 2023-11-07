package lotto;

import static lotto.Enum.Number.WINNING_MONEY;
import static lotto.Enum.OutputMessage.PRINT_CORRECTS;

import java.text.NumberFormat;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import lotto.Enum.OutputMessage;

public class Statistics {
    private final List<Integer> winningNumbers;
    private final int bonusNumber;
    private final List<Lotto> lottoNumbers;
    private final Map<Integer, Integer> countWinningLotto;

    public Statistics(List<Lotto> lottoNumbers, List<Integer> winningNumbers, int bonusNumber) {
        this.lottoNumbers = lottoNumbers;
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
        this.countWinningLotto = new LinkedHashMap<>();
        initCountCorrect();
    }

    private void initCountCorrect() {
        for (int i = 3; i <= 5; i++){
            countWinningLotto.put(i, 0);
        }
        countWinningLotto.put(7, 0);
        countWinningLotto.put(6, 0);
    }

    private int checkWinningNumbers(List<Integer> winningNumbers) {
        int count = 0;
        for (int number : this.winningNumbers) {
            if (winningNumbers.contains(number)) {
                count++;
            }
        }
        return count;
    }

    private void countWinningLotto() {
        for (Lotto lotto : this.lottoNumbers) {
            int total = checkWinningNumbers(lotto.getLottoNumbers());
            boolean ifBonusCorrect = checkIfBonusNumberExist(lotto.getLottoNumbers());
            if (total == 5 && ifBonusCorrect) {
                this.countWinningLotto.replace(total+2, this.countWinningLotto.get(total)+1);
            }
            if (total >= 3 && !ifBonusCorrect) {
                this.countWinningLotto.replace(total, this.countWinningLotto.get(total)+1);
            }
        }
    }

    public void printStatisticResult() {
        countWinningLotto();
        for (Entry<Integer, Integer> m : this.countWinningLotto.entrySet()) {
            int key = m.getKey();
            int value = m.getValue();
            int number = WINNING_MONEY.getMoneyByIndex(key);
            String message = PRINT_CORRECTS.getCorrectMessageByIndex(key);
            String commaNum = NumberFormat.getInstance().format(number);
            System.out.println(OutputMessage.printGuessedLotto(message, commaNum, value));
        }
    }

    public void calculateTotalRateOfReturn(int money) {
        double totalRateOfReturn;
        int totalWinningMoney = 0;
        for (Entry<Integer, Integer> m : this.countWinningLotto.entrySet()) {
            int key = m.getKey();
            if (key >= 3 && key <= 7) {
                int value = m.getValue();
                int number = WINNING_MONEY.getMoneyByIndex(key);
                totalWinningMoney += number * value;
            }
        }
        totalRateOfReturn = Math.round(totalWinningMoney / (float) money * 100 * 100) / 100.0;
        System.out.print(OutputMessage.printTotalRateOfReturn(totalRateOfReturn));
    }

    private boolean checkIfBonusNumberExist(List<Integer> winningNumbers) {
        for (int number : winningNumbers) {
            if (number == this.bonusNumber) {
                return true;
            }
        }
        return false;
    }
}