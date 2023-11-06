package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class Jackpot {
    public static final String NUMBER_PATTERN = "\\d+";

    private final List<Integer> winningNumbers;
    private final int bonusNumber;

    public Jackpot(String inputWinningNumbers, String inputBonusNumber) {
        String[] splitWinningNumbers = getSplitWinningNumbers(inputWinningNumbers);

        List<Integer> winningNumbers = new ArrayList<>();
        addWinningNumber(splitWinningNumbers, winningNumbers);
        this.winningNumbers = winningNumbers;

        validateNumeric(inputBonusNumber);
        this.bonusNumber = Integer.parseInt(inputBonusNumber);
    }

    private static String[] getSplitWinningNumbers(String inputWinningNumbers) {
        String[] splitWinningNumbers = inputWinningNumbers.split(",");
        validateWinningNumbersSize(splitWinningNumbers);
        return splitWinningNumbers;
    }

    private static void addWinningNumber(String[] splitWinningNumbers, List<Integer> winningNumbers) {
        for (String number : splitWinningNumbers) {
            validateNumeric(number);
            winningNumbers.add(Integer.parseInt(number));
        }
    }

    private static void validateNumeric(String number) {
        if (!number.matches(NUMBER_PATTERN)) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 숫자로만 이루어져야 합니다.");
        }
    }

    private static void validateWinningNumbersSize(String[] splitWinningNumbers) {
        if (splitWinningNumbers.length != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 6개로 이루어져야 합니다.");
        }
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
