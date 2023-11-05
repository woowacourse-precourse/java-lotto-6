package lotto;

import java.util.*;

public class Lotto {
    private final List<Integer> numbers;
    private int bonusNumber;
    private Map<Integer, Boolean> winningNumbers = new HashMap<>();
    private int winningCount = 0;
    private int winningMoney = 0;
    private final int LOTTO_SIZE = 6;

    private final int THREE_NUMBER_WINNING_MONEY = 5000;
    private final int FOUR_NUMBER_WINNING_MONEY = 50000;
    private final int FIVE_NUMBER_WINNING_MONEY = 1500000;
    private final int SIX_NUMBER_WINNING_MONEY = 2000000000;
    private final int FIVE_NUMBER_WINNING_MONEY_WITH_BONUS_NUMBER = 30000000;


    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public void setWinningNumbersAndBonusNumber(List<Integer> winningNumbers, int bonusNumber) {
        setBonusNumber(bonusNumber);
        setWinningNumbers(winningNumbers);
        judgeWinning();
    }

    private void judgeWinning() {
        switch (getWinningCount()) {
            case 3:
                winningMoney = THREE_NUMBER_WINNING_MONEY;
                break;
            case 4:
                winningMoney = FOUR_NUMBER_WINNING_MONEY;
                break;
            case 5:
                winningMoney = FIVE_NUMBER_WINNING_MONEY;
                break;
            case 6:
                winningMoney = SIX_NUMBER_WINNING_MONEY;
                break;
            default:
                break;
        }
        if (isWinningCountWithBonusNumber()) {
            winningMoney = FIVE_NUMBER_WINNING_MONEY_WITH_BONUS_NUMBER;
        }
    }

    public int getWinningMoney() {
        return winningMoney;
    }

    private Lotto setBonusNumber(int number) {
        this.bonusNumber = number;
        return this;
    }

    private Lotto setWinningNumbers(List<Integer> winningNumbers) {
        winningNumbers.forEach(number -> this.winningNumbers.put(number, true));
        addWinningCountWithoutBonusNumberMatching();
        return this;
    }

    public int getWinningCount() {
        if (winningCount == 5 && isWinningCountWithBonusNumber()) {
            return winningCount - 1;
        }
        return winningCount;
    }

    // 5개 번호가 일치하되 보너스 번호가 일치하지 않는 경우
    public boolean isWinningCountWithBonusNumber() {
        if (winningCount == 5 && numbers.contains(bonusNumber)) {
            return true;
        }
        return false;
    }

    private void addWinningCountWithoutBonusNumberMatching() {
        numbers.forEach(number -> {
            if (this.winningNumbers.containsKey(number) || this.bonusNumber == number) {
                winningCount++;
            }
        });
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException();
        }
        Set<Integer> uniqueNumbers = new HashSet<>();

        for (Integer number : numbers) {
            if (!uniqueNumbers.add(number)) {
                throw new IllegalArgumentException("[ERROR] 중복된 숫자가 있습니다.");
            }
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
