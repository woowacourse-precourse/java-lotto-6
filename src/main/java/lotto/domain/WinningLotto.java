package lotto.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import lotto.message.ConsoleMessage;

public class WinningLotto {
    private final List<WinningNumber> winningNumbers;
    private static final int LOTTO_NUM_SIZE = 6;

    private WinningLotto(List<WinningNumber> winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    public static WinningLotto of(List<WinningNumber> winningNumbers, WinningNumber bonusNum) {
        List<WinningNumber> resultNumbers = new ArrayList<>(winningNumbers);
        resultNumbers.add(bonusNum);
        validateDuplicate(resultNumbers);
        return new WinningLotto(resultNumbers);
    }

    public int getSize() {
        return this.winningNumbers.size();
    }

    public List<WinningNumber> getWinnigNumbers() {
        return this.winningNumbers;
    }

    private static List<WinningNumber> validateDuplicate(List<WinningNumber> numbers) {
        List<Integer> numberList = numbers.stream().map(WinningNumber::getWinningNum).toList();
        HashSet hashSet = new HashSet(numberList);
        if (hashSet.size() != numbers.size()) {
            throw new IllegalArgumentException(ConsoleMessage.LOTTO_NUMBER_DUPLICATE_ERROR.getMessage());
        }
        return numbers;
    }

}
