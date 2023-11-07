package lotto;

import static lotto.Enum.Number.SEVEN;
import static lotto.Enum.Number.THREE;
import static lotto.Enum.Number.WINNING_MONEY;
import static lotto.Enum.OutputMessage.PRINT_CORRECTS;
import static lotto.Enum.OutputMessage.TOTAL_RATE_OF_RETURN;

import java.text.NumberFormat;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import lotto.Enum.OutputMessage;

public class Statistics {
    private final List<Integer> inputNumbers;
    private final int bonusNumber;
    private final List<Lotto> lottos;
    private final Map<Integer, Integer> countWinningLotto;
    private int totalWinningMoney;

    public Statistics(List<Lotto> lottos, List<Integer> inputNumbers, int bonusNumber) {
        this.lottos = lottos;
        this.inputNumbers = inputNumbers;
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

    private int checkWinningNumbers(List<Integer> winningNumber) {
        int count = 0;
        for (int number : this.inputNumbers) {
            if (winningNumber.contains(number)) {
                count++;
            }
        }
        return count;
    }

    private void countWinningLotto() {
        for (Lotto lotto : this.lottos) {
            int total = checkWinningNumbers(lotto.getLottoNumbers());
            boolean ifBonusCorrect = checkIfBonusNumberExist(lotto.getLottoNumbers());
            if (total == 5 && ifBonusCorrect) {
                this.countWinningLotto.replace(total+2, this.countWinningLotto.get(total)+1);
            }
            if (total >= THREE.getNumber() && !ifBonusCorrect) {
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
        for (Entry<Integer, Integer> m : this.countWinningLotto.entrySet()) {
            int key = m.getKey();
            if (key >= THREE.getNumber() && key <= SEVEN.getNumber()) {
                int value = m.getValue();
                int number = WINNING_MONEY.getMoneyByIndex(key);
                totalWinningMoney += number * value;
            }
        }
        totalRateOfReturn = Math.round(totalWinningMoney / (float) money * 100 * 100) / 100.0;
        System.out.print(TOTAL_RATE_OF_RETURN.getMessage() + totalRateOfReturn + "%입니다.");
    }

    private boolean checkIfBonusNumberExist(List<Integer> winningNumber) {
        for (int number : winningNumber) {
            if (number == this.bonusNumber) {
                return true;
            }
        }
        return false;
    }
}